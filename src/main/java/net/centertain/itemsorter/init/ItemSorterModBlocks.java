
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.centertain.itemsorter.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.centertain.itemsorter.block.SorterBlock;
import net.centertain.itemsorter.block.ImprovedSorterBlock;
import net.centertain.itemsorter.ItemSorterMod;

public class ItemSorterModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ItemSorterMod.MODID);
	public static RegistryObject<Block> SORTER;

	public static RegistryObject<Block> IMPROVED_SORTER;

	public static void init() {
		init1();
	}

	public static void init1() {
		SORTER = REGISTRY.register("sorter", () -> new SorterBlock());
		IMPROVED_SORTER = REGISTRY.register("improved_sorter", () -> new ImprovedSorterBlock());
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
