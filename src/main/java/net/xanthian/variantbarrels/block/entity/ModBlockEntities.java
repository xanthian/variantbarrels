package net.xanthian.variantbarrels.block.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.xanthian.variantbarrels.platform.RegistryBridge;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.function.Supplier;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;

public class ModBlockEntities {
    public static final RegistryBridge<BlockEntityType<?>> BLOCK_ENTITIES =
            RegistryBridge.create(Registries.BLOCK_ENTITY_TYPE, Initialise.MOD_ID);

    public static final Supplier<BlockEntityType<VariantBarrelBlockEntity>> BARREL =
            BLOCK_ENTITIES.register("barrel", () -> BlockEntityType.Builder.of(
                    VariantBarrelBlockEntity::new,
                    BuiltInRegistries.BLOCK.stream()
                            .filter(block -> block instanceof VariantBarrelBlock)
                            .toArray(Block[]::new)
            ).build(null));
}
