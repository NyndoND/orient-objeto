package view;

import java.awt.event.ActionEvent;
import java.util.Date;

import controle.ControleCliente;

public class ViewCadCliente extends ViewCadPessoa{

	private ControleCliente controle = new ControleCliente();
	
	public ViewCadCliente () {
		super();
	}

	public void actionPerformed(ActionEvent e) {
		if (getConfirmar()== e.getSource()) {
			controle.cadastrarCliente(getTxNome(), getTxTelefone(), getTxEndereco());
			e = null;
		}
	}
	
	
}
