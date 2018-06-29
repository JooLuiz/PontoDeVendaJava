import java.util.EventObject;

public class SellEvent extends EventObject {
	private String text;
	
	public SellEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

}
