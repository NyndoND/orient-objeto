package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleFilial;
import controle.ControleVendedor;
import main.Filial;
/**
 * Classe da tela de cadastro de vendedor
 * @author renan
 *
 */
public class ViewCadVendedor extends ViewCadPessoa{

	private JLabel cpf;
	private JTextField txCpf;
	
	private JLabel dataContratacao;
	private JTextField txDataContratacao;
	
	private JLabel salario;
	private JTextField txSalario;
	
	private JLabel filial;
	private JComboBox<Object> filialField;
	
	private GridBagConstraints gbc;
	
	private ControleVendedor controle = new ControleVendedor();
	private ControleFilial controleFil = new ControleFilial();
	
	/**
	 * Metodo construtor da tela de cadastro de vendedor com os campos especificos de vendedor 
	 */
	public ViewCadVendedor() {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		cpf = new JLabel("CPF:   ");
		dataContratacao = new JLabel("Data de Contrato:   ");
		salario = new JLabel("Salario:   ");
		filial = new JLabel("Filial:    ");
		
		
		getPanel().add(cpf, gbc);
		gbc.gridy++;
		getPanel().add(dataContratacao, gbc);
		gbc.gridy++;
		getPanel().add(salario, gbc);
		gbc.gridy++;
		getPanel().add(filial, gbc);
		
		gbc.gridx++;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txCpf = new JTextField(50);
		txDataContratacao = new JTextField(50);
		txSalario = new JTextField(50);
		filialField = new JComboBox<Object>();
		filialField.setModel(filialComboBox());
		
		getPanel().add(txCpf, gbc);
		gbc.gridy++;
		getPanel().add(txDataContratacao, gbc);
		gbc.gridy++;
		getPanel().add(txSalario, gbc);
		gbc.gridy++;
		getPanel().add(filialField, gbc);
		
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public int getTxCpfInt() {
		return Integer.parseInt(txCpf.getText());
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public Date getTxDataDate() {
		String data = txDataContratacao.getText();
		Date dataFormat = null;
		try {
			dataFormat = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormat;
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public Double getTxSalarioDouble() {
		Double salario = Double.parseDouble(txSalario.getText());
		return salario;
	}
	
	/**
	 * Metodo sobrescrito para definir seu efeito nessa tela
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.cadastrarVendedor(getTxNomeString(), getTxTelefoneInt(), getTxEnderecoString(),getTxCpfInt(),getTxDataDate(),getTxSalarioDouble(),getFilialField().getSelectedIndex() );
		e=null;
		dispose();
		}
	}
	
	public DefaultComboBoxModel<Object> filialComboBox(){
		return new DefaultComboBoxModel<>(filialArray());
	}
	
	/**
	 * Transforma um ArrayList em Array apenas com o local de cada Filial
	 * @return
	 */
	public Object[] filialArray() {
		return controleFil.toArrayFilialLocal();
	}

	public JTextField getTxCpf() {
		return txCpf;
	}

	public void setTxCpf(JTextField txCpf) {
		this.txCpf = txCpf;
	}

	public JTextField getTxSalario() {
		return txSalario;
	}

	public void setTxSalario(JTextField txSalario) {
		this.txSalario = txSalario;
	}

	public JTextField getTxDataContratacao() {
		return txDataContratacao;
	}

	public void setTxDataContratacao(JTextField txDataContratacao) {
		this.txDataContratacao = txDataContratacao;
	}

	public JComboBox<Object> getFilialField() {
		return filialField;
	}

	public void setFilialField(JComboBox<Object> filialField) {
		this.filialField = filialField;
	}

	
	
	
	
}
