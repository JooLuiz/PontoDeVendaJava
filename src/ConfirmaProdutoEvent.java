import java.util.EventObject;

public class ConfirmaProdutoEvent extends EventObject {
	
	private static final long serialVersionUID = 1L;
	
	public ConfirmaProdutoEvent (Object source) {
		super(source);		
	}
	
	public Object getProduto() {
		return source;
	}
}
