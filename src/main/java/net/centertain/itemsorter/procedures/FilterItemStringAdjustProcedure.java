package net.centertain.itemsorter.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.centertain.itemsorter.item.FilterItem;

import java.util.HashMap;

public class FilterItemStringAdjustProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		ItemStack FilterItem = ItemStack.EMPTY;
		FilterItem = FilterItemReturnProcedure.execute(entity);
		FilterItem.getOrCreateTag().putString("FilterString", ((guistate.containsKey("text:String") ? ((EditBox) guistate.get("text:String")).getValue() : "").replace("\"", "&quot;")));
	}
}
