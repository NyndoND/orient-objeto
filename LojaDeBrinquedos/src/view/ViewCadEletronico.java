package view;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCadEletronico extends ViewCadBrinquedo{
	
	private JLabel fonteDeEnergia;
	private JTextField txFonteDeEnergia;
	
	private JLabel garantia;
	private JTextField txGarantia;
	
	private GridBagConstraints gbc;
	
	public ViewCadEletronico () {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		fonteDeEnergia = new JLabel("Fonte de Energia:   ");
		garantia = new JLabel("Garantia:   ");
		
		getPanel().add(fonteDeEnergia, gbc);
		gbc.gridy++;
		getPanel().add(garantia, gbc);
		
		gbc.gridx++;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txFonteDeEnergia = new JTextField(50);
		txGarantia = new JTextField(50);
		
		getPanel().add(txFonteDeEnergia, gbc);
		gbc.gridy++;
		getPanel().add(txGarantia, gbc);
		
	}
	
	public String getTxFonteDeEnergia() {
		return txFonteDeEnergia.getText();
	}
	
	public int getTxGarantia() {
		return Integer.parseInt(txGarantia.getText());
	}
}
