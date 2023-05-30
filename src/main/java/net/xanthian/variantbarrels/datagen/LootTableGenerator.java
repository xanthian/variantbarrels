package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.xanthian.variantbarrels.block.Barrels;


public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(Barrels.ACACIA_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.BAMBOO_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.BIRCH_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.CHERRY_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.CRIMSON_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.DARK_OAK_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.JUNGLE_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.MANGROVE_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.OAK_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
        addDrop(Barrels.WARPED_BARREL,(Block block) -> this.nameableContainerDrops((Block)block));
    }
}