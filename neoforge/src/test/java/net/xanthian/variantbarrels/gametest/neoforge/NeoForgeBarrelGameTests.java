package net.xanthian.variantbarrels.gametest.neoforge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.gametest.BarrelChecks;

@GameTestHolder("variantbarrels_tests")
@PrefixGameTestTemplate(false)
public class NeoForgeBarrelGameTests {
    @GameTest(templateNamespace = "variantbarrels_tests", template = "empty")
    public static void universalBarrels(GameTestHelper helper) {
        BarrelChecks.checkBarrels(helper);
        var inventory = helper.getLevel().getCapability(Capabilities.ItemHandler.BLOCK,
                helper.absolutePos(new BlockPos(1, 1, 1)), (Direction) null);
        helper.assertTrue(inventory != null && inventory.getSlots() == 27, "NeoForge automation must see all 27 barrel slots");
        helper.assertTrue(new ItemStack(Vanilla.OAK_BARREL.get()).getBurnTime(RecipeType.SMELTING) == 300, "Oak barrels must be furnace fuel");
        helper.assertTrue(new ItemStack(Vanilla.WARPED_BARREL.get()).getBurnTime(RecipeType.SMELTING) == 0, "Warped barrels must not be furnace fuel");
        helper.succeed();
    }
}
