package net.xanthian.variantbarrels;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class BarrelBlock extends net.minecraft.block.BarrelBlock {


    public BarrelBlock() {
        super(FabricBlockSettings.copy(Blocks.BARREL));

    }
}
