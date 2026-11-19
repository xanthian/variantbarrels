package net.xanthian.variantbarrels.block;

import com.mojang.logging.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.xanthian.variantbarrels.Initialise;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/** Discovers planks, slabs and existing barrels immediately before the built-in registries freeze. */
public final class DynamicBarrels {
    public record Variant(Identifier id, Identifier planks, Identifier ingredient, Identifier slab, Block block,
                          boolean nonFlammable) {
    }

    private static final Map<String, LegacyVariant> LEGACY = loadLegacyVariants();

    private record LegacyVariant(String barrel, String slab) {}

    private static volatile List<Variant> variants = List.of();
    private static boolean initialized;
    private static boolean logged;

    private DynamicBarrels() {
    }

    public static List<Variant> variants() {
        return variants;
    }

    public static void register() {
        if (initialized) {
            return;
        }
        initialized = true;

        List<Path> roots = FabricLoader.getInstance().getAllMods().stream()
                .sorted(Comparator.comparing(mod -> mod.getMetadata().getId()))
                .flatMap(mod -> mod.getRootPaths().stream()).toList();
        PlankDiscovery discovery = new PlankDiscovery(roots);
        var blockTags = discovery.entries("block", Identifier.withDefaultNamespace("planks"));
        var itemTags = discovery.entries("item", Identifier.withDefaultNamespace("planks"));
        var nonFlammable = discovery.entries("item", Identifier.withDefaultNamespace("non_flammable_wood"));
        // Both lookups use the same item snapshot before any generated barrel is registered.
        var items = BuiltInRegistries.ITEM.listElements().toList();
        var existingRecipes = existingBarrelIngredients(roots, items);
        var processed = new HashSet<Identifier>();
        var registered = new ArrayList<Variant>();
        for (var holder : items) {
            if (!(holder.value() instanceof BlockItem item) || item.getBlock() instanceof BarrelBlock) {
                continue;
            }
            Block planks = item.getBlock();
            Identifier plankId = BuiltInRegistries.BLOCK.getResourceKey(planks).map(ResourceKey::identifier).orElse(null);
            Identifier ingredient = holder.key().identifier();
            if (plankId == null || ingredient.equals(Identifier.withDefaultNamespace("air"))
                    || plankId.equals(Identifier.withDefaultNamespace("spruce_planks"))
                    || !(PlankDiscovery.hasPlankName(plankId) || blockTags.contains(plankId)
                    || itemTags.contains(ingredient) || LEGACY.containsKey(plankId.toString()))
                    || !processed.add(plankId)) {
                continue;
            }
            Identifier slab = slabFor(plankId);
            if (slab != null && !slab.equals(ingredient)
                    && !hasExistingBarrel(plankId, ingredient, slab, existingRecipes)) {
                Variant variant = registerBarrel(planks, plankId, ingredient, slab, nonFlammable.contains(ingredient));
                if (variant != null) {
                    registered.add(variant);
                }
            }
        }
        registered.sort(Comparator.comparing(variant -> variant.id().toString()));
        variants = List.copyOf(registered);
        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER) {
            ServerLifecycleEvents.SERVER_STARTING.register(server -> logRegistration());
        }
    }

    private static boolean hasExistingBarrel(Identifier planks, Identifier ingredient, Identifier slab,
                                             Set<Set<String>> existingRecipes) {
        String wood = woodPath(planks);
        Identifier barrel = planks.withPath(wood.isEmpty() ? "barrel" : wood + woodSeparator(planks, wood) + "barrel");
        return isBarrelItem(BuiltInRegistries.ITEM.getValue(barrel))
                || isBarrelItem(BuiltInRegistries.ITEM.getValue(planks.withSuffix("_barrel")))
                || existingRecipes.contains(Set.of(ingredient.toString(), slab.toString()));
    }

    private static boolean isBarrelItem(Item item) {
        return item instanceof BlockItem blockItem && blockItem.getBlock() instanceof BarrelBlock
                && BuiltInRegistries.BLOCK.getResourceKey(blockItem.getBlock()).isPresent();
    }

    private static Set<Set<String>> existingBarrelIngredients(List<Path> roots, List<Holder.Reference<Item>> items) {
        // A recipe can identify a barrel for another mod's wood, such as BetterNether's crimson barrel.
        var ingredients = new HashSet<Set<String>>();
        for (var holder : items) {
            Identifier barrel = holder.key().identifier();
            if (!isBarrelItem(holder.value()) || barrel.equals(Identifier.withDefaultNamespace("barrel"))) {
                continue;
            }
            for (Path root : roots) {
                Path path = root.resolve("data/" + barrel.getNamespace() + "/recipe/" + barrel.getPath() + ".json");
                if (!Files.isRegularFile(path)) {
                    continue;
                }
                try (var reader = Files.newBufferedReader(path)) {
                    var recipe = JsonParser.parseReader(reader).getAsJsonObject();
                    if (recipe.has("fabric:load_conditions")
                            || !recipe.get("type").getAsString().equals("minecraft:crafting_shaped")
                            || !recipe.getAsJsonObject("result").get("id").getAsString().equals(barrel.toString())) {
                        continue;
                    }
                    var keys = recipe.getAsJsonObject("key").asMap().values();
                    if (keys.size() == 2 && keys.stream().allMatch(value ->
                            value.isJsonPrimitive() && value.getAsJsonPrimitive().isString())) {
                        ingredients.add(keys.stream().map(value -> value.getAsString()).collect(Collectors.toUnmodifiableSet()));
                    }
                } catch (IOException | RuntimeException exception) {
                    LogUtils.getLogger().debug("Could not check barrel recipe {}", path, exception);
                }
            }
        }
        return ingredients;
    }

    private static Variant registerBarrel(Block planks, Identifier plankId, Identifier ingredient, Identifier slab,
                                          boolean nonFlammable) {
        Identifier id = barrelId(plankId);
        if (BuiltInRegistries.BLOCK.containsKey(id) || BuiltInRegistries.ITEM.containsKey(id)) {
            LogUtils.getLogger().warn("Skipping barrel for {}: {} is already registered", plankId, id);
            return null;
        }
        // Read mod-owned behaviour before constructing objects with intrusive registry holders.
        // A failed source read changes only properties, never the client/server barrel catalogue.
        var blockProperties = barrelProperties(planks, plankId)
                .overrideLootTable(Optional.of(ResourceKey.create(Registries.LOOT_TABLE,
                        id.withPrefix("blocks/"))))
                .setId(ResourceKey.create(Registries.BLOCK, id));
        Block block;
        String stage = "constructing the block";
        try {
            block = new VariantBarrelBlock(blockProperties);
            stage = "constructing the item";
            Item.Properties properties = new Item.Properties().useBlockDescriptionPrefix()
                    .setId(ResourceKey.create(Registries.ITEM, id));
            BlockItem item = new BlockItem(block, properties);
            // Prepare both objects before writing either registry. Constructor failures cannot
            // safely be skipped either: constructors may already have created intrusive holders.
            stage = "registering the block";
            Registry.register(BuiltInRegistries.BLOCK, id, block);
            stage = "registering the item";
            Registry.register(BuiltInRegistries.ITEM, id, item);
            stage = "adding the block to the vanilla barrel block entity type";
            ((FabricBlockEntityType) BlockEntityTypes.BARREL).addValidBlock(block);
        } catch (RuntimeException exception) {
            throw new IllegalStateException("[Variant Barrels] Failed " + stage + " for " + id
                    + " from plank " + plankId + " (ingredient " + ingredient + ")."
                    + " Loading must stop because registry changes cannot be safely rolled back.", exception);
        }
        return new Variant(id, plankId, ingredient, slab, block, nonFlammable);
    }

    private static BlockBehaviour.Properties barrelProperties(Block planks, Identifier plankId) {
        // Barrel properties, starting without the vanilla barrel's lava-ignition flag.
        // The properties API can only enable lava ignition.
        var properties = BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                .instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD);
        boolean ignitedByLava = false;
        try {
            ignitedByLava = planks.defaultBlockState().ignitedByLava();
        } catch (RuntimeException exception) {
            LogUtils.getLogger().warn("Could not read lava ignition for {}; keeping its barrel lava-safe",
                    plankId, exception);
        }
        if (ignitedByLava) {
            properties.ignitedByLava();
        }
        return properties;
    }

    public static void logRegistration() {
        if (logged) {
            return;
        }
        logged = true;
        var logger = LogUtils.getLogger();
        var byMod = variants.stream().collect(Collectors.groupingBy(
                variant -> variant.planks().getNamespace(), TreeMap::new, Collectors.toList()));
        byMod.forEach((mod, barrels) -> {
            // Keep every wood name in a single log entry per source namespace.
            String woods = barrels.stream().map(variant -> {
                String plank = variant.planks().getPath();
                String wood = plank.replaceFirst("(^|[/_])planks?$", "");
                return wood.isEmpty() ? mod : wood.replace('_', ' ').replace('/', ' ');
            }).collect(Collectors.joining(", "));
            logger.info("{}: added {} barrels for {}", mod, barrels.size(), woods);
        });
        // Full IDs remain available for diagnostics without filling the normal startup log.
        variants.forEach(variant -> logger.debug("[Variant Barrels] Detected {}; registered {}",
                variant.planks(), variant.id()));
        long vanilla = variants.stream().filter(variant -> variant.planks().getNamespace().equals("minecraft")).count();
        logger.info("[Variant Barrels] Loaded {} barrels ({} generated: {} vanilla, {} modded; plus existing spruce)",
                variants.size() + 1, variants.size(), vanilla, variants.size() - vanilla);
    }

    public static Identifier barrelId(Identifier planks) {
        LegacyVariant legacy = LEGACY.get(planks.toString());
        if (legacy != null) {
            return Identifier.parse(legacy.barrel());
        }
        // Retain the full source ID: similarly named woods from different mods cannot collide.
        String path = planks.getNamespace().equals("minecraft")
                ? planks.getPath().replaceFirst("_planks$", "") + "_barrel"
                : "mod/" + planks.getNamespace() + "/" + planks.getPath() + "_barrel";
        return Identifier.fromNamespaceAndPath(Initialise.MOD_ID, path);
    }

    private static Identifier slabFor(Identifier planks) {
        Set<Identifier> candidates = new LinkedHashSet<>();
        LegacyVariant legacy = LEGACY.get(planks.toString());
        if (legacy != null && legacy.slab() != null) {
            candidates.add(Identifier.parse(legacy.slab()));
        }
        String path = planks.getPath();
        String wood = woodPath(planks);
        if (!wood.equals(path)) {
            candidates.add(planks.withPath(wood.isEmpty() ? "slab" : wood + woodSeparator(planks, wood) + "slab"));
        }
        candidates.add(planks.withSuffix("_slab"));
        for (Identifier slab : candidates) {
            if (BuiltInRegistries.ITEM.getOptional(slab).orElse(null) instanceof BlockItem item
                    && item.getBlock() instanceof SlabBlock
                    && BuiltInRegistries.BLOCK.getResourceKey(item.getBlock()).isPresent()) {
                return slab;
            }
        }
        return null;
    }

    private static String woodPath(Identifier planks) {
        return planks.getPath().replaceFirst("(^|[/_])(planks|boards)$", "");
    }

    private static String woodSeparator(Identifier planks, String wood) {
        return planks.getPath().startsWith("/", wood.length()) ? "/" : "_";
    }

    private static Map<String, LegacyVariant> loadLegacyVariants() {
        try (var stream = DynamicBarrels.class.getResourceAsStream("/legacy_barrels.json")) {
            if (stream == null) {
                throw new IllegalStateException("Missing legacy barrel ID catalog");
            }
            try (var reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                var type = new TypeToken<Map<String, LegacyVariant>>() {}.getType();
                return Map.copyOf(new Gson().fromJson(reader, type));
            }
        } catch (IOException exception) {
            throw new IllegalStateException("Cannot read legacy barrel IDs", exception);
        }
    }
}
