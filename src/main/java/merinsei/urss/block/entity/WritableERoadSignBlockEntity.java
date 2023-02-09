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

public class WritableERoadSignBlockEntity extends BlockEntity {
	
	public String message ="";

	public WritableERoadSignBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntityInit.W_ESIGN.get(), pos, state);
	}
	
	@Override
	public void saveAdditional(CompoundTag nbtTag) {
	    super.saveAdditional(nbtTag);
	    nbtTag.putString("message", message); 
	}

	@Override
	public void load(CompoundTag nbt) {
	    super.load(nbt);
	    this.message = nbt.getString("message");
	}
	
	@Override
	public CompoundTag getUpdateTag(){
	    CompoundTag nbtTag = new CompoundTag();
	    nbtTag.putString("message", message);
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
