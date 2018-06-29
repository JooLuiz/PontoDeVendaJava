import java.util.EventListener;

public interface CancelaClienteListener extends EventListener {
	public void cancelaClienteEventOccoured(CancelaClienteEvent event);
}
