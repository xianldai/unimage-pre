package cn.xianaldai.item.material;

import cn.xianaldai.LcwkMod;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

import static cn.xianaldai.item.tag.ModItemTag.JIANYINGSHILIAO_REPAIR_ITEMS;
import static cn.xianaldai.item.tag.ModItemTag.JIXINGXUE_REPAIR_ITEMS;

public class JixingxueArmorMaterial {
    //定义基础耐久度
    public static final int BASE_DURABILITY = 15;
    //装备资产注册表项
    public static final RegistryKey<EquipmentAsset> JIXINGXUE_ARMOR_MATERIAL_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(LcwkMod.MOD_ID, "jixingxue"));
    //注册极形靴材料套
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,                            //定义基础耐久度
            //定义盔甲值
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 5,
                    EquipmentType.LEGGINGS, 3,
                    EquipmentType.BOOTS, 1
            ),
            5,                                        //附魔能力，不建议太高，不然太超标了
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,          //装备音效
            0.0F,                                       //盔甲韧性
            0.0F,                                       //击退抗性
            JIXINGXUE_REPAIR_ITEMS,                     //修复材料的标签
            JIXINGXUE_ARMOR_MATERIAL_KEY                //装备资产注册表项常量
    );
}