package net.xanthian.variantbarrels.mixin;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.BlockState;
import net.minecraft.world.poi.PointOfInterestType;

import net.xanthian.variantbarrels.Init;
import net.xanthian.variantbarrels.block.Barrels;

import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.HashSet;
import java.util.Set;


@Mixin(PointOfInterestType.class)
public abstract class PointOfInterestTypeMixin {
    @ModifyArgs(
            method = "<clinit>",
            slice = @Slice(from = @At(
                    value = "CONSTANT",
                    args = "stringValue=fisherman")
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/poi/PointOfInterestType;register(Ljava/lang/String;Ljava/util/Set;II)Lnet/minecraft/world/poi/PointOfInterestType;",
                    ordinal = 0
            )
    )
    private static void appendFishermans(Args args) {
        Init.populateBarrelsList();
        Set<BlockState> originalFishermanStates = args.get(1);
        Set<BlockState> addedFishermanStates = Init.REGISTERED_BARRELS.stream().flatMap((block) -> {
            return block.getStateManager().getStates().stream();
        }).collect(ImmutableSet.toImmutableSet());
        Set<BlockState> newFishermanStates = new HashSet<>();
        newFishermanStates.addAll(originalFishermanStates);
        newFishermanStates.addAll(addedFishermanStates);
        newFishermanStates = newFishermanStates.stream().collect(ImmutableSet.toImmutableSet());
        // Add new blockStates
        args.set(1, newFishermanStates);
        // Set ticketCount
        args.set(2, 1);

    }
}