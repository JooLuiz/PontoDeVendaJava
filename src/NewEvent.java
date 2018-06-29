import java.util.EventObject;

public class NewEvent extends EventObject {
	private String text;
	
	public NewEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
