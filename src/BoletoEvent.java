import java.util.EventObject;

public class BoletoEvent extends EventObject {
	private String text;
	
	public BoletoEvent(Object source) {
		super(source);
	}
}
