package net.xanthian.variantbarrels.mixin;

import net.minecraft.core.registries.BuiltInRegistries;
import net.xanthian.variantbarrels.block.DynamicBarrels;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BuiltInRegistries.class)
public abstract class BuiltInRegistriesMixin {
    // Fabric defers the freeze until after mod initialization. Other mods can still supply
    // blocks and items at the head of this method, so wait for the first actual freeze call.
    @Inject(method = "freeze", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/core/Registry;freeze()Lnet/minecraft/core/Registry;", ordinal = 0))
    private static void variantbarrels$registerBarrels(CallbackInfo ci) {
        DynamicBarrels.register();
    }
}
