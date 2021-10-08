package view;

import java.awt.event.ActionEvent;

import controle.ControleCliente;

public class ViewAlterarCliente extends ViewCadCliente{
	
	private ControleCliente controle = new ControleCliente();
	int indexCli = 0;
	public ViewAlterarCliente(int index) {
		setTitle("Alterar");
		
		indexCli = index;
		getTxNome().setText(controle.getClienteNome(index));
		getTxTelefone().setText(controle.getClienteTelefone(index));
		getTxEndereco().setText(controle.getEnderecoCliente(index));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar()== e.getSource()) {
			controle.alterarClienteIndex(indexCli, getTxNomeString(), getTxTelefoneInt(), getTxEnderecoString() );
			e = null;
			dispose();
		}
	}

}
