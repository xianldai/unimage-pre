package cn.xianaldai.item;

import cn.xianaldai.LcwkMod;
import cn.xianaldai.item.material.JianyingshiliaoArmorMaterial;
import cn.xianaldai.item.material.JixingxueArmorMaterial;
import cn.xianaldai.item.material.ModToolMaterials;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static cn.xianaldai.component.ModComponents.CHONGJIBINGGAN_COMPONENT;
import static cn.xianaldai.component.ModComponents.CHONGJIBINGGAN_FOOD_CONSUMABLE_COMPONENT;
import static net.minecraft.item.equipment.ArmorMaterials.IRON;

public class ModItems {
    // 声明物品字段，不在这里初始化，初始化在底下的 public static void initialize 内
    //直接都写在一起不利于改bug
    public static Item SHITOUTOUKUI;
    public static Item SHITOUXIONGJIA;
    public static Item SHITOUHUTUI;
    public static Item SHITOUXUEZI;
    public static Item JIANYINGSHIJIAN;
    public static Item JIXINGXUE;
    public static Item CHONGJIBINGGAN;

    // 注册物品工厂方法
    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LcwkMod.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    // 初始化所有物品，在主类直接调用
    public static void initialize() {
        SHITOUTOUKUI = register(
                "shitoutoukui",
                Item::new,
                new Item.Settings()
                        .armor(JianyingshiliaoArmorMaterial.INSTANCE, EquipmentType.HELMET)
                        .maxDamage(EquipmentType.HELMET.getMaxDamage(JianyingshiliaoArmorMaterial.BASE_DURABILITY))
        );

        // 石头胸甲
        SHITOUXIONGJIA = register(
                "shitouxiongjia",
                Item::new,
                new Item.Settings()
                        .armor(JianyingshiliaoArmorMaterial.INSTANCE, EquipmentType.CHESTPLATE)
                        .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(JianyingshiliaoArmorMaterial.BASE_DURABILITY))
        );

        // 石头护腿
        SHITOUHUTUI = register(
                "shitouhutui",
                Item::new,
                new Item.Settings()
                        .armor(JianyingshiliaoArmorMaterial.INSTANCE, EquipmentType.LEGGINGS)
                        .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(JianyingshiliaoArmorMaterial.BASE_DURABILITY))
        );

        // 石头靴子
        SHITOUXUEZI = register(
                "shitouxuezi",
                Item::new,
                new Item.Settings()
                        .armor(JianyingshiliaoArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                        .maxDamage(EquipmentType.BOOTS.getMaxDamage(JianyingshiliaoArmorMaterial.BASE_DURABILITY))
        );


        // 坚硬石剑
        //其实大于20次攻击每秒的攻速溢出了，除非mixin改写受击的逻辑
        JIANYINGSHIJIAN = register(
                "jianyingshijian",
                Item::new,
                new Item.Settings()
                        .sword(ModToolMaterials.JIANYINGSHILIAO, 1f, 20f)
        );

        // 极形靴
        JIXINGXUE = register(
                "jixingxue",
                Item::new,
                new Item.Settings()
                        .armor(IRON, EquipmentType.BOOTS)
                        .maxDamage(EquipmentType.BOOTS.getMaxDamage(JixingxueArmorMaterial.BASE_DURABILITY))
        );

        // 充饥饼干
        CHONGJIBINGGAN = register(
                "chongjibinggan",
                Item::new,
                new Item.Settings().food(CHONGJIBINGGAN_COMPONENT, CHONGJIBINGGAN_FOOD_CONSUMABLE_COMPONENT)
        );

    }
}