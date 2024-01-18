package merinsei.urss.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import merinsei.urss.Urss;
import merinsei.urss.block.RoadSign;
import merinsei.urss.block.WritableERoadSign;
import merinsei.urss.block.entity.WritableERoadSignBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

public class WritableERoadSignBlockEntityRenderer implements BlockEntityRenderer<WritableERoadSignBlockEntity> {

	private static final ResourceLocation FRSIGN_FONT = new ResourceLocation(Urss.MODID, "caracteres");

	
	public WritableERoadSignBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
	}
	
	@SuppressWarnings("resource")
	@Override
	public void render(WritableERoadSignBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		//opengl time lmao
		
		poseStack.pushPose();
		Direction direction = blockEntity.getBlockState().getValue(RoadSign.FACING);
		WritableERoadSign.FrESignColor signcolor = blockEntity.getBlockState().getValue(WritableERoadSign.COLOR);
		
		ChatFormatting textcolor = ChatFormatting.WHITE;
		if(signcolor==WritableERoadSign.FrESignColor.YELLOW || signcolor==WritableERoadSign.FrESignColor.WHITE ) {
			textcolor = ChatFormatting.BLACK;
		}
		
		poseStack.translate(0.5f, 0.125f, 0.5f); //Put text at pole position
		
		switch(direction) {
		case WEST -> poseStack.mulPose(Vector3f.YP.rotationDegrees(90));
		case SOUTH -> poseStack.mulPose(Vector3f.YP.rotationDegrees(180));
		case EAST -> poseStack.mulPose(Vector3f.YP.rotationDegrees(270));
		default -> poseStack.mulPose(Vector3f.YP.rotationDegrees(0));
		}
		
		poseStack.translate(0f, 0.0375f, -0.075f); //A bit forward to get to the sign, depending on facing direction
		poseStack.scale(-0.015F, -0.015F, -0.015F);
		
		
		Font f = Minecraft.getInstance().font;
		float f2 = 0;
		MutableComponent mc = Component.empty();
		
		f2 = (float)(-f.width(blockEntity.message) / 2);
		mc = Component.literal(blockEntity.message).withStyle(Style.EMPTY.withFont(FRSIGN_FONT).withColor(textcolor));
		f.drawInBatch(mc, f2, 0f, -1, false, poseStack.last().pose(), bufferSource, false, packedLight, packedLight);
		
		
		poseStack.popPose();
		
	}

}
