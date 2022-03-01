package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.xanthian.variantbarrels.CreativeTabGroup;
import net.xanthian.variantbarrels.Init;

public class Barrels {


    //Vanilla
    public static Block ACACIA_BARREL;
    public static Block BIRCH_BARREL;
    public static Block DARK_OAK_BARREL;
    public static Block JUNGLE_BARREL;
    public static Block OAK_BARREL ;
    //Nether
    public static Block CRIMSON_BARREL;
    public static Block WARPED_BARREL;
    //Tech Reborn
    public static Block RUBBER_BARREL;
    //The Wild Mod
    public static Block MANGROVE_BARREL;
    //Wilder World
    public static Block WISTERIA_BARREL;
    //Promenade
    public static Block CHERRY_OAK_BARREL;
    public static Block DARK_AMARANTH_BARREL;
    public static Block PALM_BARREL;
    // Spectrum
    public static Block BLACK_BARREL;
    public static Block BLUE_BARREL;
    public static Block BROWN_BARREL;
    public static Block CYAN_BARREL;
    public static Block GRAY_BARREL;
    public static Block GREEN_BARREL;
    public static Block LIGHT_BLUE_BARREL;
    public static Block LIGHT_GRAY_BARREL;
    public static Block LIME_BARREL;
    public static Block MAGENTA_BARREL;
    public static Block ORANGE_BARREL;
    public static Block PINK_BARREL;
    public static Block PURPLE_BARREL;
    public static Block RED_BARREL;
    public static Block WHITE_BARREL;
    public static Block YELLOW_BARREL;
    // Bewitchment
    public static Block CYPRESS_BARREL;
    public static Block ELDER_BARREL;
    public static Block DRAGONS_BLOOD_BARREL;
    public static Block JUNIPER_BARREL;

    public static void registerVanillaBarrels() {
        ACACIA_BARREL  = new VariantBarrelBlock();
        BIRCH_BARREL  = new VariantBarrelBlock();
        DARK_OAK_BARREL  = new VariantBarrelBlock();
        JUNGLE_BARREL  = new VariantBarrelBlock();
        OAK_BARREL = new VariantBarrelBlock();
        registerBarrelBlock(ACACIA_BARREL, "acacia_barrel", true);
        registerBarrelBlock(BIRCH_BARREL, "birch_barrel", true);
        registerBarrelBlock(DARK_OAK_BARREL, "dark_oak_barrel", true);
        registerBarrelBlock(JUNGLE_BARREL, "jungle_barrel", true);
        registerBarrelBlock(OAK_BARREL, "oak_barrel", true);
    }

    public static void registerNetherBarrels() {
        CRIMSON_BARREL  = new VariantBarrelBlock();
        WARPED_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(CRIMSON_BARREL, "crimson_barrel", false);
        registerBarrelBlock(WARPED_BARREL, "warped_barrel", false);
    }

    public static void registerTechRebornBarrels() {
        RUBBER_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(RUBBER_BARREL, "rubber_barrel", true);
    }

    public static void registerTheWildModBarrels() {
        MANGROVE_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(MANGROVE_BARREL, "mangrove_barrel", true);

    }

    public static void registerWilderWorldBarrels() {
        WISTERIA_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(WISTERIA_BARREL, "wisteria_barrel", true);
    }

    public static void registerPromenadeBarrels() {
        CHERRY_OAK_BARREL  = new VariantBarrelBlock();
        DARK_AMARANTH_BARREL  = new VariantBarrelBlock();
        PALM_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(CHERRY_OAK_BARREL, "cherry_oak_barrel", true);
        registerBarrelBlock(DARK_AMARANTH_BARREL, "dark_amaranth_barrel", true);
        registerBarrelBlock(PALM_BARREL, "palm_barrel", true);
    }

    public static void registerSpectrumBarrels() {
       // BLACK_BARREL  = new VariantBarrelBlock();
        //BLUE_BARREL  = new VariantBarrelBlock();
        //BROWN_BARREL  = new VariantBarrelBlock();
        //CYAN_BARREL  = new VariantBarrelBlock();
       // GRAY_BARREL  = new VariantBarrelBlock();
        //GREEN_BARREL  = new VariantBarrelBlock();
       // LIGHT_BLUE_BARREL  = new VariantBarrelBlock();
       // LIGHT_GRAY_BARREL  = new VariantBarrelBlock();
       // LIME_BARREL  = new VariantBarrelBlock();
       // MAGENTA_BARREL  = new VariantBarrelBlock();
       // ORANGE_BARREL  = new VariantBarrelBlock();
       // PINK_BARREL  = new VariantBarrelBlock();
        //PURPLE_BARREL  = new VariantBarrelBlock();
       // RED_BARREL  = new VariantBarrelBlock();
       // WHITE_BARREL  = new VariantBarrelBlock();
       // YELLOW_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(BLACK_BARREL, "black_barrel", true);
        registerBarrelBlock(BLUE_BARREL, "blue_barrel", true);
        registerBarrelBlock(BROWN_BARREL, "brown_barrel", true);
        registerBarrelBlock(CYAN_BARREL, "cyan_barrel", true);
        registerBarrelBlock(GRAY_BARREL, "gray_barrel", true);
        registerBarrelBlock(GREEN_BARREL, "green_barrel", true);
        registerBarrelBlock(LIGHT_BLUE_BARREL, "light_blue_barrel", true);
        registerBarrelBlock(LIGHT_GRAY_BARREL, "light_gray_barrel", true);
        registerBarrelBlock(LIME_BARREL, "lime_barrel", true);
        registerBarrelBlock(MAGENTA_BARREL, "magenta_barrel", true);
        registerBarrelBlock(ORANGE_BARREL, "orange_barrel", true);
        registerBarrelBlock(PINK_BARREL, "pink_barrel", true);
        registerBarrelBlock(PURPLE_BARREL, "purple_barrel", true);
        registerBarrelBlock(RED_BARREL, "red_barrel", true);
        registerBarrelBlock(WHITE_BARREL, "white_barrel", true);
        registerBarrelBlock(YELLOW_BARREL, "yellow_barrel", true);
    }

    public static void registerBewitchmentBarrels() {
        //CYPRESS_BARREL  = new VariantBarrelBlock();
       // ELDER_BARREL  = new VariantBarrelBlock();
       // DRAGONS_BLOOD_BARREL  = new VariantBarrelBlock();
        //JUNIPER_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(CYPRESS_BARREL, "cypress_barrel", true);
        registerBarrelBlock(ELDER_BARREL, "elder_barrel", true);
        registerBarrelBlock(DRAGONS_BLOOD_BARREL, "dragons_blood_barrel", true);
        registerBarrelBlock(JUNIPER_BARREL, "juniper_barrel", true);
    }

    private static void registerBarrelBlock(Block Barrel, String name, boolean canBurn) {
        Identifier id  = new Identifier(Init.MOD_ID, name);
        Registry.register(Registry.BLOCK, id, Barrel);
        Registry.register(Registry.ITEM, id, new BlockItem(Barrel, new Item.Settings().group(CreativeTabGroup.VARIANTBARRELS)));
        if (canBurn)
            FuelRegistry.INSTANCE.add(Barrel, 300);
    }
}
