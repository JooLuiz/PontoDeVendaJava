import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProdutosList extends JPanel {
	
	private JButton confirmarBtn;
	private JButton cancelarBtn;
	private JScrollPane scroll;
	private JList<Produto> listaProdutos;
	MyListModel<Produto> data = null;
	
	public ProdutosList(AcessoBanco banco) {
		setBorder(BorderFactory.createTitledBorder("Produtos"));
		
		confirmarBtn = new JButton("Confirmar");
		cancelarBtn = new JButton("Concluir");
		
		data = new MyListModel<Produto>();
		data.replaceData(banco.getListaProdutos());
		listaProdutos = new JList<Produto>(data);
		
		scroll = new JScrollPane(listaProdutos);

		confirmarBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				int index=listaProdutos.getSelectedIndex();
				Produto product = data.getElementAt(index);
				fireConfirmaProdutoEvent(new ConfirmaProdutoEvent((Produto) product));
			}
		});
		
		cancelarBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					fireCancelaProdutoEvent(new CancelaProdutoEvent(this));	
			}
		});
		

		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		//// Frist Column ////////////

		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(scroll);
		
		gc.gridx = 0;
		gc.gridy = 1;
		
		add(cancelarBtn);
		
		gc.gridx = 0;
		gc.gridy = 2;
		
		add(confirmarBtn);
	}
	public void fireConfirmaProdutoEvent(ConfirmaProdutoEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == ConfirmaProdutoListener.class) {
				((ConfirmaProdutoListener)listeners[i+1]).confirmaProdutoEventOccoured(event);
			}
		}
	}
	
	public void addConfirmaProdutoListener(ConfirmaProdutoListener listener) {
		listenerList.add(ConfirmaProdutoListener.class, listener);
	}
	
	public void removeConfirmaProdutoListener(ConfirmaProdutoListener listener) {
		listenerList.remove(ConfirmaProdutoListener.class, listener);
	}
	
	public void fireCancelaProdutoEvent(CancelaProdutoEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == CancelaProdutoListener.class) {
				((CancelaProdutoListener)listeners[i+1]).cancelaProdutoEventOccoured(event);
			}
		}
	}
	
	public void addCancelaProdutoListener(CancelaProdutoListener listener) {
		listenerList.add(CancelaProdutoListener.class, listener);
	}
	
	public void removeCancelaProdutoListener(CancelaProdutoListener listener) {
		listenerList.remove(CancelaProdutoListener.class, listener);
	}
}
