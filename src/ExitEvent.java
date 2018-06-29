import java.util.EventObject;

public class ExitEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	public ExitEvent(Object source) {
		super(source);
	}
}
