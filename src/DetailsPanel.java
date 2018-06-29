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

public class DetailsPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public DetailsPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Abrir Caixa"));

		//Details Panel Labels
		
		JLabel nomeLabel = new JLabel("Nome: ");
		JLabel idLabel = new JLabel("ID: ");
		JLabel senhaLabel = new JLabel("Senha: ");

		//Details Panel Input Fields
		
		final JTextField nomeField = new JTextField(30);
		final JTextField idField = new JTextField(3);
		final JTextField senhaField = new JTextField(8);
		
		//Details Panel Buttons
		
		JButton addBtn = new JButton("Entrar");
		JButton exitBtn = new JButton("Fechar");
		
		//Details Panel Action Listener
		
		addBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(nomeField.getText() == " " || idField.getText() == " " || senhaField.getText() == " ") {
					fireErrorEvent(new ErrorEvent(this, "Ops, algo errado aconteceu"));
				}else {
					String nome = nomeField.getText();
					String id = idField.getText();
					String senha = senhaField.getText();
					
					nomeField.setText(" ");
					idField.setText(" ");
					senhaField.setText(" ");
					
					String text ="Seja Bem Vindo: " + nome + "\nID: " + id + "\n";
					
					fireDetailEvent(new DetailEvent(this, text));
				}
			}
		});
		
		exitBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					fireExitEvent(new ExitEvent(this));
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

		add(nomeLabel, gc);

		gc.gridx = 0;
		gc.gridy = 1;

		add(idLabel, gc);

		gc.gridx = 0;
		gc.gridy = 2;

		add(senhaLabel, gc);
		//// Second Column ////////////
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.gridx = 1;
		gc.gridy = 0;

		add(nomeField, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;

		add(idField, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;

		add(senhaField, gc);
		
		//// Third Row ////////////////
		gc.weighty = 10;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 3;
		
		add(addBtn, gc);
		
		//// Fourth Row ////////////////
		
		gc.weighty = 10;
		
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 4;
		
		add(exitBtn, gc);
	}
	
	//Methods for Error Events
	
	public void fireErrorEvent(ErrorEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == SellListener.class) {
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
	
	//Methods for Details Events
	
	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == DetailListener.class) {
				((DetailListener)listeners[i+1]).detailEventOccoured(event);
			}
		}
	}
	
	public void addDetailListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}
	
	public void removeDetailListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);
	}
	
	//Methods for Exit
	
	public void fireExitEvent(ExitEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == ExitListener.class) {
				((ExitListener)listeners[i+1]).exitEventOccoured(event);
			}
		}
	}
	
	public void addExitListener(ExitListener listener) {
		listenerList.add(ExitListener.class, listener);
	}
	
	public void removeExitListener(ExitListener listener) {
		listenerList.remove(ExitListener.class, listener);
	}
}