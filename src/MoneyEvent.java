import java.util.EventObject;

public class MoneyEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	public MoneyEvent(Object source) {
		super(source);
	}
}
