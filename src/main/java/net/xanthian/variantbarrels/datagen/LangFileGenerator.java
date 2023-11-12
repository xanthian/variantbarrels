package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

import java.util.Map;

public class LangFileGenerator extends FabricLanguageProvider {
    public LangFileGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    public static String generateBlockDisplayName(Block block) {
        Identifier name = Registries.BLOCK.getId(block);
        String blockName = name.getPath();
        int underscoreIndex = blockName.indexOf('_');
        if (underscoreIndex != -1 && underscoreIndex < blockName.length() - 1) {
            blockName = blockName.substring(underscoreIndex + 1);
        }
        String[] parts = blockName.split("_");
        StringBuilder displayName = new StringBuilder();
        for (String part : parts) {
            displayName.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
        }
        return displayName.toString().trim();
    }

    private static void registerTranslations(TranslationBuilder translationBuilder, Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            translationBuilder.add(block, generateBlockDisplayName(block));
        }
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        translationBuilder.add(Vanilla.ACACIA_BARREL, "Acacia Barrel");
        translationBuilder.add(Vanilla.BAMBOO_BARREL, "Bamboo Barrel");
        translationBuilder.add(Vanilla.BIRCH_BARREL, "Birch Barrel");
        translationBuilder.add(Vanilla.CHERRY_BARREL, "Cherry Barrel");
        translationBuilder.add(Vanilla.CRIMSON_BARREL, "Crimson Barrel");
        translationBuilder.add(Vanilla.DARK_OAK_BARREL, "Dark Oak Barrel");
        translationBuilder.add(Vanilla.JUNGLE_BARREL, "Jungle Barrel");
        translationBuilder.add(Vanilla.MANGROVE_BARREL, "Mangrove Barrel");
        translationBuilder.add(Vanilla.OAK_BARREL, "Oak Barrel");
        translationBuilder.add(Blocks.BARREL, "Spruce Barrel");
        translationBuilder.add(Vanilla.WARPED_BARREL, "Warped Barrel");

        registerTranslations(translationBuilder, AdAstra.AA_BARRELS);
        registerTranslations(translationBuilder, BeachParty.LDBP_BARRELS);
        registerTranslations(translationBuilder, BetterArcheology.BA_BARRELS);
        registerTranslations(translationBuilder, Bewitchment.BW_BARRELS);
        registerTranslations(translationBuilder, DeeperAndDarker.DAD_BARRELS);
        registerTranslations(translationBuilder, EldritchEnd.EE_BARRELS);
        registerTranslations(translationBuilder, MineCells.MC_BARRELS);
        registerTranslations(translationBuilder, NaturesSpirit.NS_BARRELS);
        registerTranslations(translationBuilder, Promenade.PROM_BARRELS);
        registerTranslations(translationBuilder, RegionsUnexplored.RU_BARRELS);
        registerTranslations(translationBuilder, SnifferPlus.SP_BARRELS);
        registerTranslations(translationBuilder, TechReborn.TR_BARRELS);
        registerTranslations(translationBuilder, Vinery.LDV_BARRELS);
    }
}