package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

import net.xanthian.variantbarrels.block.Barrels;


public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Barrels.ACACIA_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.BAMBOO_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.BIRCH_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.CHERRY_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.CRIMSON_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.DARK_OAK_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.JUNGLE_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.MANGROVE_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.OAK_BARREL, this::nameableContainerDrops);
        addDrop(Barrels.WARPED_BARREL, this::nameableContainerDrops);
    }
}