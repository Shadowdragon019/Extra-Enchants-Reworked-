package net.mcreator.extraenchants.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.Block;

import net.mcreator.extraenchants.enchantment.ExcavatorEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

@ExtraenchantsModElements.ModElement.Tag
public class ExcavatorFProcedure extends ExtraenchantsModElements.ModElement {
	public ExcavatorFProcedure(ExtraenchantsModElements instance) {
		super(instance, 15);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure ExcavatorF!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency x for procedure ExcavatorF!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency y for procedure ExcavatorF!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency z for procedure ExcavatorF!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency world for procedure ExcavatorF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack itemMainHand = ItemStack.EMPTY;
		double OX = 0;
		double OY = 0;
		double OZ = 0;
		double itemMainHandExcavatorLv = 0;
		double Randomize = 0;
		double XYZEquation = 0;
		itemMainHand = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
		itemMainHandExcavatorLv = (double) (EnchantmentHelper.getEnchantmentLevel(ExcavatorEnchantment.enchantment, (itemMainHand)));
		XYZEquation = (double) (((itemMainHandExcavatorLv) * (-2)) + ((itemMainHandExcavatorLv) - 1));
		if (((EnchantmentHelper.getEnchantmentLevel(ExcavatorEnchantment.enchantment, (itemMainHand)) != 0))) {
			OY = (double) (XYZEquation);
			for (int index0 = 0; index0 < (int) ((((itemMainHandExcavatorLv) * 2) + 1)); index0++) {
				OX = (double) (XYZEquation);
				OZ = (double) (XYZEquation);
				OY = (double) ((OY) + 1);
				for (int index1 = 0; index1 < (int) ((((itemMainHandExcavatorLv) * 2) + 1)); index1++) {
					OZ = (double) (XYZEquation);
					OX = (double) ((OX) + 1);
					for (int index2 = 0; index2 < (int) ((((itemMainHandExcavatorLv) * 2) + 1)); index2++) {
						OZ = (double) ((OZ) + 1);
						if ((!(BlockTags.getCollection()
								.getTagByID(new ResourceLocation(("minecraft:wither_immune").toLowerCase(java.util.Locale.ENGLISH)))
								.contains((world.getBlockState(new BlockPos((int) (x + (OX)), (int) (y + (OY)), (int) (z + (OZ))))).getBlock())))) {
							if (world instanceof World) {
								Block.spawnDrops(world.getBlockState(new BlockPos((int) (x + (OX)), (int) (y + (OY)), (int) (z + (OZ)))),
										(World) world, new BlockPos((int) (x + (OX)), (int) (y + (OY)), (int) (z + (OZ))));
								world.destroyBlock(new BlockPos((int) (x + (OX)), (int) (y + (OY)), (int) (z + (OZ))), false);
							}
							if ((!(new Object() {
								public boolean checkGamemode(Entity _ent) {
									if (_ent instanceof ServerPlayerEntity) {
										return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.CREATIVE;
									} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
										NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
												.getPlayerInfo(((ClientPlayerEntity) _ent).getGameProfile().getId());
										return _npi != null && _npi.getGameType() == GameType.CREATIVE;
									}
									return false;
								}
							}.checkGamemode(entity)))) {
								{
									ItemStack _ist = (itemMainHand);
									if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamage(0);
									}
								}
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
