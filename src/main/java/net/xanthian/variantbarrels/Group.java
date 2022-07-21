package net.xanthian.variantbarrels;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class Group {
    public static final ItemGroup VARIANTBARRELS = FabricItemGroupBuilder.build(new Identifier(Initialise.MOD_ID, "variantbarrels"),
            () -> new ItemStack(Items.BARREL));
}