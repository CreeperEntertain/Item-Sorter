package net.centertain.itemsorter.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.centertain.itemsorter.item.FilterItem;

public class FilterItemModeAdjustProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack FilterItem = ItemStack.EMPTY;
		FilterItem = FilterItemReturnProcedure.execute(entity);
		if ((FilterItem.getOrCreateTag().getString("FilterMode")).equals("[Equals]")) {
			FilterItem.getOrCreateTag().putString("FilterMode", "[Contains]");
		} else {
			FilterItem.getOrCreateTag().putString("FilterMode", "[Equals]");
		}
	}
}
