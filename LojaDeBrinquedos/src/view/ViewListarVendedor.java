package view;

import javax.swing.table.DefaultTableModel;

import main.Cliente;
import main.Filial;
import main.Vendedor;

public class ViewListarVendedor extends ViewListarPessoa{
	
	public ViewListarVendedor() {
		super();
		
	}
	@Override
	public void listarDados(DefaultTableModel model) {
		for (Filial c : Filial.getListaFilial() ) {
			for (Vendedor v : c.getListaVendedor()) {
				String nome = v.getNome();
				int telefone = v.getTelefone();
				String endereco = v.getEndereco();
				
				Object[] rowData = {nome, telefone, endereco};
				
				model.addRow(rowData);
			}
		}
		
		
		
	}
}
