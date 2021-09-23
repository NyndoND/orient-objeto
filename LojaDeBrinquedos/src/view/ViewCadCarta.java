package view;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCadCarta extends ViewCadBrinquedo{
	
	private JLabel qtdCartas;
	private JLabel qtdJogadores;
	
	private JTextField txQtdCartas;
	private JTextField txQtdJogadores;
	
	private GridBagConstraints gbc;
	
	public ViewCadCarta() {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		qtdCartas = new JLabel("Quant. de Cartas:   ");
		qtdJogadores = new JLabel("Quant. de Jogadores:   ");
		
		getPanel().add(qtdCartas, gbc);
		gbc.gridy++;
		getPanel().add(qtdJogadores, gbc);
		
		gbc.gridx++;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txQtdCartas = new JTextField(50);
		txQtdJogadores = new JTextField(50);
		
		getPanel().add(txQtdCartas, gbc);
		gbc.gridy++;
		getPanel().add(txQtdJogadores, gbc);
	}
	
	public int getTxQtdCartas() {
		return Integer.parseInt(txQtdCartas.getText());
	}
	
	public int getTxQtdJogadores() {
		return Integer.parseInt(txQtdJogadores.getText());
	}
	
}
