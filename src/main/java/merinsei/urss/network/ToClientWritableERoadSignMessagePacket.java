package merinsei.urss.network;

import java.util.function.Supplier;

import merinsei.urss.client.gui.WritableERoadSignBlockEntityScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ToClientWritableERoadSignMessagePacket {
	public String message;
	
	public ToClientWritableERoadSignMessagePacket(String message) {
		this.message = message;
	}
	
	public static void handle(ToClientWritableERoadSignMessagePacket msg, Supplier<NetworkEvent.Context> ctx) {
		  ctx.get().enqueueWork(() -> {
	        
		    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> WritableERoadSignBlockEntityScreen.handlePacket(msg, ctx));
		  });
		  ctx.get().setPacketHandled(true);
		}
}
