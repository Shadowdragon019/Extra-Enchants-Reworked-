package net.mcreator.extraenchants.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.extraenchants.enchantment.CurseOfWeaknessEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Map;
import java.util.HashMap;

@ExtraenchantsModElements.ModElement.Tag
public class CurseOfWeaknessFProcedure extends ExtraenchantsModElements.ModElement {
	public CurseOfWeaknessFProcedure(ExtraenchantsModElements instance) {
		super(instance, 12);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure CurseOfWeaknessF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double CoWPower = 0;
		CoWPower = (double) (-1);
		if (((EnchantmentHelper.getEnchantmentLevel(CurseOfWeaknessEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY)) != 0))) {
			CoWPower = (double) ((CoWPower) + 1);
		}
		if (((EnchantmentHelper.getEnchantmentLevel(CurseOfWeaknessEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY)) != 0))) {
			CoWPower = (double) ((CoWPower) + 1);
		}
		if (((EnchantmentHelper.getEnchantmentLevel(CurseOfWeaknessEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY)) != 0))) {
			CoWPower = (double) ((CoWPower) + 1);
		}
		if (((EnchantmentHelper.getEnchantmentLevel(CurseOfWeaknessEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY)) != 0))) {
			CoWPower = (double) ((CoWPower) + 1);
		}
		if (((CoWPower) >= 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 60, (int) (CoWPower)));
		}
		if (((CoWPower) >= 1)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) ((CoWPower) - 1)));
		}
		if (((CoWPower) >= 2)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 60, (int) ((CoWPower) - 2)));
		}
		if (((CoWPower) >= 3)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 60, (int) ((CoWPower) - 3)));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
