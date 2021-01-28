package net.mcreator.extraenchants.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.extraenchants.enchantment.ColdFeetEnchantment;
import net.mcreator.extraenchants.ExtraenchantsModElements;
import net.mcreator.extraenchants.ExtraenchantsMod;

import java.util.Map;
import java.util.HashMap;

@ExtraenchantsModElements.ModElement.Tag
public class ColdFeetFProcedure extends ExtraenchantsModElements.ModElement {
	public ColdFeetFProcedure(ExtraenchantsModElements instance) {
		super(instance, 4);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency entity for procedure ColdFeetF!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ExtraenchantsMod.LOGGER.warn("Failed to load dependency world for procedure ColdFeetF!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double OX = 0;
		double OZ = 0;
		double RandomNum = 0;
		ItemStack ColdFeetBlock = ItemStack.EMPTY;
		if (((EnchantmentHelper.getEnchantmentLevel(ColdFeetEnchantment.enchantment,
				((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY)) != 0))) {
			OZ = (double) (-2);
			for (int index0 = 0; index0 < (int) (3); index0++) {
				OZ = (double) ((OZ) + 1);
				OX = (double) (-2);
				for (int index1 = 0; index1 < (int) (3); index1++) {
					OX = (double) ((OX) + 1);
					if ((BlockTags.getCollection().getTagByID(new ResourceLocation(("forge:walkable_lava").toLowerCase(java.util.Locale.ENGLISH)))
							.contains((world.getBlockState(new BlockPos((int) ((entity.getPosX()) + (OX)), (int) ((entity.getPosY()) - 1),
									(int) ((entity.getPosZ()) + (OZ))))).getBlock()))) {
						RandomNum = (double) Math.round((Math.random() * 2));
						if ((0 == (RandomNum))) {
							ColdFeetBlock = new ItemStack(Blocks.OBSIDIAN, (int) (1));
						} else if ((1 == (RandomNum))) {
							ColdFeetBlock = new ItemStack(Blocks.STONE, (int) (1));
						} else if ((2 == (RandomNum))) {
							ColdFeetBlock = new ItemStack(Blocks.COBBLESTONE, (int) (1));
						}
						world.setBlockState(
								new BlockPos((int) ((entity.getPosX()) + (OX)), (int) ((entity.getPosY()) - 1), (int) ((entity.getPosZ()) + (OZ))),
								/* @BlockState */(new Object() {
									public BlockState toBlock(ItemStack _stk) {
										if (_stk.getItem() instanceof BlockItem) {
											return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
										}
										return Blocks.AIR.getDefaultState();
									}
								}.toBlock((ColdFeetBlock))), 3);
					}
				}
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
