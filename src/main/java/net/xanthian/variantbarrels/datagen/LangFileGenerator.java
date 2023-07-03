package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Blocks;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.Barrels;

public class LangFileGenerator  extends FabricLanguageProvider {
    public LangFileGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        translationBuilder.add(Initialise.ITEM_GROUP, "Variant Barrels");

        translationBuilder.add(Barrels.ACACIA_BARREL, "Acacia Barrel");
        translationBuilder.add(Barrels.BAMBOO_BARREL, "Bamboo Barrel");
        translationBuilder.add(Barrels.BIRCH_BARREL, "Birch Barrel");
        translationBuilder.add(Barrels.CHERRY_BARREL, "Cherry Barrel");
        translationBuilder.add(Barrels.CRIMSON_BARREL, "Crimson Barrel");
        translationBuilder.add(Barrels.DARK_OAK_BARREL, "Dark Oak Barrel");
        translationBuilder.add(Barrels.JUNGLE_BARREL, "Jungle Barrel");
        translationBuilder.add(Barrels.MANGROVE_BARREL, "Mangrove Barrel");
        translationBuilder.add(Barrels.OAK_BARREL, "Oak Barrel");
        translationBuilder.add(Blocks.BARREL, "Spruce Barrel");
        translationBuilder.add(Barrels.WARPED_BARREL, "Warped Barrel");
    }
}