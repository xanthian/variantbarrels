package net.xanthian.variantbarrels.platform;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.Collection;
import java.util.function.Supplier;

public interface RegistryBridge<T> {
    static <T> RegistryBridge<T> create(ResourceKey<? extends Registry<T>> registry, String namespace) {
        return Platform.get().createRegistry(registry, namespace);
    }

    <I extends T> Supplier<I> register(String name, Supplier<I> factory);

    Collection<Supplier<T>> getEntries();

    void register();
}
