package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.block.Vanilla;

import java.util.concurrent.CompletableFuture;

import static net.xanthian.variantbarrels.util.ModItemTags.BARRELS;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final TagKey<Item> C_JOB_SITE = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:villager_job_sites"));
    private static final TagKey<Item> C_BARREL = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:barrel"));
    private static final TagKey<Item> C_WOODEN_BARRELS = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:wooden_barrels"));

        @Override
        protected void configure (RegistryWrapper.WrapperLookup arg){

            getOrCreateTagBuilder(BARRELS)
                    .add(Vanilla.ACACIA_BARREL.asItem())
                    .add(Vanilla.BAMBOO_BARREL.asItem())
                    .add(Vanilla.BIRCH_BARREL.asItem())
                    .add(Vanilla.CHERRY_BARREL.asItem())
                    .add(Vanilla.CRIMSON_BARREL.asItem())
                    .add(Vanilla.DARK_OAK_BARREL.asItem())
                    .add(Vanilla.JUNGLE_BARREL.asItem())
                    .add(Vanilla.MANGROVE_BARREL.asItem())
                    .add(Vanilla.OAK_BARREL.asItem())
                    .add(Vanilla.WARPED_BARREL.asItem())

                    .addOptional(new Identifier("variantbarrels:aa_aeronos_barrel"))
                    .addOptional(new Identifier("variantbarrels:aa_glacian_barrel"))
                    .addOptional(new Identifier("variantbarrels:aa_stropar_barrel"))

                    .addOptional(new Identifier("variantbarrels:ldbp_palm_barrel"))

                    .addOptional(new Identifier("variantbarrels:ba_rotten_barrel"))

                    .addOptional(new Identifier("variantbarrels:bw_cypress_barrel"))
                    .addOptional(new Identifier("variantbarrels:bw_dragons_blood_barrel"))
                    .addOptional(new Identifier("variantbarrels:bw_elder_barrel"))
                    .addOptional(new Identifier("variantbarrels:bw_juniper_barrel"))

                    .addOptional(new Identifier("variantbarrels:dad_echo_barrel"))

                    .addOptional(new Identifier("variantbarrels:mc_putrid_barrel"))

                    .addOptional(new Identifier("variantbarrels:ns_aspen_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_cypress_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_fir_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_joshua_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_maple_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_olive_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_redwood_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_sugi_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_willow_barrel"))
                    .addOptional(new Identifier("variantbarrels:ns_wisteria_barrel"))

                    .addOptional(new Identifier("variantbarrels:prom_dark_amaranth_barrel"))
                    .addOptional(new Identifier("variantbarrels:prom_maple_barrel"))
                    .addOptional(new Identifier("variantbarrels:prom_palm_barrel"))
                    .addOptional(new Identifier("variantbarrels:prom_sakura_barrel"))

                    .addOptional(new Identifier("variantbarrels:ru_alpha_oak_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_baobab_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_black_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_blackwood_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_blue_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_brown_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_cherry_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_cyan_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_cypress_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_dead_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_eucalyptus_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_green_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_gray_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_joshua_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_larch_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_light_blue_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_light_gray_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_lime_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_magenta_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_maple_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_mauve_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_orange_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_palm_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_pine_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_pink_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_purple_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_red_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_redwood_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_sculkwood_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_white_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_willow_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_yellow_painted_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_brimwood_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_cobalt_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_kapok_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_magnolia_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_socotra_barrel"))
                    .addOptional(new Identifier("variantbarrels:ru_yellow_bioshroom_barrel"))

                    .addOptional(new Identifier("variantbarrels:sp_stone_pine_barrel"))

                    .addOptional(new Identifier("variantbarrels:tr_rubber_barrel"))

                    .addOptional(new Identifier("variantbarrels:ldv_cherry_barrel"));


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
    }