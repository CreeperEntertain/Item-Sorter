package net.centertain.itemsorter.procedures;

import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.ArrayList;

public class FilterItemSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		List<Object> Ye = new ArrayList<>();
		return itemstack.getOrCreateTag().getString("FilterType") + " " + itemstack.getOrCreateTag().getString("FilterMode") + " " + (itemstack.getOrCreateTag().getString("FilterString")).replace("&quot;", "\"");
	}
}
