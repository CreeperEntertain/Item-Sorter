package net.centertain.itemsorter.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class FilterItemTagWarningReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		ItemStack filterItem = ItemStack.EMPTY;
		filterItem = FilterItemReturnProcedure.execute(entity);
		if ((filterItem.getOrCreateTag().getString("FilterType")).equals("[Item Tag]") && (filterItem.getOrCreateTag().getString("FilterMode")).equals("[Contains]")) {
			return "INFO: Item tag scans default to [Equals]";
		}
		return "";
	}
}
