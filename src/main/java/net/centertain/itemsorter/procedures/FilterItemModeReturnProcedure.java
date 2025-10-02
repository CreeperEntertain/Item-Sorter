package net.centertain.itemsorter.procedures;

import net.minecraft.world.entity.Entity;

public class FilterItemModeReturnProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return FilterItemReturnProcedure.execute(entity).getOrCreateTag().getString("FilterMode");
	}
}
