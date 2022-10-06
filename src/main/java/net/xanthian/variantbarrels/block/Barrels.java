package net.xanthian.variantbarrels.block;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.xanthian.variantbarrels.Initialise;

import java.util.Map;

public class Barrels {

    public static Map<Identifier, Block> MOD_BARRELS = Maps.newHashMap();

    // Vanilla
    public static void addVanillaBarrels() {
        VariantBarrelBlock ACACIA_BARREL = new VariantBarrelBlock();
        registerBarrelBlock("acacia_barrel", ACACIA_BARREL, true);
        VariantBarrelBlock BIRCH_BARREL = new VariantBarrelBlock();
        registerBarrelBlock("birch_barrel", BIRCH_BARREL, true);
        VariantBarrelBlock DARK_OAK_BARREL = new VariantBarrelBlock();
        registerBarrelBlock("dark_oak_barrel", DARK_OAK_BARREL, true);
        VariantBarrelBlock JUNGLE_BARREL = new VariantBarrelBlock();
        registerBarrelBlock("jungle_barrel", JUNGLE_BARREL, true);
        VariantBarrelBlock OAK_BARREL = new VariantBarrelBlock();
        registerBarrelBlock("oak_barrel", OAK_BARREL, true);
    }
    public static void addVanilla119Barrels() {
        VariantBarrelBlock MANGROVE_BARREL = new VariantBarrelBlock();
        registerBarrelBlock("mangrove_barrel", MANGROVE_BARREL, true);
    }
    public static void addNetherBarrels() {
        VariantBarrelBlock CRIMSON_BARREL = new VariantBarrelBlock(); registerBarrelBlock("crimson_barrel", CRIMSON_BARREL,false);
        VariantBarrelBlock WARPED_BARREL = new VariantBarrelBlock(); registerBarrelBlock("warped_barrel", WARPED_BARREL,false);
    }
    public static void addTechRebornBarrels() {
        VariantBarrelBlock RUBBER_BARREL = new VariantBarrelBlock(); registerBarrelBlock("rubber_barrel", RUBBER_BARREL,true);
    }
    public static void addWilderWorldBarrels() {
        VariantBarrelBlock WISTERIA_BARREL = new VariantBarrelBlock(); registerBarrelBlock("wisteria_barrel",WISTERIA_BARREL, true);
    }
    public static void addPromenadeBarrels() {
        VariantBarrelBlock CHERRY_OAK_BARREL = new VariantBarrelBlock(); registerBarrelBlock("cherry_oak_barrel",CHERRY_OAK_BARREL, true);
        VariantBarrelBlock DARK_AMARANTH_BARREL = new VariantBarrelBlock(); registerBarrelBlock("dark_amaranth_barrel", DARK_AMARANTH_BARREL,true);
        VariantBarrelBlock PALM_BARREL = new VariantBarrelBlock(); registerBarrelBlock("palm_barrel",PALM_BARREL, true);
    }
    public static void addSpectrumBarrels() {
        VariantBarrelBlock BLACK_BARREL = new VariantBarrelBlock(); registerBarrelBlock("black_barrel",BLACK_BARREL, true);
        VariantBarrelBlock BLUE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("blue_barrel",BLUE_BARREL , true);
        VariantBarrelBlock BROWN_BARREL = new VariantBarrelBlock(); registerBarrelBlock("brown_barrel",BROWN_BARREL , true);
        VariantBarrelBlock CYAN_BARREL = new VariantBarrelBlock(); registerBarrelBlock("cyan_barrel",CYAN_BARREL , true);
        VariantBarrelBlock GRAY_BARREL = new VariantBarrelBlock(); registerBarrelBlock("gray_barrel",GRAY_BARREL , true);
        VariantBarrelBlock GREEN_BARREL = new VariantBarrelBlock(); registerBarrelBlock("green_barrel",GREEN_BARREL , true);
        VariantBarrelBlock LIGHT_BLUE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("light_blue_barrel",LIGHT_BLUE_BARREL , true);
        VariantBarrelBlock LIGHT_GRAY_BARREL = new VariantBarrelBlock(); registerBarrelBlock("light_gray_barrel",LIGHT_GRAY_BARREL , true);
        VariantBarrelBlock LIME_BARREL = new VariantBarrelBlock(); registerBarrelBlock("lime_barrel",LIME_BARREL , true);
        VariantBarrelBlock MAGENTA_BARREL = new VariantBarrelBlock(); registerBarrelBlock("magenta_barrel",MAGENTA_BARREL , true);
        VariantBarrelBlock ORANGE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("orange_barrel",ORANGE_BARREL , true);
        VariantBarrelBlock PINK_BARREL = new VariantBarrelBlock(); registerBarrelBlock("pink_barrel",PINK_BARREL , true);
        VariantBarrelBlock PURPLE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("purple_barrel",PURPLE_BARREL , true);
        VariantBarrelBlock RED_BARREL = new VariantBarrelBlock(); registerBarrelBlock("red_barrel",RED_BARREL , true);
        VariantBarrelBlock WHITE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("white_barrel",WHITE_BARREL , true);
        VariantBarrelBlock YELLOW_BARREL = new VariantBarrelBlock(); registerBarrelBlock("yellow_barrel",YELLOW_BARREL , true);
    }
    public static void addBewitchmentBarrels() {
        VariantBarrelBlock CYPRESS_BARREL = new VariantBarrelBlock(); registerBarrelBlock("cypress_barrel", CYPRESS_BARREL, true);
        VariantBarrelBlock ELDER_BARREL = new VariantBarrelBlock(); registerBarrelBlock("elder_barrel", ELDER_BARREL, true);
        VariantBarrelBlock DRAGONS_BLOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("dragons_blood_barrel", DRAGONS_BLOOD_BARREL, true);
        VariantBarrelBlock JUNIPER_BARREL = new VariantBarrelBlock(); registerBarrelBlock("juniper_barrel", JUNIPER_BARREL, true);
    }
    public static void addTwigsBarrels() {
        VariantBarrelBlock STRIPPED_BAMBOO_BARREL = new VariantBarrelBlock(); registerBarrelBlock("stripped_bamboo_barrel", STRIPPED_BAMBOO_BARREL, true);
    }
    public static void addBotaniaBarrels() {
        VariantBarrelBlock DREAMWOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("dreamwood_barrel", DREAMWOOD_BARREL, true);
        VariantBarrelBlock LIVINGWOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("livingwood_barrel", LIVINGWOOD_BARREL, true);
        VariantBarrelBlock MOSSY_DREAMWOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("mossy_dreamwood_barrel", MOSSY_DREAMWOOD_BARREL, true);
        VariantBarrelBlock MOSSY_LIVINGWOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("mossy_livingwood_barrel", MOSSY_LIVINGWOOD_BARREL, true);
        VariantBarrelBlock SHIMMERWOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("shimmerwood_barrel", SHIMMERWOOD_BARREL, true);
    }
    public static void addCroptopiaBarrels() {
        VariantBarrelBlock CINNAMON_BARREL = new VariantBarrelBlock(); registerBarrelBlock("cinnamon_barrel", CINNAMON_BARREL, true);
    }
        public static void addEpicPaladinsBarrels() {
        VariantBarrelBlock JADE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("jade_barrel", JADE_BARREL, true);
        VariantBarrelBlock MOON_BARREL = new VariantBarrelBlock(); registerBarrelBlock("moon_barrel", MOON_BARREL, true);
        VariantBarrelBlock SHADOW_BARREL = new VariantBarrelBlock(); registerBarrelBlock("shadow_barrel", SHADOW_BARREL, true);
    }
    public static void addSimpleMangoBarrels() {
        VariantBarrelBlock MANGO_BARREL = new VariantBarrelBlock(); registerBarrelBlock("mango_barrel", MANGO_BARREL, true);
    }
    public static void addTraverseBarrels() {
        VariantBarrelBlock FIR_BARREL = new VariantBarrelBlock(); registerBarrelBlock("fir_barrel", FIR_BARREL, true);
    }
    public static void addTerrestriaBarrels() {
        VariantBarrelBlock CYPRESS_BARREL2 = new VariantBarrelBlock(); registerBarrelBlock("cypress_barrel2", CYPRESS_BARREL2, true);
        VariantBarrelBlock HEMLOCK_BARREL = new VariantBarrelBlock(); registerBarrelBlock("hemlock_barrel", HEMLOCK_BARREL, true);
        VariantBarrelBlock JAPANESE_MAPLE_BARREL = new VariantBarrelBlock(); registerBarrelBlock("japanese_maple_barrel", JAPANESE_MAPLE_BARREL, true);
        VariantBarrelBlock RAINBOW_EUCALYPTUS_BARREL = new VariantBarrelBlock(); registerBarrelBlock("rainbow_eucalyptus_barrel", RAINBOW_EUCALYPTUS_BARREL, true);
        VariantBarrelBlock REDWOOD_BARREL = new VariantBarrelBlock(); registerBarrelBlock("redwood_barrel", REDWOOD_BARREL, true);
        VariantBarrelBlock RUBBER_BARREL2 = new VariantBarrelBlock(); registerBarrelBlock("rubber_barrel2", RUBBER_BARREL2, true);
        VariantBarrelBlock SAKURA_BARREL = new VariantBarrelBlock(); registerBarrelBlock("sakura_barrel", SAKURA_BARREL, true);
        VariantBarrelBlock WILLOW_BARREL = new VariantBarrelBlock(); registerBarrelBlock("willow_barrel", WILLOW_BARREL, true);
        VariantBarrelBlock YUCCA_PALM_BARREL = new VariantBarrelBlock(); registerBarrelBlock("yucca_palm_barrel", YUCCA_PALM_BARREL, true);
    }
    public static void addCinderscapeBarrels() {
        VariantBarrelBlock SCORCHED_BARREL = new VariantBarrelBlock(); registerBarrelBlock("scorched_barrel", SCORCHED_BARREL, true);
        VariantBarrelBlock UMBRAL_BARREL = new VariantBarrelBlock(); registerBarrelBlock("umbral_barrel", UMBRAL_BARREL, true);
    }

    // To-do : Updated Biome Makeover, Ecologics, Enriched
    // Not yet updated : Paradise Lost

    private static void registerBarrelBlock(String Id, Block block, boolean canBurn) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, Id.toLowerCase());
        Registry.register(Registry.BLOCK, identifier, block);
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(Initialise.VARIANTBARRELS)));
        if (canBurn) FuelRegistry.INSTANCE.add(block, 300);
        MOD_BARRELS.put(identifier, block);
        }
    }