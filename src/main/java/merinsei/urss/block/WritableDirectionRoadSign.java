package merinsei.urss.block;

import javax.annotation.Nullable;

import merinsei.urss.block.entity.WritableRoadSignBlockEntity;
import merinsei.urss.client.gui.WritableRoadSignBlockEntityMenu;
import merinsei.urss.init.BlockEntityInit;
import merinsei.urss.network.UrssPacketHandler;
import merinsei.urss.network.ToClientWritableRoadSignMessagePacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PacketDistributor;

public class WritableDirectionRoadSign extends RoadSign implements EntityBlock {
	
	public enum FrDirectionSignColor implements StringRepresentable 
	{ 
		
		WHITE_L, WHITE_R, GREEN_L, GREEN_R, BLUE_L, BLUE_R;

		@Override
		public String getSerializedName() {
			return this.toString().toLowerCase();
		}
		
	}
	
	public static final IntegerProperty COUNT = IntegerProperty.create("count", 1, 4);
	public static final EnumProperty<FrDirectionSignColor> COLOR = EnumProperty.create("color", FrDirectionSignColor.class);
	
	public static final String MENU_TITLE = "Edit signs";
	
	
	
			
	@Override
	public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
	  return new SimpleMenuProvider((containerId, playerInventory, pplayer) 
			  -> new WritableRoadSignBlockEntityMenu(containerId, playerInventory, ContainerLevelAccess.create(level, pos)),
			  Component.literal(MENU_TITLE));
	}



	public WritableDirectionRoadSign() {
        super();
    }
	
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(COUNT);
        builder.add(COLOR);
    }
    
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.W_SIGN.get().create(pos, state);
	}
	
	@Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
			BlockEntity blockEntity = level.getBlockEntity(pos);
			if(blockEntity instanceof WritableRoadSignBlockEntity wrsbe) {
				
			    NetworkHooks.openScreen(serverPlayer, state.getMenuProvider(level, pos));
			    UrssPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(()->serverPlayer), new ToClientWritableRoadSignMessagePacket(wrsbe.messages, state.getValue(COLOR).getSerializedName()));
			}
			
		}
		return InteractionResult.sidedSuccess(level.isClientSide);
    }
	
}
