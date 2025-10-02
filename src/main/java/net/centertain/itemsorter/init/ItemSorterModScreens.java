
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.centertain.itemsorter.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.centertain.itemsorter.client.gui.SorterInterfaceScreen;
import net.centertain.itemsorter.client.gui.FilterInterfaceScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemSorterModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ItemSorterModMenus.SORTER_INTERFACE.get(), SorterInterfaceScreen::new);
			MenuScreens.register(ItemSorterModMenus.FILTER_INTERFACE.get(), FilterInterfaceScreen::new);
		});
	}
}
