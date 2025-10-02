package net.centertain.itemsorter.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.centertain.itemsorter.world.inventory.FilterInterfaceMenu;
import net.centertain.itemsorter.procedures.FilterItemTypeReturnProcedure;
import net.centertain.itemsorter.procedures.FilterItemTagWarningReturnProcedure;
import net.centertain.itemsorter.procedures.FilterItemStringReturnProcedure;
import net.centertain.itemsorter.procedures.FilterItemModeReturnProcedure;
import net.centertain.itemsorter.network.FilterInterfaceButtonMessage;
import net.centertain.itemsorter.ItemSorterMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FilterInterfaceScreen extends AbstractContainerScreen<FilterInterfaceMenu> {
	private final static HashMap<String, Object> guistate = FilterInterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox String;
	Button button_mode;
	Button button_type;
	Button button_set;

	public FilterInterfaceScreen(FilterInterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 210;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		String.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (String.isFocused())
			return String.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		String.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				FilterItemTypeReturnProcedure.execute(entity), 89, 62, -3881778, false);
		guiGraphics.drawString(this.font,

				FilterItemModeReturnProcedure.execute(entity), 89, 82, -3881778, false);
		guiGraphics.drawString(this.font,

				FilterItemStringReturnProcedure.execute(entity), 40, 115, -3881778, false);
		guiGraphics.drawString(this.font,

				FilterItemTagWarningReturnProcedure.execute(entity), 41, 45, -3885775, false);
	}

	@Override
	public void init() {
		super.init();
		String = new EditBox(this.font, this.leftPos + 41, this.topPos + 129, 118, 18, Component.translatable("gui.item_sorter.filter_interface.String"));
		String.setMaxLength(32767);
		guistate.put("text:String", String);
		this.addWidget(this.String);
		button_mode = Button.builder(Component.translatable("gui.item_sorter.filter_interface.button_mode"), e -> {
			if (true) {
				ItemSorterMod.PACKET_HANDLER.sendToServer(new FilterInterfaceButtonMessage(0, x, y, z));
				FilterInterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 77, 46, 20).build();
		guistate.put("button:button_mode", button_mode);
		this.addRenderableWidget(button_mode);
		button_type = Button.builder(Component.translatable("gui.item_sorter.filter_interface.button_type"), e -> {
			if (true) {
				ItemSorterMod.PACKET_HANDLER.sendToServer(new FilterInterfaceButtonMessage(1, x, y, z));
				FilterInterfaceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 57, 46, 20).build();
		guistate.put("button:button_type", button_type);
		this.addRenderableWidget(button_type);
		button_set = Button.builder(Component.translatable("gui.item_sorter.filter_interface.button_set"), e -> {
			if (true) {
				ItemSorterMod.PACKET_HANDLER.sendToServer(new FilterInterfaceButtonMessage(2, x, y, z));
				FilterInterfaceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 120, this.topPos + 148, 40, 20).build();
		guistate.put("button:button_set", button_set);
		this.addRenderableWidget(button_set);
	}
}
