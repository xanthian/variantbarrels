package net.xanthian.variantbarrels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import net.xanthian.variantbarrels.block.Barrels;
import net.xanthian.variantbarrels.util.ModPOITypes;
import net.xanthian.variantbarrels.util.ModRegistries;

public class Initialise implements ModInitializer {

    public static final String MOD_ID = "variantbarrels";
    
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "variantbarrels"));

    @Override
    public void onInitialize() {
        // Custom Item Group
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
                .displayName(Text.translatable("variantbarrels.group.variantbarrels"))
                .icon(() -> new ItemStack(Barrels.MANGROVE_BARREL))
                .entries((context, entries) -> {
                    entries.add(Barrels.ACACIA_BARREL);
                    entries.add(Barrels.BAMBOO_BARREL);
                    entries.add(Barrels.BIRCH_BARREL);
                    entries.add(Barrels.CHERRY_BARREL);
                    entries.add(Barrels.CRIMSON_BARREL);
                    entries.add(Barrels.DARK_OAK_BARREL);
                    entries.add(Barrels.JUNGLE_BARREL);
                    entries.add(Barrels.MANGROVE_BARREL);
                    entries.add(Barrels.OAK_BARREL);
                    entries.add(Blocks.BARREL); // Spruce
                    entries.add(Barrels.WARPED_BARREL);
                })
                .build());

        // Barrel Registration
        Barrels.registerVanillaBarrels();

        // Fuel & Flammable Block registration
        ModRegistries.registerFuelandFlammable();

        // Fisherman POI Registration
        ModPOITypes.init();
    }
}