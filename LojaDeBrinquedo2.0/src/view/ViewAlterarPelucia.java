package view;

import java.awt.event.ActionEvent;

import controle.ControleBrinquedo;
import main.Pelucia;
/**
 * Classe da tela de alterar pelucia 
 * @author renan
 *
 */
public class ViewAlterarPelucia extends ViewCadPelucia{
	private ControleBrinquedo controle = new ControleBrinquedo();
	int indexBrin = 0;
	int indexFilial=0;
	
	/**
	 *Construtor da tela que j� vem com os campos preenchidos 
	 * @param index
	 * @param p
	 */
	public ViewAlterarPelucia(int index, Pelucia p) {
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
		getTxPeso().setText(controle.getPeluciaPeso(p).toString());
		getFilialField().setSelectedIndex(indexFilial);
	}
	
	/**
	 * Metodo sobrescrito defininco o que o botao deve fazer qunado ele for acionado nessa tela 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarPeluciaIndex(indexFilial, indexBrin, getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt(), getTxComissaoVendedorDouble(), getTxLucroDouble(), getTxCodigoInt(), getTxPesoDouble() ,getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
