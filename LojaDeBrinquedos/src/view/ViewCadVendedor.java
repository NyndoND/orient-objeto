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


import controle.ControleVendedor;
import main.Filial;

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
	
	public int getTxCpf() {
		return Integer.parseInt(txCpf.getText());
	}
	
	public Date getTxData() {
		String data = txDataContratacao.getText();
		Date dataFormat = null;
		try {
			dataFormat = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dataFormat;
	}
	
	public Double getTxSalario() {
		Double salario = Double.parseDouble(txSalario.getText());
		return salario;
	}
	
	public Filial getFilial() {
		int i=0;
		int IndFi = 0;
		for (Filial fi : Filial.getListaFilial()) {
			 if (fi.getLocal().equals(filialField.getSelectedItem())) {
				 IndFi = i;
			 } else {
				 i++;
			 }
		}
		Filial filial = Filial.getListaFilial().get(IndFi);
		i=0;
		return filial;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.cadastrarVendedor(getTxNome(), getTxTelefone(), getTxEndereco(),getTxCpf(),getTxData(),getTxSalario(),getFilial() );
		dispose();
		e=null;
		}
	}
	
	public DefaultComboBoxModel<Object> filialComboBox(){
		return new DefaultComboBoxModel<>(filialArray());
	}
	
	public Object[] filialArray() {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Filial f : Filial.getListaFilial()) {
			nomes.add(f.getLocal());
		}
		return nomes.toArray();
	}
	
}
