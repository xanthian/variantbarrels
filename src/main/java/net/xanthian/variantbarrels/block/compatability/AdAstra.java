package net.xanthian.variantbarrels.block.compatability;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.BarrelBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.Initialise;

public class AdAstra {

    public static Block AA_AERONOS_BARREL;
    public static Block AA_GLACIAN_BARREL;
    public static Block AA_STROPHAR_BARREL;

    public static void registerBarrels() {
        AA_AERONOS_BARREL = registerBarrel("aa_aeronos_barrel");
        AA_GLACIAN_BARREL = registerBarrel("aa_glacian_barrel");
        AA_STROPHAR_BARREL = registerBarrel("aa_strophar_barrel");
    }

    public static Block register(String Id, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, Id.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String id) {
        return register(id, new BarrelBlock(FabricBlockSettings.copy(Blocks.BARREL)));
    }
}