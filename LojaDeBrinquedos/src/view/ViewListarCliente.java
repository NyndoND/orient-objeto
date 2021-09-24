package view;

import javax.swing.table.DefaultTableModel;

import main.Cliente;

public class ViewListarCliente extends ViewListarPessoa{

	public ViewListarCliente () {
		super();
		
	}
	
	@Override
	public void listarDados(DefaultTableModel model) {
		for (Cliente c : Cliente.getListaCliente() ) {
			String nome = c.getNome();
			int telefone = c.getTelefone();
			String endereco = c.getEndereco();
			
			Object[] rowData = {nome, telefone, endereco};
			
			model.addRow(rowData);
		}
	}

}
