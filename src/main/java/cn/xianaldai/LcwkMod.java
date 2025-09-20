package cn.xianaldai;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

import static net.minecraft.datafixer.fix.EntityRavagerRenameFix.ITEMS;
import cn.xianaldai.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LcwkMod implements ModInitializer {
    public static final String MOD_ID = "lcwkmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // 初始化物品注册
        ModItems.initialize();

        // 物品组注册：合并为一个事件处理器
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register(entries -> {
                    // 工具类物品
                    entries.add(ModItems.JIANYINGSHIJIAN);

                    //  armor类物品
                    entries.add(ModItems.SHITOUTOUKUI);
                    entries.add(ModItems.SHITOUXIONGJIA);
                    entries.add(ModItems.SHITOUHUTUI);
                    entries.add(ModItems.SHITOUXUEZI);
                    entries.add(ModItems.JIXINGXUE);
                    entries.add(ModItems.YIHUAJIXINGXUE);

                    // 食物类物品
                    entries.add(ModItems.CHONGJIBINGGAN);
                    entries.add(ModItems.TIANCAIAIHAOZHE_ZAISHENG);
                });

        LOGGER.info("LcwkMod 初始化完成！");
    }

}