package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;

public class ModCreativeTab {

    public static final ItemGroup ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Initialise.MOD_ID, "variantbarrels"),

            FabricItemGroup.builder()
                    .displayName(Text.literal("Variant Barrels"))
                    .icon(() -> new ItemStack(Vanilla.MANGROVE_BARREL))
                    .entries((context, entries) -> {

                        entries.add(Vanilla.ACACIA_BARREL);
                        entries.add(Vanilla.BAMBOO_BARREL);
                        entries.add(Vanilla.BIRCH_BARREL);
                        entries.add(Vanilla.CHERRY_BARREL);
                        entries.add(Vanilla.CRIMSON_BARREL);
                        entries.add(Vanilla.DARK_OAK_BARREL);
                        entries.add(Vanilla.JUNGLE_BARREL);
                        entries.add(Vanilla.MANGROVE_BARREL);
                        entries.add(Vanilla.OAK_BARREL);
                        entries.add(Blocks.BARREL); // Spruce
                        entries.add(Vanilla.WARPED_BARREL);

                        if (FabricLoader.getInstance().isModLoaded("cinderscapes")) {
                            for (Block block : Cinderscapes.CS_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("natures_spirit")) {
                            for (Block block : NaturesSpirit.NS_BARRELS.values()) {
                                entries.add(block);
                            }
                        }
                        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
                            entries.add(TechReborn.TR_RUBBER_BARREL);
                        }
                    })
                    .texture(Identifier.ofVanilla("textures/gui/container/creative_inventory/tab_variantbarrels.png")).noRenderedName().build());

    public static void registerItemGroup() {
    }
}