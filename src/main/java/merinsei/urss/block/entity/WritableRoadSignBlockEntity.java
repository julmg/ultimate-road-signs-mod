package merinsei.urss.block.entity;

import merinsei.urss.init.BlockEntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WritableRoadSignBlockEntity extends BlockEntity {
	
	public String[] messages = {"", "", "", ""};

	public WritableRoadSignBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.W_SIGN.get(), pos, state);
		
	}
	
	@Override
	public void saveAdditional(CompoundTag nbtTag) {
	    super.saveAdditional(nbtTag);
	    nbtTag.putString("message1", messages[0]); 
	    nbtTag.putString("message2", messages[1]); 
	    nbtTag.putString("message3", messages[2]); 
	    nbtTag.putString("message4", messages[3]); 
	}

	@Override
	public void load(CompoundTag nbt) {
	    super.load(nbt);
	    this.messages[0] = nbt.getString("message1");
	    this.messages[1] = nbt.getString("message2");
	    this.messages[2] = nbt.getString("message3");
	    this.messages[3] = nbt.getString("message4");
	}
	
	@Override
	public CompoundTag getUpdateTag(){
	    CompoundTag nbtTag = new CompoundTag();
	    nbtTag.putString("message1", messages[0]);
	    nbtTag.putString("message2", messages[1]); 
	    nbtTag.putString("message3", messages[2]); 
	    nbtTag.putString("message4", messages[3]); 
	    return nbtTag;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
	  return ClientboundBlockEntityDataPacket.create(this);
	}
	
	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		this.load(pkt.getTag());
	}
}
