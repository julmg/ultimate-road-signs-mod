package merinsei.urss.network;

public class ToServerWritableERoadSignMessagePacket {
	public String message;
	public String color;
	
	public ToServerWritableERoadSignMessagePacket(String message, String color) {
		this.message = message;
		this.color = color;
	}
}
