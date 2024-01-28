package net.xanthian.variantbarrels.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class ModPOITypes {

    public static DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");
    public static RegistryObject<PoiType> FISHERMAN = POI_TYPES.register("fisherman", () ->
            new PoiType(ImmutableSet.copyOf(getPOIBlockStates()), 1, 1));

    private static Set<BlockState> getPOIBlockStates() {
        Set<BlockState> states = new HashSet<>();

        ForgeRegistries.BLOCKS.getValues().stream()
                .filter(ModPOITypes::isVariantBarrel)
                .forEach(addAllBlockStates(states));
        return states;
    }

    @NotNull
    private static Consumer<Block> addAllBlockStates(Set<BlockState> states) {
        return block -> states.addAll(block.getStateDefinition().getPossibleStates());
    }

    private static boolean isVariantBarrel(Block block) {
        return block instanceof VariantBarrelBlock;
    }
}