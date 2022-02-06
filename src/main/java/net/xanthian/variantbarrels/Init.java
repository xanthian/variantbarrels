package net.xanthian.variantbarrels;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Init implements ModInitializer {

    public static final String MOD_ID = "variantbarrels";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //Vanilla
    public static final Block ACACIA_BARREL = new VariantBarrelBlock();
    public static final Block BIRCH_BARREL = new VariantBarrelBlock();
    public static final Block DARK_OAK_BARREL = new VariantBarrelBlock();
    public static final Block JUNGLE_BARREL = new VariantBarrelBlock();
    public static final Block OAK_BARREL = new VariantBarrelBlock();
    //Nether
    public static final Block CRIMSON_BARREL = new VariantBarrelBlock();
    public static final Block WARPED_BARREL = new VariantBarrelBlock();
    //Tech Reborn
    public static final Block RUBBER_BARREL = new VariantBarrelBlock();
    //Promenade
    public static final Block CHERRY_OAK_BARREL = new VariantBarrelBlock();
    public static final Block DARK_AMARANTH_BARREL = new VariantBarrelBlock();
    public static final Block PALM_BARREL = new VariantBarrelBlock();


    @Override
    public void onInitialize() {

        // Disable Vanilla barrels if Blockus is installed
        if (!FabricLoader.getInstance().isModLoaded("blockus")) {
            registerBarrelBlock(ACACIA_BARREL, "acacia_barrel", true);
            registerBarrelBlock(BIRCH_BARREL, "birch_barrel", true);
            registerBarrelBlock(DARK_OAK_BARREL, "dark_oak_barrel", true);
            registerBarrelBlock(JUNGLE_BARREL, "jungle_barrel", true);
            registerBarrelBlock(OAK_BARREL, "oak_barrel", true);
        }
        if (FabricLoader.getInstance().isModLoaded("blockus")) {
            LOGGER.info("Blockus detected, removing Barrels from Variant Barrels");
        }

        // Disable Nether barrels if Better Nether is installed
        if (!FabricLoader.getInstance().isModLoaded("betternether")) {
            registerBarrelBlock(CRIMSON_BARREL, "crimson_barrel", false);
            registerBarrelBlock(WARPED_BARREL, "warped_barrel", false);
        }
        if (FabricLoader.getInstance().isModLoaded("betternether")) {
            LOGGER.info("Better Nether detected, removing Barrels from Variant Barrels");
        }

        // Tech Reborn
        if (FabricLoader.getInstance().isModLoaded("techreborn")) {
            registerBarrelBlock(RUBBER_BARREL, "rubber_barrel", true);
            LOGGER.info("Tech Reborn detected, creating Crafting Tables from Tech Reborn Planks");
        }

        // Promenade Items
        if (FabricLoader.getInstance().isModLoaded("promenade")) {
            registerBarrelBlock(CHERRY_OAK_BARREL, "cherry_oak_barrel", true);
            registerBarrelBlock(DARK_AMARANTH_BARREL, "dark_amaranth_barrel", true);
            registerBarrelBlock(PALM_BARREL, "palm_barrel", true);
            LOGGER.info("Promenade detected, creating Crafting Tables from Promenade Planks");
        }



    }
    private void registerBarrelBlock(Block Barrel, String name, boolean canBurn) {

        Identifier id = new Identifier(MOD_ID, name);
        Registry.register(Registry.BLOCK, id, Barrel);
        Registry.register(Registry.ITEM, id, new BlockItem(Barrel, new Item.Settings().group(CreativeTabGroup.VARIANTBARRELS)));
        if (canBurn)
            FuelRegistry.INSTANCE.add(Barrel, 300);
    }
}
