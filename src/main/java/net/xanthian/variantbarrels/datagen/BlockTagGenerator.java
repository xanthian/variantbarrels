package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.xanthian.variantbarrels.Initialise.MOD_ID;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    private static final TagKey<Block> BARRELS = TagKey.of(Registries.BLOCK.getKey(), new Identifier(MOD_ID, "barrels"));
    private static final TagKey<Block> C_JOB_SITE = TagKey.of(Registries.BLOCK.getKey(), new Identifier("c:villager_job_sites"));
    private static final TagKey<Block> C_BARREL = TagKey.of(Registries.BLOCK.getKey(), new Identifier("c:barrel"));
    private static final TagKey<Block> C_WOODEN_BARRELS = TagKey.of(Registries.BLOCK.getKey(), new Identifier("c:wooden_barrels"));
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        registerTags(Vanilla.VANILLA_BARRELS);

        registerTags(AdAstra.AA_BARRELS);
        registerTags(BeachParty.LDBP_BARRELS);
        registerTags(BetterArcheology.BA_BARRELS);
        registerTags(BiomeMakeover.BM_BARRELS);
        registerTags(Bewitchment.BW_BARRELS);
        registerTags(Botania.BOT_BARRELS);
        registerTags(Cinderscapes.CS_BARRELS);
        registerTags(DeeperAndDarker.DAD_BARRELS);
        registerTags(Desolation.DS_BARRELS);
        registerTags(EldritchEnd.EE_BARRELS);
        registerTags(MineCells.MC_BARRELS);
        registerTags(NaturesSpirit.NS_BARRELS);
        registerTags(Promenade.PROM_BARRELS);
        registerTags(RegionsUnexplored.RU_BARRELS);
        registerTags(SnifferPlus.SP_BARRELS);
        registerTags(TechReborn.TR_BARRELS);
        registerTags(Vinery.LDV_BARRELS);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addTag(BARRELS);

        getOrCreateTagBuilder(C_JOB_SITE)
                .addTag(BARRELS);

        getOrCreateTagBuilder(C_BARREL)
                .addTag(BARRELS);

        getOrCreateTagBuilder(C_WOODEN_BARRELS)
                .addTag(BARRELS);

        getOrCreateTagBuilder(BlockTags.GUARDED_BY_PIGLINS)
                .addTag(BARRELS);
    }

    private void registerTags(Map<Identifier, Block> blockMap) {
        for (Block block : blockMap.values()) {
            Identifier lootTableId = block.getLootTableId();
            String newPath = lootTableId.getPath().replaceFirst("blocks/", "");
            Identifier modifiedId = new Identifier(lootTableId.getNamespace(), newPath);

            getOrCreateTagBuilder(BARRELS)
                    .addOptional(modifiedId);
        }
    }
}