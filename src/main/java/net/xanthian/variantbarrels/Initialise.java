package net.xanthian.variantbarrels;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compat.RegionsUnexplored;
import net.xanthian.variantbarrels.block.entity.ModBlockEntities;
import net.xanthian.variantbarrels.item.ModItems;
import net.xanthian.variantbarrels.util.ModCreativeTabs;
import net.xanthian.variantbarrels.util.ModPOITypes;

@Mod(Initialise.MOD_ID)
public class Initialise {

    public static final String MOD_ID = "variantbarrels";

    public Initialise(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModPOITypes.POI_TYPES.register(modEventBus);

        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        Vanilla.BLOCKS.register(modEventBus);

        ModBlockEntities.BLOCK_ENTITIES.register(modEventBus);

        ModItems.ITEMS.register(modEventBus);

        ModList.get().getModContainerById("regions_unexplored").ifPresent(modContainer
                -> RegionsUnexplored.BLOCKS.register(modEventBus));
    }
}
