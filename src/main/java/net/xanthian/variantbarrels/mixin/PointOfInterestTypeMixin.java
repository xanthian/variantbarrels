package net.xanthian.variantbarrels.mixin;

import net.xanthian.variantbarrels.Init;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.BlockState;
import net.minecraft.world.poi.PointOfInterestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.HashSet;
import java.util.Set;


@Mixin(PointOfInterestType.class)
public abstract class PointOfInterestTypeMixin
{
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
        Set<BlockState> originalFishermanStates = args.get(1);
        Set<BlockState> addedFishermanStates = ImmutableList.of(
                Init.ACACIA_BARREL,
                Init.BIRCH_BARREL,
                Init.CRIMSON_BARREL,
                Init.DARK_OAK_BARREL,
                Init.JUNGLE_BARREL,
                Init.OAK_BARREL,
                Init.WARPED_BARREL,
                Init.RED_BARREL,
                Init.CHERRY_OAK_BARREL,
                Init.DARK_AMARANTH_BARREL,
                Init.PALM_BARREL,
                Init.BLACK_BARREL,
                Init.BLUE_BARREL,
                Init.BROWN_BARREL,
                Init.CYAN_BARREL,
                Init.GRAY_BARREL,
                Init.GREEN_BARREL,
                Init.LIGHT_BLUE_BARREL,
                Init.LIGHT_GRAY_BARREL,
                Init.LIME_BARREL,
                Init.MAGENTA_BARREL,
                Init.ORANGE_BARREL,
                Init.PINK_BARREL,
                Init.PURPLE_BARREL,
                Init.RED_BARREL,
                Init.WHITE_BARREL,
                Init.YELLOW_BARREL,
                Init.CYPRESS_BARREL,
                Init.ELDER_BARREL,
                Init.DRAGONS_BLOOD_BARREL,
                Init.JUNIPER_BARREL

        ).stream().flatMap((block) -> {
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