package net.centertain.itemsorter.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class SorterItemTransportingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double inventorySlot = 0;
		ItemStack sorterItem = ItemStack.EMPTY;
		ItemStack slotItem = ItemStack.EMPTY;
		inventorySlot = 0;
		for (int index0 = 0; index0 < (int) new Object() {
			public int getContainerSize(LevelAccessor world, BlockPos pos) {
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null) {
					if (_ent instanceof BaseContainerBlockEntity _block) {
						return _block.getContainerSize();
					}
				}
				return 0;
			}

			public int getAmount(LevelAccessor world, BlockPos pos) {
				Block block = world.getBlockState(pos).getBlock();
				if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
					boolean isSingle = block.getStateDefinition().getProperty("type") instanceof EnumProperty _getep5 && world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE");
					if (!isSingle) {
						return getContainerSize(world, pos) * 2;
					}
				}
				return getContainerSize(world, pos);
			}
		}.getAmount(world, new BlockPos((int) x, (int) (y - 1), (int) z)); index0++) {
			sorterItem = (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0));
			slotItem = (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y - 1, z), (int) inventorySlot));
			if (!(sorterItem.getItem() == Blocks.AIR.asItem())) {
				if (slotItem.getItem() == Blocks.AIR.asItem()) {
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
						if (_ent != null) {
							final int _slotid = (int) inventorySlot;
							final ItemStack _setstack = sorterItem.copy();
							_setstack.setCount(sorterItem.getCount());
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent != null) {
							final int _slotid = 0;
							final ItemStack _setstack = sorterItem.copy();
							_setstack.setCount(0);
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				} else if ((ForgeRegistries.ITEMS.getKey(slotItem.getItem()).toString()).equals(ForgeRegistries.ITEMS.getKey(sorterItem.getItem()).toString())) {
					if (slotItem.getMaxStackSize() - slotItem.getCount() >= sorterItem.getCount()) {
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
							if (_ent != null) {
								final int _slotid = (int) inventorySlot;
								final ItemStack _setstack = sorterItem.copy();
								_setstack.setCount((int) (slotItem.getCount() + sorterItem.getCount()));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = sorterItem.copy();
								_setstack.setCount(0);
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y - 1, z));
							if (_ent != null) {
								final int _slotid = (int) inventorySlot;
								final ItemStack _setstack = sorterItem.copy();
								_setstack.setCount(slotItem.getMaxStackSize());
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = sorterItem.copy();
								_setstack.setCount((int) (sorterItem.getCount() - (slotItem.getMaxStackSize() - slotItem.getCount())));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					}
				}
			}
			inventorySlot = inventorySlot + 1;
		}
	}
}
