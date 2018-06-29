import java.util.EventObject;

public class SangriaEvent extends EventObject{
	
	private static final long serialVersionUID = 1L;
	
	private String text;
	
	public SangriaEvent(Object source, String text) {
		super(source);
		
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
