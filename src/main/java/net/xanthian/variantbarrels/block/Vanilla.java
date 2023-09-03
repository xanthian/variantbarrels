package net.xanthian.variantbarrels.block;

import com.google.common.collect.Maps;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.Initialise;

import java.util.Map;

public class Vanilla {

    public static Map<Identifier, Block> MOD_BARRELS = Maps.newHashMap();

    public static final VariantBarrelBlock ACACIA_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock BAMBOO_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock BIRCH_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock CHERRY_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock CRIMSON_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock DARK_OAK_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock JUNGLE_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock MANGROVE_BARREL = new VariantBarrelBlock();
    public static final VariantBarrelBlock OAK_BARREL = new VariantBarrelBlock();
    // Vanila Barrel block is made from Spruce
    public static final VariantBarrelBlock WARPED_BARREL = new VariantBarrelBlock();

    public static void registerBarrels() {
        registerBarrelBlock("acacia_barrel", ACACIA_BARREL);
        registerBarrelBlock("bamboo_barrel", BAMBOO_BARREL);
        registerBarrelBlock("birch_barrel", BIRCH_BARREL);
        registerBarrelBlock("cherry_barrel", CHERRY_BARREL);
        registerBarrelBlock("crimson_barrel", CRIMSON_BARREL);
        registerBarrelBlock("dark_oak_barrel", DARK_OAK_BARREL);
        registerBarrelBlock("jungle_barrel", JUNGLE_BARREL);
        registerBarrelBlock("mangrove_barrel", MANGROVE_BARREL);
        registerBarrelBlock("oak_barrel", OAK_BARREL);
        // No need to register spruce
        registerBarrelBlock("warped_barrel", WARPED_BARREL);
    }

    private static void registerBarrelBlock(String Id, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, Id.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        MOD_BARRELS.put(identifier, block);
    }
}