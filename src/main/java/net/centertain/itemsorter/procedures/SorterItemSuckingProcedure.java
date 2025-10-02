package net.centertain.itemsorter.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.forgespi.language.IModInfo;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.centertain.itemsorter.init.ItemSorterModItems;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;

public class SorterItemSuckingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double hopperSlot = 0;
		double filterSlot = 0;
		ItemStack hopperItem = ItemStack.EMPTY;
		ItemStack throughputItem = ItemStack.EMPTY;
		ItemStack referenceItem = ItemStack.EMPTY;
		ItemStack filterItem = ItemStack.EMPTY;
		boolean succeed = false;
		boolean referenceCheck = false;
		boolean sortingMode = false;
		boolean filterCheck1 = false;
		boolean filterCheck2 = false;
		boolean filterCheck3 = false;
		boolean filterCheck4 = false;
		boolean filterCheck5 = false;
		boolean tempCheck = false;
		boolean filterMode = false;
		boolean containsFilter = false;
		String filterType = "";
		String filterString = "";
		String filterItemRegistryName = "";
		String filterItemRegistryKey = "";
		String filterItemModID = "";
		String hopperItemDisplayName = "";
		hopperSlot = 0;
		succeed = false;
		referenceCheck = false;
		referenceItem = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 1));
		sortingMode = (new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "SortingMode")).equals("[Additive]");
		filterCheck1 = false;
		filterCheck2 = false;
		filterCheck3 = false;
		filterCheck4 = false;
		filterCheck5 = false;
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
		}.getAmount(world, new BlockPos((int) x, (int) (y + 1), (int) z)); index0++) {
			throughputItem = (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y, z), 0));
			hopperItem = (new Object() {
				public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
					return _retval.get();
				}
			}.getItemStack(world, BlockPos.containing(x, y + 1, z), (int) hopperSlot));
			if ((ForgeRegistries.ITEMS.getKey(hopperItem.getItem()).toString()).equals(ForgeRegistries.ITEMS.getKey(referenceItem.getItem()).toString()) || referenceItem.getItem() == Blocks.AIR.asItem()) {
				referenceCheck = true;
			}
			containsFilter = false;
			filterSlot = 2;
			for (int index1 = 0; index1 < 5; index1++) {
				if ((new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) filterSlot)).getItem() == ItemSorterModItems.FILTER.get()) {
					containsFilter = true;
				}
				filterSlot = filterSlot + 1;
			}
			if (sortingMode && referenceItem.getItem() == Blocks.AIR.asItem() && containsFilter) {
				referenceCheck = false;
			}
			filterSlot = 2;
			for (int index2 = 0; index2 < 5; index2++) {
				tempCheck = false;
				filterItem = (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x, y, z), (int) filterSlot));
				filterType = filterItem.getOrCreateTag().getString("FilterType");
				filterMode = (filterItem.getOrCreateTag().getString("FilterMode")).equals("[Equals]");
				filterString = (filterItem.getOrCreateTag().getString("FilterString")).replace("&quot;", "\"");
				hopperItemDisplayName = (hopperItem.getDisplayName().getString()).substring(1, (int) ((hopperItem.getDisplayName().getString()).length() - 1));
				filterItemRegistryName = ForgeRegistries.ITEMS.getKey(hopperItem.getItem()).toString();
				filterItemRegistryKey = filterItemRegistryName.contains(":") ? filterItemRegistryName.split(":", 2)[1] : filterItemRegistryName;
				filterItemModID = filterItemRegistryName.contains(":") ? filterItemRegistryName.split(":", 2)[0] : filterItemRegistryName;
				if (filterItem.getItem() == Blocks.AIR.asItem() && !sortingMode) {
					tempCheck = true;
				} else {
					if ((filterType).equals("[Item Name]")) {
						if (filterMode) {
							if ((hopperItemDisplayName).equals(filterString)) {
								tempCheck = true;
							}
						} else {
							if (hopperItemDisplayName.contains(filterString)) {
								tempCheck = true;
							}
						}
					} else if ((filterType).equals("[Registry Key]")) {
						if (filterMode) {
							if ((filterItemRegistryKey).equals(filterString)) {
								tempCheck = true;
							}
						} else {
							if (filterItemRegistryKey.contains(filterString)) {
								tempCheck = true;
							}
						}
					} else if ((filterType).equals("[Mod ID]")) {
						if (filterMode) {
							if ((filterItemModID).equals(filterString)) {
								tempCheck = true;
							}
						} else {
							if (filterItemModID.contains(filterString)) {
								tempCheck = true;
							}
						}
					} else if ((filterType).equals("[Mod Name]")) {
						if (filterMode) {
							if ((new Object() {
								String getModInfo(String modid, int type) {
									String val = "";
									List<IModInfo> mods = ModList.get().getMods();
									for (IModInfo mod : mods) {
										if (mod.getModId().equals(modid.toLowerCase())) {
											if (type == 0) {
												val = mod.getVersion().toString();
											} else {
												val = mod.getDisplayName();
											}
											break;
										}
									}
									return val;
								}
							}.getModInfo(filterItemModID, 1)).equals(filterString)) {
								tempCheck = true;
							}
						} else {
							if (new Object() {
								String getModInfo(String modid, int type) {
									String val = "";
									List<IModInfo> mods = ModList.get().getMods();
									for (IModInfo mod : mods) {
										if (mod.getModId().equals(modid.toLowerCase())) {
											if (type == 0) {
												val = mod.getVersion().toString();
											} else {
												val = mod.getDisplayName();
											}
											break;
										}
									}
									return val;
								}
							}.getModInfo(filterItemModID, 1).contains(filterString)) {
								tempCheck = true;
							}
						}
					} else if ((filterType).equals("[Item Tag]")) {
						if (hopperItem.is(ItemTags.create(new ResourceLocation((filterString).toLowerCase(java.util.Locale.ENGLISH))))) {
							tempCheck = true;
						}
					}
				}
				if (tempCheck) {
					if (filterSlot == 2) {
						filterCheck1 = true;
					} else if (filterSlot == 3) {
						filterCheck2 = true;
					} else if (filterSlot == 4) {
						filterCheck3 = true;
					} else if (filterSlot == 5) {
						filterCheck4 = true;
					} else {
						filterCheck5 = true;
					}
				}
				filterSlot = filterSlot + 1;
			}
			if (sortingMode) {
				if (referenceCheck || filterCheck1 || filterCheck2 || filterCheck3 || filterCheck4 || filterCheck5) {
					succeed = true;
				}
			} else {
				if (referenceCheck && filterCheck1 && filterCheck2 && filterCheck3 && filterCheck4 && filterCheck5) {
					succeed = true;
				}
			}
			if (succeed && !(hopperItem.getItem() == Blocks.AIR.asItem())) {
				if (throughputItem.getItem() == Blocks.AIR.asItem()) {
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
						if (_ent != null) {
							final int _slotid = 0;
							final ItemStack _setstack = hopperItem.copy();
							_setstack.setCount(hopperItem.getCount());
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
					{
						BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
						if (_ent != null) {
							final int _slotid = (int) hopperSlot;
							final ItemStack _setstack = hopperItem.copy();
							_setstack.setCount(0);
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable)
									((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
							});
						}
					}
				} else if ((ForgeRegistries.ITEMS.getKey(hopperItem.getItem()).toString()).equals(ForgeRegistries.ITEMS.getKey(throughputItem.getItem()).toString())) {
					if (throughputItem.getMaxStackSize() - throughputItem.getCount() >= hopperItem.getCount()) {
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = hopperItem.copy();
								_setstack.setCount((int) (throughputItem.getCount() + hopperItem.getCount()));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
							if (_ent != null) {
								final int _slotid = (int) hopperSlot;
								final ItemStack _setstack = hopperItem.copy();
								_setstack.setCount(0);
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					} else {
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
							if (_ent != null) {
								final int _slotid = 0;
								final ItemStack _setstack = hopperItem.copy();
								_setstack.setCount(hopperItem.getMaxStackSize());
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
						{
							BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y + 1, z));
							if (_ent != null) {
								final int _slotid = (int) hopperSlot;
								final ItemStack _setstack = hopperItem.copy();
								_setstack.setCount((int) (hopperItem.getCount() - (throughputItem.getMaxStackSize() - throughputItem.getCount())));
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
									if (capability instanceof IItemHandlerModifiable)
										((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
								});
							}
						}
					}
				}
			}
			hopperSlot = hopperSlot + 1;
		}
	}
}
