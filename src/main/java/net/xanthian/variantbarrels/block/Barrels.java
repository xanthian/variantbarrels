package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;
import net.xanthian.variantbarrels.CreativeTabGroup;
import net.xanthian.variantbarrels.Init;

public class Barrels {

    public static void addVanillaBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("acacia_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("birch_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("dark_oak_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("jungle_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("oak_barrel", true));
    }

    public static void addNetherBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("crimson_barrel", false));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("warped_barrel", false));
    }

    public static void addTechRebornBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("rubber_barrel", true));
    }

    public static void addTheWildModBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("mangrove_barrel", true));
    }

    public static void addWilderWorldBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("wisteria_barrel", true));
    }

    public static void addPromenadeBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("cherry_oak_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("dark_amaranth_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("palm_barrel", true));
    }

    public static void addSpectrumBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("black_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("blue_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("brown_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("cyan_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("gray_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("green_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("light_blue_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("light_gray_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("lime_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("magenta_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("orange_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("pink_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("purple_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("red_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("white_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("yellow_barrel", true));
    }

    public static void addBewitchmentBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("cypress_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("elder_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("dragons_blood_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("juniper_barrel", true));
    }

    public static void addTwigsBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("stripped_bamboo_barrel", true));
    }

    public static void addBotaniaBarrels() {
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("dreamwood_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("livingwood_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("mossy_dreamwood_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("mossy_livingwood_barrel", true));
        Init.REGISTERED_BARRELS.add(new VariantBarrelBlock("shimmerwood_barrel", true));
    }
    public static void registerAllBarrels()
    {
        for (Block block : Init.REGISTERED_BARRELS)
        {
            if (block instanceof VariantBarrelBlock barrel)
            {
                Registry.register(Registry.BLOCK, barrel.getIdentifier(), barrel);
                Registry.register(Registry.ITEM, barrel.getIdentifier(), new BlockItem(barrel, new Item.Settings().group(CreativeTabGroup.VARIANTBARRELS)));
                if (barrel.canBurn())
                {
                    FuelRegistry.INSTANCE.add(barrel, 300);
                }
            }
        }
    }
}