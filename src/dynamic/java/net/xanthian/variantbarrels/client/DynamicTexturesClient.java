package net.xanthian.variantbarrels.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.SpriteSourceRegistry;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.xanthian.variantbarrels.block.DynamicBarrels;
import net.minecraft.resources.Identifier;
import net.xanthian.variantbarrels.Initialise;

public final class DynamicTexturesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> DynamicBarrels.logRegistration());
        SourceModTooltip.register();
        SpriteSourceRegistry.register(Identifier.fromNamespaceAndPath(Initialise.MOD_ID, "barrels"),
                BarrelSpriteSource.CODEC);
    }
}
