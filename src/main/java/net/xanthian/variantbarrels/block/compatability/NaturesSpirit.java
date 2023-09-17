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

public class NaturesSpirit {

    public static Map<Identifier, Block> NS_BARRELS = Maps.newHashMap();

    public static Block NS_ASPEN_BARREL;
    public static Block NS_CYPRESS_BARREL;
    public static Block NS_FIR_BARREL;
    public static Block NS_JOSHUA_BARREL;
    public static Block NS_MAPLE_BARREL;
    public static Block NS_OLIVE_BARREL;
    public static Block NS_REDWOOD_BARREL;
    public static Block NS_SUGI_BARREL;
    public static Block NS_WILLOW_BARREL;
    public static Block NS_WISTERIA_BARREL;

    public static void registerBarrels() {
        NS_ASPEN_BARREL = registerBarrel("ns_aspen_barrel");
        NS_CYPRESS_BARREL = registerBarrel("ns_cypress_barrel");
        NS_FIR_BARREL = registerBarrel("ns_fir_barrel");
        NS_JOSHUA_BARREL = registerBarrel("ns_joshua_barrel");
        NS_MAPLE_BARREL = registerBarrel("ns_maple_barrel");
        NS_OLIVE_BARREL = registerBarrel("ns_olive_barrel");
        NS_REDWOOD_BARREL = registerBarrel("ns_redwood_barrel");
        NS_SUGI_BARREL = registerBarrel("ns_sugi_barrel");
        NS_WILLOW_BARREL = registerBarrel("ns_willow_barrel");
        NS_WISTERIA_BARREL = registerBarrel("ns_wisteria_barrel");
    }

    private static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        NS_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    private static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}