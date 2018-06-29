import java.util.EventObject;

public class MoneyEvent extends EventObject {
	private String text;
	
	public MoneyEvent(Object source) {
		super(source);
	}
}
