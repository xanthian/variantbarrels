package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

public class ModCreativeTab {

    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Initialise.MOD_ID, "variantbarrels"),

            FabricItemGroup.builder()
                    .displayName(Text.literal("Variant Barrels"))
                    .icon(() -> new ItemStack(Vanilla.MANGROVE_BARREL))
                    .entries((context, entries) -> {

                        entries.add(Vanilla.ACACIA_BARREL);
                        entries.add(Vanilla.BAMBOO_BARREL);
                        entries.add(Vanilla.BIRCH_BARREL);
                        entries.add(Vanilla.CHERRY_BARREL);
                        entries.add(Vanilla.CRIMSON_BARREL);
                        entries.add(Vanilla.DARK_OAK_BARREL);
                        entries.add(Vanilla.JUNGLE_BARREL);
                        entries.add(Vanilla.MANGROVE_BARREL);
                        entries.add(Vanilla.OAK_BARREL);
                        entries.add(Blocks.BARREL); // Spruce
                        entries.add(Vanilla.WARPED_BARREL);

                        if (FabricLoader.getInstance().isModLoaded("ad_astra")) {
                            entries.add(AdAstra.AA_AERONOS_BARREL);
                            entries.add(AdAstra.AA_GLACIAN_BARREL);
                            entries.add(AdAstra.AA_STROPHAR_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("beachparty")) {
                            entries.add(BeachParty.LDBP_PALM_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("betterarcheology")) {
                            entries.add(BetterArcheology.BA_ROTTEN_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("bewitchment")){
                            entries.add(Bewitchment.BW_CYPRESS_BARREL);
                            entries.add(Bewitchment.BW_DRAGONS_BLOOD_BARREL);
                            entries.add(Bewitchment.BW_ELDER_BARREL);
                            entries.add(Bewitchment.BW_JUNIPER_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
                            entries.add(DeeperAndDarker.DAD_ECHO_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("promenade")) {
                            entries.add(Promenade.PROM_DARK_AMARANTH_BARREL);
                            entries.add(Promenade.PROM_MAPLE_BARREL);
                            entries.add(Promenade.PROM_PALM_BARREL);
                            entries.add(Promenade.PROM_SAKURA_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("regions_unexplored")){
                            entries.add(RegionsUnexplored.RU_ALPHA_OAK_BARREL);
                            entries.add(RegionsUnexplored.RU_BAOBAB_BARREL);
                            entries.add(RegionsUnexplored.RU_BLACK_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_BLACKWOOD_BARREL);
                            entries.add(RegionsUnexplored.RU_BLUE_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_BROWN_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_CHERRY_BARREL);
                            entries.add(RegionsUnexplored.RU_CYAN_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_CYPRESS_BARREL);
                            entries.add(RegionsUnexplored.RU_DEAD_BARREL);
                            entries.add(RegionsUnexplored.RU_EUCALYPTUS_BARREL);
                            entries.add(RegionsUnexplored.RU_GRAY_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_GREEN_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_JOSHUA_BARREL);
                            entries.add(RegionsUnexplored.RU_LARCH_BARREL);
                            entries.add(RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_LIME_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_MAPLE_BARREL);
                            entries.add(RegionsUnexplored.RU_MAUVE_BARREL);
                            entries.add(RegionsUnexplored.RU_ORANGE_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_PALM_BARREL);
                            entries.add(RegionsUnexplored.RU_PINE_BARREL);
                            entries.add(RegionsUnexplored.RU_PINK_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_PURPLE_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_REDWOOD_BARREL);
                            entries.add(RegionsUnexplored.RU_RED_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_SCULKWOOD_BARREL);
                            entries.add(RegionsUnexplored.RU_WHITE_PAINTED_BARREL);
                            entries.add(RegionsUnexplored.RU_WILLOW_BARREL);
                            entries.add(RegionsUnexplored.RU_YELLOW_PAINTED_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("snifferplus")) {
                            entries.add(SnifferPlus.SP_STONE_PINE_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
                            entries.add(TechReborn.TR_RUBBER_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("vinery")) {
                            entries.add(Vinery.LDV_CHERRY_BARREL);
                        }
                    })
                    .build());

    public static void registerItemGroup() {
    }
}