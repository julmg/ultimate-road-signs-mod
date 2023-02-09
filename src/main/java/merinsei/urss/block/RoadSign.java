package merinsei.urss.block;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;

public class RoadSign extends Pole {
	
	public enum SignType implements StringRepresentable 
	{ 
		
		FULL, SMALL_UP, SMALL_DOWN;

		@Override
		public String getSerializedName() {
			return this.toString().toLowerCase();
		}
		
	}
	
	public static final EnumProperty<SignType> SIGNTYPE = EnumProperty.create("type", SignType.class);
	
    public RoadSign() {
        super();
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(SIGNTYPE);
    }
    

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if(player.getItemInHand(hand).getItem() == ItemInit.HAMMER.get()) {
			level.playSound(player, pos, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
			switch(state.getValue(SIGNTYPE)) {
			case FULL:
				level.setBlock(pos, state.setValue(SIGNTYPE, SignType.SMALL_DOWN), UPDATE_ALL);
				break;
			case SMALL_DOWN:
				level.setBlock(pos, state.setValue(SIGNTYPE, SignType.SMALL_UP), UPDATE_ALL);
				break;
			case SMALL_UP:
				level.setBlock(pos, state.setValue(SIGNTYPE, SignType.FULL), UPDATE_ALL);
				break;
			default:
				break;
			}
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
    }
    
	
	
}