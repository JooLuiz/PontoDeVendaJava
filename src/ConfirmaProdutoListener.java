import java.util.EventListener;

public interface ConfirmaProdutoListener extends EventListener {
	public void confirmaProdutoEventOccoured(ConfirmaProdutoEvent event);
}
