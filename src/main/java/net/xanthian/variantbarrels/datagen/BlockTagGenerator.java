package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Barrels;

import java.util.concurrent.CompletableFuture;

import static net.xanthian.variantbarrels.Initialise.MOD_ID;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final TagKey<Block> BARRELS = TagKey.of(Registries.BLOCK.getKey(), new Identifier(MOD_ID,"barrels"));
    private static final TagKey<Block> MINEABLE_AXE = TagKey.of(Registries.BLOCK.getKey(), new Identifier("minecraft:mineable/axe"));
    private static final TagKey<Block> JOB_SITE = TagKey.of(Registries.BLOCK.getKey(), new Identifier("c:villager_job_sites"));
    private static final TagKey<Block> GUARDED_PIGLIN = TagKey.of(Registries.BLOCK.getKey(), new Identifier("minecraft:guarded_by_piglins"));

    @Override
    protected void configure (RegistryWrapper.WrapperLookup arg){

        getOrCreateTagBuilder(BARRELS)
                .add(Barrels.ACACIA_BARREL)
                .add(Barrels.BAMBOO_BARREL)
                .add(Barrels.BIRCH_BARREL)
                .add(Barrels.CHERRY_BARREL)
                .add(Barrels.CRIMSON_BARREL)
                .add(Barrels.DARK_OAK_BARREL)
                .add(Barrels.JUNGLE_BARREL)
                .add(Barrels.MANGROVE_BARREL)
                .add(Barrels.OAK_BARREL)
                .add(Barrels.WARPED_BARREL);

        getOrCreateTagBuilder(MINEABLE_AXE)
                .addTag(BARRELS);

        getOrCreateTagBuilder(JOB_SITE)
                .addTag(BARRELS);

        getOrCreateTagBuilder(GUARDED_PIGLIN)
                .addTag(BARRELS);
    }
}
