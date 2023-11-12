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

public class AdAstra {

    public static Map<Identifier, Block> AA_BARRELS = Maps.newHashMap();

    public static Block AA_AERONOS_BARREL;
    public static Block AA_GLACIAN_BARREL;
    public static Block AA_STROPHAR_BARREL;

    public static void registerBarrels() {
        AA_AERONOS_BARREL = registerBarrel("aa_aeronos_barrel");
        AA_GLACIAN_BARREL = registerBarrel("aa_glacian_barrel");
        AA_STROPHAR_BARREL = registerBarrel("aa_strophar_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        AA_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}