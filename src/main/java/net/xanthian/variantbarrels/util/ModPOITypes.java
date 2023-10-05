package net.xanthian.variantbarrels.util;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xanthian.variantbarrels.block.Vanilla;

import java.util.HashSet;

public class ModPOITypes {

    public static DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");

    // Credit to cech12 & BrickFurnace mod

    public static RegistryObject<PoiType> FISHERMAN = POI_TYPES.register("fisherman", () -> {
        HashSet<BlockState> states = new HashSet<>(ForgeRegistries.POI_TYPES.getDelegateOrThrow(PoiTypes.FISHERMAN).get().matchingStates());
        RegistryObject<Block>[] barrelRegistryObjects = new RegistryObject[]{
                Vanilla.ACACIA_BARREL, Vanilla.BAMBOO_BARREL, Vanilla.CHERRY_BARREL,
                Vanilla.CRIMSON_BARREL, Vanilla.DARK_OAK_BARREL, Vanilla.JUNGLE_BARREL,
                Vanilla.MANGROVE_BARREL, Vanilla.OAK_BARREL, Vanilla.WARPED_BARREL
        };
        for (RegistryObject<Block> barrelRegistryObject : barrelRegistryObjects) {
            states.addAll(barrelRegistryObject.get().getStateDefinition().getPossibleStates());
        }
        return new PoiType(states, 1, 1);
    });
}