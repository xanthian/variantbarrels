package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;

public class VariantBarrelBlock extends BarrelBlock {

    public VariantBarrelBlock() {
        super(FabricBlockSettings.copy(Blocks.BARREL));
    }
}