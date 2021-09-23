package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public abstract class ViewCadBrinquedo extends JInternalFrame{
	
	static final int xPosition = 30, yPosition = 30;
	 private JButton botao = null;
	 private JPanel painel = null;
	 private JToolBar barra = null;
	 
	 private JTextField txNome = null;
	 private JTextField txValor = null;
	 private JTextField txDescricao = null;
	 private JTextField txFaixaEtaria = null;
	 private JTextField txComissaoVendedor = null;
	 private JTextField txLucro = null;
	 private JTextField txCodigo = null;
	 private JLabel label;
	 
	 private  GridBagConstraints gbc;
	 
	 public ViewCadBrinquedo (){
		 super("Cadastrar", true, true, true, true);
		 setSize(800,250);
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
		 
		 label = new JLabel("Nome:  ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Valor:  ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Descricao:  ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Faixa Etaria:  ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Comissao Vendedor:  ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Lucro:  ");
		 painel.add(label, gbc);
		 gbc.gridy++;
		 label = new JLabel("Codigo:  ");
		 painel.add(label, gbc);
		 gbc.gridy = 0;
		 
		 gbc.gridx++;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.anchor = GridBagConstraints.EAST;
		 
		 txNome = new JTextField(50);
		 painel.add(txNome, gbc);
		 
		 gbc.gridy++;
		 txValor = new JTextField(50);
		 painel.add(txValor, gbc);
		 
		 gbc.gridy++;
		 txDescricao = new JTextField(50);
		 painel.add(txDescricao, gbc);
		 
		 gbc.gridy++;
		 txFaixaEtaria = new JTextField(50);
		 painel.add(txFaixaEtaria, gbc);
		 
		 gbc.gridy++;
		 txComissaoVendedor = new JTextField(50);
		 painel.add(txComissaoVendedor, gbc);
		 
		 gbc.gridy++;
		 txLucro = new JTextField(50);
		 painel.add(txLucro, gbc);
		 
		 gbc.gridy++;
		 txCodigo = new JTextField(50);
		 painel.add(txCodigo, gbc);
		 
		//Adiconando os botões principais CONFIRMAR E CANCELAR
		 JPanel botoes = new JPanel();
		 botoes.setLayout(new GridLayout());
		 
		 JButton confirmar = new JButton("Confirmar");
		 confirmar.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					System.out.println(getTxDescricao());
				}
			});
		 JButton cancelar = new JButton("Cancelar");
		 cancelar.addActionListener(new ActionListener() {			
				public void actionPerformed(ActionEvent e) {
					System.out.println(getTxComissaoVendedor());
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
	 
	 public Double getTxValor() {
		 return Double.parseDouble(txValor.getText());
	 }
	 
	 public String getTxDescricao() {
		 return txDescricao.getText();
	 }
	 
	 public int getTxFaixaEtaria () {
		 return Integer.parseInt(txFaixaEtaria.getText());
	 }
	 
	 public Double getTxComissaoVendedor() {
		 return Double.parseDouble(txComissaoVendedor.getText());
	 }
	 
	 public Double getTxLucro() {
		 return Double.parseDouble(txLucro.getText());
	 }
	 
	 public int getTxCodigo() {
		 return Integer.parseInt(txCodigo.getText());
	 }
	 
	 public JPanel getPanel() {
			return painel;
		}
	 
	 public  GridBagConstraints getGbc() {
			return gbc;
		}
	 
}
