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

public class ClientesPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public ClientesPanel() {
	Dimension size = getPreferredSize();
	size.width = 250;
	setPreferredSize(size);

	setBorder(BorderFactory.createTitledBorder("Venda"));
	
	//Panel Buttons
	JButton clienteBtn = new JButton("Selecionar Cliente");
	JButton cancelaBtn = new JButton("Cancelar Compra");

	//Panel Buttons Actions
	
	clienteBtn.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) {
				String text = "teste";
				fireClienteEvent(new ClienteEvent(this, text));	
		}
	});
	
	cancelaBtn.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) {
				String text = "teste";
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

	add(clienteBtn, gc);

	gc.gridx = 0;
	gc.gridy = 1;
	
	add(cancelaBtn, gc);
	}
	
	public void fireClienteEvent(ClienteEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == ClienteListener.class) {
				((ClienteListener)listeners[i+1]).clienteEventOccoured(event);
			}
		}
	}
	
	public void addClienteListener(ClienteListener listener) {
		listenerList.add(ClienteListener.class, listener);
	}
	
	public void removeClienteListener(ClienteListener listener) {
		listenerList.remove(ClienteListener.class, listener);
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
