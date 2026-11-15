package net.xanthian.variantbarrels.gametest;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.Tags;
import net.minecraftforge.gametest.GameTestHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import net.xanthian.variantbarrels.block.entity.ModBlockEntities;

@GameTestHolder(Initialise.MOD_ID)
public class VariantBarrelsGameTests {
    @GameTest(template = "variantbarrels_tests:empty")
    public static void barrelsPreserveInventoryAndName(GameTestHelper helper) {
        var level = helper.getLevel();
        var registries = level.registryAccess();
        var pos = new BlockPos(1, 1, 1);

        for (Block block : ForgeRegistries.BLOCKS.getValues()) {
            if (!(block instanceof VariantBarrelBlock)) {
                continue;
            }
            String id = ForgeRegistries.BLOCKS.getKey(block).toString();
            helper.setBlock(pos, block);
            var barrel = (BarrelBlockEntity) helper.getBlockEntity(pos);
            helper.assertTrue(barrel != null && barrel.getType() == ModBlockEntities.BARREL.get(), id + " must have a valid block entity");
            var namedItem = new ItemStack(block);
            namedItem.set(DataComponents.CUSTOM_NAME, Component.literal("Stored supplies"));
            barrel.applyComponentsFromItemStack(namedItem);
            barrel.setItem(0, new ItemStack(Items.DIAMOND, 7));

            var saved = barrel.saveWithFullMetadata(registries);
            var loaded = (BarrelBlockEntity) BlockEntity.loadStatic(helper.absolutePos(pos), block.defaultBlockState(), saved, registries);
            helper.assertTrue(loaded != null, id + " must reload its block entity");
            helper.assertTrue(loaded.getItem(0).is(Items.DIAMOND) && loaded.getItem(0).getCount() == 7, id + " must preserve inventory");
            helper.assertTrue(Component.literal("Stored supplies").equals(loaded.getCustomName()), id + " must preserve its name");

            helper.assertTrue(PoiTypes.forState(block.defaultBlockState()).orElseThrow().is(PoiTypes.FISHERMAN), id + " must be a fisherman workstation");
            helper.assertTrue(block.defaultBlockState().is(Tags.Blocks.BARRELS_WOODEN), id + " must be in the shared block tag");
            helper.assertTrue(new ItemStack(block).is(Tags.Items.BARRELS_WOODEN), id + " must be in the shared item tag");

            var drops = Block.getDrops(block.defaultBlockState(), level, helper.absolutePos(pos), barrel);
            helper.assertTrue(drops.size() == 1 && drops.getFirst().is(block.asItem()), id + " must drop itself");
            helper.assertTrue(Component.literal("Stored supplies").equals(drops.getFirst().getHoverName()), id + " must copy its name to the drop");
            helper.assertTrue(level.getRecipeManager().byKey(ResourceLocation.parse(id)).isPresent(), id + " must have a loaded recipe");
        }
        helper.assertTrue(PoiTypes.forState(Blocks.BARREL.defaultBlockState()).orElseThrow().is(PoiTypes.FISHERMAN), "The vanilla barrel must remain a fisherman workstation");
        helper.succeed();
    }
}
