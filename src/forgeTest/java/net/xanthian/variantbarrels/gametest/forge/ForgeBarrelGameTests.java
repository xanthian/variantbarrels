package net.xanthian.variantbarrels.gametest.forge;

import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.gametest.GameTestHolder;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.gametest.BarrelChecks;

@GameTestHolder(Initialise.MOD_ID)
public class ForgeBarrelGameTests {
    @GameTest(template = "variantbarrels_tests:empty")
    public static void universalBarrels(GameTestHelper helper) {
        BarrelChecks.checkBarrels(helper);
        var barrel = helper.getBlockEntity(new BlockPos(1, 1, 1));
        var inventory = barrel.getCapability(ForgeCapabilities.ITEM_HANDLER).orElseThrow(IllegalStateException::new);
        helper.assertTrue(inventory.getSlots() == 27, "Forge automation must see all 27 barrel slots");
        helper.assertTrue(ForgeHooks.getBurnTime(new ItemStack(Vanilla.OAK_BARREL.get()), RecipeType.SMELTING) == 300, "Oak barrels must be furnace fuel");
        helper.assertTrue(ForgeHooks.getBurnTime(new ItemStack(Vanilla.WARPED_BARREL.get()), RecipeType.SMELTING) == 0, "Warped barrels must not be furnace fuel");
        helper.succeed();
    }
}
