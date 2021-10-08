package view;

import java.awt.event.ActionEvent;
import java.util.Date;

import controle.ControleCliente;
/**
 * Classe da tela de cadastro de cliente 
 * @author renan
 *
 */
public class ViewCadCliente extends ViewCadPessoa{

	private ControleCliente controle = new ControleCliente();
	/**
	 * Metodo construtor simples, executa apenas a cosntrucao da super classe  
	 */
	public ViewCadCliente () {
		super();
	}
	
	/**
	 * Metodo sobrescrito para definir seu efeito nessa tela
	 * @return
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getConfirmar()== e.getSource()) {
			controle.cadastrarCliente(getTxNomeString(), getTxTelefoneInt(), getTxEnderecoString());
			e = null;
			dispose();
		}
	}
	
	
}
