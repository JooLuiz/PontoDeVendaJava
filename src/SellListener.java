import java.util.EventListener;

public interface SellListener extends EventListener {
	public void sellEventOccoured(SellEvent event);
}
