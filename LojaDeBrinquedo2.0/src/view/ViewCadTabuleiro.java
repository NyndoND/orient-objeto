package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleBrinquedo;

/**
 * Classe da view cadastro de jogo de tabuleiro 
 * @author renan
 *
 */
public class ViewCadTabuleiro extends ViewCadBrinquedo{
	
	private JLabel qtdJogadores;
	private JLabel tempoMedio;
	
	private JTextField txQtdJogadores;
	private JTextField txTempoMedio;
	
	private GridBagConstraints gbc;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	
	/**
	 * Metodo construtor da tela com os cmapos especificos do objeto 
	 */
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
		gbc.gridy = 8;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txQtdJogadores = new JTextField(50);
		txTempoMedio = new JTextField(50);
		
		getPanel().add(txQtdJogadores, gbc);
		gbc.gridy++;
		getPanel().add(txTempoMedio, gbc);
	}
	/**
	 * Metodo sobrescrito para definir seu efeito nessa tela
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
			controle.cadastrarTabuleiroIndex(getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt() ,getTxComissaoVendedorDouble() ,getTxLucroDouble(),getTxCodigoInt(), getTxQtdJogadoresInt (), getTxTempoMedioDouble(), getFilialField().getSelectedIndex() );
			e=null;
			dispose();
			}
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public int getTxQtdJogadoresInt () {
		return Integer.parseInt(txQtdJogadores.getText());
	}
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public Double getTxTempoMedioDouble() {
		return Double.parseDouble(txTempoMedio.getText());
	}

	public JTextField getTxQtdJogadores() {
		return txQtdJogadores;
	}

	public void setTxQtdJogadores(JTextField txQtdJogadores) {
		this.txQtdJogadores = txQtdJogadores;
	}

	public JTextField getTxTempoMedio() {
		return txTempoMedio;
	}

	public void setTxTempoMedio(JTextField txTempoMedio) {
		this.txTempoMedio = txTempoMedio;
	}
	
	
}
