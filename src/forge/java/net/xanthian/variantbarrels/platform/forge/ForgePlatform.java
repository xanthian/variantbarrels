package net.xanthian.variantbarrels.platform.forge;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.xanthian.variantbarrels.platform.PlatformBackend;
import net.xanthian.variantbarrels.platform.RegistryBridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class ForgePlatform implements PlatformBackend {
    private final IEventBus modBus;

    public ForgePlatform(IEventBus modBus) {
        this.modBus = modBus;
    }

    @Override
    public <T> RegistryBridge<T> createRegistry(ResourceKey<? extends Registry<T>> key, String namespace) {
        var registry = DeferredRegister.create(key, namespace);
        return new RegistryBridge<>() {
            private final List<Supplier<T>> entries = new ArrayList<>();

            @Override
            public <I extends T> Supplier<I> register(String name, Supplier<I> factory) {
                var entry = registry.register(name, factory);
                entries.add(entry::get);
                return entry;
            }

            @Override
            public Collection<Supplier<T>> getEntries() {
                return Collections.unmodifiableList(entries);
            }

            @Override
            public void register() {
                registry.register(modBus);
            }
        };
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public void registerWorkstationsAndCapabilities() {
        ForgePoiTypes.POI_TYPES.register(modBus);
    }
}
