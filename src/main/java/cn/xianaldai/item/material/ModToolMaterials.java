package cn.xianaldai.item.material;

import cn.xianaldai.item.tag.ModItemTag;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

/**
 * 工具材料定义类
 * 包含所有自定义工具材料的定义
 */
public class ModToolMaterials {
    // 定义坚硬石料材料
    public static final ToolMaterial JIANYINGSHILIAO = new ToolMaterial(
            BlockTags.INCORRECT_FOR_STONE_TOOL,      // 不适合该材料工具的方块标签
            520,                                     // 耐久度：介于铁(250)和钻石(1561)之间
            3.0F,                                    // 挖掘速度：比铁(4.0)慢
            2.0F,                                    // 额外攻击伤害：铁是1.0，钻石是3.0
            18,                                      // 附魔值：高于铁(14)和钻石(10)
            ModItemTag.JIANYINGSHILIAO_REPAIR_ITEMS  // 修复物品标签
    )
;}
