package net.xanthian.variantbarrels.block.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Initialise.MOD_ID);

    public static final RegistryObject<BlockEntityType<VariantBarrelBlockEntity>> BARREL =
            BLOCK_ENTITIES.register("barrel", () -> BlockEntityType.Builder.of(
                    VariantBarrelBlockEntity::new,
                    ForgeRegistries.BLOCKS.getValues().stream()
                            .filter(block -> block instanceof VariantBarrelBlock)
                            .toArray(Block[]::new)
            ).build(null));
}
