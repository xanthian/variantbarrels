package net.xanthian.variantbarrels.block.compatability;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;

import java.util.Map;

public class Promenade {

    public static Map<Identifier, Block> PROM_BARRELS = Maps.newHashMap();

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

    public static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        PROM_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}