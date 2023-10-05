package net.xanthian.variantbarrels.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class Vanilla {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Initialise.MOD_ID);

    public static final RegistryObject<Block> ACACIA_BARREL = register("acacia_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_PLANKS)), 300);
    public static final RegistryObject<Block> BAMBOO_BARREL = register("bamboo_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.BAMBOO_PLANKS)), 300);
    public static final RegistryObject<Block> BIRCH_BARREL = register("birch_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)), 300);
    public static final RegistryObject<Block> CHERRY_BARREL = register("cherry_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_PLANKS)), 300);
    public static final RegistryObject<Block> CRIMSON_BARREL = register("crimson_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_PLANKS)), 0);
    public static final RegistryObject<Block> DARK_OAK_BARREL = register("dark_oak_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)), 300);
    public static final RegistryObject<Block> JUNGLE_BARREL = register("jungle_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_PLANKS)), 300);
    public static final RegistryObject<Block> MANGROVE_BARREL = register("mangrove_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_PLANKS)), 300);
    public static final RegistryObject<Block> OAK_BARREL = register("oak_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);

    public static final RegistryObject<Block> WARPED_BARREL = register("warped_barrel",
            () -> new BarrelBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS)), 0);


    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, int burnTime) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, burnTime);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<BlockItem> registerBlockItem(String name, RegistryObject<T> block, int burnTime) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()) {
            @Override
            public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
                return burnTime;
            }
        });
    }
}