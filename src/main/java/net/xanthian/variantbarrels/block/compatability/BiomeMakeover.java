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

public class BiomeMakeover {

    public static Map<Identifier, Block> BM_BARRELS = Maps.newHashMap();

    public static Block BM_ANCIENT_OAK_BARREL;
    public static Block BM_BLIGHTED_BALSA_BARREL;
    public static Block BM_SWAMP_CYPRESS_BARREL;
    public static Block BM_WILLOW_BARREL;

    public static void registerBarrels() {
        BM_ANCIENT_OAK_BARREL = registerBarrel("bm_ancient_oak_barrel");
        BM_BLIGHTED_BALSA_BARREL = registerBarrel("bm_blighted_balsa_barrel");
        BM_SWAMP_CYPRESS_BARREL = registerBarrel("bm_swamp_cypress_barrel");
        BM_WILLOW_BARREL = registerBarrel("bm_willow_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        BM_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}