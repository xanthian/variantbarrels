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

    public static void ifModLoaded(String modId, Runnable runnable) {
        if (FabricLoader.getInstance().isModLoaded(modId)) {
            runnable.run();
        }
    }

    @Override
    public void onInitialize() {

        Vanilla.registerBarrels();

        ifModLoaded("ad_astra", AdAstra::registerBarrels);

        ifModLoaded("beachparty", BeachParty::registerBarrels);

        ifModLoaded("betterarcheology", BetterArcheology::registerBarrels);

        ifModLoaded("biomemakeover", BiomeMakeover::registerBarrels);

        ifModLoaded("bewitchment", Bewitchment::registerBarrels);

        ifModLoaded("botania", Botania::registerBarrels);

        ifModLoaded("cinderscapes", Cinderscapes::registerBarrels);

        ifModLoaded("deeperdarker", DeeperAndDarker::registerBarrels);

        ifModLoaded("desolation", Desolation::registerBarrels);

        ifModLoaded("eldritch_end", EldritchEnd::registerBarrels);

        ifModLoaded("minecells", MineCells::registerBarrels);

        ifModLoaded("natures_spirit", NaturesSpirit::registerBarrels);

        ifModLoaded("promenade", Promenade::registerBarrels);

        ifModLoaded("regions_unexplored", RegionsUnexplored::registerBarrels);

        ifModLoaded("snifferplus", SnifferPlus::registerBarrels);

        ifModLoaded("techreborn", TechReborn::registerBarrels);

        ifModLoaded("vinery", Vinery::registerBarrels);

        ModRegistries.registerFuelandFlammable();
        ModCreativeTab.registerItemGroup();
        ModPOITypes.init();

        // Datagen Block - disable for client run
        //Botania.registerBarrels();
        //SnifferPlus.registerBarrels();
    }
}