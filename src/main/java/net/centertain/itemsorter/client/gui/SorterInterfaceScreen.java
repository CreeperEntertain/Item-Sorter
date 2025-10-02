package net.centertain.itemsorter.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.centertain.itemsorter.world.inventory.SorterInterfaceMenu;
import net.centertain.itemsorter.procedures.FilterModeReturnProcedure;
import net.centertain.itemsorter.network.SorterInterfaceButtonMessage;
import net.centertain.itemsorter.ItemSorterMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SorterInterfaceScreen extends AbstractContainerScreen<SorterInterfaceMenu> {
	private final static HashMap<String, Object> guistate = SorterInterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_mode;

	public SorterInterfaceScreen(SorterInterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 216;
		this.imageHeight = 196;
	}

	private static final ResourceLocation texture = new ResourceLocation("item_sorter:textures/screens/sorter_interface.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.item_sorter.sorter_interface.label_inventory"), 27, 99, -12829636, false);
		guiGraphics.drawString(this.font,

				FilterModeReturnProcedure.execute(world, x, y, z), 117, 78, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.item_sorter.sorter_interface.label_g"), 8, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.item_sorter.sorter_interface.label_filtered_item"), 28, 62, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.item_sorter.sorter_interface.label_throughput"), 28, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.item_sorter.sorter_interface.label_item"), 28, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.item_sorter.sorter_interface.label_filters"), 117, 27, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_mode = Button.builder(Component.translatable("gui.item_sorter.sorter_interface.button_mode"), e -> {
			if (true) {
				ItemSorterMod.PACKET_HANDLER.sendToServer(new SorterInterfaceButtonMessage(0, x, y, z));
				SorterInterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 117, this.topPos + 55, 46, 20).build();
		guistate.put("button:button_mode", button_mode);
		this.addRenderableWidget(button_mode);
	}
}
