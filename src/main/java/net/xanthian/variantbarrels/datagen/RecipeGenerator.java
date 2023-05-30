package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Barrels;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
                
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.ACACIA_BARREL,1)
                .input('P', Blocks.ACACIA_PLANKS)
                .input('S', Blocks.ACACIA_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.ACACIA_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.ACACIA_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.ACACIA_SLAB), FabricRecipeProvider.conditionsFromItem(Items.ACACIA_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.ACACIA_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.BAMBOO_BARREL, 1)
                .input('P', Blocks.BAMBOO_PLANKS)
                .input('S', Blocks.BAMBOO_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.BAMBOO_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.BAMBOO_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.BAMBOO_SLAB), FabricRecipeProvider.conditionsFromItem(Items.BAMBOO_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.BAMBOO_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.BIRCH_BARREL, 1)
                .input('P', Blocks.BIRCH_PLANKS)
                .input('S', Blocks.BIRCH_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.BIRCH_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.BIRCH_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.BIRCH_SLAB), FabricRecipeProvider.conditionsFromItem(Items.BIRCH_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.BIRCH_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.CHERRY_BARREL, 1)
                .input('P', Blocks.CHERRY_PLANKS)
                .input('S', Blocks.CHERRY_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.CHERRY_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.CHERRY_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.CHERRY_SLAB), FabricRecipeProvider.conditionsFromItem(Items.CHERRY_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.CHERRY_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.CRIMSON_BARREL, 1)
                .input('P', Blocks.CRIMSON_PLANKS)
                .input('S', Blocks.CRIMSON_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.CRIMSON_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.CRIMSON_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.CRIMSON_SLAB), FabricRecipeProvider.conditionsFromItem(Items.CRIMSON_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.CRIMSON_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.DARK_OAK_BARREL, 1)
                .input('P', Blocks.DARK_OAK_PLANKS)
                .input('S', Blocks.DARK_OAK_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.DARK_OAK_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.DARK_OAK_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.DARK_OAK_SLAB), FabricRecipeProvider.conditionsFromItem(Items.DARK_OAK_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.DARK_OAK_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.JUNGLE_BARREL, 1)
                .input('P', Blocks.JUNGLE_PLANKS)
                .input('S', Blocks.JUNGLE_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.JUNGLE_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.JUNGLE_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.JUNGLE_SLAB), FabricRecipeProvider.conditionsFromItem(Items.JUNGLE_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.JUNGLE_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.MANGROVE_BARREL, 1)
                .input('P', Blocks.MANGROVE_PLANKS)
                .input('S', Blocks.MANGROVE_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.MANGROVE_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.MANGROVE_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.MANGROVE_SLAB), FabricRecipeProvider.conditionsFromItem(Items.MANGROVE_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.MANGROVE_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.OAK_BARREL, 1)
                .input('P', Blocks.OAK_PLANKS)
                .input('S', Blocks.OAK_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.OAK_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.OAK_SLAB), FabricRecipeProvider.conditionsFromItem(Items.OAK_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.OAK_BARREL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Barrels.WARPED_BARREL, 1)
                .input('P', Blocks.WARPED_PLANKS)
                .input('S', Blocks.WARPED_SLAB)
                .pattern("PSP")
                .pattern("P P")
                .pattern("PSP")
                .criterion(FabricRecipeProvider.hasItem(Items.WARPED_PLANKS), FabricRecipeProvider.conditionsFromItem(Items.WARPED_PLANKS))
                .criterion(FabricRecipeProvider.hasItem(Items.WARPED_SLAB), FabricRecipeProvider.conditionsFromItem(Items.WARPED_SLAB))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Barrels.WARPED_BARREL)));
    }
}