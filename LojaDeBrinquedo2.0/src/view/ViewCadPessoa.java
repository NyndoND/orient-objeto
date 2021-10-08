package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;


/**
 * Classe de cadastro de pessoa essa tela é a base para cadastro de cliente e de vendedor 
 * @author renan
 *
 */
public abstract class ViewCadPessoa extends JInternalFrame implements ActionListener{
	
	static final int xPosition = 30, yPosition = 30;
	 private JButton botao = null;
	 private JPanel painel = null;
	 private JToolBar barra = null;
	 
	 private JTextField txNome = null;
	 private JTextField txTelefone = null;
	 private JTextField txEndereco = null;
	 private JLabel label;
	 
	 private  GridBagConstraints gbc;
	 private JButton confirmar;
	 
	 /**
	  * Metodo construtor que coloca os campos que são comuns entra vendedor e cliente 
	  */
	 public ViewCadPessoa () {
		 super("Cadastrar", true, true, true, true);
		 setSize(800,200);
		 setLocation(xPosition, yPosition);
		 
		 //Adicionando a barra de botoes 
		 barra = new JToolBar();
		 botao = new JButton(new IconeJButton().getIconeFiltrar());
		 botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("cadastrar chama nenem");
			}
		 });
		 barra.add(botao);
		 botao = null;
		 add(barra, BorderLayout.NORTH);
		 
		 //adicionando os campos para preencher
		 painel = new JPanel();
		 painel.setLayout(new GridBagLayout());
		 painel.setLocation(xPosition, yPosition);
		 gbc = new GridBagConstraints();
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.anchor = GridBagConstraints.WEST;
		 
		 label = new JLabel("Nome: ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Telefone: ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel ("Endereco:        ");
		 painel.add(label, gbc);
		 
		 gbc.gridy = 0;
		 gbc.gridx++ ;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.EAST;
		 txNome = new JTextField(50);
		 painel.add(txNome, gbc);
		 gbc.gridy++;
		 txTelefone = new JTextField(50);
		 painel.add(txTelefone, gbc);
		 gbc.gridy++;
		 txEndereco = new JTextField(50);
		 painel.add(txEndereco, gbc);
		 
		 //Adiconando os botões principais CONFIRMAR E CANCELAR
		 JPanel botoes = new JPanel();
		 botoes.setLayout(new GridLayout());
		 
		 confirmar = new JButton("Confirmar");
		 confirmar.addActionListener(this);
				
		 JButton cancelar = new JButton("Cancelar");
		 cancelar.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		 botoes.add(confirmar);
		 botoes.add(cancelar);
		 add(botoes, BorderLayout.SOUTH);
		 add(painel, BorderLayout.NORTH);
	 }
	 
	 /**
	  * Retorna o que foi digitado pelo usuario no campo
	  * @return
	  */
	 public String getTxNomeString() {
		 return txNome.getText();
	 }
	 
	 /**
	  * Retorna o que foi digitado pelo usuario no campo
	  * @return
	  */
	 public int getTxTelefoneInt() {
		 return Integer.parseInt(txTelefone.getText());
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario no campo
	  * @return
	  */
	 public String getTxEnderecoString() {
		 return txEndereco.getText();
	 }
	 
	public JPanel getPanel() {
		return painel;
	}
	public  GridBagConstraints getGbc() {
		return gbc;
	}
	public JButton getConfirmar() {
		return confirmar;
	}

	public JTextField getTxNome() {
		return txNome;
	}

	public JTextField getTxTelefone() {
		return txTelefone;
	}

	public JTextField getTxEndereco() {
		return txEndereco;
	}

	public void setTxNome(JTextField txNome) {
		this.txNome = txNome;
	}

	public void setTxTelefone(JTextField txTelefone) {
		this.txTelefone = txTelefone;
	}

	public void setTxEndereco(JTextField txEndereco) {
		this.txEndereco = txEndereco;
	}
	
	
}
