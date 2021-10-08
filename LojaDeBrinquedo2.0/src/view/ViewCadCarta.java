package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleBrinquedo;
/**
 * Classe da tela cadastro de jogo de carta 
 * @author renan
 *
 */
public class ViewCadCarta extends ViewCadBrinquedo{
	
	private JLabel qtdCartas;
	private JLabel qtdJogadores;
	
	private JTextField txQtdCartas;
	private JTextField txQtdJogadores;
	
	private GridBagConstraints gbc;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	/**
	 * Metodo contrutor da tela de cadastro 
	 */
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
		gbc.gridy = 8;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txQtdCartas = new JTextField(50);
		txQtdJogadores = new JTextField(50);
		
		getPanel().add(txQtdCartas, gbc);
		gbc.gridy++;
		getPanel().add(txQtdJogadores, gbc);
	}
	/**
	 * Metodo sobrescrito para definir seu efeito nessa tela 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
			controle.cadastrarCartaIndex(getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt() ,getTxComissaoVendedorDouble() ,getTxLucroDouble(),getTxCodigoInt(), getTxQtdCartasInt(), getTxQtdJogadoresInt(), getFilialField().getSelectedIndex() );
			e=null;
			dispose();
			}
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public int getTxQtdCartasInt() {
		return Integer.parseInt(txQtdCartas.getText());
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public int getTxQtdJogadoresInt() {
		return Integer.parseInt(txQtdJogadores.getText());
	}

	public JTextField getTxQtdCartas() {
		return txQtdCartas;
	}

	public void setTxQtdCartas(JTextField txQtdCartas) {
		this.txQtdCartas = txQtdCartas;
	}

	public JTextField getTxQtdJogadores() {
		return txQtdJogadores;
	}

	public void setTxQtdJogadores(JTextField txQtdJogadores) {
		this.txQtdJogadores = txQtdJogadores;
	}
	
	

	
	
}
