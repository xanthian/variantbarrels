package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.Init;

public class VariantBarrelBlock extends BarrelBlock {

    private final Identifier blockName;
    private final boolean canBurn;
    public VariantBarrelBlock(String name, boolean canBurn) {
        super(FabricBlockSettings.copy(Blocks.BARREL));
        blockName = new Identifier(Init.MOD_ID, name);
        this.canBurn = canBurn;
    }

    public Identifier getIdentifier() { return blockName; }
    public boolean canBurn() { return canBurn; }
}