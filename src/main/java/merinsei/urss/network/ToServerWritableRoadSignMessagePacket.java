package merinsei.urss.network;

public class ToServerWritableRoadSignMessagePacket {
	public String[] messages;
	public String color;
	
	public ToServerWritableRoadSignMessagePacket(String[] messages, String color) {
		this.messages = messages;
		this.color = color;
	}
}
