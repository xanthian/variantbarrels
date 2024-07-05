package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

public class ModRegistries {

    public static void registerFuelandFlammable() {
        registerFuel();
    }

    private static void registerFuel() {
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(Vanilla.ACACIA_BARREL, 300);
        registry.add(Vanilla.BAMBOO_BARREL, 300);
        registry.add(Vanilla.BIRCH_BARREL, 300);
        registry.add(Vanilla.CHERRY_BARREL, 300);
        registry.add(Vanilla.DARK_OAK_BARREL, 300);
        registry.add(Vanilla.JUNGLE_BARREL, 300);
        registry.add(Vanilla.MANGROVE_BARREL, 300);
        registry.add(Vanilla.OAK_BARREL, 300);

        if (FabricLoader.getInstance().isModLoaded("cinderscapes")) {
            for (Block block : Cinderscapes.CS_BARRELS.values()) {
                registry.add(block, 300);
            }
        }
        if (FabricLoader.getInstance().isModLoaded("natures_spirit")) {
            for (Block block : NaturesSpirit.NS_BARRELS.values()) {
                registry.add(block, 300);
            }
        }
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            registry.add(TechReborn.TR_RUBBER_BARREL, 300);
        }
    }
}