package net.xanthian.variantbarrels.platform.forge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.platform.Platform;

@Mod(Initialise.MOD_ID)
public class ForgeEntrypoint {
    public ForgeEntrypoint(FMLJavaModLoadingContext context) {
        Platform.initialize(new ForgePlatform(context.getModEventBus()));
        Initialise.init();
    }
}
