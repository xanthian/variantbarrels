package net.xanthian.variantbarrels.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.xanthian.variantbarrels.platform.RegistryBridge;
import net.minecraft.core.registries.Registries;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.item.ModItems;
import org.jetbrains.annotations.Nullable;


import java.util.function.Supplier;

public class Vanilla {

    public static final RegistryBridge<Block> BLOCKS =
            RegistryBridge.create(Registries.BLOCK, Initialise.MOD_ID);

    public static final Supplier<Block> ACACIA_BARREL = register("acacia_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)), 300);
    public static final Supplier<Block> BAMBOO_BARREL = register("bamboo_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS)), 300);
    public static final Supplier<Block> BIRCH_BARREL = register("birch_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)), 300);
    public static final Supplier<Block> CHERRY_BARREL = register("cherry_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)), 300);
    public static final Supplier<Block> CRIMSON_BARREL = register("crimson_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)), 0);
    public static final Supplier<Block> DARK_OAK_BARREL = register("dark_oak_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)), 300);
    public static final Supplier<Block> JUNGLE_BARREL = register("jungle_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)), 300);
    public static final Supplier<Block> MANGROVE_BARREL = register("mangrove_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)), 300);
    public static final Supplier<Block> OAK_BARREL = register("oak_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)), 300);

    public static final Supplier<Block> WARPED_BARREL = register("warped_barrel",
            () -> new VariantBarrelBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)), 0);


    private static <T extends Block> Supplier<T> register(String name, Supplier<T> block, int burnTime) {
        Supplier<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, burnTime);
        return toReturn;
    }

    private static <T extends Block> Supplier<BlockItem> registerBlockItem(String name, Supplier<T> block, int burnTime) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return burnTime;
            }
        });
    }
}