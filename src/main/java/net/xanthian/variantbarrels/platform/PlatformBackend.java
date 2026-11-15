package net.xanthian.variantbarrels.platform;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public interface PlatformBackend {
    <T> RegistryBridge<T> createRegistry(ResourceKey<? extends Registry<T>> registry, String namespace);

    boolean isModLoaded(String modId);

    void registerWorkstationsAndCapabilities();
}
