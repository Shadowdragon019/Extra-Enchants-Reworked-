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

import net.mcreator.extraenchants.enchantment.MermaidEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Map;
import java.util.HashMap;

@ExtraenchantsModElements.ModElement.Tag
public class MermaidFProcedure extends ExtraenchantsModElements.ModElement {
	public MermaidFProcedure(ExtraenchantsModElements instance) {
		super(instance, 31);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure MermaidF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double mLv = 0;
		mLv = (double) (-1);
		if (((EnchantmentHelper.getEnchantmentLevel(MermaidEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY)) != 0))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, (int) 60, (int) 0));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 60, (int) 0));
		}
		if (((EnchantmentHelper.getEnchantmentLevel(MermaidEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY)) != 0))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 60, (int) 0));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 60, (int) 0));
		}
		if (((EnchantmentHelper.getEnchantmentLevel(MermaidEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY)) != 0))) {
			mLv = (double) ((mLv) + 1);
		}
		if (((EnchantmentHelper.getEnchantmentLevel(MermaidEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY)) != 0))) {
			mLv = (double) ((mLv) + 1);
		}
		if (((mLv) >= 0)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, (int) 60, (int) (mLv)));
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
