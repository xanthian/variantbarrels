package net.xanthian.variantbarrels;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;

import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;
import net.xanthian.variantbarrels.util.ModCreativeTab;
import net.xanthian.variantbarrels.util.ModPOITypes;
import net.xanthian.variantbarrels.util.ModRegistries;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "variantbarrels";

    @Override
    public void onInitialize() {

        Vanilla.registerBarrels();


        if (FabricLoader.getInstance().isModLoaded("ad_astra")) { // DISABLE FOR DATAGEN
            AdAstra.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("beachparty")) {
            BeachParty.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("betterarcheology")) {
            BetterArcheology.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("bewitchment")) {
            Bewitchment.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) { // DISABLE FOR DATAGEN
            DeeperAndDarker.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            Promenade.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("regions_unexplored")) {
            RegionsUnexplored.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("snifferplus")) { // DISABLE FOR DATAGEN
            SnifferPlus.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            TechReborn.registerBarrels();
        }
        if (FabricLoader.getInstance().isModLoaded("vinery")) {
            Vinery.registerBarrels();
        }

        ModRegistries.registerFuelandFlammable();
        ModCreativeTab.registerItemGroup();
        ModPOITypes.init();
    }
}