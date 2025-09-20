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

// 自带附魔的异化极形靴实现（修复注册表所有者判断）
public class YihuaJixingxueItem extends Item {
    // 附魔标识符
    private static final Identifier UNBREAKING_ID = Identifier.of("minecraft", "unbreaking");
    private static final Identifier PROTECTION_ID = Identifier.of("minecraft", "protection");
    private static final Identifier FEATHER_FALLING_ID = Identifier.of("minecraft", "feather_falling");

    // 附魔等级
    private static final int UNBREAKING_LEVEL = 3;
    private static final int PROTECTION_LEVEL = 2;
    private static final int FEATHER_FALLING_LEVEL = 2;

    // 附魔注册表所有者（单例模式确保一致性）
    private static final EnchantmentRegistryOwner ENCHANTMENT_OWNER = new EnchantmentRegistryOwner();

    public YihuaJixingxueItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = super.getDefaultStack();

        // 1. 获取现有附魔组件
        ComponentType<ItemEnchantmentsComponent> enchantmentType = DataComponentTypes.ENCHANTMENTS;
        ItemEnchantmentsComponent existing = stack.getOrDefault(enchantmentType, ItemEnchantmentsComponent.DEFAULT);

        // 2. 构建新的附魔组件
        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(existing);

        // 3. 添加附魔
        addEnchantment(builder, UNBREAKING_ID, UNBREAKING_LEVEL);
        addEnchantment(builder, PROTECTION_ID, PROTECTION_LEVEL);
        addEnchantment(builder, FEATHER_FALLING_ID, FEATHER_FALLING_LEVEL);

        // 4. 设置组件
        stack.set(enchantmentType, builder.build());

        return stack;
    }

    private void addEnchantment(ItemEnchantmentsComponent.Builder builder, Identifier id, int level) {
        RegistryEntry<Enchantment> entry = createEnchantmentEntry(id);
        if (entry != null && level > 0 && level <= Enchantment.MAX_LEVEL) {
            builder.add(entry, level);
        }
    }

    private RegistryEntry<Enchantment> createEnchantmentEntry(Identifier id) {
        try {
            RegistryKey<Enchantment> key = RegistryKey.of(RegistryKeys.ENCHANTMENT, id);
            return RegistryEntry.Reference.standAlone(ENCHANTMENT_OWNER, key);
        } catch (Exception e) {
            return null;
        }
    }

    // 修正注册表所有者实现
    private static class EnchantmentRegistryOwner implements RegistryEntryOwner<Enchantment> {
        @Override
        public boolean ownerEquals(RegistryEntryOwner<Enchantment> other) {
            // 仅判断是否为当前实例，避免使用不存在的getOwner()方法
            return other == this;
        }
    }
}
