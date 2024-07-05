package net.xanthian.variantbarrels.block.compatability;

import com.google.common.collect.Maps;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;

import java.util.Map;

public class TechReborn {

    public static Map<Identifier, Block> TR_BARRELS = Maps.newHashMap();

    public static Block TR_RUBBER_BARREL;

    public static void registerBarrels() {
        TR_RUBBER_BARREL = registerBarrel("tr_rubber_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = Identifier.of(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        TR_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}