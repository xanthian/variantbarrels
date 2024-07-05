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

public class Botania {

    public static Map<Identifier, Block> BOT_BARRELS = Maps.newHashMap();

    public static Block BOT_DREAMWOOD_BARREL;
    public static Block BOT_LIVINGWOOD_BARREL;
    public static Block BOT_SHIMMERWOOD_BARREL;

    public static void registerBarrels() {
        BOT_DREAMWOOD_BARREL = registerBarrel("bot_dreamwood_barrel");
        BOT_LIVINGWOOD_BARREL = registerBarrel("bot_livingwood_barrel");
        BOT_SHIMMERWOOD_BARREL = registerBarrel("bot_shimmerwood_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = Identifier.of(Initialise.MOD_ID, name);
        Registry.register(Registries.BLOCK, identifier, block);
        BOT_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new Item.Settings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}