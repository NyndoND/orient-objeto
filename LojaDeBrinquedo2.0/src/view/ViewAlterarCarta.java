package view;

import java.awt.event.ActionEvent;

import controle.ControleBrinquedo;
import main.JogoDeCarta;

public class ViewAlterarCarta extends ViewCadCarta{
	private ControleBrinquedo controle = new ControleBrinquedo();
	int indexBrin = 0;
	int indexFilial=0;
	
	public ViewAlterarCarta(int index, JogoDeCarta c) {
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
		getTxQtdCartas().setText(Integer.toString(controle.getCartaQtdCartas(c)));
		getTxQtdJogadores().setText(Integer.toString(controle.getCartaQtdJogadores(c)));
		getFilialField().setSelectedIndex(indexFilial);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarCartaIndex(indexFilial, indexBrin, getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt(), getTxComissaoVendedorDouble(), getTxLucroDouble(), getTxCodigoInt(),getTxQtdCartasInt(), getTxQtdJogadoresInt() ,getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
