package net.centertain.itemsorter.procedures;

import net.minecraft.world.item.ItemStack;

public class FilterItemInitializationProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putString("FilterType", "[Registry Key]");
		itemstack.getOrCreateTag().putString("FilterMode", "[Contains]");
	}
}
