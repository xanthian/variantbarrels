package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.minecraft.block.Blocks;

import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

public class LangFileGenerator  extends FabricLanguageProvider {
    public LangFileGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
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

        // Ad Astra
        translationBuilder.add(AdAstra.AA_AERONOS_BARREL, "Aeronos Barrel");
        translationBuilder.add(AdAstra.AA_GLACIAN_BARREL, "Glacian Barrel");
        translationBuilder.add(AdAstra.AA_STROPHAR_BARREL, "Strophar Barrel");
        // Beach Party (Lets Do)
        translationBuilder.add(BeachParty.LDBP_PALM_BARREL, "Palm Barrel");
        // Better Archeology
        translationBuilder.add(BetterArcheology.BA_ROTTEN_BARREL, "Rotten Barrel");
        // Bewitchment
        translationBuilder.add(Bewitchment.BW_CYPRESS_BARREL, "Cypress Barrel");
        translationBuilder.add(Bewitchment.BW_DRAGONS_BLOOD_BARREL, "Dragon's Blood Barrel");
        translationBuilder.add(Bewitchment.BW_ELDER_BARREL, "Elder Barrel");
        translationBuilder.add(Bewitchment.BW_JUNIPER_BARREL, "Juniper Barrel");
        // Deeper & Darker
        translationBuilder.add(DeeperAndDarker.DAD_ECHO_BARREL, "Echo Barrel");
        // Promenade
        translationBuilder.add(Promenade.PROM_DARK_AMARANTH_BARREL, "Dark Amaranth Barrel");
        translationBuilder.add(Promenade.PROM_MAPLE_BARREL, "Maple Barrel");
        translationBuilder.add(Promenade.PROM_PALM_BARREL, "Palm Barrel");
        translationBuilder.add(Promenade.PROM_SAKURA_BARREL, "Sakura Barrel");
        // Regions Unexplored
        translationBuilder.add(RegionsUnexplored.RU_ALPHA_OAK_BARREL, "Alpha Oak Barrel");
        translationBuilder.add(RegionsUnexplored.RU_BAOBAB_BARREL,"Baobab Barrel");
        translationBuilder.add(RegionsUnexplored.RU_BLACK_PAINTED_BARREL,"Black Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_BLACKWOOD_BARREL,"Blackwood Barrel");
        translationBuilder.add(RegionsUnexplored.RU_BLUE_PAINTED_BARREL, "Blue Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_BROWN_PAINTED_BARREL, "Brown Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_CHERRY_BARREL, "Cherry Barrel");
        translationBuilder.add(RegionsUnexplored.RU_CYAN_PAINTED_BARREL, "Cyan Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_CYPRESS_BARREL, "Cypress Barrel");
        translationBuilder.add(RegionsUnexplored.RU_DEAD_BARREL, "Dead Barrel");
        translationBuilder.add(RegionsUnexplored.RU_EUCALYPTUS_BARREL, "Eucalyptus Barrel");
        translationBuilder.add(RegionsUnexplored.RU_GRAY_PAINTED_BARREL, "Gray Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_GREEN_PAINTED_BARREL, "Green Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_JOSHUA_BARREL, "Joshua Barrel");
        translationBuilder.add(RegionsUnexplored.RU_LARCH_BARREL, "Larch Barrel");
        translationBuilder.add(RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL, "Light Blue Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL, "Light Gray Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_LIME_PAINTED_BARREL, "Lime Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL, "Magenta Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_MAPLE_BARREL, "Maple Barrel");
        translationBuilder.add(RegionsUnexplored.RU_MAUVE_BARREL, "Mauve Barrel");
        translationBuilder.add(RegionsUnexplored.RU_ORANGE_PAINTED_BARREL, "Orange Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_PALM_BARREL, "Palm Barrel");
        translationBuilder.add(RegionsUnexplored.RU_PINE_BARREL, "Pine Barrel");
        translationBuilder.add(RegionsUnexplored.RU_PINK_PAINTED_BARREL, "Pink Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_PURPLE_PAINTED_BARREL, "Purple Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_REDWOOD_BARREL, "Redwood Barrel");
        translationBuilder.add(RegionsUnexplored.RU_RED_PAINTED_BARREL, "Red Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_SCULKWOOD_BARREL, "Sculkwood Barrel");
        translationBuilder.add(RegionsUnexplored.RU_WHITE_PAINTED_BARREL, "White Painted Barrel");
        translationBuilder.add(RegionsUnexplored.RU_WILLOW_BARREL, "Willow Barrel");
        translationBuilder.add(RegionsUnexplored.RU_YELLOW_PAINTED_BARREL, "Yellow Painted Barrel");
        // SnifferPlus
        translationBuilder.add(SnifferPlus.SP_STONE_PINE_BARREL, "Stone Pine Barrel");
        // Tech Reborn
        translationBuilder.add(TechReborn.TR_RUBBER_BARREL, "Rubber Barrel");
        // Vinery
        translationBuilder.add(Vinery.LDV_CHERRY_BARREL,"Cherry Barrel");
    }
}