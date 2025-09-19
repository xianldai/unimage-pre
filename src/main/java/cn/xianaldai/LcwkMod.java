package cn.xianaldai;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import static net.minecraft.datafixer.fix.EntityRavagerRenameFix.ITEMS;
import cn.xianaldai.item.ModItems;

public class LcwkMod implements ModInitializer {
    public static final String MOD_ID = "lcwkmod";
    @Override
    public void onInitialize() {
        registerItems();
        //其实最好的办法是常量一起注册
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(ModItems.JIANYINGSHIJIAN));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(ModItems.SHITOUTOUKUI));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(ModItems.SHITOUXIONGJIA));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(ModItems.SHITOUHUTUI));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(ModItems.SHITOUXUEZI));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> entries.add(ModItems.JIXINGXUE));


    }

    private void registerItems() {
        ModItems.initialize();
    }

}