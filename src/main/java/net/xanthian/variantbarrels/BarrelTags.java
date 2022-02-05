package net.xanthian.variantbarrels;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class BarrelTags {

    public static final Tag.Identified<Item> BARRELS = create("barrels");
    private BarrelTags() {
        return;
    }
    private static Tag.Identified<Item> create(String path) {
        return TagFactory.ITEM.create(new Identifier(Init.MOD_ID, path));
    }
}