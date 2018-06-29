import java.util.EventObject;

public class ConfirmaClienteEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	public ConfirmaClienteEvent (Object source) {
		super(source);		
	}
	
	public Object getCliente() {
		return source;
	}
}
