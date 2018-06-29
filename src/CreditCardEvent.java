import java.util.EventObject;

public class CreditCardEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	public CreditCardEvent(Object source) {
		super(source);
	}
}
