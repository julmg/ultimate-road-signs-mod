package merinsei.urss.block.entity;

import com.mojang.logging.LogUtils;

import merinsei.urss.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrafficLightBlockEntity extends BlockEntity {
	

	public TrafficLightBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.TRAFFIC_LIGHT.get(), pos, state);
	}
}
