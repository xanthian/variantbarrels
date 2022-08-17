package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VariantBarrelBlock extends net.minecraft.block.BarrelBlock {

    public static final TagKey<Block> FISHERMAN_WORKSTATION = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "workstation/fisherman"));
    public static final TagKey<Block> BARREL = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "barrel"));
    public static final TagKey<Block> WOODEN_BARRELS = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "wooden_barrels"));
    public static final TagKey<Item> BARREL_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "barrel"));
    public static final TagKey<Item> WOODEN_BARRELS_ITEM = TagKey.of(Registry.ITEM_KEY, new Identifier("c", "wooden_barrels"));
    public VariantBarrelBlock() {
        super(FabricBlockSettings.copy(Blocks.BARREL));

    }
}
