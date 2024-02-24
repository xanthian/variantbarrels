package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;
import net.xanthian.variantbarrels.util.ModItemTags;

import java.util.Map;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    public static void offerBarrelRecipe(RecipeExporter exporter, ItemConvertible barrel, ItemConvertible plank, ItemConvertible slab) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, barrel, 1)
                .input('P', plank).input('S', slab)
                .pattern("PSP").pattern("P P").pattern("PSP")
                .criterion("has_planks", VanillaRecipeProvider.conditionsFromItem(plank)).criterion("has_wood_slab", VanillaRecipeProvider.conditionsFromItem(slab))
                .offerTo(exporter);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerBarrelRecipe(exporter, Vanilla.ACACIA_BARREL, Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB);
        offerBarrelRecipe(exporter, Vanilla.BAMBOO_BARREL, Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_SLAB);
        offerBarrelRecipe(exporter, Vanilla.BIRCH_BARREL, Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB);
        offerBarrelRecipe(exporter, Vanilla.CHERRY_BARREL, Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB);
        offerBarrelRecipe(exporter, Vanilla.CRIMSON_BARREL, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB);
        offerBarrelRecipe(exporter, Vanilla.DARK_OAK_BARREL, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB);
        offerBarrelRecipe(exporter, Vanilla.JUNGLE_BARREL, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB);
        offerBarrelRecipe(exporter, Vanilla.MANGROVE_BARREL, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB);
        offerBarrelRecipe(exporter, Vanilla.OAK_BARREL, Blocks.OAK_PLANKS, Blocks.OAK_SLAB);
        offerBarrelRecipe(exporter, Vanilla.WARPED_BARREL, Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB);


        registerBarrelRecipe(exporter, AdAstra.AA_BARRELS, "ad_astra");
        registerBarrelRecipe(exporter, BeachParty.LDBP_BARRELS, "beachparty");
        registerBarrelRecipe(exporter, BetterArcheology.BA_BARRELS, "betterarcheology");
        registerBarrelRecipe(exporter, Bewitchment.BW_BARRELS, "bewitchment");
        registerBarrelRecipe(exporter, BiomeMakeover.BM_BARRELS, "biomemakeover");
        //registerBarrelRecipe(exporter, Botania.BOT_BARRELS, "botania");
        registerBarrelRecipe(exporter, Cinderscapes.CS_BARRELS, "cinderscapes");
        registerBarrelRecipe(exporter, DeeperAndDarker.DAD_BARRELS, "deeperdarker");
        registerBarrelRecipe(exporter, Desolation.DS_BARRELS, "desolation");
        registerBarrelRecipe(exporter, EldritchEnd.EE_BARRELS, "eldritch_end");
        registerBarrelRecipe(exporter, MineCells.MC_BARRELS, "minecells");
        registerBarrelRecipe(exporter, NaturesSpirit.NS_BARRELS, "natures_spirit");
        registerBarrelRecipe(exporter, Promenade.PROM_BARRELS, "promenade");
        registerBarrelRecipe(exporter, RegionsUnexplored.RU_BARRELS, "regions_unexplored");
        //registerBarrelRecipe(exporter, SnifferPlus.SP_BARRELS, "snifferplus");
        registerBarrelRecipe(exporter, TechReborn.TR_BARRELS, "techreborn");
        registerBarrelRecipe(exporter, Vinery.LDV_BARRELS, "vinery");

        // Uncrafting recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BARREL)
                .input(ModItemTags.BARRELS)
                .criterion("has_barrel", InventoryChangedCriterion.Conditions.items(Items.BARREL))
                .offerTo(exporter, new Identifier("variantbarrels", "barrel"));

    }

    public void registerBarrelRecipe(RecipeExporter exporter, Map<Identifier, Block> barrel, String modId) {
        registerBarrelRecipe(exporter, barrel, modId, "_planks", "_slab");
    }

    public void registerBarrelRecipe(RecipeExporter exporter, Map<Identifier, Block> bookshelves, String modId, String plankSuffix, String slabSuffix) {
        for (Map.Entry<Identifier, Block> entry : bookshelves.entrySet()) {
            Identifier bookshelfId = entry.getKey();
            Block bookshelf = entry.getValue();
            String path = bookshelfId.getPath();
            String name = path.replace("variantbarrels:", "").replace("_barrel", "").replaceFirst("^[^_]+_", "");
            String plankPath = modId + ":" + name + plankSuffix;
            String slabPath = modId + ":" + name + slabSuffix;
            offerBarrelRecipe(withConditions(exporter, DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded(modId),
                            DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier(plankPath))))),
                    bookshelf, Registries.ITEM.get(new Identifier(plankPath)), Registries.ITEM.get(new Identifier(slabPath)));
        }
    }
}