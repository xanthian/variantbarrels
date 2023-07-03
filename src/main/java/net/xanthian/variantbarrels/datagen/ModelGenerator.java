package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.block.Barrels;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        createBarrel(blockStateModelGenerator,Barrels.ACACIA_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.BAMBOO_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.BIRCH_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.CHERRY_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.CRIMSON_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.DARK_OAK_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.JUNGLE_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.MANGROVE_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.OAK_BARREL);
        createBarrel(blockStateModelGenerator,Barrels.WARPED_BARREL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }

    public void createBarrel(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = TextureMap.getSubId(block, "_top_open");
        Identifier modelLocation = new Identifier(identifier.getNamespace(),"block/");
        (new TextureMap()).put(TextureKey.PARTICLE, modelLocation).put(TextureKey.TOP, modelLocation).put(TextureKey.BOTTOM, modelLocation).put(TextureKey.SIDE, modelLocation);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(blockStateModelGenerator.createUpDefaultFacingVariantMap())
                .coordinate(BlockStateVariantMap.create(Properties.OPEN).register(false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, TexturedModel.CUBE_BOTTOM_TOP.upload(block,blockStateModelGenerator.modelCollector ))).register(true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, TexturedModel.CUBE_BOTTOM_TOP.get(block).textures(textureMap -> textureMap
                        .put(TextureKey.TOP, identifier)).upload(block, "_open",blockStateModelGenerator.modelCollector )))));
    }

}
