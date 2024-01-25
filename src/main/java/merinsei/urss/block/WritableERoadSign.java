package merinsei.urss.block;

import javax.annotation.Nullable;

import merinsei.urss.block.WritableDirectionRoadSign.FrDirectionSignColor;
import merinsei.urss.block.entity.WritableERoadSignBlockEntity;
import merinsei.urss.client.gui.WritableERoadSignBlockEntityMenu;
import merinsei.urss.init.BlockEntityInit;
import merinsei.urss.init.ItemInit;
import merinsei.urss.network.UrssPacketHandler;
import merinsei.urss.network.ToClientWritableERoadSignMessagePacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PacketDistributor;

public class WritableERoadSign extends RoadSign implements EntityBlock {
	
	public enum FrESignColor implements StringRepresentable 
	{ 
		
		WHITE, YELLOW, RED, CYAN, GREEN, BI;

		@Override
		public String getSerializedName() {
			return this.toString().toLowerCase();
		}
		
	}

	public static final EnumProperty<FrESignColor> COLOR = EnumProperty.create("color", FrESignColor.class);
	public static final String MENU_TITLE = "Edit sign";
	
	
	
			
	@Override
	public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
	  return new SimpleMenuProvider((containerId, playerInventory, pplayer) 
			  -> new WritableERoadSignBlockEntityMenu(containerId, playerInventory, ContainerLevelAccess.create(level, pos)),
			  Component.literal(MENU_TITLE));
	}



	public WritableERoadSign() {
        super();
    }
	
	@Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(COLOR);
    }
    
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return BlockEntityInit.W_ESIGN.get().create(pos, state);
	}
	
	@Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
			BlockEntity blockEntity = level.getBlockEntity(pos);
			if(blockEntity instanceof WritableERoadSignBlockEntity wersbe) {
				
				if(player.getItemInHand(hand).getItem() == ItemInit.BRUSH.get()) {
					level.playSound(player, pos, SoundEvents.PAINTING_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
					FrESignColor currentColor = state.getValue(COLOR);
					switch(currentColor) {
					case WHITE:
						currentColor = FrESignColor.CYAN;
						break;
					case CYAN:
						currentColor = FrESignColor.GREEN;
						break;
					case GREEN:
						currentColor = FrESignColor.RED;
						break;
					case RED:
						currentColor = FrESignColor.BI;
						break;
					case BI:
						currentColor = FrESignColor.YELLOW;
						break;
					case YELLOW:
						currentColor = FrESignColor.WHITE;
						break;
					default:
						break;
					
					}
					level.setBlock(pos, state.setValue(COLOR, currentColor), UPDATE_ALL);

				} else if(player.getItemInHand(hand).getItem() == ItemInit.HAMMER.get()) {
					NetworkHooks.openScreen(serverPlayer, state.getMenuProvider(level, pos));
				    UrssPacketHandler.INSTANCE.send(PacketDistributor.PLAYER.with(()->serverPlayer), new ToClientWritableERoadSignMessagePacket(wersbe.message));
				}
				
			    
			}
			
		}
		return InteractionResult.sidedSuccess(level.isClientSide);
    }
	
}
