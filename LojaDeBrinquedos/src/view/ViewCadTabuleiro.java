package view;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCadTabuleiro extends ViewCadBrinquedo{
	
	private JLabel qtdJogadores;
	private JLabel tempoMedio;
	
	private JTextField txQtdJogadores;
	private JTextField txTempoMedio;
	
	private GridBagConstraints gbc;
	
	public ViewCadTabuleiro () {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		qtdJogadores = new JLabel("Quant. de Jogadores:   ");
		tempoMedio = new JLabel("Tempo Medio:   ");
		
		getPanel().add(qtdJogadores, gbc);
		gbc.gridy++;
		getPanel().add(tempoMedio, gbc);
		
		gbc.gridx++;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txQtdJogadores = new JTextField(50);
		txTempoMedio = new JTextField(50);
		
		getPanel().add(txQtdJogadores, gbc);
		gbc.gridy++;
		getPanel().add(txTempoMedio, gbc);
	}
	
	public int getTxQtdJogadores () {
		return Integer.parseInt(txQtdJogadores.getText());
	}
	
	public double getTxTempoMedio() {
		return Double.parseDouble(txTempoMedio.getText());
	}
}
