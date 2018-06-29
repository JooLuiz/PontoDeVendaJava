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

public class PaymentsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public PaymentsPanel() {
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Pagamento"));
		
		JButton boletoBtn = new JButton("Pagar Boleto");
		JButton creditCardBtn = new JButton("Pagar Cartao de Credito");
		JButton moneyBtn = new JButton("Pagar Dinheiro");
		
		boletoBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				fireBoletoEvent(new BoletoEvent(this));
			}
		});
		
		creditCardBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				fireCreditCardEvent(new CreditCardEvent(this));
			}
		});
		
		moneyBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				fireMoneyEvent(new MoneyEvent(this));
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

		add(boletoBtn, gc);

		gc.gridx = 0;
		gc.gridy = 1;

		add(creditCardBtn, gc);

		gc.gridx = 0;
		gc.gridy = 2;

		add(moneyBtn, gc);		
	}
	
	public void fireBoletoEvent(BoletoEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == BoletoListener.class) {
				((BoletoListener)listeners[i+1]).boletoEventOccoured(event);
			}
		}
	}
	
	public void addBoletoListener(BoletoListener listener) {
		listenerList.add(BoletoListener.class, listener);
	}
	
	public void removeBoletoListener(BoletoListener listener) {
		listenerList.remove(BoletoListener.class, listener);
	}
	
	public void fireCreditCardEvent(CreditCardEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == CreditCardListener.class) {
				((CreditCardListener)listeners[i+1]).creditCardEventOccoured(event);
			}
		}
	}
	
	public void addCreditCardListener(CreditCardListener listener) {
		listenerList.add(CreditCardListener.class, listener);
	}
	
	public void removeCreditCardListener(CreditCardListener listener) {
		listenerList.remove(CreditCardListener.class, listener);
	}
	
	public void fireMoneyEvent(MoneyEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for(int i=0; i < listeners.length; i+=2) {
			if(listeners[i] == MoneyListener.class) {
				((MoneyListener)listeners[i+1]).moneyEventOccoured(event);
			}
		}
	}
	
	public void addMoneyListener(MoneyListener listener) {
		listenerList.add(MoneyListener.class, listener);
	}
	
	public void removeMoneyListener(MoneyListener listener) {
		listenerList.remove(MoneyListener.class, listener);
	}
	
}
