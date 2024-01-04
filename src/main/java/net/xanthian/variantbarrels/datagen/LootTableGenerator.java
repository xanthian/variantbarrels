package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

import java.util.Map;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        for (Block block : Vanilla.VANILLA_BARRELS.values()) {
            addDrop(block, this::nameableContainerDrops);
        }

        registerLootTables(AdAstra.AA_BARRELS, "ad_astra");
        registerLootTables(BeachParty.LDBP_BARRELS, "beachparty");
        registerLootTables(BetterArcheology.BA_BARRELS, "betterarcheology");
        registerLootTables(BiomeMakeover.BM_BARRELS, "biomemakeover");
        registerLootTables(Bewitchment.BW_BARRELS, "bewitchment");
        registerLootTables(Botania.BOT_BARRELS, "botania");
        registerLootTables(Cinderscapes.CS_BARRELS, "cinderscape");
        registerLootTables(DeeperAndDarker.DAD_BARRELS, "deeperdarker");
        registerLootTables(Desolation.DS_BARRELS, "desolation");
        registerLootTables(EldritchEnd.EE_BARRELS, "eldritch_end");
        registerLootTables(MineCells.MC_BARRELS, "minecells");
        registerLootTables(NaturesSpirit.NS_BARRELS, "natures_spirit");
        registerLootTables(Promenade.PROM_BARRELS, "promenade");
        registerLootTables(RegionsUnexplored.RU_BARRELS, "regions_unexplored");
        registerLootTables(SnifferPlus.SP_BARRELS, "snifferplus");
        registerLootTables(TechReborn.TR_BARRELS, "techreborn");
        registerLootTables(Vinery.LDV_BARRELS, "vinery");
    }

    private void registerLootTables(Map<Identifier, Block> blockMap, String modId) {
        for (Block barrel : blockMap.values()) {
            withConditions(DefaultResourceConditions.allModsLoaded(modId)).addDrop(barrel, nameableContainerDrops(barrel));
        }
    }
}