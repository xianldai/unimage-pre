package cn.xianaldai.item.tag;

import cn.xianaldai.LcwkMod;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

/**
 * 自定义物品标签
 * 用于工具修复等功能
 */
public class ModItemTag {
    // 定义坚硬石料修复材料标签
    public static final TagKey<Item> JIANYINGSHILIAO_REPAIR_ITEMS = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(LcwkMod.MOD_ID, "jianyingshiliao_repair_items")
    );

    //定义极形靴材料套修复材料标签
    public static final TagKey<Item> JIXINGXUE_REPAIR_ITEMS = TagKey.of(
            RegistryKeys.ITEM,
            Identifier.of(LcwkMod.MOD_ID,  "jixingxue_repair_items")
    );

    //定义
}
