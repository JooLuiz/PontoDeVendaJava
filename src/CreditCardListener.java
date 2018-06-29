import java.util.EventListener;

public interface CreditCardListener extends EventListener {
	public void creditCardEventOccoured(CreditCardEvent event);
}
