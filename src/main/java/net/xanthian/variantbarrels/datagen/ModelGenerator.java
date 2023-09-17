package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        for (Block block : Vanilla.MOD_BARRELS.values()){
            createBarrel(blockStateModelGenerator, block);
        }

        // Ad Astra
        for (Block block : AdAstra.AA_BARRELS.values()){
            createBarrel(blockStateModelGenerator, block);
        }

        // Beach Party (Lets Do)
        createBarrel(blockStateModelGenerator,BeachParty.LDBP_PALM_BARREL);

        // Better Archeology
        createBarrel(blockStateModelGenerator, BetterArcheology.BA_ROTTEN_BARREL);

        // Bewitchment
        for (Block block : Bewitchment.BW_BARRELS.values()){
            createBarrel(blockStateModelGenerator, block);
        }

        // Deeper & Darker
        createBarrel(blockStateModelGenerator,DeeperAndDarker.DAD_ECHO_BARREL);

        // MineCells
        createBarrel(blockStateModelGenerator, MineCells.MC_PUTRID_BARREL);

        // Natures Spirit
        for (Block block : NaturesSpirit.NS_BARRELS.values()){
            createBarrel(blockStateModelGenerator, block);
        }

        // Promenade
        for (Block block : Promenade.PROM_BARRELS.values()){
            createBarrel(blockStateModelGenerator, block);
        }

        // Regions Unexplored
        for (Block block : RegionsUnexplored.RU_BARRELS.values()){
            createBarrel(blockStateModelGenerator, block);
        }
        // SnifferPlus
        createBarrel(blockStateModelGenerator, SnifferPlus.SP_STONE_PINE_BARREL);

        // Tech Reborn
        createBarrel(blockStateModelGenerator, TechReborn.TR_RUBBER_BARREL);

        // Vinery (Lets Do)
        createBarrel(blockStateModelGenerator, Vinery.LDV_CHERRY_BARREL);
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