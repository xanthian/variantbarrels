package net.xanthian.variantbarrels;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.loader.api.FabricLoader;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.ModMetadata;
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

        ifModLoaded("ad_astra", AdAstra::registerBarrels);

        ifModLoaded("beachparty", BeachParty::registerBarrels);

        ifModLoaded("betterarcheology", BetterArcheology::registerBarrels);

        ifModLoaded("bewitchment", Bewitchment::registerBarrels);

        ifModLoaded("deeperdarker", DeeperAndDarker::registerBarrels);

        ifModLoaded("minecells", MineCells::registerBarrels);

        ifModLoaded("natures_spirit", NaturesSpirit::registerBarrels);

        ifModLoaded("promenade", Promenade::registerBarrels);

        ifModLoaded("regions_unexplored", () -> {
            RegionsUnexplored.registerBarrels();
            if (isModVersion("regions_unexplored", "0.4")) {
                RegionsUnexplored.register04Barrels();
            } else {
                RegionsUnexplored.register05Barrels();
            }
        });

        ifModLoaded("snifferplus", SnifferPlus::registerBarrels);

        ifModLoaded("techreborn", TechReborn::registerBarrels);

        ifModLoaded("vinery", Vinery::registerBarrels);

        ModRegistries.registerFuelandFlammable();
        ModCreativeTab.registerItemGroup();
        ModPOITypes.init();

        // Datagen Block - disable for client run
        SnifferPlus.registerBarrels();
        RegionsUnexplored.register04Barrels();
        NaturesSpirit.registerBarrels();
        DeeperAndDarker.registerBarrels();
        AdAstra.registerBarrels();
    }


    public static void ifModLoaded(String modId, Runnable runnable) {
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            runnable.run();
        }
    }
    public static boolean isModVersion(String modId, String ver) {
        return FabricLoader.getInstance()
                .getModContainer(modId)
                .map(ModContainer::getMetadata)
                .map(ModMetadata::getVersion)
                .map(Version::getFriendlyString)
                .filter(version -> version.startsWith(ver))
                .isPresent();
    }
}