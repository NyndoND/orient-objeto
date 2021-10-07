package view;

import java.awt.event.ActionEvent;

import controle.ControleBrinquedo;
import main.Brinquedo;
import main.Eletronico;
import main.Filial;

public class ViewAlterarEletronico extends ViewCadEletronico{
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	int indexBrin = 0;
	int indexFilial=0;
	
	public ViewAlterarEletronico(int index, Eletronico e) {
		setTitle("Alterar");
		
		indexBrin = controle.getBrinquedoListaEstoqueIndex(index);
		indexFilial = controle.getBrinquedoListaFilialIndex(index);
		
		getTxNome().setText(controle.getBrinquedoNome(indexFilial, indexBrin));
		getTxValor().setText(controle.getBrinquedoValor(indexFilial, indexBrin).toString());
		getTxDescricao().setText(controle.getBrinquedoDescricao(indexFilial, indexBrin));
		getTxFaixaEtaria().setText(Integer.toString(controle.getBrinquedoFaixaEt(indexFilial, indexBrin)));
		getTxComissaoVendedor().setText(controle.getBrinquedoComissao(indexFilial, indexBrin).toString());
		getTxLucro().setText(controle.getBrinquedoLucro(indexFilial, indexBrin).toString());
		getTxCodigo().setText(Integer.toString(controle.getBrinquedoCodigo(indexFilial, indexBrin)));
		getTxFonteDeEnergia().setText(controle.getEletronicoFonte(e));
		getTxGarantia().setText(Integer.toString(controle.getEletronicoGarantia(e)));
		getFilialField().setSelectedIndex(indexFilial);
		
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarEletronicoIndex(indexFilial, indexBrin, getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt(), getTxComissaoVendedorDouble(), getTxLucroDouble(), getTxCodigoInt(),getTxFonteDeEnergiaString(), getTxGarantiaInt() ,getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
