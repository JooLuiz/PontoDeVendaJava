import java.util.EventListener;

public interface ExitListener extends EventListener {
	public void exitEventOccoured(ExitEvent event);
}
