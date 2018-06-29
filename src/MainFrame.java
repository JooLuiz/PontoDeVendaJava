import java.awt.BorderLayout;
import java.awt.Container;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame
{
	private DetailsPanel detailsPanel;
	private MenuPanel menuPanel;
	private ClientesPanel clientesPanel;
	private ClientesList clientesList;
	private ProdutosList produtosList;
	private SellsPanel sellsPanel;
	private SangriaPanel sangriaPanel;
	private PaymentsPanel paymentsPanel;
	private AcessoBanco banco;
	
	public MainFrame(){
		super();
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
		
		banco = new BancoTeste();
		
		// Set layout manager
		setLayout(new BorderLayout());


		// Create Swing component
		JTextArea textArea = new JTextArea();
		detailsPanel = new DetailsPanel();
		menuPanel = new MenuPanel();
		clientesPanel = new ClientesPanel();
		clientesList = new ClientesList(banco);
		produtosList = new ProdutosList(banco);
		sellsPanel = new SellsPanel();
		sangriaPanel = new SangriaPanel();
		paymentsPanel = new PaymentsPanel();
		
		// Add Swing components to content pane
		Container c = getContentPane();

		c.add(textArea, BorderLayout.CENTER);
		c.add(detailsPanel, BorderLayout.WEST);
		
		
		//Adding the Details Panel Action Listeners
		
		detailsPanel.addErrorListener(new ErrorListener() {
			public void errorEventOccoured(ErrorEvent event) {
				String text = event.getText();
				this.showText(text);
			}

			private void showText(String text) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
				textArea.append(text);
			}
		});
		

		detailsPanel.addDetailListener(new DetailListener() {
			public void detailEventOccoured(DetailEvent event) {
				String text = event.getText();
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}

			private void showText(String text) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
				textArea.append(text);
			}

			private void removePanel() {
				c.remove(detailsPanel);
				textArea.append("\n");
			}
			
			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}
		});
		
		//Adding the Menu Panel Action Listeners
		
		menuPanel.addCloseBoxListener(new CloseBoxListener() {
			public void closeBoxEventOccoured(CloseBoxEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}

			private void addPanel() {
				c.add(detailsPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(menuPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		menuPanel.addSangriaListener(new SangriaListener() {
			public void sangriaEventOccoured(SangriaEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}

			private void addPanel() {
				c.add(sangriaPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(menuPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		menuPanel.addNewListener(new NewListener() {
			public void newEventOccoured(NewEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}

			private void addPanel() {
				c.add(clientesPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(menuPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		//ClientesPanel Listeners
		
		clientesPanel.addClienteListener(new ClienteListener() {
			public void clienteEventOccoured(ClienteEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}
			
			private void addPanel() {
				c.add(clientesList, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(clientesPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		clientesPanel.addCancelaListener(new CancelaListener() {
			public void cancelaEventOccoured(CancelaEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}
			
			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(clientesPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		//ClientList Listeners
		
		clientesList.addConfirmaClienteListener(new ConfirmaClienteListener() {
			public void confirmaClienteEventOccoured(ConfirmaClienteEvent event) {
				Cliente cliente = (Cliente) event.getCliente();
				
				this.removePanel();
				this.addText(cliente);
				this.addPanel();
			}
			
			private void addText(Cliente c) {
				String cod = c.getCodigo();
				String name = c.getName();
				
				textArea.append("\n");
				textArea.append("\nCliente de nome:" + name + "\nCodigo:" + cod + "\n\n");
				
			}

			private void addPanel() {
				c.add(sellsPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(clientesList);
				textArea.append("\n");
			}
		});
		
		clientesList.addCancelaClienteListener(new CancelaClienteListener() {
			public void cancelaClienteEventOccoured(CancelaClienteEvent event) {
				this.removePanel();
				this.addText();
				this.addPanel();
			}
			
			private void addText() {
				textArea.append("\n");
			}

			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(clientesList);
				textArea.append("\n");
			}
		});
		
		//SellsPanel Listeners
		
		sellsPanel.addSellListener(new SellListener() {
			public void sellEventOccoured(SellEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}
			
			private void addPanel() {
				c.add(produtosList, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(sellsPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		sellsPanel.addCancelaListener(new CancelaListener() {
			public void cancelaEventOccoured(CancelaEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}
			
			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(sellsPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		
		//ClientList Listeners
		
				produtosList.addConfirmaProdutoListener(new ConfirmaProdutoListener() {
					public void confirmaProdutoEventOccoured(ConfirmaProdutoEvent event) {
						Produto product = (Produto) event.getProduto();
						
						//this.removePanel();
						this.addText(product);
						//this.addPanel();
					}
					
					private void addText(Produto c) {
						String cod = c.getCodigo();
						String name = c.getNome();
						double preco = c.getPreco();
						
						textArea.append("\n");
						textArea.append("\nProduto de nome:" + name + "\nCodigo:" + cod + "\nValor:" + preco + "\n\n");
						
					}

					private void addPanel() {
						c.add(sellsPanel, BorderLayout.WEST);
						textArea.append("\n");
					}

					private void removePanel() {
						c.remove(produtosList);
						textArea.append("\n");
					}
				});
				
				produtosList.addCancelaProdutoListener(new CancelaProdutoListener() {
					public void cancelaProdutoEventOccoured(CancelaProdutoEvent event) {
						this.removePanel();
						this.addText();
						this.addPanel();
					}
					
					private void addText() {
						textArea.append("\n");
						textArea.append("Venda Fechada");
					}

					private void removePanel() {
						c.remove(produtosList);
						textArea.append("\n");
					}
					
					private void addPanel() {
						c.add(paymentsPanel, BorderLayout.WEST);
						textArea.append("\n");
					}
				});
				
		//PaymentPanel Listeners
		
		paymentsPanel.addBoletoListener(new BoletoListener() {
			public void boletoEventOccoured(BoletoEvent event) {
				this.removePanel();
				this.showText();
				this.addPanel();
			}

			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(paymentsPanel);
				textArea.append("\n");
			}

			private void showText() {
				textArea.append("\n");
				JOptionPane.showMessageDialog(null, "Pagamento Via Boleto realizado com sucesso");
				textArea.selectAll();
				textArea.replaceSelection("");
			}
		});
		
		paymentsPanel.addCreditCardListener(new CreditCardListener() {
			public void creditCardEventOccoured(CreditCardEvent event) {
				this.removePanel();
				this.showText();
				this.addPanel();
			}

			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(paymentsPanel);
				textArea.append("\n");
			}

			private void showText() {
				textArea.append("\n");
				JOptionPane.showMessageDialog(null, "Pagamento Via Cartao de Credito realizado com sucesso");
				textArea.selectAll();
				textArea.replaceSelection("");
			}
		});
		
		paymentsPanel.addMoneyListener(new MoneyListener() {
			public void moneyEventOccoured(MoneyEvent event) {
				this.removePanel();
				this.showText();
				this.addPanel();
			}

			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(paymentsPanel);
				textArea.append("\n");
			}

			private void showText() {
				textArea.append("\n");
				JOptionPane.showMessageDialog(null, "Pagamento Via Dinheiro realizado com sucesso");
				textArea.selectAll();
				textArea.replaceSelection("");
			}
		});
		
		//SangriaPanel Listeners
		
		sangriaPanel.addErrorListener(new ErrorListener() {
			public void errorEventOccoured(ErrorEvent event) {
				String text = event.getText();
				this.showText(text);
			}

			private void showText(String text) {
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
				textArea.append(text);
			}
		});
		
		sangriaPanel.addRegistraSangriaListener(new RegistraSangriaListener() {
			public void registraSangriaEventOccoured(RegistraSangriaEvent event) {
				String text = event.getText();
				
				this.removePanel();
				this.showText(text);
				this.addPanel();
			}

			private void addPanel() {
				c.add(menuPanel, BorderLayout.WEST);
				textArea.append("\n");
			}

			private void removePanel() {
				c.remove(sangriaPanel);
				textArea.append("\n");
			}

			private void showText(String text) {
				JOptionPane.showMessageDialog(null, text);
				textArea.selectAll();
				textArea.replaceSelection("");
				textArea.append("\n");
			}
		});
		
		

	}
}