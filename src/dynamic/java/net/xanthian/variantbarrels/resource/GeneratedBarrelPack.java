package net.xanthian.variantbarrels.resource;

import com.google.gson.Gson;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.resources.IoSupplier;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.DynamicBarrels;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/** An in-memory pack above vanilla defaults. Mod/user packs can override generated entries. */
public final class GeneratedBarrelPack implements PackResources {
    private static final Gson GSON = new Gson();
    private final PackType type;
    private final Map<Identifier, byte[]> resources = new LinkedHashMap<>();

    public GeneratedBarrelPack(PackType type, List<DynamicBarrels.Variant> variants) {
        this.type = type;
        Map<String, String> names = new LinkedHashMap<>();
        for (var variant : variants) {
            Identifier id = variant.id();
            if (type == PackType.CLIENT_RESOURCES) {
                generateModels(id);
                names.put(variant.block().asItem().getDescriptionId(), displayName(variant.planks()));
            } else {
                generateRecipe(id, variant.ingredient(), variant.slab());
                put(id, "loot_table/blocks/", Map.of("type", "minecraft:block", "pools", List.of(Map.of(
                        "rolls", 1, "condition", Map.of("type", "minecraft:survives_explosion"),
                        "entries", List.of(Map.of("type", "minecraft:item", "name", id.toString(),
                                "modifier", Map.of("type", "minecraft:copy_components",
                                        "source", "block_entity", "include", List.of("minecraft:custom_name"))))))));
            }
        }
        if (type == PackType.CLIENT_RESOURCES) {
            names.put("block.minecraft.barrel", "Spruce Barrel");
            names.put("tag.item.variantbarrels.barrels", "Barrels");
            put(Identifier.fromNamespaceAndPath(Initialise.MOD_ID, "en_us"), "lang/", names);
        } else {
            generateTags(variants);
            generateRecipe(Identifier.withDefaultNamespace("barrel"),
                    Identifier.withDefaultNamespace("spruce_planks"), Identifier.withDefaultNamespace("spruce_slab"));
            put(Identifier.fromNamespaceAndPath(Initialise.MOD_ID, "barrel"), "recipe/",
                    Map.of("type", "minecraft:crafting_shapeless", "ingredients", List.of("#variantbarrels:barrels"),
                            "result", Map.of("id", "minecraft:barrel")));
        }
    }

    private void generateModels(Identifier id) {
        String model = id.getNamespace() + ":block/" + id.getPath();
        Map<String, Object> states = new LinkedHashMap<>();
        addFacing(states, model, "down", 180, 0);
        addFacing(states, model, "east", 90, 90);
        addFacing(states, model, "north", 90, 0);
        addFacing(states, model, "south", 90, 180);
        addFacing(states, model, "up", 0, 0);
        addFacing(states, model, "west", 90, 270);
        put(id, "blockstates/", Map.of("variants", states));
        put(id, "items/", Map.of("model", Map.of("type", "minecraft:model", "model", model)));
        put(id, "models/block/", barrelModel(model, "_top"));
        put(id.withSuffix("_open"), "models/block/", barrelModel(model, "_top_open"));
    }

    private static Object barrelModel(String model, String top) {
        return Map.of("parent", "minecraft:block/cube_bottom_top", "textures", Map.of(
                "bottom", model + "_bottom", "side", model + "_side", "top", model + top));
    }

    private static void addFacing(Map<String, Object> states, String model, String facing, int x, int y) {
        for (boolean open : new boolean[]{false, true}) {
            Map<String, Object> state = new LinkedHashMap<>();
            state.put("model", open ? model + "_open" : model);
            if (x != 0) state.put("x", x);
            if (y != 0) state.put("y", y);
            states.put("facing=" + facing + ",open=" + open, state);
        }
    }

    private void generateRecipe(Identifier id, Identifier planks, Identifier slab) {
        put(id, "recipe/", Map.of("type", "minecraft:crafting_shaped", "category", "misc",
                "pattern", List.of("PSP", "P P", "PSP"),
                "key", Map.of("P", planks.toString(), "S", slab.toString()), "result", Map.of("id", id.toString())));
        if (!id.getNamespace().equals("minecraft")) {
            put(id, "advancement/recipes/misc/", Map.of("parent", "minecraft:recipes/root",
                    "criteria", Map.of("has_planks", Map.of("trigger", "minecraft:inventory_changed",
                            "conditions", Map.of("items", List.of(Map.of("items", planks.toString()))))),
                    "requirements", List.of(List.of("has_planks")), "rewards", Map.of("recipes", List.of(id.toString()))));
        }
    }

    private void generateTags(List<DynamicBarrels.Variant> variants) {
        List<String> ids = variants.stream().map(variant -> variant.id().toString()).toList();
        Identifier modTag = Identifier.fromNamespaceAndPath(Initialise.MOD_ID, "barrels");
        Map<String, Object> shared = Map.of("replace", false, "values", List.of("#" + modTag, "minecraft:barrel"));
        Map<String, Object> variantsOnly = Map.of("replace", false, "values", List.of("#" + modTag));
        for (String registry : List.of("block", "item")) {
            String directory = "tags/" + registry + "/";
            put(modTag, directory, Map.of("replace", false, "values", ids));
            for (String tag : List.of("barrels", "barrels/wooden", "wooden_barrels")) {
                put(Identifier.fromNamespaceAndPath("c", tag), directory, shared);
            }
        }
        put(Identifier.withDefaultNamespace("mineable/axe"), "tags/block/", variantsOnly);
        put(Identifier.withDefaultNamespace("guarded_by_piglins"), "tags/block/", variantsOnly);
        List<String> nonFlammable = variants.stream().filter(DynamicBarrels.Variant::nonFlammable)
                .map(variant -> variant.id().toString()).toList();
        if (!nonFlammable.isEmpty()) {
            put(Identifier.withDefaultNamespace("non_flammable_wood"), "tags/item/",
                    Map.of("replace", false, "values", nonFlammable));
        }
    }

    private void put(Identifier id, String directory, Object json) {
        resources.put(Identifier.fromNamespaceAndPath(id.getNamespace(), directory + id.getPath() + ".json"),
                GSON.toJson(json).getBytes(StandardCharsets.UTF_8));
    }

    private static String displayName(Identifier planks) {
        String path = planks.getPath().replaceFirst("(^|[/_])planks$", "").replace('/', ' ').replace('_', ' ').trim();
        if (path.isEmpty()) {
            path = planks.getNamespace().replace('_', ' ');
        }
        StringBuilder name = new StringBuilder();
        for (String word : path.split(" +")) {
            name.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(' ');
        }
        return name + "Barrel";
    }

    @Override
    public IoSupplier<InputStream> getResource(PackType type, Identifier id) {
        byte[] bytes = this.type == type ? resources.get(id) : null;
        return bytes == null ? null : () -> new ByteArrayInputStream(bytes);
    }

    @Override
    public void listResources(PackType type, String namespace, String prefix, ResourceOutput output) {
        if (this.type == type) {
            resources.forEach((id, bytes) -> {
                if (id.getNamespace().equals(namespace) && id.getPath().startsWith(prefix + "/")) {
                    output.accept(id, () -> new ByteArrayInputStream(bytes));
                }
            });
        }
    }

    @Override
    public Set<String> getNamespaces(PackType type) {
        return this.type == type ? resources.keySet().stream().map(Identifier::getNamespace)
                .collect(java.util.stream.Collectors.toUnmodifiableSet()) : Set.of();
    }

    @Override
    public PackLocationInfo location() {
        return new PackLocationInfo("variantbarrels:generated", Component.literal("Generated Barrels"),
                PackSource.BUILT_IN, Optional.empty());
    }

    @Override
    public IoSupplier<InputStream> getRootResource(String... path) {
        return null;
    }

    @Override
    public <T> T getMetadataSection(MetadataSectionType<T> type) {
        return null;
    }

    @Override
    public void close() {
        // Only immutable byte arrays are retained; no open resources.
    }
}
