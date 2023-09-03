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
        createBarrel(blockStateModelGenerator, Vanilla.ACACIA_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.BAMBOO_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.BIRCH_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.CHERRY_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.CRIMSON_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.DARK_OAK_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.JUNGLE_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.MANGROVE_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.OAK_BARREL);
        createBarrel(blockStateModelGenerator, Vanilla.WARPED_BARREL);

        // Ad Astra
        createBarrel(blockStateModelGenerator, AdAstra.AA_AERONOS_BARREL);
        createBarrel(blockStateModelGenerator, AdAstra.AA_GLACIAN_BARREL);
        createBarrel(blockStateModelGenerator, AdAstra.AA_STROPHAR_BARREL);
        // Beach Party (Lets Do)
        createBarrel(blockStateModelGenerator,BeachParty.LDBP_PALM_BARREL);
        // Better Archeology
        createBarrel(blockStateModelGenerator, BetterArcheology.BA_ROTTEN_BARREL);
        // Bewitchment
        createBarrel(blockStateModelGenerator, Bewitchment.BW_CYPRESS_BARREL);
        createBarrel(blockStateModelGenerator, Bewitchment.BW_DRAGONS_BLOOD_BARREL);
        createBarrel(blockStateModelGenerator, Bewitchment.BW_ELDER_BARREL);
        createBarrel(blockStateModelGenerator, Bewitchment.BW_JUNIPER_BARREL);
        // Deeper & Darker
        createBarrel(blockStateModelGenerator,DeeperAndDarker.DAD_ECHO_BARREL);
        // Promenade
        createBarrel(blockStateModelGenerator, Promenade.PROM_DARK_AMARANTH_BARREL);
        createBarrel(blockStateModelGenerator, Promenade.PROM_MAPLE_BARREL);
        createBarrel(blockStateModelGenerator, Promenade.PROM_PALM_BARREL);
        createBarrel(blockStateModelGenerator, Promenade.PROM_SAKURA_BARREL);
        // Regions Unexplored
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_ALPHA_OAK_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_BAOBAB_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_BLACK_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_BLACKWOOD_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_BLUE_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_BROWN_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_CHERRY_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_CYAN_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_CYPRESS_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_DEAD_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_EUCALYPTUS_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_GREEN_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_GRAY_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_JOSHUA_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_LARCH_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_LIME_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_MAPLE_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_MAUVE_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_ORANGE_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_PALM_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_PINE_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_PINK_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_PURPLE_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_RED_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_REDWOOD_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_SCULKWOOD_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_WHITE_PAINTED_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_WILLOW_BARREL);
        createBarrel(blockStateModelGenerator, RegionsUnexplored.RU_YELLOW_PAINTED_BARREL);
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
