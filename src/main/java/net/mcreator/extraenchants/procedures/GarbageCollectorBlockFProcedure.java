package net.mcreator.extraenchants.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import net.mcreator.extraenchants.enchantment.GarbageCollectorEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Map;
import java.util.HashMap;

@ExtraenchantsModElements.ModElement.Tag
public class GarbageCollectorBlockFProcedure extends ExtraenchantsModElements.ModElement {
	public GarbageCollectorBlockFProcedure(ExtraenchantsModElements instance) {
		super(instance, 21);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure GarbageCollectorBlockF!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency x for procedure GarbageCollectorBlockF!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency y for procedure GarbageCollectorBlockF!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency z for procedure GarbageCollectorBlockF!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency world for procedure GarbageCollectorBlockF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double OX = 0;
		double OY = 0;
		double OZ = 0;
		double Randomize = 0;
		if (((EnchantmentHelper.getEnchantmentLevel(GarbageCollectorEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0))) {
			if ((Math.ceil((Math.random() * 100)) > (EnchantmentHelper.getEnchantmentLevel(GarbageCollectorEnchantment.enchantment,
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY))))) {
				for (int index0 = 0; index0 < (int) (Math.round(((Math.random() * 2) + 1))); index0++) {
					Randomize = (double) Math.round((Math.random() * 8));
					if (((Randomize) == 0)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.STICK, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 1)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.COBBLESTONE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 2)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.SUGAR, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 3)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.GLASS_BOTTLE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 4)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.ROTTEN_FLESH, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 5)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.BONE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 6)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.SLIME_BALL, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 7)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.FLINT, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					} else if (((Randomize) == 8)) {
						if (world instanceof World && !world.isRemote()) {
							ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.WHITE_DYE, (int) (1)));
							entityToSpawn.setPickupDelay((int) 10);
							world.addEntity(entityToSpawn);
						}
					}
				}
			} else {
				for (int index1 = 0; index1 < (int) (Math.round((Math.random() + 1))); index1++) {
					Randomize = (double) Math.round((Math.random() * 3));
					if (((Randomize) == 0)) {
						for (int index2 = 0; index2 < (int) (Math.round(((Math.random() * 2) + 3))); index2++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.IRON_INGOT, (int) (1)));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
					} else if (((Randomize) == 1)) {
						for (int index3 = 0; index3 < (int) (Math.round(((Math.random() * 3) + 3))); index3++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_INGOT, (int) (1)));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
					} else if (((Randomize) == 2)) {
						for (int index4 = 0; index4 < (int) (Math.round((Math.random() + 2))); index4++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.DIAMOND, (int) (1)));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
					} else if (((Randomize) == 3)) {
						for (int index5 = 0; index5 < (int) (Math.round(((Math.random() * 2) + 3))); index5++) {
							if (world instanceof World && !world.isRemote()) {
								ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.EXPERIENCE_BOTTLE, (int) (1)));
								entityToSpawn.setPickupDelay((int) 10);
								world.addEntity(entityToSpawn);
							}
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event) {
		Entity entity = event.getPlayer();
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("xpAmount", event.getExpToDrop());
		dependencies.put("x", event.getPos().getX());
		dependencies.put("y", event.getPos().getY());
		dependencies.put("z", event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
