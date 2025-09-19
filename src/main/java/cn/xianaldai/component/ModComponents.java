package cn.xianaldai.component;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModComponents {
    // 定义充饥面包的饥饿debuff
    public static final ConsumableComponent CHONGJIBINGGAN_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            // 获得buff，单位：游戏刻
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 6 * 20, 1), 1.0f))
            .build();
    public static final FoodComponent CHONGJIBINGGAN_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()  //无论饥饿值多少都可以使用
            .build();
    //
    //
}