package com.favouriteless.spectraledge;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SpectralEdge implements ModInitializer {

	public static final String MOD_ID = "spectraledge";

	private static final Enchantment SPECTRAL_EDGE = Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "spectral_edge"), new SpectralEdgeEnchantment());;

	@Override
	public void onInitialize() {
		AutoConfig.register(SpectralEdgeConfig.class, Toml4jConfigSerializer::new);
	}
}
