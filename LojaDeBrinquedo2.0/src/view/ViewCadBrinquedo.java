package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controle.ControleFilial;
/**
 * Classe que cria a base da tela para cadastro de brinquedos 
 * @author renan
 *
 */
public abstract class ViewCadBrinquedo extends JInternalFrame implements ActionListener{
	
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
	 
	private JComboBox<Object> filialField;
	 
	 private  GridBagConstraints gbc;
	 private JButton confirmar;
	 
	 private ControleFilial controleFil = new ControleFilial();
	 
	 /**
	  * Metodo construtor que usa todos os atributos da classe 
	  */
	 public ViewCadBrinquedo (){
		 super("Cadastrar", true, true, true, true);
		 setSize(800,300);
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
		 
		 //Essa barra de butoes está atrás da caixa de texto, pois no final eu coloco
		 // que todos os textos vao ficar na posição NORTH tbm, futuramente eu posso 
		 // arrumar isso, mas por enquanto eu não achei esa barra muito útil
		 add(barra, BorderLayout.NORTH);
		 //
		 
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
		 gbc.gridy++;
		 label = new JLabel("Filial:  ");
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
		 
		 gbc.gridy++;
		 filialField = new JComboBox<Object>();
		 filialField.setModel(filialComboBox());
		 painel.add(filialField, gbc);
		 
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
	  * Cria um comboBoxModel usando um Array que é fornecido por filialArray()
	  * @return
	  */
	 public DefaultComboBoxModel<Object> filialComboBox(){
			return new DefaultComboBoxModel<>(filialArray());
		}
	 /**
	  * executa o metodo "toArrayFilialLocal()" da ControleFilial 
	  * @return
	  */
	 public Object[] filialArray() {
			return controleFil.toArrayFilialLocal();
		}
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public String getTxNomeString() {
		 return txNome.getText();
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public Double getTxValorDouble() {
		 return Double.parseDouble(txValor.getText());
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public String getTxDescricaoString() {
		 return txDescricao.getText();
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public int getTxFaixaEtariaInt () {
		 return Integer.parseInt(txFaixaEtaria.getText());
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public Double getTxComissaoVendedorDouble() {
		 return Double.parseDouble(txComissaoVendedor.getText());
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public Double getTxLucroDouble() {
		 return Double.parseDouble(txLucro.getText());
	 }
	 /**
	  * Retorna o que foi digitado pelo usuario 
	  * @return
	  */
	 public int getTxCodigoInt() {
		 return Integer.parseInt(txCodigo.getText());
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

	public void setTxNome(JTextField txNome) {
		this.txNome = txNome;
	}

	public JTextField getTxValor() {
		return txValor;
	}

	public void setTxValor(JTextField txValor) {
		this.txValor = txValor;
	}

	public JTextField getTxDescricao() {
		return txDescricao;
	}

	public void setTxDescricao(JTextField txDescricao) {
		this.txDescricao = txDescricao;
	}

	public JTextField getTxFaixaEtaria() {
		return txFaixaEtaria;
	}

	public void setTxFaixaEtaria(JTextField txFaixaEtaria) {
		this.txFaixaEtaria = txFaixaEtaria;
	}

	public JTextField getTxComissaoVendedor() {
		return txComissaoVendedor;
	}

	public void setTxComissaoVendedor(JTextField txComissaoVendedor) {
		this.txComissaoVendedor = txComissaoVendedor;
	}

	public JTextField getTxLucro() {
		return txLucro;
	}

	public void setTxLucro(JTextField txLucro) {
		this.txLucro = txLucro;
	}

	public JTextField getTxCodigo() {
		return txCodigo;
	}

	public void setTxCodigo(JTextField txCodigo) {
		this.txCodigo = txCodigo;
	}

	public JComboBox<Object> getFilialField() {
		return filialField;
	}

	public void setFilialField(JComboBox<Object> filialField) {
		this.filialField = filialField;
	}
	 
	 
}
