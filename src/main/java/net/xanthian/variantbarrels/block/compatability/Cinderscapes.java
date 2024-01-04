package net.xanthian.variantbarrels.block.compatability;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.Initialise;

import java.util.Map;

public class Cinderscapes {
    public static Map<Identifier, Block> CS_BARRELS = Maps.newHashMap();

    public static Block CS_SCORCHED_BARREL;
    public static Block CS_UMBRAL_BARREL;

    public static void registerBarrels() {
        CS_SCORCHED_BARREL = registerBarrel("cs_scorched_barrel");
        CS_UMBRAL_BARREL = registerBarrel("cs_umbral_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        CS_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new BarrelBlock(FabricBlockSettings.copy(Blocks.BARREL)));
    }
}