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

public class ClientesList extends JPanel{
	
	private JButton confirmarBtn;
	private JButton cancelarBtn;
	private JScrollPane scroll;
	private JList<Cliente> listaClientes;
	MyListModel<Cliente> data = null;
	
	
	public ClientesList(AcessoBanco banco) {
		setBorder(BorderFactory.createTitledBorder("Clientes"));
		
		confirmarBtn = new JButton("Confirmar");
		cancelarBtn = new JButton("Cancelar");
		
		data = new MyListModel<Cliente>();
		data.replaceData(banco.getListaClientes());
		listaClientes = new JList<Cliente>(data);
		
		scroll = new JScrollPane(listaClientes);
		
		confirmarBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				int index=listaClientes.getSelectedIndex();
				Cliente client = data.getElementAt(index);
				fireConfirmaClienteEvent(new ConfirmaClienteEvent((Cliente) client));
			}
		});
		
		cancelarBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					fireCancelaClienteEvent(new CancelaClienteEvent(this));	
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
	
	public void fireConfirmaClienteEvent(ConfirmaClienteEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == ConfirmaClienteListener.class) {
				((ConfirmaClienteListener)listeners[i+1]).confirmaClienteEventOccoured(event);
			}
		}
	}
	
	public void addConfirmaClienteListener(ConfirmaClienteListener listener) {
		listenerList.add(ConfirmaClienteListener.class, listener);
	}
	
	public void removeConfirmaClienteListener(ConfirmaClienteListener listener) {
		listenerList.remove(ConfirmaClienteListener.class, listener);
	}
	
	public void fireCancelaClienteEvent(CancelaClienteEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == CancelaClienteListener.class) {
				((CancelaClienteListener)listeners[i+1]).cancelaClienteEventOccoured(event);
			}
		}
	}
	
	public void addCancelaClienteListener(CancelaClienteListener listener) {
		listenerList.add(CancelaClienteListener.class, listener);
	}
	
	public void removeCancelaClienteListener(CancelaClienteListener listener) {
		listenerList.remove(CancelaClienteListener.class, listener);
	}
}
