package net.xanthian.variantbarrels.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.xanthian.variantbarrels.block.entity.VariantBarrelBlockEntity;

public class VariantBarrelBlock extends BarrelBlock {
    public static final MapCodec<BarrelBlock> CODEC = simpleCodec(VariantBarrelBlock::new);

    public VariantBarrelBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public MapCodec<BarrelBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new VariantBarrelBlockEntity(pos, state);
    }
}
