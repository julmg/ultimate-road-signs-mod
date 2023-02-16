package merinsei.urss.client.gui;

import java.util.function.Supplier;

import merinsei.urss.block.WritableERoadSign;
import merinsei.urss.block.entity.WritableERoadSignBlockEntity;
import merinsei.urss.init.MenuInit;
import merinsei.urss.network.ToServerWritableERoadSignMessagePacket;
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

public class WritableERoadSignBlockEntityMenu extends AbstractContainerMenu {
	
	public static WritableERoadSignBlockEntity blockEntity;
	private static BlockPos currentPos;
	private static Level currentLevel;
	

	// Client menu constructor
	public WritableERoadSignBlockEntityMenu(int containerId, Inventory playerInventory) {
	  this(containerId, playerInventory, ContainerLevelAccess.NULL);
	}

	// Server menu constructor
	public WritableERoadSignBlockEntityMenu(int containerId, Inventory playerInventory, ContainerLevelAccess access) {
	  	super(MenuInit.WRITABLE_ESIGN_MENU.get(), containerId);
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
	
	public static void handle(ToServerWritableERoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		
	    ctx.get().enqueueWork(() -> {
        	BlockEntity tile = currentLevel.getBlockEntity(currentPos);
        	if (tile instanceof WritableERoadSignBlockEntity){
        		BlockState state = currentLevel.getBlockState(currentPos);
        		
        		
	            ((WritableERoadSignBlockEntity) tile).message = msg.message;
	            
	            BlockState nstate = state.setValue(WritableERoadSign.COLOR, WritableERoadSign.FrESignColor.valueOf(msg.color.toUpperCase()));
	            
	            currentLevel.setBlock(currentPos, nstate, 3);
	            currentLevel.sendBlockUpdated(currentPos, 
	            		state, 
	            		nstate, 3);
	            
	            ((WritableERoadSignBlockEntity) tile).setChanged();
	        }
        	
	    });
	    ctx.get().setPacketHandled(true);
	    
	    
	}
	
}
