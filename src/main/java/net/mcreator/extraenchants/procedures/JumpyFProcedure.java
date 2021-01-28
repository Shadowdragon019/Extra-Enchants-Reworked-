package net.mcreator.extraenchants.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.extraenchants.enchantment.JumpyEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModVariables;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Map;
import java.util.HashMap;

@ExtraenchantsModElements.ModElement.Tag
public class JumpyFProcedure extends ExtraenchantsModElements.ModElement {
	public JumpyFProcedure(ExtraenchantsModElements instance) {
		super(instance, 29);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure JumpyF!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency x for procedure JumpyF!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency y for procedure JumpyF!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency z for procedure JumpyF!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency world for procedure JumpyF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getBlockState(new BlockPos((int) x, (int) (y - 0.5), (int) z)).isSolid())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(ExtraenchantsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.canExtraJump = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((((entity.isSneaking()) && (((entity.getCapability(ExtraenchantsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ExtraenchantsModVariables.PlayerVariables())).canExtraJump) == (true)))
				&& ((EnchantmentHelper.getEnchantmentLevel(JumpyEnchantment.enchantment,
						((entity instanceof LivingEntity)
								? ((LivingEntity) entity)
										.getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
								: ItemStack.EMPTY)) != 0)))) {
			entity.setMotion(((entity.getMotion().getX()) * 2.5), ((entity.getMotion().getY()) + 0.75), ((entity.getMotion().getZ()) * 2.5));
			{
				boolean _setval = (boolean) (false);
				entity.getCapability(ExtraenchantsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.canExtraJump = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
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
