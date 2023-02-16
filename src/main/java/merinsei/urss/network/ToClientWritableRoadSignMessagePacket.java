package merinsei.urss.network;

import java.util.function.Supplier;

import merinsei.urss.client.gui.WritableRoadSignBlockEntityScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ToClientWritableRoadSignMessagePacket {
	public String[] messages;
	public String color;
	
	public ToClientWritableRoadSignMessagePacket(String[] messages, String color) {
		this.messages = messages;
		this.color = color;
	}
	
	public static void handle(ToClientWritableRoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		  ctx.get().enqueueWork(() -> {
	        
		    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> WritableRoadSignBlockEntityScreen.handlePacket(msg, ctx));
		  });
		  ctx.get().setPacketHandled(true);
		}
}
