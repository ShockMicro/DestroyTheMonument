package eu.pb4.destroythemonument.items;

import eu.pb4.destroythemonument.blocks.DtmBlocks;
import eu.pb4.destroythemonument.other.DtmUtil;
import eu.pb4.polymer.item.BasicVirtualItem;
import eu.pb4.polymer.item.VirtualBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class DtmItems {
    public static final Item CLASS_SELECTOR = createBasic(Items.PAPER, Rarity.EPIC);
    public static final Item MULTI_BLOCK = new MultiBlockItem(new Item.Settings());
    public static final Item WEAK_GLASS = new VirtualBlockItem(DtmBlocks.WEAK_GLASS, new Item.Settings(), Items.GLASS);
    public static final Item LADDER = new VirtualBlockItem(DtmBlocks.LADDER, new Item.Settings(), Items.LADDER);
    public static final Item MAP = new DtmMapItem(new Item.Settings());

    public static void registerItems() {
        register("class_selector", CLASS_SELECTOR);
        register("multi_block", MULTI_BLOCK);
        register("weak_glass", WEAK_GLASS);
        register("map", MAP);
        register("ladder", LADDER);
    }

    private static Item createBasic(Item virtual) {
        return new BasicVirtualItem(new Item.Settings(), virtual);
    }

    private static Item createBasic(Item virtual, Rarity rarity) {
        return new BasicVirtualItem(new Item.Settings().rarity(rarity), virtual);
    }

    private static void register(String name, Item item) {
        Registry.register(Registry.ITEM, DtmUtil.id(name), item);
    }
}
