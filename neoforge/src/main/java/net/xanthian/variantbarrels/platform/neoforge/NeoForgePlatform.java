package net.xanthian.variantbarrels.platform.neoforge;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.common.world.poi.ExtendPoiTypesEvent;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import net.xanthian.variantbarrels.block.entity.ModBlockEntities;
import net.xanthian.variantbarrels.platform.PlatformBackend;
import net.xanthian.variantbarrels.platform.RegistryBridge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class NeoForgePlatform implements PlatformBackend {
    private final IEventBus modBus;

    public NeoForgePlatform(IEventBus modBus) {
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
        modBus.addListener((ExtendPoiTypesEvent event) -> BuiltInRegistries.BLOCK.stream()
                .filter(block -> block instanceof VariantBarrelBlock)
                .forEach(block -> event.addBlockToPoi(PoiTypes.FISHERMAN, block)));
        modBus.addListener((RegisterCapabilitiesEvent event) -> event.registerBlockEntity(
                Capabilities.ItemHandler.BLOCK, ModBlockEntities.BARREL.get(),
                (barrel, side) -> new InvWrapper(barrel)));
    }
}
