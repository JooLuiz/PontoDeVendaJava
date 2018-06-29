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

public class MenuPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();

	
	public MenuPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Menu"));

		//Menu Panel Buttons
		
		JButton newBtn = new JButton("Nova Venda");
		JButton sangriaBtn = new JButton("Registrar Sangria");
		JButton closeBoxBtn = new JButton("Fechar Caixa");
		
		//Menu Panel Action Listeners
		
		//newBtn Action Listener
		
		newBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String text ="\nNova Venda\n" ;
				
				fireNewEvent(new NewEvent(this, text));
			}
		});
		
		//sangriaBtn Action Listener
		sangriaBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String text ="\nNovo Registro de Sangria\n" ;
				
				fireSangriaEvent(new SangriaEvent(this, text));
			}
		});
		
		//closeBoxBtn Action Listener
		closeBoxBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				String text ="\nCaixa Fechado\n" ;
				
				fireCloseBoxEvent(new CloseBoxEvent(this, text));
			}
		});
		
		//Menu Panel Layout setted with GridBagLayout
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		//// Frist Column ////////////

		gc.gridx = 0;
		gc.gridy = 0;

		add(newBtn, gc);

		//// Second Column ////////////
		gc.gridx = 0;
		gc.gridy = 1;

		add(sangriaBtn, gc);
		
		//// Third Row ////////////////
		gc.gridx = 0;
		gc.gridy = 2;

		add(closeBoxBtn, gc);
	}
	
	//Methods for NewButton Events
	
	public void fireNewEvent(NewEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == NewListener.class) {
				((NewListener)listeners[i+1]).newEventOccoured(event);
			}
		}
	}
	
	public void addNewListener(NewListener listener) {
		listenerList.add(NewListener.class, listener);
	}
	
	public void removeNewListener(NewListener listener) {
		listenerList.remove(NewListener.class, listener);
	}
	
	//Methods for SangriaButton Events
	
	public void fireSangriaEvent(SangriaEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == SangriaListener.class) {
				((SangriaListener)listeners[i+1]).sangriaEventOccoured(event);
			}
		}
	}
	
	public void addSangriaListener(SangriaListener listener) {
		listenerList.add(SangriaListener.class, listener);
	}
	
	public void removeSangriaListener(SangriaListener listener) {
		listenerList.remove(SangriaListener.class, listener);
	}

	//Methods for CloseBoxButton Events
	
	public void fireCloseBoxEvent(CloseBoxEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == CloseBoxListener.class) {
				((CloseBoxListener)listeners[i+1]).closeBoxEventOccoured(event);
			}
		}
	}
	
	public void addCloseBoxListener(CloseBoxListener listener) {
		listenerList.add(CloseBoxListener.class, listener);
	}
	
	public void removeCloseBoxListener(CloseBoxListener listener) {
		listenerList.remove(CloseBoxListener.class, listener);
	}
	
	
}
