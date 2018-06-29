import java.util.EventListener;

public interface ErrorListener extends EventListener {
	public void errorEventOccoured(ErrorEvent event);
}
