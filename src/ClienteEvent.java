import java.util.EventObject;

public class ClienteEvent extends EventObject {
	private String text;
	
	public ClienteEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

}
