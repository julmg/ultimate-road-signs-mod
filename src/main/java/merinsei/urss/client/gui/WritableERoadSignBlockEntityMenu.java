package merinsei.urss.client.gui;

import java.util.function.Supplier;

import com.mojang.logging.LogUtils;

import merinsei.urss.block.WritableDirectionRoadSign;
import merinsei.urss.block.entity.WritableERoadSignBlockEntity;
import merinsei.urss.block.entity.WritableRoadSignBlockEntity;
import merinsei.urss.init.MenuInit;
import merinsei.urss.network.ToServerWritableERoadSignMessagePacket;
import merinsei.urss.network.ToServerWritableRoadSignMessagePacket;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
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
		LogUtils.getLogger().info("Clicked button " + button); 
        if(button == 1) {
        	
            
            return true; 
        }
		// ... other button etc	...
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
        	LogUtils.getLogger().info("Tile class  : "+tile.getClass().toString());
        	if (tile instanceof WritableERoadSignBlockEntity){
        		BlockState state = currentLevel.getBlockState(currentPos);
        		
        		
	            ((WritableERoadSignBlockEntity) tile).message = msg.message;
	            currentLevel.sendBlockUpdated(currentPos, 
	            		currentLevel.getBlockState(currentPos), 
	            		currentLevel.getBlockState(currentPos), 3);
	            
	            tile.setChanged();
	        }
        	
	    });
	    ctx.get().setPacketHandled(true);
	    
	    
	}
	
}
