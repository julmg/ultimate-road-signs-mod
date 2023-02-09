package merinsei.urss.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Pole extends Block {
	
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	private static final VoxelShape SHAPE = makeShape();
	
    public Pole() {
        super(Block.Properties.copy(Blocks.IRON_BARS));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    public Pole(int lightLevel) {
        super(Block.Properties.copy(Blocks.IRON_BARS).lightLevel((state) -> lightLevel));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    public static VoxelShape makeShape(){
    	VoxelShape shape = Shapes.empty();
    	shape = Shapes.join(shape, Shapes.box(0.4375, 0, 0.4375, 0.5625, 1, 0.5625), BooleanOp.OR);

    	return shape;
    }

	// Called for class loading.
    public static void register(){};

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
		return SHAPE;
    	
    }
}