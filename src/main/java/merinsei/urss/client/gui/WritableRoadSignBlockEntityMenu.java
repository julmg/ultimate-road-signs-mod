package merinsei.urss.client.gui;

import java.util.function.Supplier;

import merinsei.urss.block.WritableDirectionRoadSign;
import merinsei.urss.block.entity.WritableRoadSignBlockEntity;
import merinsei.urss.init.MenuInit;
import merinsei.urss.network.ToServerWritableRoadSignMessagePacket;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkEvent;

public class WritableRoadSignBlockEntityMenu extends AbstractContainerMenu {
	
	public static WritableRoadSignBlockEntity blockEntity;
	private static BlockPos currentPos;
	private static Level currentLevel;
	

	// Client menu constructor
	public WritableRoadSignBlockEntityMenu(int containerId, Inventory playerInventory) {
	  this(containerId, playerInventory, ContainerLevelAccess.NULL);
	}

	// Server menu constructor
	public WritableRoadSignBlockEntityMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
	  	super(MenuInit.WRITABLE_SIGN_MENU.get(), containerId);
	  	access.evaluate((l,p) -> {
	  		currentPos = p;
	  		currentLevel = l;
	  		return 0;
	  	});
	}
	
	@Override
    public boolean clickMenuButton(Player player, int button) {
        if(button == 1) {
            return true; 
        }
		return false;
    }
    

	@Override
	public ItemStack quickMoveStack(Player p_38941_, int p_38942_) {
		return null;
	}

	@Override
	public boolean stillValid(Player p_38874_) {
		return true;
	}
	
	public static void handle(ToServerWritableRoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		
	    ctx.get().enqueueWork(() -> {
        	BlockEntity tile = currentLevel.getBlockEntity(currentPos);
        	if (tile instanceof WritableRoadSignBlockEntity){
        		BlockState state = currentLevel.getBlockState(currentPos);
        		BlockState nstate = state;
        		
        		if(msg.messages[3]=="") {
        			if(msg.messages[2]=="") {
        				if(msg.messages[1]=="") {
        					nstate = nstate.setValue(WritableDirectionRoadSign.COUNT, 1);
                		} else {
                			nstate = nstate.setValue(WritableDirectionRoadSign.COUNT, 2);
                		}
            		} else {
            			nstate = nstate.setValue(WritableDirectionRoadSign.COUNT, 3);
            		}
        		} else {
        			nstate = nstate.setValue(WritableDirectionRoadSign.COUNT, 4);
        		}
        		
	            ((WritableRoadSignBlockEntity) tile).messages = msg.messages.clone();
	            currentLevel.setBlock(currentPos, nstate, 3);
	            
	            currentLevel.sendBlockUpdated(currentPos, 
	            		state, 
	            		nstate, 3);
	            
	            ((WritableRoadSignBlockEntity) tile).setChanged();
	        }
        	
	    });
	    ctx.get().setPacketHandled(true);
	    
	    
	}
	
}
