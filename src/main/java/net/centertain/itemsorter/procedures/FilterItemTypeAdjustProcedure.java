package net.centertain.itemsorter.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.centertain.itemsorter.item.FilterItem;

public class FilterItemTypeAdjustProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack FilterItem = ItemStack.EMPTY;
		FilterItem = FilterItemReturnProcedure.execute(entity);
		if ((FilterItem.getOrCreateTag().getString("FilterType")).equals("[Registry Key]")) {
			FilterItem.getOrCreateTag().putString("FilterType", "[Item Name]");
		} else if ((FilterItem.getOrCreateTag().getString("FilterType")).equals("[Item Name]")) {
			FilterItem.getOrCreateTag().putString("FilterType", "[Mod ID]");
		} else if ((FilterItem.getOrCreateTag().getString("FilterType")).equals("[Mod ID]")) {
			FilterItem.getOrCreateTag().putString("FilterType", "[Mod Name]");
		} else if ((FilterItem.getOrCreateTag().getString("FilterType")).equals("[Mod Name]")) {
			FilterItem.getOrCreateTag().putString("FilterType", "[Item Tag]");
		} else {
			FilterItem.getOrCreateTag().putString("FilterType", "[Registry Key]");
		}
	}
}
