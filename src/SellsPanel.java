import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
//import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JTextField;
import javax.swing.event.EventListenerList;


public class SellsPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();

	public SellsPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Venda"));
		
		//Sells Panel Buttons
		JButton productBtn = new JButton("Adicionar Produto");
		JButton closeBtn = new JButton("Fechar Compra");
		
		//Sells Panel Buttons Actions
		productBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String text = "teste";
				fireSellEvent(new SellEvent(this, text));	
			}
		});
		
		closeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String text = "\nVenda Fechada!";	
			
				fireCancelaEvent(new CancelaEvent(this, text));
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

		add(productBtn, gc);

		gc.gridx = 0;
		gc.gridy = 1;

		add(closeBtn, gc);
	}
	public void fireSellEvent(SellEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == SellListener.class) {
				((SellListener)listeners[i+1]).sellEventOccoured(event);
			}
		}
	}
	
	public void addSellListener(SellListener listener) {
		listenerList.add(SellListener.class, listener);
	}
	
	public void removeSellListener(SellListener listener) {
		listenerList.remove(SellListener.class, listener);
	}
	
	public void fireCancelaEvent(CancelaEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == CancelaListener.class) {
				((CancelaListener)listeners[i+1]).cancelaEventOccoured(event);
			}
		}
	}
	
	public void addCancelaListener(CancelaListener listener) {
		listenerList.add(CancelaListener.class, listener);
	}
	
	public void removeCancelaListener(CancelaListener listener) {
		listenerList.remove(CancelaListener.class, listener);
	}

}
