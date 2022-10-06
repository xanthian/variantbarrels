package net.xanthian.variantbarrels;

import com.google.common.collect.Lists;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.SharedConstants;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
    public static final ItemGroup VARIANTBARRELS = FabricItemGroupBuilder.build(new Identifier(Initialise.MOD_ID, "variantbarrels"),
            () -> new ItemStack(Items.BARREL));


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
            if (SharedConstants.getGameVersion().getName().startsWith("1.19")) {
                woodTypes.add(Pair.of("mangrove", new String[0]));
                Barrels.addVanilla119Barrels();
            }
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
            woodTypes.add(Pair.of("rubber", new String[]{"techreborn"}));
        }
        // Wilder World
        if (FabricLoader.getInstance().isModLoaded("wilderworld")) {
            Barrels.addWilderWorldBarrels();
            woodTypes.add(Pair.of("wisteria", new String[]{"wilderworld"}));
        }
        // Promenade
        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            Barrels.addPromenadeBarrels();
            woodTypes.add(Pair.of("cherry_oak", new String[]{"promenade"}));
            woodTypes.add(Pair.of("dark_amaranth", new String[]{"promenade"}));
            woodTypes.add(Pair.of("palm", new String[]{"promenade"}));
        }
        // Spectrum
        if (FabricLoader.getInstance().isModLoaded("spectrum")) {
            Barrels.addSpectrumBarrels();
            woodTypes.add(Pair.of("black", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("blue", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("brown", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("cyan", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("gray", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("green", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("light_blue", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("light_gray", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("lime", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("magenta", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("orange", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("pink", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("purple", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("red", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("white", new String[]{"spectrum"}));
            woodTypes.add(Pair.of("yellow", new String[]{"spectrum"}));
        }
        // Bewitchment
        if (FabricLoader.getInstance().isModLoaded("bewitchment")) {
            Barrels.addBewitchmentBarrels();
            woodTypes.add(Pair.of("cypress", new String[]{"bewitchment"}));
            woodTypes.add(Pair.of("elder", new String[]{"bewitchment"}));
            woodTypes.add(Pair.of("dragons_blood", new String[]{"bewitchment"}));
            woodTypes.add(Pair.of("juniper", new String[]{"bewitchment"}));
        }
        // Twigs
        if (FabricLoader.getInstance().isModLoaded("twigs")) {
            Barrels.addTwigsBarrels();
            woodTypes.add(Pair.of("stripped_bamboo", new String[]{"twigs"}));
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
        }
        // Croptopia
        if (FabricLoader.getInstance().isModLoaded("croptopia")) {
            Barrels.addCroptopiaBarrels();
            woodTypes.add(Pair.of("cinnamon", new String[]{"croptopia"}));
        }
        // Epic Paladins (Arclight)
        if (FabricLoader.getInstance().isModLoaded("arclight")) {
            Barrels.addEpicPaladinsBarrels();
            woodTypes.add(Pair.of("jade", new String[]{"arclight"}));
            woodTypes.add(Pair.of("moon", new String[]{"arclight"}));
            woodTypes.add(Pair.of("shadow", new String[]{"arclight"}));
        }
        // Simple Mango
        if (FabricLoader.getInstance().isModLoaded("simplemango")) {
            Barrels.addSimpleMangoBarrels();
            woodTypes.add(Pair.of("mango", new String[]{"simplemango"}));
        }
        // Traverse
        if (FabricLoader.getInstance().isModLoaded("traverse")) {
            woodTypes.add(Pair.of("fir", new String[]{"traverse"}));
            Barrels.addTraverseBarrels();
        }
        // Terrestria
        if (FabricLoader.getInstance().isModLoaded("terrestria")) {
            //woodTypes.add(Pair.of("cypress", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("hemlock", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("japanese_maple", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("rainbow_eucalyptus", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("redwood", new String[]{"terrestria"}));
            //woodTypes.add(Pair.of("rubber", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("sakura", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("willow", new String[]{"terrestria"}));
            woodTypes.add(Pair.of("yucca_palm", new String[]{"terrestria"}));
            Barrels.addTerrestriaBarrels();
        }
        // Cinderscapes
        if (FabricLoader.getInstance().isModLoaded("cinderscapes")) {
            woodTypes.add(Pair.of("scorched", new String[]{"cinderscapes"}));
            woodTypes.add(Pair.of("umbral", new String[]{"cinderscapes"}));
            Barrels.addCinderscapeBarrels();
        }
    }
}