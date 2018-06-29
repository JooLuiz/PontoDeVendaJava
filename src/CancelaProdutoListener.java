import java.util.EventListener;

public interface CancelaProdutoListener extends EventListener {
	public void cancelaProdutoEventOccoured(CancelaProdutoEvent event);
}
