package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

public abstract class ViewCadPessoa extends JInternalFrame {
	
	static final int xPosition = 30, yPosition = 30;
	 private JButton botao = null;
	 private JPanel painel = null;
	 private JToolBar barra = null;
	 
	 private JTextField txNome = null;
	 private JTextField txTelefone = null;
	 private JTextField txEndereco = null;
	 private JLabel label;
	 
	 private  GridBagConstraints gbc;
	 
	 public ViewCadPessoa () {
		 super("Cadastrar", true, true, true, true);
		 setSize(800,200);
		 setLocation(xPosition, yPosition);
		 
		 //Adicionando a barra de botoes 
		 barra = new JToolBar();
		 botao = new JButton(new IconeJButton().getIconeCadastrar());
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
		 
		 //Adiconando os bot�es principais CONFIRMAR E CANCELAR
		 JPanel botoes = new JPanel();
		 botoes.setLayout(new GridLayout());
		 
		 JButton confirmar = new JButton("Confirmar");
		 confirmar.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					System.out.println(getTxTelefone());
				}
			});
		 JButton cancelar = new JButton("Cancelar");
		 cancelar.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					System.out.println(getTxTelefone());
				}
			});
		 botoes.add(confirmar);
		 botoes.add(cancelar);
		 add(botoes, BorderLayout.SOUTH);
		 add(painel, BorderLayout.NORTH);
	 }
	 
	 public String getTxNome() {
		 return txNome.getText();
	 }
	 
	 public int getTxTelefone() {
		 return Integer.parseInt(txTelefone.getText());
	 }
	 public String getTxEndereco() {
		 return txEndereco.getText();
	 }
	public JPanel getPanel() {
		return painel;
	}
	public  GridBagConstraints getGbc() {
		return gbc;
	}
}