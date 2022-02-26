package net.xanthian.variantbarrels.mixin;

import com.google.gson.JsonElement;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.recipe.RecipeType;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.World;
import net.xanthian.variantbarrels.Init;
import net.xanthian.variantbarrels.util.Recipes;
import org.apache.commons.lang3.tuple.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.*;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {

    @Shadow
    private <C extends Inventory, T extends Recipe<C>> Map<Identifier, Recipe<C>> getAllOfType(RecipeType<T> type) {
        return null;
    }

    @Shadow
    private Map<RecipeType<?>, Map<Identifier, Recipe<?>>> recipes;

    /**
     * @author Paulevs
     */
    @Overwrite
    public <C extends Inventory, T extends Recipe<C>> Optional<T> getFirstMatch(RecipeType<T> type, C inventory, World world) {
        Map<Identifier, Recipe<C>> typeMap = getAllOfType(type);
        if (typeMap == null)
        {
            return null;
        }
        Collection<Recipe<C>> values = typeMap.values();
        List<Recipe<C>> list = new ArrayList<>(values);
        String mc = new Identifier("").getNamespace();

        list.sort((v1, v2) -> {
            boolean b1 = v1.getId().getNamespace().equals(mc);
            return (b1 ^ v2.getId().getNamespace().equals(mc)) ? (b1 ? 1 : -1) : 0;
        });
        return list.stream().flatMap((recipe -> Util.stream(type.match(recipe, world, inventory)))).findFirst();

    }

    @Inject(method = "apply", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo info) {
        for (Pair<String, String[]> woodType : Init.woodTypes) {
            map.put(new Identifier(Init.MOD_ID, woodType.getLeft() + "_barrel"), Recipes.createVanillaBarrelRecipeJson(woodType.getLeft(), woodType.getRight()));
         }
    }
}