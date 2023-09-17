package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ConditionJsonProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;

import net.minecraft.block.Block;
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

        for (Block block : Vanilla.MOD_BARRELS.values()){
            addDrop(block, this::nameableContainerDrops);
        }

        // Ad Astra
        for (Block block : AdAstra.AA_BARRELS.values()){
            addDrop(block, addConditions(nameableContainerDrops(block),List.of(DefaultResourceConditions.allModsLoaded("ad_astra"))));
        }

        // Beach Party (Lets Do)
        addDrop(BeachParty.LDBP_PALM_BARREL, addConditions(nameableContainerDrops(BeachParty.LDBP_PALM_BARREL), List.of(DefaultResourceConditions.allModsLoaded("beachparty"))));
        
        // Better Archeology
        addDrop(BetterArcheology.BA_ROTTEN_BARREL, addConditions(nameableContainerDrops(BetterArcheology.BA_ROTTEN_BARREL), List.of(DefaultResourceConditions.allModsLoaded("betterarcheology"))));
        
        // Bewitchment
        for (Block block : Bewitchment.BW_BARRELS.values()){
            addDrop(block, addConditions(nameableContainerDrops(block),List.of(DefaultResourceConditions.allModsLoaded("bewitchment"))));
        }

        // Deeper & Darker
        addDrop(DeeperAndDarker.DAD_ECHO_BARREL, addConditions(nameableContainerDrops(DeeperAndDarker.DAD_ECHO_BARREL), List.of(DefaultResourceConditions.allModsLoaded("deeperdarker"))));
        
        // MineCells
        addDrop(MineCells.MC_PUTRID_BARREL, addConditions(nameableContainerDrops(MineCells.MC_PUTRID_BARREL), List.of(DefaultResourceConditions.allModsLoaded("minecells"))));
        
        // Natures Spirit
        for (Block block : NaturesSpirit.NS_BARRELS.values()){
            addDrop(block, addConditions(nameableContainerDrops(block),List.of(DefaultResourceConditions.allModsLoaded("natures_spirit"))));
        }

        // Promenade
        for (Block block : Promenade.PROM_BARRELS.values()){
            addDrop(block, addConditions(nameableContainerDrops(block),List.of(DefaultResourceConditions.allModsLoaded("promenade"))));
        }

        // Regions Unexplored

        for (Block block : RegionsUnexplored.RU_BARRELS.values()){
            addDrop(block, addConditions(nameableContainerDrops(block),List.of(DefaultResourceConditions.allModsLoaded("regions_unexplored"))));
        }

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