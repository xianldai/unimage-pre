package cn.xianaldai.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.util.Identifier;

// 自带附魔的异化极形靴实现
public class YihuaJixingxueItem extends Item {
    // 附魔标识符
    private static final Identifier UNBREAKING_ID = Identifier.of("minecraft", "unbreaking");
    private static final Identifier PROTECTION_ID = Identifier.of("minecraft", "protection");
    private static final Identifier FEATHER_FALLING_ID = Identifier.of("minecraft", "feather_falling");

    // 附魔等级
    private static final int UNBREAKING_LEVEL = 3;
    private static final int PROTECTION_LEVEL = 2;
    private static final int FEATHER_FALLING_LEVEL = 2;

    public YihuaJixingxueItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();

        // 直接构建附魔组件
        ComponentType<ItemEnchantmentsComponent> enchantmentType = DataComponentTypes.ENCHANTMENTS;
        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);

        // 添加附魔
        builder.add(createEnchantmentEntry(UNBREAKING_ID), UNBREAKING_LEVEL);
        builder.add(createEnchantmentEntry(PROTECTION_ID), PROTECTION_LEVEL);
        builder.add(createEnchantmentEntry(FEATHER_FALLING_ID), FEATHER_FALLING_LEVEL);

        stack.set(enchantmentType, builder.build());
        return stack;
    }

    // 创建附魔引用条目（使用静态方法）
    private RegistryEntry<Enchantment> createEnchantmentEntry(Identifier id) {
        // 创建附魔的注册表键
        RegistryKey<Enchantment> key = RegistryKey.of(RegistryKeys.ENCHANTMENT, id);

        // 使用standAlone方法创建引用条目，传入所有者和键
        return RegistryEntry.Reference.standAlone(new EnchantmentRegistryOwner(), key);
    }

    // 附魔注册表所有者
    private static class EnchantmentRegistryOwner implements RegistryEntryOwner<Enchantment> {
        @Override
        public boolean ownerEquals(RegistryEntryOwner<Enchantment> other) {
            return other == this;
        }
    }
}
