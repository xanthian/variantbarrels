package net.xanthian.variantbarrels.block.compatability;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;

public class DeeperAndDarker {
    public static Block DAD_ECHO_BARREL;

    public static void registerBarrels() {
        DAD_ECHO_BARREL = registerBarrel("dad_echo_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}