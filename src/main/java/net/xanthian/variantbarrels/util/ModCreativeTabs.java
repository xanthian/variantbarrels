package net.xanthian.variantbarrels.util;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.Vanilla;


public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Initialise.MOD_ID);

    public static final RegistryObject<CreativeModeTab> VCB_TAB = CREATIVE_MODE_TABS.register("variantbarrels",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Vanilla.MANGROVE_BARREL.get()))
                    .title(Component.literal("Variant Barrels"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Vanilla.ACACIA_BARREL.get());
                        pOutput.accept(Vanilla.BAMBOO_BARREL.get());
                        pOutput.accept(Vanilla.BIRCH_BARREL.get());
                        pOutput.accept(Vanilla.CHERRY_BARREL.get());
                        pOutput.accept(Vanilla.CRIMSON_BARREL.get());
                        pOutput.accept(Vanilla.DARK_OAK_BARREL.get());
                        pOutput.accept(Vanilla.JUNGLE_BARREL.get());
                        pOutput.accept(Vanilla.MANGROVE_BARREL.get());
                        pOutput.accept(Vanilla.OAK_BARREL.get());
                        pOutput.accept(Blocks.BARREL); // Spruce
                        pOutput.accept(Vanilla.WARPED_BARREL.get());
                    })
                    .build());
}