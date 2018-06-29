import java.util.EventObject;

public class CancelaProdutoEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	public CancelaProdutoEvent (Object source) {
		super(source);
		
	}
}
