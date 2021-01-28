package net.mcreator.extraenchants.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.extraenchants.enchantment.IlluminationEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Map;

@ExtraenchantsModElements.ModElement.Tag
public class IlluminationAttackFProcedure extends ExtraenchantsModElements.ModElement {
	public IlluminationAttackFProcedure(ExtraenchantsModElements instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure IlluminationAttackF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((EnchantmentHelper.getEnchantmentLevel(IlluminationEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 600, (int) 0));
		}
	}
}
