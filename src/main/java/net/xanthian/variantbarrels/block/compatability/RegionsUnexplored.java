package net.xanthian.variantbarrels.block.compatability;

import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.Initialise;
import net.xanthian.variantbarrels.block.VariantBarrelBlock;

import java.util.Map;

public class RegionsUnexplored {

    public static Map<Identifier, Block> RU_BARRELS = Maps.newHashMap();

    public static Block RU_ALPHA_OAK_BARREL;
    public static Block RU_BAOBAB_BARREL;
    public static Block RU_BLACK_PAINTED_BARREL;
    public static Block RU_BLACKWOOD_BARREL;
    public static Block RU_BLUE_PAINTED_BARREL;
    public static Block RU_BROWN_PAINTED_BARREL;
    public static Block RU_CYAN_PAINTED_BARREL;
    public static Block RU_CYPRESS_BARREL;
    public static Block RU_DEAD_BARREL;
    public static Block RU_EUCALYPTUS_BARREL;
    public static Block RU_GRAY_PAINTED_BARREL;
    public static Block RU_GREEN_PAINTED_BARREL;
    public static Block RU_JOSHUA_BARREL;
    public static Block RU_LARCH_BARREL;
    public static Block RU_LIGHT_BLUE_PAINTED_BARREL;
    public static Block RU_LIGHT_GRAY_PAINTED_BARREL;
    public static Block RU_LIME_PAINTED_BARREL;
    public static Block RU_MAGENTA_PAINTED_BARREL;
    public static Block RU_MAPLE_BARREL;
    public static Block RU_MAUVE_BARREL;
    public static Block RU_ORANGE_PAINTED_BARREL;
    public static Block RU_PALM_BARREL;
    public static Block RU_PINE_BARREL;
    public static Block RU_PINK_PAINTED_BARREL;
    public static Block RU_PURPLE_PAINTED_BARREL;
    public static Block RU_REDWOOD_BARREL;
    public static Block RU_RED_PAINTED_BARREL;
    public static Block RU_WHITE_PAINTED_BARREL;
    public static Block RU_WILLOW_BARREL;
    public static Block RU_YELLOW_PAINTED_BARREL;

    public static Block RU_CHERRY_BARREL;
    public static Block RU_SCULKWOOD_BARREL;

    public static Block RU_BRIMWOOD_BARREL;
    public static Block RU_COBALT_BARREL;
    public static Block RU_KAPOK_BARREL;
    public static Block RU_MAGNOLIA_BARREL;
    public static Block RU_SOCOTRA_BARREL;
    public static Block RU_YELLOW_BIOSHROOM_BARREL;


    public static void registerBarrels() {
        RU_ALPHA_OAK_BARREL = registerBarrel("ru_alpha_oak_barrel");
        RU_BAOBAB_BARREL = registerBarrel("ru_baobab_barrel");
        RU_BLACK_PAINTED_BARREL = registerBarrel("ru_black_painted_barrel");
        RU_BLACKWOOD_BARREL = registerBarrel("ru_blackwood_barrel");
        RU_BLUE_PAINTED_BARREL = registerBarrel("ru_blue_painted_barrel");
        RU_BROWN_PAINTED_BARREL = registerBarrel("ru_brown_painted_barrel");
        RU_CYAN_PAINTED_BARREL = registerBarrel("ru_cyan_painted_barrel");
        RU_CYPRESS_BARREL = registerBarrel("ru_cypress_barrel");
        RU_DEAD_BARREL = registerBarrel("ru_dead_barrel");
        RU_EUCALYPTUS_BARREL = registerBarrel("ru_eucalyptus_barrel");
        RU_GREEN_PAINTED_BARREL = registerBarrel("ru_green_painted_barrel");
        RU_GRAY_PAINTED_BARREL = registerBarrel("ru_gray_painted_barrel");
        RU_JOSHUA_BARREL = registerBarrel("ru_joshua_barrel");
        RU_LARCH_BARREL = registerBarrel("ru_larch_barrel");
        RU_LIGHT_BLUE_PAINTED_BARREL = registerBarrel("ru_light_blue_painted_barrel");
        RU_LIGHT_GRAY_PAINTED_BARREL = registerBarrel("ru_light_gray_painted_barrel");
        RU_LIME_PAINTED_BARREL = registerBarrel("ru_lime_painted_barrel");
        RU_MAGENTA_PAINTED_BARREL = registerBarrel("ru_magenta_painted_barrel");
        RU_MAPLE_BARREL = registerBarrel("ru_maple_barrel");
        RU_MAUVE_BARREL = registerBarrel("ru_mauve_barrel");
        RU_ORANGE_PAINTED_BARREL = registerBarrel("ru_orange_painted_barrel");
        RU_PALM_BARREL = registerBarrel("ru_palm_barrel");
        RU_PINE_BARREL = registerBarrel("ru_pine_barrel");
        RU_PINK_PAINTED_BARREL = registerBarrel("ru_pink_painted_barrel");
        RU_PURPLE_PAINTED_BARREL = registerBarrel("ru_purple_painted_barrel");
        RU_RED_PAINTED_BARREL = registerBarrel("ru_red_painted_barrel");
        RU_REDWOOD_BARREL = registerBarrel("ru_redwood_barrel");
        RU_WHITE_PAINTED_BARREL = registerBarrel("ru_white_painted_barrel");
        RU_WILLOW_BARREL = registerBarrel("ru_willow_barrel");
        RU_YELLOW_PAINTED_BARREL = registerBarrel("ru_yellow_painted_barrel");
    }

    public static void register04Barrels() {
        RU_CHERRY_BARREL = registerBarrel("ru_cherry_barrel");
        RU_SCULKWOOD_BARREL = registerBarrel("ru_sculkwood_barrel");
    }

    public static void register05Barrels() {
        RU_BRIMWOOD_BARREL = registerBarrel("ru_brimwood_barrel");
        RU_COBALT_BARREL = registerBarrel("ru_cobalt_barrel");
        RU_KAPOK_BARREL = registerBarrel("ru_kapok_barrel");
        RU_MAGNOLIA_BARREL = registerBarrel("ru_magnolia_barrel");
        RU_SOCOTRA_BARREL = registerBarrel("ru_socotra_barrel");
        RU_YELLOW_BIOSHROOM_BARREL = registerBarrel("ru_yellow_bioshroom_barrel");
    }

    public static Block register(String name, Block block) {
        Identifier identifier = new Identifier(Initialise.MOD_ID, name.toLowerCase());
        Registry.register(Registries.BLOCK, identifier, block);
        RU_BARRELS.put(identifier, block);
        Registry.register(Registries.ITEM, identifier, new BlockItem(block, new FabricItemSettings()));
        return block;
    }

    public static Block registerBarrel(String name) {
        return register(name, new VariantBarrelBlock());
    }
}