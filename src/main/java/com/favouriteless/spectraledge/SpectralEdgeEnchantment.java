package com.favouriteless.spectraledge;

import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class SpectralEdgeEnchantment extends Enchantment {

	protected SpectralEdgeEnchantment() {
		super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	public int getMinPower(int pEnchantmentLevel) {
		SpectralEdgeConfig config = AutoConfig.getConfigHolder(SpectralEdgeConfig.class).getConfig();
		return 1 + (pEnchantmentLevel - 1) * config.levelCost;
	}

	@Override
	public int getMaxPower(int pEnchantmentLevel) {
		SpectralEdgeConfig config = AutoConfig.getConfigHolder(SpectralEdgeConfig.class).getConfig();
		return this.getMinPower(pEnchantmentLevel) + config.levelCost;
	}

	@Override
	public int getMaxLevel() {
		SpectralEdgeConfig config = AutoConfig.getConfigHolder(SpectralEdgeConfig.class).getConfig();
		return config.maxLevel;
	}

	@Override
	public boolean canAccept(Enchantment enchantment) {
		return !(enchantment instanceof DamageEnchantment);
	}

	@Override
	public boolean isAcceptableItem(ItemStack pStack) {
		return pStack.getItem() instanceof AxeItem || super.isAcceptableItem(pStack);
	}

}
