package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Barrels;

import java.util.concurrent.CompletableFuture;

import static net.xanthian.variantbarrels.Initialise.MOD_ID;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

        private static final TagKey<Item> BARRELS = TagKey.of(Registries.ITEM.getKey(), new Identifier(MOD_ID,"barrels"));
        private static final TagKey<Item> NON_FLAMMABLE_WOOD = TagKey.of(Registries.ITEM.getKey(), new Identifier("minecraft:non_flammable_wood"));
        private static final TagKey<Item> JOB_SITE = TagKey.of(Registries.ITEM.getKey(), new Identifier("c:villager_job_sites"));

        @Override
        protected void configure (RegistryWrapper.WrapperLookup arg){

            getOrCreateTagBuilder(BARRELS)
                    .add(Item.fromBlock(Barrels.ACACIA_BARREL))
                    .add(Item.fromBlock(Barrels.BAMBOO_BARREL))
                    .add(Item.fromBlock(Barrels.BIRCH_BARREL))
                    .add(Item.fromBlock(Barrels.CHERRY_BARREL))
                    .add(Item.fromBlock(Barrels.CRIMSON_BARREL))
                    .add(Item.fromBlock(Barrels.DARK_OAK_BARREL))
                    .add(Item.fromBlock(Barrels.JUNGLE_BARREL))
                    .add(Item.fromBlock(Barrels.MANGROVE_BARREL))
                    .add(Item.fromBlock(Barrels.OAK_BARREL))
                    .add(Item.fromBlock(Barrels.WARPED_BARREL));

            getOrCreateTagBuilder(NON_FLAMMABLE_WOOD)
                    .add(Item.fromBlock(Barrels.CRIMSON_BARREL))
                    .add(Item.fromBlock(Barrels.WARPED_BARREL));

            getOrCreateTagBuilder(JOB_SITE)
                    .addTag(BARRELS);
        }
    }