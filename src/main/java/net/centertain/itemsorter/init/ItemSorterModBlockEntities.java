
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.centertain.itemsorter.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.centertain.itemsorter.block.entity.SorterBlockEntity;
import net.centertain.itemsorter.block.entity.ImprovedSorterBlockEntity;
import net.centertain.itemsorter.ItemSorterMod;

public class ItemSorterModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ItemSorterMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> SORTER = register("sorter", ItemSorterModBlocks.SORTER, SorterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IMPROVED_SORTER = register("improved_sorter", ItemSorterModBlocks.IMPROVED_SORTER, ImprovedSorterBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
