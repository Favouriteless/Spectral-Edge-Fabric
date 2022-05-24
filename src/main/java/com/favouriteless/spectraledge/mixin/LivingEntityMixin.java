package com.favouriteless.spectraledge.mixin;

import com.favouriteless.spectraledge.SpectralEdge;
import com.favouriteless.spectraledge.SpectralEdgeConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method="getAttributeValue", at=@At("RETURN"), cancellable = true)
	public void getAttributeValue(EntityAttribute attribute, CallbackInfoReturnable<Double> cir) {
		if(attribute == EntityAttributes.GENERIC_ATTACK_DAMAGE) {
			SpectralEdgeConfig config = AutoConfig.getConfigHolder(SpectralEdgeConfig.class).getConfig();
			cir.setReturnValue(((LivingEntity)(Object)this).getAttributes().getValue(attribute) * (1 + EnchantmentHelper.getLevel(SpectralEdge.SPECTRAL_EDGE, ((LivingEntity)(Object)this).getMainHandStack()) * config.damagePercent/100F));
		}
	}

}
