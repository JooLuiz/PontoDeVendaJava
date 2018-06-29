import java.util.EventObject;

public class ConfirmaProdutoEvent extends EventObject {
	public ConfirmaProdutoEvent (Object source) {
		super(source);		
	}
	
	public Object getProduto() {
		return source;
	}
}
