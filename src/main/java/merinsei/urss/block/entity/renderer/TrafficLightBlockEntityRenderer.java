package merinsei.urss.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.mojang.math.Vector3f;

import merinsei.urss.block.RoadSign;
import merinsei.urss.block.TrafficLight;
import merinsei.urss.block.TrafficLight.TrafficType;
import merinsei.urss.block.entity.TrafficLightBlockEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class TrafficLightBlockEntityRenderer implements BlockEntityRenderer<TrafficLightBlockEntity> {

	
	
	public TrafficLightBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
	}
	
	@SuppressWarnings("resource")
	@Override
	public void render(TrafficLightBlockEntity blockEntity, float partialTick, PoseStack poseStack,
			MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
		
		poseStack.pushPose();
		BlockState bs = blockEntity.getBlockState();
		
		Direction direction = bs.getValue(RoadSign.FACING);
		
		poseStack.translate(0.5f, 0.15f, 0.5f); //Put text at pole position
		
		switch(direction) {
		case WEST -> poseStack.mulPose(Vector3f.YP.rotationDegrees(90));
		case SOUTH -> poseStack.mulPose(Vector3f.YP.rotationDegrees(180));
		case EAST -> poseStack.mulPose(Vector3f.YP.rotationDegrees(270));
		default -> poseStack.mulPose(Vector3f.YP.rotationDegrees(0));
		}
		
		poseStack.translate(0.136f, 0.18f, -0.15f); //A bit forward to get to the sign, depending on facing direction
		poseStack.scale(-0.03F, -0.03F, -0.03F);
		Font f = Minecraft.getInstance().font;
		MutableComponent mc = Component.empty();
		
		if(bs.getValue(TrafficLight.TRAFFICTYPE)==TrafficType.BLINK_ORANGE) {
			mc = Component.literal("⬤").withStyle(ChatFormatting.GOLD);
		} else {
			mc = Component.literal("⬤").withStyle(ChatFormatting.RED);
		}
		if(blockEntity.getLevel().getGameTime() % 30 < 15) {
			f.drawInBatch(mc, 1, 0f, -1, false, poseStack.last().pose(), bufferSource, false, packedLight, packedLight);
		}		
		
		poseStack.popPose();
		
	}

}
