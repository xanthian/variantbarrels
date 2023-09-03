package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.fabricmc.loader.api.FabricLoader;

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

        if (FabricLoader.getInstance().isModLoaded("ad_astra")) {
            registry.add(AdAstra.AA_AERONOS_BARREL, 300);
            registry.add(AdAstra.AA_GLACIAN_BARREL, 300);
            registry.add(AdAstra.AA_STROPHAR_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("beachparty")) {
            registry.add(BeachParty.LDBP_PALM_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("betterarcheology")) {
            registry.add(BetterArcheology.BA_ROTTEN_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("bewitchment")) {
            registry.add(Bewitchment.BW_CYPRESS_BARREL, 300);
            registry.add(Bewitchment.BW_DRAGONS_BLOOD_BARREL, 300);
            registry.add(Bewitchment.BW_ELDER_BARREL, 300);
            registry.add(Bewitchment.BW_JUNIPER_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
            registry.add(DeeperAndDarker.DAD_ECHO_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            registry.add(Promenade.PROM_DARK_AMARANTH_BARREL, 300);
            registry.add(Promenade.PROM_MAPLE_BARREL, 300);
            registry.add(Promenade.PROM_PALM_BARREL, 300);
            registry.add(Promenade.PROM_SAKURA_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("regions_unexplored")) {
            registry.add(RegionsUnexplored.RU_ALPHA_OAK_BARREL, 300);
            registry.add(RegionsUnexplored.RU_BAOBAB_BARREL, 300);
            registry.add(RegionsUnexplored.RU_BLACK_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_BLACKWOOD_BARREL, 300);
            registry.add(RegionsUnexplored.RU_BLUE_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_BROWN_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_CHERRY_BARREL, 300);
            registry.add(RegionsUnexplored.RU_CYAN_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_CYPRESS_BARREL, 300);
            registry.add(RegionsUnexplored.RU_DEAD_BARREL, 300);
            registry.add(RegionsUnexplored.RU_EUCALYPTUS_BARREL, 300);
            registry.add(RegionsUnexplored.RU_GRAY_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_GREEN_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_JOSHUA_BARREL, 300);
            registry.add(RegionsUnexplored.RU_LARCH_BARREL, 300);
            registry.add(RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_LIME_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_MAPLE_BARREL, 300);
            registry.add(RegionsUnexplored.RU_MAUVE_BARREL, 300);
            registry.add(RegionsUnexplored.RU_ORANGE_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_PALM_BARREL, 300);
            registry.add(RegionsUnexplored.RU_PINE_BARREL, 300);
            registry.add(RegionsUnexplored.RU_PINK_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_PURPLE_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_REDWOOD_BARREL, 300);
            registry.add(RegionsUnexplored.RU_RED_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_SCULKWOOD_BARREL, 300);
            registry.add(RegionsUnexplored.RU_WHITE_PAINTED_BARREL, 300);
            registry.add(RegionsUnexplored.RU_WILLOW_BARREL, 300);
            registry.add(RegionsUnexplored.RU_YELLOW_PAINTED_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("snifferplus")) {
            registry.add(SnifferPlus.SP_STONE_PINE_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            registry.add(TechReborn.TR_RUBBER_BARREL, 300);
        }
        if (FabricLoader.getInstance().isModLoaded("vinery")) {
            registry.add(Vinery.LDV_CHERRY_BARREL, 300);
        }
    }
}