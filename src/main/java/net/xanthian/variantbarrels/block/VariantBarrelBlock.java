package net.xanthian.variantbarrels.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;

public class VariantBarrelBlock extends BarrelBlock {

    public VariantBarrelBlock() {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));
    }
}