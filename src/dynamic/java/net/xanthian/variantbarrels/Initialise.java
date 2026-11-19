package net.xanthian.variantbarrels;

import net.fabricmc.api.ModInitializer;
import net.xanthian.variantbarrels.block.BarrelFireBehavior;
import net.xanthian.variantbarrels.block.BarrelFuelBehavior;
import net.xanthian.variantbarrels.block.BarrelWorkstations;
import net.xanthian.variantbarrels.util.ModCreativeTab;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "variantbarrels";

    @Override
    public void onInitialize() {
        BarrelFireBehavior.register();
        BarrelFuelBehavior.register();
        BarrelWorkstations.register();
        ModCreativeTab.registerItemGroup();
    }
}
