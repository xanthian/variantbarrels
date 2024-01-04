package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

import java.util.Map;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    public static void createBarrel(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        Identifier identifier = TextureMap.getSubId(block, "_top_open");
        Identifier modelLocation = new Identifier(identifier.getNamespace(), "block/");
        (new TextureMap()).put(TextureKey.PARTICLE, modelLocation).put(TextureKey.TOP, modelLocation).put(TextureKey.BOTTOM, modelLocation).put(TextureKey.SIDE, modelLocation);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(blockStateModelGenerator.createUpDefaultFacingVariantMap())
                .coordinate(BlockStateVariantMap.create(Properties.OPEN).register(false, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, TexturedModel.CUBE_BOTTOM_TOP.upload(block, blockStateModelGenerator.modelCollector))).register(true, BlockStateVariant.create()
                        .put(VariantSettings.MODEL, TexturedModel.CUBE_BOTTOM_TOP.get(block).textures(textureMap -> textureMap
                                .put(TextureKey.TOP, identifier)).upload(block, "_open", blockStateModelGenerator.modelCollector)))));
    }

    public static void registerModel(BlockStateModelGenerator blockStateModelGenerator, Map<Identifier, Block> blockMap) {
        for (Block barrel : blockMap.values()) {
            createBarrel(blockStateModelGenerator, barrel);
        }
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        registerModel(blockStateModelGenerator, Vanilla.VANILLA_BARRELS);
        registerModel(blockStateModelGenerator, AdAstra.AA_BARRELS);
        registerModel(blockStateModelGenerator, BeachParty.LDBP_BARRELS);
        registerModel(blockStateModelGenerator, BetterArcheology.BA_BARRELS);
        registerModel(blockStateModelGenerator, BiomeMakeover.BM_BARRELS);
        registerModel(blockStateModelGenerator, Bewitchment.BW_BARRELS);
        registerModel(blockStateModelGenerator, Botania.BOT_BARRELS);
        registerModel(blockStateModelGenerator, Cinderscapes.CS_BARRELS);
        registerModel(blockStateModelGenerator, DeeperAndDarker.DAD_BARRELS);
        registerModel(blockStateModelGenerator, Desolation.DS_BARRELS);
        registerModel(blockStateModelGenerator, EldritchEnd.EE_BARRELS);
        registerModel(blockStateModelGenerator, MineCells.MC_BARRELS);
        registerModel(blockStateModelGenerator, NaturesSpirit.NS_BARRELS);
        registerModel(blockStateModelGenerator, Promenade.PROM_BARRELS);
        registerModel(blockStateModelGenerator, RegionsUnexplored.RU_BARRELS);
        registerModel(blockStateModelGenerator, SnifferPlus.SP_BARRELS);
        registerModel(blockStateModelGenerator, TechReborn.TR_BARRELS);
        registerModel(blockStateModelGenerator, Vinery.LDV_BARRELS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }
}