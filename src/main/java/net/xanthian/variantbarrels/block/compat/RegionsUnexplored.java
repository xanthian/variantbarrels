package net.xanthian.variantbarrels.block.compat;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import net.xanthian.variantbarrels.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class RegionsUnexplored {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Initialise.MOD_ID);

    public static final RegistryObject<Block> RU_ALPHA_BARREL = register("ru_alpha_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BAOBAB_BARREL = register("ru_baobab_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BLACK_PAINTED_BARREL = register("ru_black_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BLACKWOOD_BARREL = register("ru_blackwood_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BLUE_PAINTED_BARREL = register("ru_blue_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BROWN_PAINTED_BARREL = register("ru_brown_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_CYAN_PAINTED_BARREL = register("ru_cyan_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_CYPRESS_BARREL = register("ru_cypress_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_DEAD_BARREL = register("ru_dead_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 0);
    public static final RegistryObject<Block> RU_EUCALYPTUS_BARREL = register("ru_eucalyptus_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_GREEN_PAINTED_BARREL = register("ru_green_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_GRAY_PAINTED_BARREL = register("ru_gray_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_JOSHUA_BARREL = register("ru_joshua_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_LARCH_BARREL = register("ru_larch_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_LIGHT_BLUE_PAINTED_BARREL = register("ru_light_blue_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_LIGHT_GRAY_PAINTED_BARREL = register("ru_light_gray_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_LIME_PAINTED_BARREL = register("ru_lime_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_MAGENTA_PAINTED_BARREL = register("ru_magenta_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_MAPLE_BARREL = register("ru_maple_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_MAUVE_BARREL = register("ru_mauve_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_ORANGE_PAINTED_BARREL = register("ru_orange_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_PALM_BARREL = register("ru_palm_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_PINE_BARREL = register("ru_pine_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_PINK_PAINTED_BARREL = register("ru_pink_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_PURPLE_PAINTED_BARREL = register("ru_purple_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_RED_PAINTED_BARREL = register("ru_red_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_REDWOOD_BARREL = register("ru_redwood_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_WHITE_PAINTED_BARREL = register("ru_white_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_WILLOW_BARREL = register("ru_willow_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_YELLOW_PAINTED_BARREL = register("ru_yellow_painted_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BLUE_BIOSHROOM_BARREL = register("ru_blue_bioshroom_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_BRIMWOOD_BARREL = register("ru_brimwood_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 0);
    public static final RegistryObject<Block> RU_COBALT_BARREL = register("ru_cobalt_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 0);
    public static final RegistryObject<Block> RU_GREEN_BIOSHROOM_BARREL = register("ru_green_bioshroom_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_KAPOK_BARREL = register("ru_kapok_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_MAGNOLIA_BARREL = register("ru_magnolia_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_PINK_BIOSHROOM_BARREL = register("ru_pink_bioshroom_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_SOCOTRA_BARREL = register("ru_socotra_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 300);
    public static final RegistryObject<Block> RU_YELLOW_BIOSHROOM_BARREL = register("ru_yellow_bioshroom_barrel", () -> new VariantBarrelBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), 0);

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