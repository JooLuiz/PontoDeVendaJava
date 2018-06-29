import java.util.EventObject;

public class ExitEvent extends EventObject {
	private String text;
	
	public ExitEvent(Object source) {
		super(source);
	}
}
