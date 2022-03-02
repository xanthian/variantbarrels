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

    public static void registerVanillaBarrels() {
        Block ACACIA_BARREL  = new VariantBarrelBlock();
        Block BIRCH_BARREL  = new VariantBarrelBlock();
        Block DARK_OAK_BARREL  = new VariantBarrelBlock();
        Block JUNGLE_BARREL  = new VariantBarrelBlock();
        Block OAK_BARREL = new VariantBarrelBlock();
        registerBarrelBlock(ACACIA_BARREL, "acacia_barrel", true);
        registerBarrelBlock(BIRCH_BARREL, "birch_barrel", true);
        registerBarrelBlock(DARK_OAK_BARREL, "dark_oak_barrel", true);
        registerBarrelBlock(JUNGLE_BARREL, "jungle_barrel", true);
        registerBarrelBlock(OAK_BARREL, "oak_barrel", true);
    }

    public static void registerNetherBarrels() {
        Block CRIMSON_BARREL  = new VariantBarrelBlock();
        Block WARPED_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(CRIMSON_BARREL, "crimson_barrel", false);
        registerBarrelBlock(WARPED_BARREL, "warped_barrel", false);
    }

    public static void registerTechRebornBarrels() {
        Block RUBBER_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(RUBBER_BARREL, "rubber_barrel", true);
    }

    public static void registerTheWildModBarrels() {
        Block MANGROVE_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(MANGROVE_BARREL, "mangrove_barrel", true);

    }

    public static void registerWilderWorldBarrels() {
        Block WISTERIA_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(WISTERIA_BARREL, "wisteria_barrel", true);
    }

    public static void registerPromenadeBarrels() {
        Block CHERRY_OAK_BARREL  = new VariantBarrelBlock();
        Block DARK_AMARANTH_BARREL  = new VariantBarrelBlock();
        Block PALM_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(CHERRY_OAK_BARREL, "cherry_oak_barrel", true);
        registerBarrelBlock(DARK_AMARANTH_BARREL, "dark_amaranth_barrel", true);
        registerBarrelBlock(PALM_BARREL, "palm_barrel", true);
    }

    public static void registerSpectrumBarrels() {
        Block BLACK_BARREL  = new VariantBarrelBlock();
        Block BLUE_BARREL  = new VariantBarrelBlock();
        Block BROWN_BARREL  = new VariantBarrelBlock();
        Block CYAN_BARREL  = new VariantBarrelBlock();
        Block GRAY_BARREL  = new VariantBarrelBlock();
        Block GREEN_BARREL  = new VariantBarrelBlock();
        Block LIGHT_BLUE_BARREL  = new VariantBarrelBlock();
        Block LIGHT_GRAY_BARREL  = new VariantBarrelBlock();
        Block LIME_BARREL  = new VariantBarrelBlock();
        Block MAGENTA_BARREL  = new VariantBarrelBlock();
        Block ORANGE_BARREL  = new VariantBarrelBlock();
        Block PINK_BARREL  = new VariantBarrelBlock();
        Block PURPLE_BARREL  = new VariantBarrelBlock();
        Block RED_BARREL  = new VariantBarrelBlock();
        Block WHITE_BARREL  = new VariantBarrelBlock();
        Block YELLOW_BARREL  = new VariantBarrelBlock();
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
        Block CYPRESS_BARREL  = new VariantBarrelBlock();
        Block ELDER_BARREL  = new VariantBarrelBlock();
        Block DRAGONS_BLOOD_BARREL  = new VariantBarrelBlock();
        Block JUNIPER_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(CYPRESS_BARREL, "cypress_barrel", true);
        registerBarrelBlock(ELDER_BARREL, "elder_barrel", true);
        registerBarrelBlock(DRAGONS_BLOOD_BARREL, "dragons_blood_barrel", true);
        registerBarrelBlock(JUNIPER_BARREL, "juniper_barrel", true);
    }

    public static void registerTwigsBarrels() {
        Block STRIPPED_BAMBOO_BARREL  = new VariantBarrelBlock();
        registerBarrelBlock(STRIPPED_BAMBOO_BARREL, "stripped_bamboo_barrel", true);
    }

    private static void registerBarrelBlock(Block Barrel, String name, boolean canBurn) {
        Identifier id  = new Identifier(Init.MOD_ID, name);
        Registry.register(Registry.BLOCK, id, Barrel);
        Registry.register(Registry.ITEM, id, new BlockItem(Barrel, new Item.Settings().group(CreativeTabGroup.VARIANTBARRELS)));
        if (canBurn)
            FuelRegistry.INSTANCE.add(Barrel, 300);
    }
}
