import java.util.EventObject;

public class CloseBoxEvent extends EventObject {
	private String text;
	
	public CloseBoxEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
