import java.util.EventObject;

public class CloseEvent extends EventObject {
	private String text;
	
	public CloseEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
