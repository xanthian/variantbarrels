package net.xanthian.variantbarrels;

import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compat.RegionsUnexplored;
import net.xanthian.variantbarrels.block.entity.ModBlockEntities;
import net.xanthian.variantbarrels.item.ModItems;
import net.xanthian.variantbarrels.util.ModCreativeTabs;
import net.xanthian.variantbarrels.platform.Platform;

public class Initialise {

    public static final String MOD_ID = "variantbarrels";

    public static void init() {
        ModCreativeTabs.CREATIVE_MODE_TABS.register();
        Vanilla.BLOCKS.register();
        ModBlockEntities.BLOCK_ENTITIES.register();
        ModItems.ITEMS.register();

        if (Platform.get().isModLoaded("regions_unexplored")) {
            RegionsUnexplored.BLOCKS.register();
        }
        Platform.get().registerWorkstationsAndCapabilities();
    }
}
