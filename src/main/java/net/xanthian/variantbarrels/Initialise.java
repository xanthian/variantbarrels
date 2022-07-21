package net.xanthian.variantbarrels;

import com.google.common.collect.Lists;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import net.xanthian.variantbarrels.block.Barrels;

import org.apache.commons.lang3.tuple.Pair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "variantbarrels";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static List<Pair<String, String[]>> woodTypes = Lists.newArrayList();
    public static List<Pair<String, String[]>> plankwoodTypes = Lists.newArrayList();

    @Override
    public void onInitialize() {
        // Disable Vanilla barrels if Blockus is installed
        if (!FabricLoader.getInstance().isModLoaded("blockus")) {
            Barrels.addVanillaBarrels();
            woodTypes.add(Pair.of("acacia", new String[0]));
            woodTypes.add(Pair.of("birch", new String[0]));
            woodTypes.add(Pair.of("dark_oak", new String[0]));
            woodTypes.add(Pair.of("jungle", new String[0]));
            woodTypes.add(Pair.of("oak", new String[0]));
            woodTypes.add(Pair.of("mangrove", new String[0]));
        }
        if (FabricLoader.getInstance().isModLoaded("blockus")) {
            LOGGER.info("Blockus detected, removing Barrels from Variant Barrels");
        }

        // Disable Nether barrels if Better Nether is installed
        if (!FabricLoader.getInstance().isModLoaded("betternether")) {
            Barrels.addNetherBarrels();
            woodTypes.add(Pair.of("crimson", new String[0]));
            woodTypes.add(Pair.of("warped", new String[0]));
        }
        if (FabricLoader.getInstance().isModLoaded("betternether")) {
            LOGGER.info("Better Nether detected, removing Barrels from Variant Barrels");
        }
        // Tech Reborn
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            Barrels.addTechRebornBarrels();
            plankwoodTypes.add(Pair.of("rubber", new String[]{"techreborn"}));
            LOGGER.info("Tech Reborn detected, creating Barrels from Tech Reborn Planks");
        }

        // Wilder World
        if (FabricLoader.getInstance().isModLoaded("wilderworld")) {
            Barrels.addWilderWorldBarrels();
            woodTypes.add(Pair.of("wisteria", new String[]{"wilderworld"}));
            LOGGER.info("Wilder World detected, creating Barrels from Wilder World Planks");
        }

        // Promenade
        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            Barrels.addPromenadeBarrels();
            woodTypes.add(Pair.of("cherry_oak", new String[]{"promenade"}));
            woodTypes.add(Pair.of("dark_amaranth", new String[]{"promenade"}));
            woodTypes.add(Pair.of("palm", new String[]{"promenade"}));
            LOGGER.info("Promenade detected, creating Barrels from Promenade Planks");
        }

        // Spectrum
        if (FabricLoader.getInstance().isModLoaded("spectrum")) {
            Barrels.addSpectrumBarrels();
            plankwoodTypes.add(Pair.of("black", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("blue", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("brown", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("cyan", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("gray", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("green", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("light_blue", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("light_gray", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("lime", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("magenta", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("orange", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("pink", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("purple", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("red", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("white", new String[]{"spectrum"}));
            plankwoodTypes.add(Pair.of("yellow", new String[]{"spectrum"}));
            LOGGER.info("Spectrum detected, creating Barrels from Spectrum Planks");
        }
        // Bewitchment
        if (FabricLoader.getInstance().isModLoaded("bewitchment")) {
            Barrels.addBewitchmentBarrels();
            woodTypes.add(Pair.of("cypress", new String[]{"bewitchment"}));
            woodTypes.add(Pair.of("elder", new String[]{"bewitchment"}));
            woodTypes.add(Pair.of("dragons_blood", new String[]{"bewitchment"}));
            woodTypes.add(Pair.of("juniper", new String[]{"bewitchment"}));
            LOGGER.info("Bewitchment detected, creating Barrels from Bewitchment Planks");
        }
        // Twigs
        if (FabricLoader.getInstance().isModLoaded("twigs")) {
            Barrels.addTwigsBarrels();
            woodTypes.add(Pair.of("stripped_bamboo", new String[]{"twigs"}));
            LOGGER.info("Twigs detected, creating Barrels from Twigs Planks");
        }
        // Botania
        if (FabricLoader.getInstance().isModLoaded("botania")) {
            Barrels.addBotaniaBarrels();
            // Leaving this here in case Botania changes block names
            //plankwoodTypes.add(Pair.of("dreamwood", new String[]{"botania"}));
            //plankwoodTypes.add(Pair.of("livingwood", new String[]{"botania"}));
            //plankwoodTypes.add(Pair.of("mossy_dreamwood", new String[]{"botania"}));
            //plankwoodTypes.add(Pair.of("mossy_livingwood", new String[]{"botania"}));
            //plankwoodTypes.add(Pair.of("shimmerwood", new String[]{"botania"}));
            LOGGER.info("Botania detected, creating Barrels from Botania Planks");
        }
    }
}