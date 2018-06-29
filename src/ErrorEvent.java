import java.util.EventObject;

public class ErrorEvent extends EventObject {
	private String text;
	
	public ErrorEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
