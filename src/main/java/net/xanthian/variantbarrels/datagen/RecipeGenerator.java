package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.VanillaRecipeProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import net.xanthian.variantbarrels.block.Barrels;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.ACACIA_BARREL,Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.BAMBOO_BARREL,Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.BIRCH_BARREL,Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.CHERRY_BARREL,Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.CRIMSON_BARREL,Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.DARK_OAK_BARREL,Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.JUNGLE_BARREL,Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.MANGROVE_BARREL,Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.OAK_BARREL,Blocks.OAK_PLANKS, Blocks.OAK_SLAB);
        RecipeGenerator.offerBarrelRecipe(exporter,Barrels.WARPED_BARREL,Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB);

    }
    public static void offerBarrelRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible barrel, ItemConvertible plank, ItemConvertible slab) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, barrel, 1)
                .input('P', plank).input('S', slab)
                .pattern("PSP").pattern("P P").pattern("PSP")
                .criterion("has_planks", VanillaRecipeProvider.conditionsFromItem(plank)).criterion("has_wood_slab", VanillaRecipeProvider.conditionsFromItem(slab)).offerTo(exporter);
    }
}