import java.util.EventObject;

public class CreditCardEvent extends EventObject {
	private String text;
	
	public CreditCardEvent(Object source) {
		super(source);
	}
}
