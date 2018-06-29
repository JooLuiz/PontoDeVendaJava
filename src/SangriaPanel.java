import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;

public class SangriaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public SangriaPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Sangria"));
		
		//Sangria Panel Labels
		
		JLabel remetenteLabel = new JLabel("Remetente: ");
		JLabel valorLabel = new JLabel("Valor: ");

		//Sangria Panel Input Fields
		
		final JTextField remetenteField = new JTextField(30);
		final JTextField valorField = new JTextField(3);
		
		//Sangria Panel Buttons
		
		JButton registerBtn = new JButton("Registrar Sangria");
		
		registerBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(remetenteField.getText() == " " || valorField.getText() == " ") {
					fireErrorEvent(new ErrorEvent(this, "Ops, algo errado aconteceu"));
				}else {
					String remetente = remetenteField.getText();
					String valor = valorField.getText();
					
					remetenteField.setText(" ");
					valorField.setText(" ");
					
					String text ="Sangria registrada para o caixa: " + remetente + "\nNo valor de: " + valor + "\n";
					
					fireRegistraSangriaEvent(new RegistraSangriaEvent(this, text));
				}
			}
		});
		
		//Details Panel Layout setted with GridBagLayout
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		//// Frist Column ////////////

		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		gc.gridx = 0;
		gc.gridy = 0;

		add(remetenteLabel, gc);

		gc.gridx = 0;
		gc.gridy = 1;

		add(valorLabel, gc);

		//// Second Column ////////////
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.gridx = 1;
		gc.gridy = 0;

		add(remetenteField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;

		add(valorField, gc);

		//// Third Row ////////////////
		
		gc.weighty = 10;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 3;
		
		add(registerBtn, gc);
	}
	
	public void fireErrorEvent(ErrorEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == ErrorListener.class) {
				((ErrorListener)listeners[i+1]).errorEventOccoured(event);
			}
		}
	}
	
	public void addErrorListener(ErrorListener listener) {
		listenerList.add(ErrorListener.class, listener);
	}
	
	public void removeErrorListener(ErrorListener listener) {
		listenerList.remove(ErrorListener.class, listener);
	}
	
	public void fireRegistraSangriaEvent(RegistraSangriaEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == RegistraSangriaListener.class) {
				((RegistraSangriaListener)listeners[i+1]).registraSangriaEventOccoured(event);
			}
		}
	}
	
	public void addRegistraSangriaListener(RegistraSangriaListener listener) {
		listenerList.add(RegistraSangriaListener.class, listener);
	}
	
	public void removeRegistraSangriaListener(RegistraSangriaListener listener) {
		listenerList.remove(RegistraSangriaListener.class, listener);
	}

}
