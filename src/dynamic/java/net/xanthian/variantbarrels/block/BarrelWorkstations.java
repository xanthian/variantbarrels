package net.xanthian.variantbarrels.block;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.xanthian.variantbarrels.mixin.PoiTypeAccessor;
import net.xanthian.variantbarrels.mixin.PoiTypesAccessor;

import java.util.HashSet;
import java.util.Set;

public final class BarrelWorkstations {
    private BarrelWorkstations() {}

    public static void register() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            var fisherman = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getOrThrow(PoiTypes.FISHERMAN);
            var type = fisherman.value();
            var states = new HashSet<>(type.matchingStates());
            var byState = PoiTypesAccessor.variantbarrels$getTypesByState();
            for (var variant : DynamicBarrels.variants()) {
                for (var state : variant.block().getStateDefinition().getPossibleStates()) {
                    var previous = byState.putIfAbsent(state, fisherman);
                    if (previous == null || previous.equals(fisherman)) {
                        states.add(state);
                    }
                }
            }
            ((PoiTypeAccessor) (Object) type).variantbarrels$setMatchingStates(Set.copyOf(states));
        });
    }
}
