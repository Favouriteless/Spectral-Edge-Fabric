package com.favouriteless.spectraledge.mixin;

import com.favouriteless.spectraledge.SpectralEdge;
import com.favouriteless.spectraledge.SpectralEdgeConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

	@ModifyVariable(method="getTooltip", at=@At(value="INVOKE", target="Lnet/minecraft/enchantment/EnchantmentHelper;getAttackDamage(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/EntityGroup;)F", shift=Shift.BY, by=4))
	private double getTooltipModifyDamage(double d) {
		return d * (1.0D + (EnchantmentHelper.getLevel(SpectralEdge.SPECTRAL_EDGE, ((ItemStack)(Object)this)) * AutoConfig.getConfigHolder(SpectralEdgeConfig.class).getConfig().damagePercent / 100D));
	}

}
