package merinsei.urss.client.gui;

import java.util.function.Supplier;

import com.mojang.blaze3d.vertex.PoseStack;
import merinsei.urss.network.UrssPacketHandler;
import merinsei.urss.block.WritableERoadSign;
import merinsei.urss.block.WritableERoadSign.FrESignColor;
import merinsei.urss.network.ToClientWritableERoadSignMessagePacket;
import merinsei.urss.network.ToServerWritableERoadSignMessagePacket;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.network.NetworkEvent;

public class WritableERoadSignBlockEntityScreen extends AbstractContainerScreen<WritableERoadSignBlockEntityMenu> {

	private static String message = "";
	private static WritableERoadSign.FrESignColor color = FrESignColor.RED;
	private static EditBox editbox;
	
	Button colorbtn = new Button(this.width / 2, this.height / 5 + 170, 100, 20, Component.literal("Color : "+color.getSerializedName().toUpperCase()), (p_169820_) -> {
		switch(color) {
		case CYAN:
			color = FrESignColor.GREEN;
			break;
		case GREEN:
			color = FrESignColor.RED;
			break;
		case RED:
			color = FrESignColor.YELLOW;
			break;
		case YELLOW:
			color = FrESignColor.CYAN;
			break;
		default:
			break;
		
		}
		switchColorBtnMsg();
	});
	
	public WritableERoadSignBlockEntityScreen(WritableERoadSignBlockEntityMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
	}

	@Override
	protected void init() {
		super.init();

		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		
		WritableERoadSignBlockEntityScreen.editbox = new EditBox(this.font, this.width / 2 - 100, this.height / 5, 200, 20, Component.literal("edittext"));
		WritableERoadSignBlockEntityScreen.editbox.setEditable(true);
		this.addRenderableWidget(WritableERoadSignBlockEntityScreen.editbox);
		
		this.setInitialFocus(WritableERoadSignBlockEntityScreen.editbox);

		this.addRenderableWidget(new Button(this.width / 2 - 100, this.height / 5 + 170, 100, 20, CommonComponents.GUI_DONE, (p_169820_) -> {
			getEditBoxesValues();
			
			ToServerWritableERoadSignMessagePacket pkt = new ToServerWritableERoadSignMessagePacket(message, color.getSerializedName().toUpperCase());
			UrssPacketHandler.INSTANCE.sendToServer(pkt);
			
			this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, 1);
			this.minecraft.player.closeContainer();
		}));
				
		this.addRenderableWidget(colorbtn);

	}
	
	private void switchColorBtnMsg() {
		colorbtn.setMessage(Component.literal("Color : "+ color.getSerializedName().toUpperCase()));
		
	}

	private static void getEditBoxesValues() {
		message = WritableERoadSignBlockEntityScreen.editbox.getValue();
	}
	
	private static void setEditBoxesValues() {
		WritableERoadSignBlockEntityScreen.editbox.setValue(message);
	}

	public void render(PoseStack poseStack, int p_97922_, int p_97923_, float p_97924_) {
		this.renderBackground(poseStack);
		super.render(poseStack, p_97922_, p_97923_, p_97924_);
	}



	@Override
	public void removed() {
		super.removed();

	}

	
	
	@Override
	public void onClose() {
	    super.onClose();
	}

	@Override
	protected void renderBg(PoseStack p_97787_, float p_97788_, int p_97789_, int p_97790_) {
	}
	
	@Override
	public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
		for(int i=0;i<4;i++) {
			if (WritableERoadSignBlockEntityScreen.editbox.isFocused()) {
				WritableERoadSignBlockEntityScreen.editbox.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
				return true;
			}
		}
		return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
	}
	
	@Override
	public boolean mouseClicked(double p_97748_, double p_97749_, int p_97750_) {
		return super.mouseClicked(p_97748_, p_97749_, p_97750_);
		
	}
	
	public static void handlePacket(ToClientWritableERoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		message = msg.message;
		color = FrESignColor.valueOf(msg.color.toUpperCase());
		setEditBoxesValues();
	}
	
	@Override
	protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
		
	}
	


}
