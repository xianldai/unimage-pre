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

public class JianyingshiliaoArmorMaterial {
    //定义基础耐久度
    public static final int BASE_DURABILITY = 15;
    //装备资产注册表项
    public static final RegistryKey<EquipmentAsset> JIANYINGSHILIAO_ARMOR_MATERIAL_KEY =
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(LcwkMod.MOD_ID, "jianyingshiliao"));
    //注册坚硬石套
    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,                            //定义基础耐久度
            //定义盔甲值
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 5,
                    EquipmentType.LEGGINGS, 3,
                    EquipmentType.BOOTS, 1
            ),
            5,                                        //附魔能力
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,          //装备音效
            0.0F,                                       //盔甲韧性
            0.0F,                                       //击退抗性
            JIANYINGSHILIAO_REPAIR_ITEMS,               //修复材料的标签
            JIANYINGSHILIAO_ARMOR_MATERIAL_KEY          //装备资产注册表项常量
    );
}