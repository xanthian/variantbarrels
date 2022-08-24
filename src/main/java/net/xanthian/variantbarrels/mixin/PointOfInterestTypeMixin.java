package net.xanthian.variantbarrels.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PointOfInterestType.class)
public class PointOfInterestTypeMixin {
    @Inject(method = "contains", at = @At("HEAD"), cancellable = true)
    void checkTag(BlockState blockState, CallbackInfoReturnable<Boolean> cir) {
        PointOfInterestType self = (PointOfInterestType)(Object)this;
        if (self == Registry.POINT_OF_INTEREST_TYPE.get(PointOfInterestTypes.FISHERMAN)
                && blockState.getBlock() instanceof VariantBarrelBlock)
        {
            cir.setReturnValue(true);
        }
    }
}