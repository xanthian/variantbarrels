package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
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
                            for (Block block : AdAstra.AA_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("beachparty")) {
                            entries.add(BeachParty.LDBP_PALM_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("betterarcheology")) {
                            entries.add(BetterArcheology.BA_ROTTEN_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("biomemakeover")) {
                            for (Block block : BiomeMakeover.BM_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("bewitchment")) {
                            for (Block block : Bewitchment.BW_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("botania")) {
                            for (Block block : Botania.BOT_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("cinderscapes")) {
                            for (Block block : Cinderscapes.CS_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("deeperdarker")) {
                            entries.add(DeeperAndDarker.DAD_ECHO_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("desolation")) {
                            entries.add(Desolation.DS_CHARRED_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("eldritch_end")) {
                            entries.add(EldritchEnd.EE_PRIMORDIAL_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("minecells")) {
                            entries.add(MineCells.MC_PUTRID_BARREL);
                        }
                        if (FabricLoader.getInstance().isModLoaded("natures_spirit")) {
                            for (Block block : NaturesSpirit.NS_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("promenade")) {
                            for (Block block : Promenade.PROM_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("regions_unexplored")) {
                            for (Block block : RegionsUnexplored.RU_BARRELS.values()) {
                                entries.add(block);
                            }
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
                    .texture("variantbarrels.png").noRenderedName().build());

    public static void registerItemGroup() {
    }
}