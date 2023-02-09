package merinsei.urss.network;

import java.util.function.Supplier;

import com.mojang.logging.LogUtils;

import merinsei.urss.client.gui.WritableRoadSignBlockEntityScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ToClientWritableRoadSignMessagePacket {
	public String[] messages;
	
	public ToClientWritableRoadSignMessagePacket(String[] messages) {
		this.messages = messages;
	}
	
	public static void handle(ToClientWritableRoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		  ctx.get().enqueueWork(() -> {
	        
		    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> WritableRoadSignBlockEntityScreen.handlePacket(msg, ctx));
		  });
		  ctx.get().setPacketHandled(true);
		}
}
