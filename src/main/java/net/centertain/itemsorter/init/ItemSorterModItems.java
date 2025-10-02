
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.centertain.itemsorter.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.centertain.itemsorter.item.FilterItem;
import net.centertain.itemsorter.ItemSorterMod;

public class ItemSorterModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ItemSorterMod.MODID);
	public static final RegistryObject<Item> SORTER = block(ItemSorterModBlocks.SORTER);
	public static final RegistryObject<Item> FILTER = REGISTRY.register("filter", () -> new FilterItem());
	public static final RegistryObject<Item> IMPROVED_SORTER = block(ItemSorterModBlocks.IMPROVED_SORTER);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
