package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;

import net.minecraft.loot.LootTable;

import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

import java.util.List;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Vanilla.ACACIA_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.BAMBOO_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.BIRCH_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.CHERRY_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.CRIMSON_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.DARK_OAK_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.JUNGLE_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.MANGROVE_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.OAK_BARREL, this::nameableContainerDrops);
        addDrop(Vanilla.WARPED_BARREL, this::nameableContainerDrops);

        // Ad Astra
        addDrop(AdAstra.AA_AERONOS_BARREL,addConditions(nameableContainerDrops(AdAstra.AA_AERONOS_BARREL), List.of(DefaultResourceConditions.allModsLoaded("ad_astra"))));
        addDrop(AdAstra.AA_GLACIAN_BARREL, addConditions(nameableContainerDrops(AdAstra.AA_GLACIAN_BARREL), List.of(DefaultResourceConditions.allModsLoaded("ad_astra"))));
        addDrop(AdAstra.AA_STROPHAR_BARREL, addConditions(nameableContainerDrops(AdAstra.AA_STROPHAR_BARREL), List.of(DefaultResourceConditions.allModsLoaded("ad_astra"))));
        // Beach Party (Lets Do)
        addDrop(BeachParty.LDBP_PALM_BARREL, addConditions(nameableContainerDrops(BeachParty.LDBP_PALM_BARREL), List.of(DefaultResourceConditions.allModsLoaded("beachparty"))));
        // Better Archeology
        addDrop(BetterArcheology.BA_ROTTEN_BARREL, addConditions(nameableContainerDrops(BetterArcheology.BA_ROTTEN_BARREL), List.of(DefaultResourceConditions.allModsLoaded("betterarcheology"))));
        // Bewitchment
        addDrop(Bewitchment.BW_CYPRESS_BARREL, addConditions(nameableContainerDrops(Bewitchment.BW_CYPRESS_BARREL), List.of(DefaultResourceConditions.allModsLoaded("bewitchment"))));
        addDrop(Bewitchment.BW_DRAGONS_BLOOD_BARREL, addConditions(nameableContainerDrops(Bewitchment.BW_DRAGONS_BLOOD_BARREL), List.of(DefaultResourceConditions.allModsLoaded("bewitchment"))));
        addDrop(Bewitchment.BW_ELDER_BARREL, addConditions(nameableContainerDrops(Bewitchment.BW_ELDER_BARREL), List.of(DefaultResourceConditions.allModsLoaded("bewitchment"))));
        addDrop(Bewitchment.BW_JUNIPER_BARREL, addConditions(nameableContainerDrops(Bewitchment.BW_JUNIPER_BARREL), List.of(DefaultResourceConditions.allModsLoaded("bewitchment"))));
        // Deeper & Darker
        addDrop(DeeperAndDarker.DAD_ECHO_BARREL, addConditions(nameableContainerDrops(DeeperAndDarker.DAD_ECHO_BARREL), List.of(DefaultResourceConditions.allModsLoaded("deeperdarker"))));
        // Promenade
        addDrop(Promenade.PROM_DARK_AMARANTH_BARREL, addConditions(nameableContainerDrops(Promenade.PROM_DARK_AMARANTH_BARREL), List.of(DefaultResourceConditions.allModsLoaded("promenade"))));
        addDrop(Promenade.PROM_MAPLE_BARREL, addConditions(nameableContainerDrops(Promenade.PROM_MAPLE_BARREL), List.of(DefaultResourceConditions.allModsLoaded("promenade"))));
        addDrop(Promenade.PROM_PALM_BARREL, addConditions(nameableContainerDrops(Promenade.PROM_PALM_BARREL), List.of(DefaultResourceConditions.allModsLoaded("promenade"))));
        addDrop(Promenade.PROM_SAKURA_BARREL, addConditions(nameableContainerDrops(Promenade.PROM_SAKURA_BARREL), List.of(DefaultResourceConditions.allModsLoaded("promenade"))));
        // Regions Unexplored
        addDrop(RegionsUnexplored.RU_ALPHA_OAK_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_ALPHA_OAK_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_BAOBAB_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_BAOBAB_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_BLACK_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_BLACK_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_BLACKWOOD_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_BLACKWOOD_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_BLUE_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_BLUE_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_BROWN_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_BROWN_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_CHERRY_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_CHERRY_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_CYAN_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_CYAN_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_CYPRESS_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_CYPRESS_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_DEAD_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_DEAD_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_EUCALYPTUS_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_EUCALYPTUS_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_GREEN_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_GREEN_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_GRAY_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_GRAY_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_JOSHUA_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_JOSHUA_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_LARCH_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_LARCH_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_LIME_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_LIME_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_MAPLE_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_MAPLE_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_MAUVE_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_MAUVE_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_ORANGE_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_ORANGE_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_PALM_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_PALM_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_PINE_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_PINE_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_PINK_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_PINK_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_PURPLE_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_PURPLE_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_RED_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_RED_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_REDWOOD_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_REDWOOD_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_SCULKWOOD_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_SCULKWOOD_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_WHITE_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_WHITE_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_WILLOW_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_WILLOW_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        addDrop(RegionsUnexplored.RU_YELLOW_PAINTED_BARREL, addConditions(nameableContainerDrops(RegionsUnexplored.RU_YELLOW_PAINTED_BARREL), List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        // SnifferPlus
        addDrop(SnifferPlus.SP_STONE_PINE_BARREL, addConditions(nameableContainerDrops(SnifferPlus.SP_STONE_PINE_BARREL), List.of(DefaultResourceConditions.allModsLoaded("snifferplus"))));
        // Tech reborn
        addDrop(TechReborn.TR_RUBBER_BARREL, addConditions(nameableContainerDrops(TechReborn.TR_RUBBER_BARREL), List.of(DefaultResourceConditions.allModsLoaded("techreborn"))));
        // Vinery (Lets Do)
        addDrop(Vinery.LDV_CHERRY_BARREL, addConditions(nameableContainerDrops(Vinery.LDV_CHERRY_BARREL), List.of(DefaultResourceConditions.allModsLoaded("vinery"))));
    }

    private LootTable.Builder addConditions(LootTable.Builder builder, List<ConditionJsonProvider> conditions) {
        if (!conditions.isEmpty())
            FabricDataGenHelper.addConditions(builder, conditions.toArray(ConditionJsonProvider[]::new));
        return builder;
    }
}