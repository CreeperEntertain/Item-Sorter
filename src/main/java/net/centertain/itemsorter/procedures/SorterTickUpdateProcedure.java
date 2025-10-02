package net.centertain.itemsorter.procedures;

import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.centertain.itemsorter.init.ItemSorterModBlocks;
import net.centertain.itemsorter.ItemSorterMod;

public class SorterTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.HOPPER || blockstate.getBlock() == ItemSorterModBlocks.IMPROVED_SORTER.get() && new Object() {
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
		}.getAmount(world, new BlockPos((int) x, (int) (y + 1), (int) z)) > 0) {
			SorterItemSuckingProcedure.execute(world, x, y, z);
		}
		ItemSorterMod.queueServerWork(1, () -> {
			if (new Object() {
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
			}.getAmount(world, new BlockPos((int) x, (int) (y - 1), (int) z)) > 0) {
				SorterItemTransportingProcedure.execute(world, x, y, z);
			}
		});
	}
}
