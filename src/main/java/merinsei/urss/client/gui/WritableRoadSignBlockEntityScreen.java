package merinsei.urss.client.gui;

import java.util.function.Supplier;

import com.mojang.blaze3d.vertex.PoseStack;
import merinsei.urss.network.UrssPacketHandler;
import merinsei.urss.block.WritableDirectionRoadSign;
import merinsei.urss.block.WritableDirectionRoadSign.FrDirectionSignColor;
import merinsei.urss.network.ToClientWritableRoadSignMessagePacket;
import merinsei.urss.network.ToServerWritableRoadSignMessagePacket;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.network.NetworkEvent;

public class WritableRoadSignBlockEntityScreen extends AbstractContainerScreen<WritableRoadSignBlockEntityMenu> {

	private static String[] messages = {"", "", "", ""};
	private static WritableDirectionRoadSign.FrDirectionSignColor color = FrDirectionSignColor.WHITE_L;
	private static EditBox[] editboxes = new EditBox[4];
	
	Button colorbtn = new Button(this.width / 2, this.height / 5 + 170, 100, 20, Component.literal("Color : "+color.getSerializedName().toUpperCase()), (p_169820_) -> {
		switch(color) {
		case BLUE_L:
			color = FrDirectionSignColor.BLUE_R;
			break;
		case BLUE_R:
			color = FrDirectionSignColor.GREEN_L;
			break;
		case GREEN_L:
			color = FrDirectionSignColor.GREEN_R;
			break;
		case GREEN_R:
			color = FrDirectionSignColor.WHITE_L;
			break;
		case WHITE_L:
			color = FrDirectionSignColor.WHITE_R;
			break;
		case WHITE_R:
			color = FrDirectionSignColor.BLUE_L;
			break;
		default:
			break;
		
		}
		switchColorBtnMsg();
	});
	
	public WritableRoadSignBlockEntityScreen(WritableRoadSignBlockEntityMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
	}

	@Override
	protected void init() {
		super.init();

		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		
		for(int i=0; i<4; i++) {
			WritableRoadSignBlockEntityScreen.editboxes[i] = new EditBox(this.font, this.width / 2 - 100, this.height / 5 + 40*i, 200, 20, Component.literal("edittext "+i));
			WritableRoadSignBlockEntityScreen.editboxes[i].setEditable(true);
			this.addRenderableWidget(WritableRoadSignBlockEntityScreen.editboxes[i]);
			
		}
		this.setInitialFocus(WritableRoadSignBlockEntityScreen.editboxes[0]);

		this.addRenderableWidget(new Button(this.width / 2 - 100, this.height / 5 + 170, 100, 20, CommonComponents.GUI_DONE, (p_169820_) -> {
			getEditBoxesValues();
			
			ToServerWritableRoadSignMessagePacket pkt = new ToServerWritableRoadSignMessagePacket(messages, color.getSerializedName().toUpperCase());
			UrssPacketHandler.INSTANCE.sendToServer(pkt);
			
			this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, 1);
			this.minecraft.player.closeContainer();
		}));
		
		
		this.addRenderableWidget(colorbtn);

	}
	
	private static void getEditBoxesValues() {
		messages[0] = WritableRoadSignBlockEntityScreen.editboxes[0].getValue();
		messages[1] = WritableRoadSignBlockEntityScreen.editboxes[1].getValue();
		messages[2] = WritableRoadSignBlockEntityScreen.editboxes[2].getValue();
		messages[3] = WritableRoadSignBlockEntityScreen.editboxes[3].getValue();
	}
	
	private static void setEditBoxesValues() {
		WritableRoadSignBlockEntityScreen.editboxes[0].setValue(messages[0]);
		WritableRoadSignBlockEntityScreen.editboxes[1].setValue(messages[1]);
		WritableRoadSignBlockEntityScreen.editboxes[2].setValue(messages[2]);
		WritableRoadSignBlockEntityScreen.editboxes[3].setValue(messages[3]);
	}

	public void render(PoseStack poseStack, int p_97922_, int p_97923_, float p_97924_) {
		this.renderBackground(poseStack);
		super.render(poseStack, p_97922_, p_97923_, p_97924_);
	}
	
	private void switchColorBtnMsg() {
		colorbtn.setMessage(Component.literal("Color : "+ color.getSerializedName().toUpperCase()));
		
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
		for(int i=0; i<4; i++) {
		      this.font.draw(p_97787_, "Line "+i, (float) editboxes[i].x-50, (float) editboxes[i].y+5, 13158600);
			}
	}
	
	@Override
	public boolean keyPressed(int p_keyPressed_1_, int p_keyPressed_2_, int p_keyPressed_3_) {
		for(int i=0;i<4;i++) {
			if (WritableRoadSignBlockEntityScreen.editboxes[i].isFocused()) {
				WritableRoadSignBlockEntityScreen.editboxes[i].keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
				return true;
			}
		}
		return super.keyPressed(p_keyPressed_1_, p_keyPressed_2_, p_keyPressed_3_);
	}
	
	@Override
	public boolean mouseClicked(double p_97748_, double p_97749_, int p_97750_) {
		return super.mouseClicked(p_97748_, p_97749_, p_97750_);
		
	}
	
	public static void handlePacket(ToClientWritableRoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		messages = msg.messages.clone();
		color = FrDirectionSignColor.valueOf(msg.color.toUpperCase());
		setEditBoxesValues();
	}
	
	@Override
	protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
		
	}
	


}
