package view;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleBrinquedo;
import controle.ControleFilial;

public class ViewCadPelucia extends ViewCadBrinquedo{

	private JLabel peso;
	private JTextField txPeso;
	
	private GridBagConstraints gbc;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
			controle.cadastrarPeluciaIndex(getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt() ,getTxComissaoVendedorDouble() ,getTxLucroDouble(),getTxCodigoInt(), getTxPesoDouble(), getFilialField().getSelectedIndex() );
			e=null;
			dispose();
			}
	}
	
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
