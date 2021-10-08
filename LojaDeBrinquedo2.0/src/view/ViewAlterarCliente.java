package view;

import java.awt.event.ActionEvent;

import controle.ControleCliente;
/**
 * Classe da tela de alterar cliente 
 * @author renan
 *
 */
public class ViewAlterarCliente extends ViewCadCliente{
	
	private ControleCliente controle = new ControleCliente();
	int indexCli = 0;
	
	/**
	 * Construtor da tela que é criado com os campos já preeenchidos 
	 * @param index
	 */
	public ViewAlterarCliente(int index) {
		setTitle("Alterar");
		
		indexCli = index;
		getTxNome().setText(controle.getClienteNome(index));
		getTxTelefone().setText(controle.getClienteTelefone(index));
		getTxEndereco().setText(controle.getEnderecoCliente(index));
	}
	
	/**
	 * metodo sobrescrito para definir o que o botao deve fazer quando ele for acionado nessa tela 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar()== e.getSource()) {
			controle.alterarClienteIndex(indexCli, getTxNomeString(), getTxTelefoneInt(), getTxEnderecoString() );
			e = null;
			dispose();
		}
	}

}
