package net.xanthian.variantbarrels.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

import net.fabricmc.fabric.api.resource.conditions.v1.DefaultResourceConditions;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.xanthian.variantbarrels.block.Vanilla;
import net.xanthian.variantbarrels.block.compatability.*;
import net.xanthian.variantbarrels.util.ModItemTags;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        offerBarrelRecipe(exporter, Vanilla.ACACIA_BARREL,Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB);
        offerBarrelRecipe(exporter, Vanilla.BAMBOO_BARREL,Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_SLAB);
        offerBarrelRecipe(exporter, Vanilla.BIRCH_BARREL,Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB);
        offerBarrelRecipe(exporter, Vanilla.CHERRY_BARREL,Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB);
        offerBarrelRecipe(exporter, Vanilla.CRIMSON_BARREL,Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB);
        offerBarrelRecipe(exporter, Vanilla.DARK_OAK_BARREL,Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB);
        offerBarrelRecipe(exporter, Vanilla.JUNGLE_BARREL,Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB);
        offerBarrelRecipe(exporter, Vanilla.MANGROVE_BARREL,Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB);
        offerBarrelRecipe(exporter, Vanilla.OAK_BARREL,Blocks.OAK_PLANKS, Blocks.OAK_SLAB);
        offerBarrelRecipe(exporter, Vanilla.WARPED_BARREL,Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB);


        // Ad Astra (disabled)
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("ad_astra")),AdAstra.AA_AERONOS_BARREL, Registries.ITEM.get(new Identifier("adastra:aeronos_planks")), Registries.ITEM.get(new Identifier("adastra:strophar_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("ad_astra")),AdAstra.AA_GLACIAN_BARREL, Registries.ITEM.get(new Identifier("adastra:glacian_planks")), Registries.ITEM.get(new Identifier("adastra:strophar_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("ad_astra")),AdAstra.AA_STROPHAR_BARREL, Registries.ITEM.get(new Identifier("adastra:strophar_planks")), Registries.ITEM.get(new Identifier("adastra:strophar_slab")));

        // Beach Party (Lets Do)
        offerBarrelRecipe(withConditions(exporter, DefaultResourceConditions.allModsLoaded("beachparty")),BeachParty.LDBP_PALM_BARREL, Registries.ITEM.get(new Identifier("beachparty:palm_planks")), Registries.ITEM.get(new Identifier("beachparty:palm_slab")));

        // Better Archeology
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("betterarcheology")),BetterArcheology.BA_ROTTEN_BARREL, Registries.ITEM.get(new Identifier("betterarcheology:rotten_planks")), Registries.ITEM.get(new Identifier("betterarcheology:rotten_slab")));

        // Bewitchment
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("bewitchment")),Bewitchment.BW_CYPRESS_BARREL, Registries.ITEM.get(new Identifier("bewitchment:cypress_planks")), Registries.ITEM.get(new Identifier("bewitchment:cypress_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("bewitchment")),Bewitchment.BW_DRAGONS_BLOOD_BARREL, Registries.ITEM.get(new Identifier("bewitchment:dragons_blood_planks")), Registries.ITEM.get(new Identifier("bewitchment:dragons_blood_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("bewitchment")),Bewitchment.BW_ELDER_BARREL, Registries.ITEM.get(new Identifier("bewitchment:elder_planks")), Registries.ITEM.get(new Identifier("bewitchment:elder_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("bewitchment")),Bewitchment.BW_JUNIPER_BARREL, Registries.ITEM.get(new Identifier("bewitchment:juniper_planks")), Registries.ITEM.get(new Identifier("bewitchment:juniper_slab")));

        // Deeper & Darker (disabled)
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("deeperdarker")),DeeperAndDarker.DAD_ECHO_BARREL, Registries.ITEM.get(new Identifier("deeperanddarker:echo_planks")), Registries.ITEM.get(new Identifier("deeperanddarker:echo_slab")));

        // Eldritch End
        offerBarrelRecipe(withConditions(exporter, DefaultResourceConditions.allModsLoaded("eldritch_end")), EldritchEnd.EE_PRIMORDIAL_BARREL, Registries.ITEM.get(new Identifier("eldritch_end:primordial_planks")), Registries.ITEM.get(new Identifier("eldritch_end:primordial_slab")));
        // MineCells
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("minecells")), MineCells.MC_PUTRID_BARREL, Registries.ITEM.get(new Identifier("minecells:putrid_planks")), Registries.ITEM.get(new Identifier("minecells:putrid_slab")));

        // Natures Spirit (disabled)
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_ASPEN_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:aspen_planks")), Registries.ITEM.get(new Identifier("natures_spirit:aspen_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_CYPRESS_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:cypress_planks")), Registries.ITEM.get(new Identifier("natures_spirit:cypress_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_FIR_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:fir_planks")), Registries.ITEM.get(new Identifier("natures_spirit:fir_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_JOSHUA_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:joshua_planks")), Registries.ITEM.get(new Identifier("natures_spirit:joshua_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_MAPLE_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:maple_planks")), Registries.ITEM.get(new Identifier("natures_spirit:maple_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_OLIVE_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:olive_planks")), Registries.ITEM.get(new Identifier("natures_spirit:olive_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_REDWOOD_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:redwood_planks")), Registries.ITEM.get(new Identifier("natures_spirit:redwood_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_SUGI_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:sugi_planks")), Registries.ITEM.get(new Identifier("natures_spirit:sugi_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_WILLOW_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:willow_planks")), Registries.ITEM.get(new Identifier("natures_spirit:willow_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("natures_spirit")), NaturesSpirit.NS_WISTERIA_BARREL, Registries.ITEM.get(new Identifier("natures_spirit:wisteria_planks")), Registries.ITEM.get(new Identifier("natures_spirit:wisteria_slab")));

        // Promenade
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("promenade")), Promenade.PROM_DARK_AMARANTH_BARREL, Registries.ITEM.get(new Identifier("promenade:dark_amaranth_planks")), Registries.ITEM.get(new Identifier("promenade:dark_amaranth_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("promenade")), Promenade.PROM_MAPLE_BARREL, Registries.ITEM.get(new Identifier("promenade:maple_planks")), Registries.ITEM.get(new Identifier("promenade:maple_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("promenade")), Promenade.PROM_PALM_BARREL, Registries.ITEM.get(new Identifier("promenade:palm_planks")), Registries.ITEM.get(new Identifier("promenade:palm_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("promenade")), Promenade.PROM_SAKURA_BARREL, Registries.ITEM.get(new Identifier("promenade:sakura_planks")), Registries.ITEM.get(new Identifier("promenade:sakura_slab")));

        // Regions Unexplored
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_ALPHA_OAK_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:alpha_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:alpha_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_BAOBAB_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:baobab_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:baobab_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_BLACK_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:black_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:black_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_BLACKWOOD_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:blackwood_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:blackwood_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_BLUE_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:blue_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:blue_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_BROWN_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:brown_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:brown_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_CYAN_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:cyan_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:cyan_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_CYPRESS_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:cypress_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:cypress_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_DEAD_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:dead_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:dead_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_EUCALYPTUS_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:eucalyptus_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:eucalyptus_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_GREEN_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:green_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:green_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_GRAY_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:gray_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:gray_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_JOSHUA_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:joshua_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:joshua_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_LARCH_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:larch_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:larch_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_LIGHT_BLUE_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:light_blue_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:light_blue_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_LIGHT_GRAY_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:light_gray_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:light_gray_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_LIME_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:lime_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:lime_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_MAGENTA_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:magenta_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:magenta_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_MAPLE_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:maple_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:maple_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_MAUVE_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:mauve_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:mauve_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_ORANGE_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:orange_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:orange_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_PALM_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:palm_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:palm_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_PINE_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:pine_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:pine_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_PINK_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:pink_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:pink_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_PURPLE_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:purple_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:purple_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_RED_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:red_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:red_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_REDWOOD_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:redwood_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:redwood_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_WHITE_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:white_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:white_painted_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_WILLOW_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:willow_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:willow_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("regions_unexplored")),RegionsUnexplored.RU_YELLOW_PAINTED_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:yellow_painted_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:yellow_painted_slab")));
        //0.4.1 (disabled)
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:cherry_planks"))))), RegionsUnexplored.RU_CHERRY_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:cherry_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:cherry_slab")));
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:sculkwood_planks"))))), RegionsUnexplored.RU_SCULKWOOD_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:sculkwood_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:sculkwood_slab")));
        //0.5.0
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:brimwood_planks"))))), RegionsUnexplored.RU_BRIMWOOD_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:brimwood_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:brimwood_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:cobalt_planks"))))), RegionsUnexplored.RU_COBALT_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:cobalt_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:cobalt_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:kapok_planks"))))), RegionsUnexplored.RU_KAPOK_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:kapok_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:kapok_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:magnolia_planks"))))), RegionsUnexplored.RU_MAGNOLIA_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:magnolia_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:magnolia_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:socotra_planks"))))), RegionsUnexplored.RU_SOCOTRA_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:socotra_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:socotra_slab")));
        offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.and(DefaultResourceConditions.allModsLoaded("regions_unexplored"),DefaultResourceConditions.registryContains(RegistryKey.of(RegistryKeys.BLOCK, new Identifier("regions_unexplored:yellow_bioshroom_planks"))))), RegionsUnexplored.RU_YELLOW_BIOSHROOM_BARREL, Registries.ITEM.get(new Identifier("regions_unexplored:yellow_bioshroom_planks")), Registries.ITEM.get(new Identifier("regions_unexplored:yellow_bioshroom_slab")));

        // SnifferPlus (disabled)
        //offerBarrelRecipe(withConditions(exporter,DefaultResourceConditions.allModsLoaded("snifferplus")),HellionsSniffer.HS_STONE_PINE_BARREL, Registries.ITEM.get(new Identifier("snifferplus:stone_pine_planks")), Registries.ITEM.get(new Identifier("snifferplus:stone_pine_slab")));

        // Tech Reborn
        offerBarrelRecipe(withConditions(exporter, DefaultResourceConditions.allModsLoaded("techreborn")),TechReborn.TR_RUBBER_BARREL, Registries.ITEM.get(new Identifier("techreborn:rubber_planks")), Registries.ITEM.get(new Identifier("techreborn:rubber_slab")));

        // Vinery (Lets Do)
        offerBarrelRecipe(withConditions(exporter, DefaultResourceConditions.allModsLoaded("vinery")),Vinery.LDV_CHERRY_BARREL, Registries.ITEM.get(new Identifier("vinery:cherry_planks")), Registries.ITEM.get(new Identifier("vinery:cherry_slab")));
        
        // Uncrafting recipe
        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Items.BARREL)
                .input(ModItemTags.BARRELS)
                .criterion("has_barrel", InventoryChangedCriterion.Conditions.items(Items.BARREL))
                .offerTo(exporter,new Identifier("variantbarrels", "barrel"));

    }
    public static void offerBarrelRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible barrel, ItemConvertible plank, ItemConvertible slab) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, barrel, 1)
                .input('P', plank).input('S', slab)
                .pattern("PSP").pattern("P P").pattern("PSP")
                .criterion("has_planks", FabricRecipeProvider.conditionsFromItem(plank)).criterion("has_wood_slab", FabricRecipeProvider.conditionsFromItem(slab))
                .offerTo(exporter);
    }
}