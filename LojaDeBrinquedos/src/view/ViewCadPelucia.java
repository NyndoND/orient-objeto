package view;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCadPelucia extends ViewCadBrinquedo{

	private JLabel peso;
	private JTextField txPeso;
	
	private GridBagConstraints gbc;
	
	public ViewCadPelucia() {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		peso = new JLabel("Peso:   ");
		
		getPanel().add(peso, gbc);
		
		gbc.gridx++;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txPeso = new JTextField(50);
		getPanel().add(txPeso, gbc);
	}
	 public Double getTxPeso() {
		 return Double.parseDouble(txPeso.getText());
	 }
	
}
