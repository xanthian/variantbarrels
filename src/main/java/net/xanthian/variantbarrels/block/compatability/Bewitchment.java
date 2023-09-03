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

public class Bewitchment {

    public static Block BW_CYPRESS_BARREL;
    public static Block BW_DRAGONS_BLOOD_BARREL;
    public static Block BW_ELDER_BARREL;
    public static Block BW_JUNIPER_BARREL;

    public static void registerBarrels() {
        BW_CYPRESS_BARREL = registerBarrel("bw_cypress_barrel");
        BW_DRAGONS_BLOOD_BARREL = registerBarrel("bw_dragons_blood_barrel");
        BW_ELDER_BARREL = registerBarrel("bw_elder_barrel");
        BW_JUNIPER_BARREL = registerBarrel("bw_juniper_barrel");
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