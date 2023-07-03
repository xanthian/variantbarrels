package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;

import net.xanthian.variantbarrels.block.Barrels;

public class ModRegistries {

    public static void registerFuelandFlammable() {
        registerFuel();
    }

    private static void registerFuel() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

/**
        Copy from {@link AbstractFurnaceBlockEntity#createFuelTimeMap()}
 **/

        registry.add(Barrels.ACACIA_BARREL, 300);
        registry.add(Barrels.BAMBOO_BARREL, 300);
        registry.add(Barrels.BIRCH_BARREL, 300);
        registry.add(Barrels.CHERRY_BARREL, 300);
        registry.add(Barrels.DARK_OAK_BARREL, 300);
        registry.add(Barrels.JUNGLE_BARREL, 300);
        registry.add(Barrels.MANGROVE_BARREL, 300);
        registry.add(Barrels.OAK_BARREL, 300);
    }
}
