package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleBrinquedo;
import main.Eletronico;

public class ViewCadEletronico extends ViewCadBrinquedo{
	
	private JLabel fonteDeEnergia;
	private JTextField txFonteDeEnergia;
	
	private JLabel garantia;
	private JTextField txGarantia;
	
	private GridBagConstraints gbc;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
			controle.cadastrarEletronicoIndex(getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt() ,getTxComissaoVendedorDouble() ,getTxLucroDouble(),getTxCodigoInt(), getTxFonteDeEnergiaString(), getTxGarantiaInt(), getFilialField().getSelectedIndex() );
			e=null;
			dispose();
			}
	}
	
	public String getTxFonteDeEnergiaString() {
		return txFonteDeEnergia.getText();
	}
	
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
