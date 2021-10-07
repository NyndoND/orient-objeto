package view;

import java.awt.event.ActionEvent;

import controle.ControleVendedor;

public class ViewAlterarVendedor extends ViewCadVendedor{
	private ControleVendedor controle = new ControleVendedor();
	int indexVen = 0;
	int indexFilial = 0;
	
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar() == e.getSource()) {
		controle.alterarVendedorIndex(indexFilial, indexVen,getTxNomeString(), getTxTelefoneInt(), getTxEnderecoString(),getTxCpfInt(),getTxDataDate(),getTxSalarioDouble(),getFilialField().getSelectedIndex());
		e=null;
		dispose();
		}
	}
}
