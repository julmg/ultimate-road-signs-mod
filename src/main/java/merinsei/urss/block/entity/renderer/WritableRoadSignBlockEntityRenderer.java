package merinsei.urss.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import merinsei.urss.Urss;
import merinsei.urss.block.RoadSign;
import merinsei.urss.block.WritableDirectionRoadSign;
import merinsei.urss.block.entity.WritableRoadSignBlockEntity;
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

public class WritableRoadSignBlockEntityRenderer implements BlockEntityRenderer<WritableRoadSignBlockEntity> {

	
	public WritableRoadSignBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
	}
	
	@SuppressWarnings("resource")
	@Override
	public void render(WritableRoadSignBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		//opengl time lmao
		
		poseStack.pushPose();
		Direction direction = blockEntity.getBlockState().getValue(RoadSign.FACING);
		WritableDirectionRoadSign.FrDirectionSignColor signcolor = blockEntity.getBlockState().getValue(WritableDirectionRoadSign.COLOR);
		int signCount = blockEntity.getBlockState().getValue(WritableDirectionRoadSign.COUNT);
		
		ChatFormatting textcolor = ChatFormatting.WHITE;
		if(signcolor==WritableDirectionRoadSign.FrDirectionSignColor.WHITE_L || signcolor==WritableDirectionRoadSign.FrDirectionSignColor.WHITE_R) {
			textcolor = ChatFormatting.BLACK;
		}
		
		Style style = Style.EMPTY.withColor(textcolor);
		
		poseStack.translate(0.5f, 0.9125f, 0.5f); //Put text at pole position
		
		switch(direction) {
		case WEST -> poseStack.mulPose(Vector3f.YP.rotationDegrees(90));
		case SOUTH -> poseStack.mulPose(Vector3f.YP.rotationDegrees(180));
		case EAST -> poseStack.mulPose(Vector3f.YP.rotationDegrees(270));
		default -> poseStack.mulPose(Vector3f.YP.rotationDegrees(0));
		}
		
		poseStack.translate(0f, 0f, -0.075f); //A bit forward to get to the sign, depending on facing direction
		poseStack.scale(-0.0125F, -0.0125F, -0.0125F);
		
		poseStack.scale(0.8F, 0.8F, 0.8F);
		
		
		
		Font f = Minecraft.getInstance().font;
		float f2 = 0;
		MutableComponent mc = Component.empty();
		
		for(int i=0;i<signCount;i++) {
			if(blockEntity.messages[i].contains("||")) {
				String[] mes1 = blockEntity.messages[i].split("\\|\\|",2);
				f2 = Math.min(f2,(float)(-Math.max(f.width(mes1[0]),f.width(mes1[1])) / 2));
			} else {
				f2 = Math.min(f2,(float)(-f.width(blockEntity.messages[i]) / 2));
			}
		}
		
		for(int i=0;i<signCount;i++) {
			if(blockEntity.messages[i].contains("||")) {
				String[] mes1 = blockEntity.messages[i].split("\\|\\|",2);
				
				poseStack.translate(0f, -5.625f, 0f);
				
				mc = Component.literal(mes1[0]).withStyle(style);
				f.drawInBatch(mc, f2, 0f, -1, false, poseStack.last().pose(), bufferSource, false, packedLight, packedLight);
				poseStack.translate(0f, 11.25f, 0f);
				
				mc = Component.literal(mes1[1]).withStyle(style);
				f.drawInBatch(mc, f2, 0f, -1, false, poseStack.last().pose(), bufferSource, false, packedLight, packedLight);
				poseStack.translate(0f, 19.3125f, 0f);
			} else {
				
				mc = Component.literal(blockEntity.messages[i]).withStyle(style);
				f.drawInBatch(mc, f2, 0f, -1, false, poseStack.last().pose(), bufferSource, false, packedLight, packedLight);
				poseStack.translate(0f, 24.9375f, 0f);
			}
			
		}
		
		
		poseStack.popPose();
		
	}

}
