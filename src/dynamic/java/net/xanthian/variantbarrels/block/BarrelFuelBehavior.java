package net.xanthian.variantbarrels.block;

import com.mojang.logging.LogUtils;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CookingFuel;
import net.xanthian.variantbarrels.Initialise;

import java.util.IdentityHashMap;
import java.util.Map;

public final class BarrelFuelBehavior {
    private BarrelFuelBehavior() {
    }

    public static void register() {
        Identifier phase = Identifier.fromNamespaceAndPath(Initialise.MOD_ID, "inherit_plank_fuel");
        // Source components are bound here. Run after normal callbacks so their fuel edits are inherited too.
        DefaultItemComponentEvents.MODIFY.addPhaseOrdering(Event.DEFAULT_PHASE, phase);
        DefaultItemComponentEvents.MODIFY.register(phase, context -> {
            Map<Item, DynamicBarrels.Variant> barrels = new IdentityHashMap<>();
            DynamicBarrels.variants().forEach(variant -> barrels.put(variant.block().asItem(), variant));
            context.modify(barrels::containsKey, (builder, registries, item) -> {
                var variant = barrels.get(item);
                CookingFuel fuel = null;
                if (!variant.nonFlammable()) {
                    try {
                        fuel = BuiltInRegistries.ITEM.getValue(variant.ingredient())
                                .components().get(DataComponents.COOKING_FUEL);
                    } catch (RuntimeException exception) {
                        LogUtils.getLogger().warn("Could not read fuel for {}; keeping barrel {} non-fuel",
                                variant.ingredient(), variant.id(), exception);
                    }
                }
                // A missing source fuel component removes fuel from the barrel as well.
                builder.set(DataComponents.COOKING_FUEL, fuel);
            });
        });
    }
}
