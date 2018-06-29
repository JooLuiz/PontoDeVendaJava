import java.util.EventObject;

public class ConfirmaClienteEvent extends EventObject {
	public ConfirmaClienteEvent (Object source) {
		super(source);		
	}
	
	public Object getCliente() {
		return source;
	}
}
