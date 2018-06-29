import java.util.EventListener;

public interface ClienteListener extends EventListener {
	public void clienteEventOccoured(ClienteEvent event);
}
