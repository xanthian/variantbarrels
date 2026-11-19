package net.xanthian.variantbarrels.util;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.DynamicBarrels;

import java.util.ArrayList;
import java.util.Comparator;

public final class ModCreativeTab {
    private ModCreativeTab() {}

    public static void registerItemGroup() {
        var key = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
                Identifier.fromNamespaceAndPath(Initialise.MOD_ID, "variantbarrels"));
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, key,
                FabricCreativeModeTab.builder()
                        .title(Component.literal("Variant Barrels"))
                        .icon(() -> new ItemStack(DynamicBarrels.variants().stream()
                                .filter(variant -> variant.planks().equals(Identifier.withDefaultNamespace("mangrove_planks")))
                                .map(DynamicBarrels.Variant::block).findFirst().orElse(Blocks.BARREL)))
                        .displayItems((context, output) -> {
                            var barrels = new ArrayList<ItemStack>();
                            barrels.add(new ItemStack(Blocks.BARREL));
                            DynamicBarrels.variants().forEach(variant -> barrels.add(new ItemStack(variant.block())));
                            barrels.sort(Comparator.comparing((ItemStack stack) -> stack.getHoverName().getString(),
                                            String.CASE_INSENSITIVE_ORDER)
                                    .thenComparing(stack -> BuiltInRegistries.ITEM.getKey(stack.getItem()).toString()));
                            barrels.forEach(output::accept);
                        })
                        .backgroundTexture(Identifier.withDefaultNamespace("textures/gui/container/creative_inventory/tab_variantbarrels.png"))
                        .hideTitle()
                        .build());
    }
}
