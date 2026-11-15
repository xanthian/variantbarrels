package net.xanthian.variantbarrels.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VariantBarrelBlockEntity extends BarrelBlockEntity {
    public VariantBarrelBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        // The vanilla constructor also uses this method to validate the block state.
        return ModBlockEntities.BARREL.get();
    }
}
