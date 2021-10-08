package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleBrinquedo;
import main.Eletronico;
/**
 * Classe da tela de cadastro de Eletronico 
 * @author renan
 *
 */
public class ViewCadEletronico extends ViewCadBrinquedo{
	
	private JLabel fonteDeEnergia;
	private JTextField txFonteDeEnergia;
	
	private JLabel garantia;
	private JTextField txGarantia;
	
	private GridBagConstraints gbc;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	
	/**
	 * Metodo construtor da tela de eletronico, adiciona os campos especificos do objeto
	 */
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
		gbc.gridy = 8;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.EAST;
		
		txFonteDeEnergia = new JTextField(50);
		txGarantia = new JTextField(50);
		
		getPanel().add(txFonteDeEnergia, gbc);
		gbc.gridy++;
		getPanel().add(txGarantia, gbc);
		
	}
	
	/**
	 * Metodo sobrescrito para definir seu efeito nessa tela
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
			controle.cadastrarEletronicoIndex(getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt() ,getTxComissaoVendedorDouble() ,getTxLucroDouble(),getTxCodigoInt(), getTxFonteDeEnergiaString(), getTxGarantiaInt(), getFilialField().getSelectedIndex() );
			e=null;
			dispose();
			}
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public String getTxFonteDeEnergiaString() {
		return txFonteDeEnergia.getText();
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public int getTxGarantiaInt() {
		return Integer.parseInt(txGarantia.getText());
	}
	
	public JLabel getFonteDeEnergia() {
		return fonteDeEnergia;
	}
	public void setFonteDeEnergia(JLabel fonteDeEnergia) {
		this.fonteDeEnergia = fonteDeEnergia;
	}
	public JTextField getTxFonteDeEnergia() {
		return txFonteDeEnergia;
	}
	public void setTxFonteDeEnergia(JTextField txFonteDeEnergia) {
		this.txFonteDeEnergia = txFonteDeEnergia;
	}
	public JLabel getGarantia() {
		return garantia;
	}
	public void setGarantia(JLabel garantia) {
		this.garantia = garantia;
	}
	public JTextField getTxGarantia() {
		return txGarantia;
	}
	public void setTxGarantia(JTextField txGarantia) {
		this.txGarantia = txGarantia;
	}
	
	
}
