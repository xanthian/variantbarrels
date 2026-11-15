package net.xanthian.variantbarrels.platform.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.platform.Platform;

@Mod(Initialise.MOD_ID)
public class NeoForgeEntrypoint {
    public NeoForgeEntrypoint(IEventBus modBus) {
        Platform.initialize(new NeoForgePlatform(modBus));
        Initialise.init();
    }
}
