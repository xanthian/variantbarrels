package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static net.xanthian.variantbarrels.util.ModItemTags.BARRELS;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    private static final TagKey<Item> C_JOB_SITE = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:villager_job_sites"));
    private static final TagKey<Item> C_BARREL = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:barrel"));
    private static final TagKey<Item> C_WOODEN_BARRELS = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:wooden_barrels"));

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
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


        getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD)
                .add(Vanilla.CRIMSON_BARREL.asItem())
                .add(Vanilla.WARPED_BARREL.asItem())
                .addOptional(new Identifier("variantbarrels:prom_dark_amaranth_barrel"))
                .addOptional(new Identifier("variantbarrels:ru_brimwood_barrel"))
                .addOptional(new Identifier("variantbarrels:ru_cobalt_barrel"))
                .addOptional(new Identifier("variantbarrels:ru_dead_barrel"))
                .addOptional(new Identifier("variantbarrels:ru_yellow_bioshroom_barrel"));

        getOrCreateTagBuilder(C_JOB_SITE)
                .addTag(BARRELS);

        getOrCreateTagBuilder(C_BARREL)
                .addTag(BARRELS);

        getOrCreateTagBuilder(C_WOODEN_BARRELS)
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