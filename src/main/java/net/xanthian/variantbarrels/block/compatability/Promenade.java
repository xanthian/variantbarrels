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

public class Promenade {

    public static Block PROM_DARK_AMARANTH_BARREL;
    public static Block PROM_MAPLE_BARREL;
    public static Block PROM_PALM_BARREL;
    public static Block PROM_SAKURA_BARREL;

    public static void registerBarrels() {
        PROM_DARK_AMARANTH_BARREL = registerBarrel("prom_dark_amaranth_barrel");
        PROM_MAPLE_BARREL = registerBarrel("prom_maple_barrel");
        PROM_PALM_BARREL = registerBarrel("prom_palm_barrel");
        PROM_SAKURA_BARREL = registerBarrel("prom_sakura_barrel");
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