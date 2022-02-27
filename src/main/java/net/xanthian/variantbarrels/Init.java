package net.xanthian.variantbarrels;

import com.google.common.collect.Lists;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import net.xanthian.variantbarrels.util.Recipes;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Init implements ModInitializer {


    public static List<Pair<String, String[]>> woodTypes = Lists.newArrayList(
        );
    public static List<Pair<String, String[]>> plankwoodTypes = Lists.newArrayList(
        );

    public static final String MOD_ID = "variantbarrels";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //Vanilla
    public static final Block ACACIA_BARREL = new VariantBarrelBlock();
    public static final Block BIRCH_BARREL = new VariantBarrelBlock();
    public static final Block DARK_OAK_BARREL = new VariantBarrelBlock();
    public static final Block JUNGLE_BARREL = new VariantBarrelBlock();
    public static final Block OAK_BARREL = new VariantBarrelBlock();
    //Nether
    public static final Block CRIMSON_BARREL = new VariantBarrelBlock();
    public static final Block WARPED_BARREL = new VariantBarrelBlock();
    //Tech Reborn
    public static final Block RUBBER_BARREL = new VariantBarrelBlock();
    //The Wild Mod
    public static final Block MANGROVE_BARREL = new VariantBarrelBlock();
    //Wilder World
    public static final Block WISTERIA_BARREL = new VariantBarrelBlock();
    //Promenade
    public static final Block CHERRY_OAK_BARREL = new VariantBarrelBlock();
    public static final Block DARK_AMARANTH_BARREL = new VariantBarrelBlock();
    public static final Block PALM_BARREL = new VariantBarrelBlock();
    // Spectrum
    public static final Block BLACK_BARREL = new VariantBarrelBlock();
    public static final Block BLUE_BARREL = new VariantBarrelBlock();
    public static final Block BROWN_BARREL = new VariantBarrelBlock();
    public static final Block CYAN_BARREL = new VariantBarrelBlock();
    public static final Block GRAY_BARREL = new VariantBarrelBlock();
    public static final Block GREEN_BARREL = new VariantBarrelBlock();
    public static final Block LIGHT_BLUE_BARREL = new VariantBarrelBlock();
    public static final Block LIGHT_GRAY_BARREL = new VariantBarrelBlock();
    public static final Block LIME_BARREL = new VariantBarrelBlock();
    public static final Block MAGENTA_BARREL = new VariantBarrelBlock();
    public static final Block ORANGE_BARREL = new VariantBarrelBlock();
    public static final Block PINK_BARREL = new VariantBarrelBlock();
    public static final Block PURPLE_BARREL = new VariantBarrelBlock();
    public static final Block RED_BARREL = new VariantBarrelBlock();
    public static final Block WHITE_BARREL = new VariantBarrelBlock();
    public static final Block YELLOW_BARREL = new VariantBarrelBlock();
    // Bewitchment
    public static final Block CYPRESS_BARREL = new VariantBarrelBlock();
    public static final Block ELDER_BARREL = new VariantBarrelBlock();
    public static final Block DRAGONS_BLOOD_BARREL = new VariantBarrelBlock();
    public static final Block JUNIPER_BARREL = new VariantBarrelBlock();

    @Override
    public void onInitialize() {

            // Disable Vanilla barrels if Blockus is installed
        if (!FabricLoader.getInstance().isModLoaded("blockus")) {
            registerBarrelBlock(ACACIA_BARREL, "acacia_barrel", true);
            woodTypes.add(Pair.of("acacia", new String[0]));
            registerBarrelBlock(BIRCH_BARREL, "birch_barrel", true);
            woodTypes.add(Pair.of("birch", new String[0]));
            registerBarrelBlock(DARK_OAK_BARREL, "dark_oak_barrel", true);
            woodTypes.add(Pair.of("dark_oak", new String[0]));
            registerBarrelBlock(JUNGLE_BARREL, "jungle_barrel", true);
            woodTypes.add(Pair.of("jungle", new String[0]));
            registerBarrelBlock(OAK_BARREL, "oak_barrel", true);
            woodTypes.add(Pair.of("oak", new String[0]));
        }
        if (FabricLoader.getInstance().isModLoaded("blockus")) {
            LOGGER.info("Blockus detected, removing Barrels from Variant Barrels");
        }
        // Disable Nether barrels if Better Nether is installed
        if (!FabricLoader.getInstance().isModLoaded("betternether")) {
            registerBarrelBlock(CRIMSON_BARREL, "crimson_barrel", false);
            woodTypes.add(Pair.of("crimson", new String[0]));
            registerBarrelBlock(WARPED_BARREL, "warped_barrel", false);
            woodTypes.add(Pair.of("warped", new String[0]));            
        }
        if (FabricLoader.getInstance().isModLoaded("betternether")) {
            LOGGER.info("Better Nether detected, removing Barrels from Variant Barrels");
        }
        // Tech Reborn
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            registerBarrelBlock(RUBBER_BARREL, "rubber_barrel", true);
            plankwoodTypes.add(Pair.of("rubber", new String[]{"techreborn"}));
            LOGGER.info("Tech Reborn detected, creating Crafting Tables from Tech Reborn Planks");
        }
        // The Wild Mod
        if (FabricLoader.getInstance().isModLoaded("twm")) {
            registerBarrelBlock(MANGROVE_BARREL, "mangrove_barrel", true);
            woodTypes.add(Pair.of("mangrove", new String[]{"twm"}));
            LOGGER.info("The Wild Mod detected, creating Crafting Tables from The Wild Mod Planks");
        }
        // Wilder World
        if (FabricLoader.getInstance().isModLoaded("wilderworld")) {
            registerBarrelBlock(WISTERIA_BARREL, "wisteria_barrel", true);
            woodTypes.add(Pair.of("wisteria", new String[]{"wilderworld"}));
            LOGGER.info("Wilder World detected, creating Crafting Tables from Wilder World Planks");
        }
        // Promenade
        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            registerBarrelBlock(CHERRY_OAK_BARREL, "cherry_oak_barrel", true);
            woodTypes.add(Pair.of("cherry_oak", new String[]{"promenade"}));
            registerBarrelBlock(DARK_AMARANTH_BARREL, "dark_amaranth_barrel", true);
            woodTypes.add(Pair.of("dark_amaranth", new String[]{"promenade"}));
            registerBarrelBlock(PALM_BARREL, "palm_barrel", true);
            woodTypes.add(Pair.of("palm", new String[]{"promenade"}));
            LOGGER.info("Promenade detected, creating Crafting Tables from Promenade Planks");
        }
        // Spectrum
        if (FabricLoader.getInstance().isModLoaded("spectrum")) {
            registerBarrelBlock(BLACK_BARREL, "black_barrel", true);
            plankwoodTypes.add(Pair.of("black", new String[]{"spectrum"}));
            registerBarrelBlock(BLUE_BARREL, "blue_barrel", true);
            plankwoodTypes.add(Pair.of("blue", new String[]{"spectrum"}));
            registerBarrelBlock(BROWN_BARREL, "brown_barrel", true);
            plankwoodTypes.add(Pair.of("brown", new String[]{"spectrum"}));
            registerBarrelBlock(CYAN_BARREL, "cyan_barrel", true);
            plankwoodTypes.add(Pair.of("cyan", new String[]{"spectrum"}));
            registerBarrelBlock(GRAY_BARREL, "gray_barrel", true);
            plankwoodTypes.add(Pair.of("gray", new String[]{"spectrum"}));
            registerBarrelBlock(GREEN_BARREL, "green_barrel", true);
            plankwoodTypes.add(Pair.of("green", new String[]{"spectrum"}));
            registerBarrelBlock(LIGHT_BLUE_BARREL, "light_blue_barrel", true);
            plankwoodTypes.add(Pair.of("light_blue", new String[]{"spectrum"}));
            registerBarrelBlock(LIGHT_GRAY_BARREL, "light_gray_barrel", true);
            plankwoodTypes.add(Pair.of("light_gray", new String[]{"spectrum"}));
            registerBarrelBlock(LIME_BARREL, "lime_barrel", true);
            plankwoodTypes.add(Pair.of("lime", new String[]{"spectrum"}));
            registerBarrelBlock(MAGENTA_BARREL, "magenta_barrel", true);
            plankwoodTypes.add(Pair.of("magenta", new String[]{"spectrum"}));
            registerBarrelBlock(ORANGE_BARREL, "orange_barrel", true);
            plankwoodTypes.add(Pair.of("orange", new String[]{"spectrum"}));
            registerBarrelBlock(PINK_BARREL, "pink_barrel", true);
            plankwoodTypes.add(Pair.of("pink", new String[]{"spectrum"}));
            registerBarrelBlock(PURPLE_BARREL, "purple_barrel", true);
            plankwoodTypes.add(Pair.of("purple", new String[]{"spectrum"}));
            registerBarrelBlock(RED_BARREL, "red_barrel", true);
            plankwoodTypes.add(Pair.of("red", new String[]{"spectrum"}));
            registerBarrelBlock(WHITE_BARREL, "white_barrel", true);
            plankwoodTypes.add(Pair.of("white", new String[]{"spectrum"}));
            registerBarrelBlock(YELLOW_BARREL, "yellow_barrel", true);
            plankwoodTypes.add(Pair.of("yellow", new String[]{"spectrum"}));
            LOGGER.info("Spectrum detected, creating Crafting Tables from Spectrum Planks");
         }
        // Bewitchment
        if (FabricLoader.getInstance().isModLoaded("bewitchment")) {
            registerBarrelBlock(CYPRESS_BARREL, "cypress_barrel", true);
            woodTypes.add(Pair.of("cypress", new String[]{"bewitchment"}));
            registerBarrelBlock(ELDER_BARREL, "elder_barrel", true);
            woodTypes.add(Pair.of("elder", new String[]{"bewitchment"}));
            registerBarrelBlock(DRAGONS_BLOOD_BARREL, "dragons_blood_barrel", true);
            woodTypes.add(Pair.of("dragons_blood", new String[]{"bewitchment"}));
            registerBarrelBlock(JUNIPER_BARREL, "juniper_barrel", true);
            woodTypes.add(Pair.of("juniper", new String[]{"bewitchment"}));
            LOGGER.info("Bewitchment detected, creating Crafting Tables from Bewitchment Planks");
        }
    }
    private void registerBarrelBlock(Block Barrel, String name, boolean canBurn) {

        Identifier id = new Identifier(MOD_ID, name);
        Registry.register(Registry.BLOCK, id, Barrel);
        Registry.register(Registry.ITEM, id, new BlockItem(Barrel, new Item.Settings().group(CreativeTabGroup.VARIANTBARRELS)));
        if (canBurn)
            FuelRegistry.INSTANCE.add(Barrel, 300);
    }
}