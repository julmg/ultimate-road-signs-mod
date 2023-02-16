package merinsei.urss.block.entity;

import merinsei.urss.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TrafficLightBlockEntity extends BlockEntity {
	

	public TrafficLightBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.TRAFFIC_LIGHT.get(), pos, state);
	}
}
