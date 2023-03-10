package merinsei.urss.block;

import merinsei.urss.init.BlockEntityInit;
import merinsei.urss.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BlinkingTrafficLight extends Pole implements EntityBlock {
	
	public enum TrafficLightSize implements StringRepresentable {
		
		ONE, TWO_H, TWO_V, THREE_H, THREE_V;

		@Override
		public String getSerializedName() {
			return this.toString().toLowerCase();
		}
	}
	
	public enum BlinkingTrafficLightColor implements StringRepresentable {
		
		BLINK_RED, BLINK_ORANGE;

		@Override
		public String getSerializedName() {
			return this.toString().toLowerCase();
		}
	}
	
	
	public static final EnumProperty<BlinkingTrafficLightColor> TRAFFICTYPE = EnumProperty.create("color", BlinkingTrafficLightColor.class);
	
	public TrafficLightSize size;
	
    public BlinkingTrafficLight(TrafficLightSize size) {
        super(8);
        this.size = size;
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(TRAFFICTYPE);
    }
    

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if(player.getItemInHand(hand).getItem() == ItemInit.HAMMER.get()) {
			level.playSound(player, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
			switch(state.getValue(TRAFFICTYPE)) {
			case BLINK_ORANGE:
				level.setBlock(pos, state.setValue(TRAFFICTYPE, BlinkingTrafficLightColor.BLINK_RED), UPDATE_ALL);
				break;
			case BLINK_RED:
				level.setBlock(pos, state.setValue(TRAFFICTYPE, BlinkingTrafficLightColor.BLINK_ORANGE), UPDATE_ALL);
				break;
				
				
			default:
				break;
			}
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
    }

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.TRAFFIC_LIGHT.get().create(pos, state);
	}
    
	
	
}