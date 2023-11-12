package net.xanthian.variantbarrels.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import net.xanthian.variantbarrels.mixin.PointOfInterestTypesAccessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModPOITypes {
    public static void init() {

        Map<BlockState, RegistryEntry<PointOfInterestType>> poiStatesToType = PointOfInterestTypesAccessor
                .getPointOfInterestStatesToType();

        RegistryEntry<PointOfInterestType> fishermanEntry = Registries.POINT_OF_INTEREST_TYPE
                .getEntry(PointOfInterestTypes.FISHERMAN).get();
        PointOfInterestType fishermanPoiType = Registries.POINT_OF_INTEREST_TYPE.get(PointOfInterestTypes.FISHERMAN);
        List<BlockState> fishermanBlockStates = new ArrayList<BlockState>(fishermanPoiType.blockStates);

        for (Block block : Registries.BLOCK) { // Iterate through all blocks
            if (block instanceof VariantBarrelBlock barrelBlock) { // Check if the block is an instance of VariantBarrelBlock
                ImmutableList<BlockState> blockStates = barrelBlock.getStateManager().getStates();

                for (BlockState blockState : blockStates) {
                    poiStatesToType.putIfAbsent(blockState, fishermanEntry);
                }
                fishermanBlockStates.addAll(blockStates);
            }
        }
        fishermanPoiType.blockStates = ImmutableSet.copyOf(fishermanBlockStates);
    }
}