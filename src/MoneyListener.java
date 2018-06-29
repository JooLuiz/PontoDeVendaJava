import java.util.EventListener;

public interface MoneyListener extends EventListener {
	public void moneyEventOccoured(MoneyEvent event);
}
