package net.xanthian.variantbarrels.item;

import net.minecraft.world.item.Item;
import net.xanthian.variantbarrels.platform.RegistryBridge;
import net.minecraft.core.registries.Registries;
import net.xanthian.variantbarrels.Initialise;


public class ModItems {

    public static final RegistryBridge<Item> ITEMS =
            RegistryBridge.create(Registries.ITEM, Initialise.MOD_ID);
}
