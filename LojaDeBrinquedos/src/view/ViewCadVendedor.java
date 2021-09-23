package view;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCadVendedor extends ViewCadPessoa{

	private JLabel cpf;
	private JTextField txCpf;
	
	private JLabel dataContratacao;
	private JTextField txDataContratacao;
	
	private JLabel salario;
	private JTextField txSalario;
	
	private GridBagConstraints gbc;
	
	public ViewCadVendedor() {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		cpf = new JLabel("CPF:   ");
		dataContratacao = new JLabel("Data de Contrato:   ");
		salario = new JLabel("Salario:   ");
		
		getPanel().add(cpf, gbc);
		gbc.gridy++;
		getPanel().add(dataContratacao, gbc);
		gbc.gridy++;
		getPanel().add(salario, gbc);
		
		gbc.gridx++;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txCpf = new JTextField(50);
		txDataContratacao = new JTextField(50);
		txSalario = new JTextField(50);
		
		getPanel().add(txCpf, gbc);
		gbc.gridy++;
		getPanel().add(txDataContratacao, gbc);
		gbc.gridy++;
		getPanel().add(txSalario, gbc);
		
	}
	
	
}
