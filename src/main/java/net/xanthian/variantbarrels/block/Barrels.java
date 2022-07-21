package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.xanthian.variantbarrels.Group;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.BarrelBlock;

public class Barrels {

    // Vanilla
    public static void addVanillaBarrels() {
        BarrelBlock ACACIA_BARREL = new BarrelBlock();          registerBarrelBlock("acacia_barrel", ACACIA_BARREL,true);
        BarrelBlock BIRCH_BARREL = new BarrelBlock();           registerBarrelBlock("birch_barrel", BIRCH_BARREL,true);
        BarrelBlock DARK_OAK_BARREL = new BarrelBlock();        registerBarrelBlock("dark_oak_barrel", DARK_OAK_BARREL,true);
        BarrelBlock JUNGLE_BARREL = new BarrelBlock();          registerBarrelBlock("jungle_barrel", JUNGLE_BARREL,true);
        BarrelBlock OAK_BARREL = new BarrelBlock();             registerBarrelBlock("oak_barrel", OAK_BARREL,true);
        BarrelBlock MANGROVE_BARREL = new BarrelBlock();        registerBarrelBlock("mangrove_barrel", MANGROVE_BARREL,true);

    }

    public static void addNetherBarrels() {
        BarrelBlock CRIMSON_BARREL = new BarrelBlock();         registerBarrelBlock("crimson_barrel", CRIMSON_BARREL,false);
        BarrelBlock WARPED_BARREL = new BarrelBlock();          registerBarrelBlock("warped_barrel", WARPED_BARREL,false);
    }

    public static void addTechRebornBarrels() {
        BarrelBlock RUBBER_BARREL = new BarrelBlock();          registerBarrelBlock("rubber_barrel", RUBBER_BARREL,true);
    }

    public static void addWilderWorldBarrels() {
        BarrelBlock WISTERIA_BARREL = new BarrelBlock();        registerBarrelBlock("wisteria_barrel",WISTERIA_BARREL, true);
    }

    public static void addPromenadeBarrels() {
        BarrelBlock CHERRY_OAK_BARREL = new BarrelBlock();      registerBarrelBlock("cherry_oak_barrel",CHERRY_OAK_BARREL, true);
        BarrelBlock DARK_AMARANTH_BARREL = new BarrelBlock();   registerBarrelBlock("dark_amaranth_barrel", DARK_AMARANTH_BARREL,true);
        BarrelBlock PALM_BARREL = new BarrelBlock();            registerBarrelBlock("palm_barrel",PALM_BARREL, true);
    }

    public static void addSpectrumBarrels() {
        BarrelBlock BLACK_BARREL = new BarrelBlock();           registerBarrelBlock("black_barrel",BLACK_BARREL, true);
        BarrelBlock BLUE_BARREL = new BarrelBlock();            registerBarrelBlock("blue_barrel",BLUE_BARREL , true);
        BarrelBlock BROWN_BARREL = new BarrelBlock();           registerBarrelBlock("brown_barrel",BROWN_BARREL , true);
        BarrelBlock CYAN_BARREL = new BarrelBlock();            registerBarrelBlock("cyan_barrel",CYAN_BARREL , true);
        BarrelBlock GRAY_BARREL = new BarrelBlock();            registerBarrelBlock("gray_barrel",GRAY_BARREL , true);
        BarrelBlock GREEN_BARREL = new BarrelBlock();           registerBarrelBlock("green_barrel",GREEN_BARREL , true);
        BarrelBlock LIGHT_BLUE_BARREL = new BarrelBlock();      registerBarrelBlock("light_blue_barrel",LIGHT_BLUE_BARREL , true);
        BarrelBlock LIGHT_GRAY_BARREL = new BarrelBlock();      registerBarrelBlock("light_gray_barrel",LIGHT_GRAY_BARREL , true);
        BarrelBlock LIME_BARREL = new BarrelBlock();            registerBarrelBlock("lime_barrel",LIME_BARREL , true);
        BarrelBlock MAGENTA_BARREL = new BarrelBlock();         registerBarrelBlock("magenta_barrel",MAGENTA_BARREL , true);
        BarrelBlock ORANGE_BARREL = new BarrelBlock();          registerBarrelBlock("orange_barrel",ORANGE_BARREL , true);
        BarrelBlock PINK_BARREL = new BarrelBlock();            registerBarrelBlock("pink_barrel",PINK_BARREL , true);
        BarrelBlock PURPLE_BARREL = new BarrelBlock();          registerBarrelBlock("purple_barrel",PURPLE_BARREL , true);
        BarrelBlock RED_BARREL = new BarrelBlock();             registerBarrelBlock("red_barrel",RED_BARREL , true);
        BarrelBlock WHITE_BARREL = new BarrelBlock();           registerBarrelBlock("white_barrel",WHITE_BARREL , true);
        BarrelBlock YELLOW_BARREL = new BarrelBlock();          registerBarrelBlock("yellow_barrel",YELLOW_BARREL , true);
    }

    public static void addBewitchmentBarrels() {
        BarrelBlock CYPRESS_BARREL = new BarrelBlock();         registerBarrelBlock("cypress_barrel", CYPRESS_BARREL, true);
        BarrelBlock ELDER_BARREL = new BarrelBlock();           registerBarrelBlock("elder_barrel", ELDER_BARREL, true);
        BarrelBlock DRAGONS_BLOOD_BARREL = new BarrelBlock();   registerBarrelBlock("dragons_blood_barrel", DRAGONS_BLOOD_BARREL, true);
        BarrelBlock JUNIPER_BARREL = new BarrelBlock();         registerBarrelBlock("juniper_barrel", JUNIPER_BARREL, true);
    }

    public static void addTwigsBarrels() {
        BarrelBlock STRIPPED_BAMBOO_BARREL = new BarrelBlock(); registerBarrelBlock("stripped_bamboo_barrel", STRIPPED_BAMBOO_BARREL, true);
    }

    public static void addBotaniaBarrels() {
        BarrelBlock DREAMWOOD_BARREL = new BarrelBlock();       registerBarrelBlock("dreamwood_barrel", DREAMWOOD_BARREL, true);
        BarrelBlock LIVINGWOOD_BARREL = new BarrelBlock();      registerBarrelBlock("livingwood_barrel", LIVINGWOOD_BARREL, true);
        BarrelBlock MOSSY_DREAMWOOD_BARREL = new BarrelBlock(); registerBarrelBlock("mossy_dreamwood_barrel", MOSSY_DREAMWOOD_BARREL, true);
        BarrelBlock MOSSY_LIVINGWOOD_BARREL = new BarrelBlock();registerBarrelBlock("mossy_livingwood_barrel", MOSSY_LIVINGWOOD_BARREL, true);
        BarrelBlock SHIMMERWOOD_BARREL = new BarrelBlock();     registerBarrelBlock("shimmerwood_barrel", SHIMMERWOOD_BARREL, true);
    }

    private static void registerBarrelBlock(String Id, Block block, boolean canBurn) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, Id.toLowerCase());
        Registry.register(Registry.BLOCK, identifier, block);
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(Group.VARIANTBARRELS)));
        if (canBurn) FuelRegistry.INSTANCE.add(block, 300);
        }
    }
