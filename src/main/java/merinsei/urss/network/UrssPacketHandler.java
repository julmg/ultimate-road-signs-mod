package merinsei.urss.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UrssPacketHandler {
	
	private static final String PROTOCOL_VERSION = "1";
	
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
	    new ResourceLocation("urss", "main"),
	    () -> PROTOCOL_VERSION,
	    PROTOCOL_VERSION::equals,
	    PROTOCOL_VERSION::equals
	);
	
	
	public static FriendlyByteBuf encode(ToServerWritableRoadSignMessagePacket pkt, FriendlyByteBuf fbb) {
		fbb.writeUtf(pkt.messages[0]);
		fbb.writeUtf(pkt.messages[1]);
		fbb.writeUtf(pkt.messages[2]);
		fbb.writeUtf(pkt.messages[3]);
		return fbb;
		
	}
	
	public static ToServerWritableRoadSignMessagePacket decodeCTS(FriendlyByteBuf fbb) {
		String[] messages = { fbb.readUtf(), fbb.readUtf(), fbb.readUtf(), fbb.readUtf() };
		ToServerWritableRoadSignMessagePacket pkt = new ToServerWritableRoadSignMessagePacket(messages);
		return pkt;
	}
	
	
	public static FriendlyByteBuf encode(ToClientWritableRoadSignMessagePacket pkt, FriendlyByteBuf fbb) {
		fbb.writeUtf(pkt.messages[0]);
		fbb.writeUtf(pkt.messages[1]);
		fbb.writeUtf(pkt.messages[2]);
		fbb.writeUtf(pkt.messages[3]);
		return fbb;
		
	}
	
	public static ToClientWritableRoadSignMessagePacket decodeSTC(FriendlyByteBuf fbb) {
		String[] messages = { fbb.readUtf(), fbb.readUtf(), fbb.readUtf(), fbb.readUtf() };
		ToClientWritableRoadSignMessagePacket pkt = new ToClientWritableRoadSignMessagePacket(messages);
		return pkt;
	}
	
	
	//-----
	
	
	public static FriendlyByteBuf encode(ToServerWritableERoadSignMessagePacket pkt, FriendlyByteBuf fbb) {
		fbb.writeUtf(pkt.message);
		return fbb;
		
	}
	
	public static ToServerWritableERoadSignMessagePacket decodeCTS_E(FriendlyByteBuf fbb) {
		ToServerWritableERoadSignMessagePacket pkt = new ToServerWritableERoadSignMessagePacket(fbb.readUtf());
		return pkt;
	}
	
	
	public static FriendlyByteBuf encode(ToClientWritableERoadSignMessagePacket pkt, FriendlyByteBuf fbb) {
		fbb.writeUtf(pkt.message);
		return fbb;
		
	}
	
	public static ToClientWritableERoadSignMessagePacket decodeSTC_E(FriendlyByteBuf fbb) {
		ToClientWritableERoadSignMessagePacket pkt = new ToClientWritableERoadSignMessagePacket(fbb.readUtf());
		return pkt;
	}
	
	
	
}
