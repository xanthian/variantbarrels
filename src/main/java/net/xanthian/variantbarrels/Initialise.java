package net.xanthian.variantbarrels;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.item.ModItems;
import net.xanthian.variantbarrels.util.ModCreativeTabs;
import net.xanthian.variantbarrels.util.ModPOITypes;

@Mod(Initialise.MOD_ID)
@Mod.EventBusSubscriber
public class Initialise {

    public static final String MOD_ID = "variantbarrels";

    public Initialise() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModPOITypes.POI_TYPES.register(modEventBus);

        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);

        Vanilla.BLOCKS.register(modEventBus);

        ModItems.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}