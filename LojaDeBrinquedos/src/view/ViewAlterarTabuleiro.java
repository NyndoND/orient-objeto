package view;

import java.awt.event.ActionEvent;

import controle.ControleBrinquedo;
import main.JogoDeTabuleiro;

public class ViewAlterarTabuleiro extends ViewCadTabuleiro{
	private ControleBrinquedo controle = new ControleBrinquedo();
	int indexBrin = 0;
	int indexFilial=0;
	
	public ViewAlterarTabuleiro (int index, JogoDeTabuleiro t) {
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
		getTxQtdJogadores().setText(Integer.toString(controle.getTabuleiroQtdJogadores(t)));
		getTxTempoMedio().setText(controle.getTabuleiroTempo(t).toString());
		getFilialField().setSelectedIndex(indexFilial);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarTabuleiroIndex(indexFilial, indexBrin, getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt(), getTxComissaoVendedorDouble(), getTxLucroDouble(), getTxCodigoInt(), getTxQtdJogadoresInt (), getTxTempoMedioDouble() ,getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
