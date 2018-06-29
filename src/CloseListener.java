import java.util.EventListener;

public interface CloseListener extends EventListener{
	public void closeEventOccoured(CloseEvent event);
}
