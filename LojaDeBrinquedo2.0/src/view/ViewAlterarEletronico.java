package view;

import java.awt.event.ActionEvent;

import controle.ControleBrinquedo;
import main.Brinquedo;
import main.Eletronico;
import main.Filial;

/**
 * classe da tela de alterar eletronico 
 * @author renan
 *
 */
public class ViewAlterarEletronico extends ViewCadEletronico{
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	int indexBrin = 0;
	int indexFilial=0;
	/**
	 * Construtor da tela que já vem com os campos preenchidos 
	 * @param index
	 * @param e
	 */
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
	
	/**
	 * Metodo sobrescrito defininco o que o botao deve fazer qunado ele for acionado nessa tela 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarEletronicoIndex(indexFilial, indexBrin, getTxNomeString(), getTxValorDouble(), getTxDescricaoString(), getTxFaixaEtariaInt(), getTxComissaoVendedorDouble(), getTxLucroDouble(), getTxCodigoInt(),getTxFonteDeEnergiaString(), getTxGarantiaInt() ,getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
