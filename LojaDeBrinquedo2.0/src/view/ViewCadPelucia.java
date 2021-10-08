package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleBrinquedo;
import controle.ControleFilial;
/**
 * Classe da tela de cadastro de pelucia 
 * @author renan
 *
 */
public class ViewCadPelucia extends ViewCadBrinquedo{

	private JLabel peso;
	private JTextField txPeso;
	
	private GridBagConstraints gbc;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	
	/**
	 * Metodo construtor, adiciona os campos especifico da classe 
	 */
	public ViewCadPelucia() {
		super();
		gbc = getGbc();
		gbc.gridx--;
		gbc.gridy++;
		peso = new JLabel("Peso:   ");
		
		getPanel().add(peso, gbc);
		
		gbc.gridx++;
		gbc.gridy = 8;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txPeso = new JTextField(50);
		getPanel().add(txPeso, gbc);
	}
	
	/**
	 * Metodo sobrescrito para definir seu efeito nessa tela
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
			controle.cadastrarPeluciaIndex(getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt() ,getTxComissaoVendedorDouble() ,getTxLucroDouble(),getTxCodigoInt(), getTxPesoDouble(), getFilialField().getSelectedIndex() );
			e=null;
			dispose();
			}
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	 public Double getTxPesoDouble() {
		 return Double.parseDouble(txPeso.getText());
	 }

	public JTextField getTxPeso() {
		return txPeso;
	}

	public void setTxPeso(JTextField txPeso) {
		this.txPeso = txPeso;
	}
	
}
