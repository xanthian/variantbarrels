package net.xanthian.variantbarrels.mixin;

import com.google.gson.JsonElement;

import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;

import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.Recipes;

import org.apache.commons.lang3.tuple.Pair;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {

    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        for (Pair<String, String[]> woodType : Initialise.woodTypes) {
            map.put(new Identifier(Initialise.MOD_ID, woodType.getLeft() + "_barrel"), Recipes.createVanillaBarrelRecipeJson(woodType.getLeft(), woodType.getRight()));
        }
        for (Pair<String, String[]> woodType : Initialise.plankwoodTypes) {
            map.put(new Identifier(Initialise.MOD_ID, woodType.getLeft() + "_barrel"), Recipes.createUghBarrelRecipeJson(woodType.getLeft(), woodType.getRight()));
        }
    }
}