package merinsei.urss.network;

import java.util.function.Supplier;

import merinsei.urss.client.gui.WritableRoadSignBlockEntityScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

public class ToServerWritableERoadSignMessagePacket {
	public String message;
	
	public ToServerWritableERoadSignMessagePacket(String message) {
		this.message = message;
	}
}
