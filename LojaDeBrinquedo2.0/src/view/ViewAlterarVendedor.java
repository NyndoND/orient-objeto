package view;

import java.awt.event.ActionEvent;

import controle.ControleVendedor;
/**
 * Classe da tela de alterar vendedor 
 * @author renan
 *
 */
public class ViewAlterarVendedor extends ViewCadVendedor{
	private ControleVendedor controle = new ControleVendedor();
	int indexVen = 0;
	int indexFilial = 0;
	
	/**
	 * Construtor da tela que já vem com os campos preenchidos 
	 * @param index
	 */
	public ViewAlterarVendedor(int index) {
		setTitle("Alterar");
		
		indexVen = controle.getVendedorListaVendedorIndex(index);
		indexFilial = controle.getVendedorListaFilialIndex(index);
		
		getTxNome().setText(controle.getVendedorNome(indexFilial, indexVen));
		getTxTelefone().setText(controle.getVendedorTelefone(indexFilial, indexVen));
		getTxEndereco().setText(controle.getVendedorEndereco(indexFilial, indexVen));
		getTxCpf().setText(controle.getVendedorCpf(indexFilial, indexVen));
		getTxDataContratacao().setText(controle.getVendedorDataContrato(indexFilial, indexVen));
		getTxSalario().setText(controle.getVendedorSalario(indexFilial, indexVen));
		getFilialField().setSelectedIndex(indexFilial);
		
	}
	
	/**
	 * Metodo sobrescrito defininco o que o botao deve fazer qunado ele for acionado nessa tela 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarVendedorIndex(indexFilial, indexVen,getTxNomeString(), getTxTelefoneInt(), getTxEnderecoString(),getTxCpfInt(),getTxDataDate(),getTxSalarioDouble(),getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
