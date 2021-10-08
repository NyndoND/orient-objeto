package controle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.Brinquedo;
import main.Cliente;
import main.Filial;
import main.Venda;
import main.Vendedor;

public class ControleVenda {
	
	public ControleVenda() {
		
	}
	
	public void modelListarVenda(DefaultTableModel model) {
		for (Filial c : Filial.getListaFilial() ) {
			for (Venda v : c.getListaVenda()) {
				String vendedor = v.getVendedor().getNome();
				String cliente = v.getCliente().getNome();
				String brinquedo = v.getBrinquedo().getNome();
				int quantidade = v.getQtdVenda();
				String local = v.getLocal().getLocal();
				
				Object[] rowData = {vendedor, cliente, brinquedo, quantidade, local};
				
				model.addRow(rowData);
			}
		}
	}
	
	public void filtrarVenda(DefaultTableModel model, String digitado) {
		for (Filial c : Filial.getListaFilial() ) {
			for (Venda v : c.getListaVenda()) {
				if(v.getCliente().getNome().equalsIgnoreCase(digitado)) {
					String vendedor = v.getVendedor().getNome();
					String cliente = v.getCliente().getNome();
					String brinquedo = v.getBrinquedo().getNome();
					int quantidade = v.getQtdVenda();
					String local = v.getLocal().getLocal();
				
					Object[] rowData = {vendedor, cliente, brinquedo, quantidade, local};
				
					model.addRow(rowData);
				} else if (v.getVendedor().getNome().equalsIgnoreCase(digitado)) {
					String vendedor = v.getVendedor().getNome();
					String cliente = v.getCliente().getNome();
					String brinquedo = v.getBrinquedo().getNome();
					int quantidade = v.getQtdVenda();
					String local = v.getLocal().getLocal();
				
					Object[] rowData = {vendedor, cliente, brinquedo, quantidade, local};
				
					model.addRow(rowData);
				}
			}
		}
	}
	
	public void cadastrarVenda(String f, String c, String v, int qtd, String b) {
		int i = 0;
		int IndFi = 0;
		int IndC = 0;
		int IndB = 0;
		int IndV = 0;

		//pegando o Objeto Filial
		for (Filial fi : Filial.getListaFilial()) {
			 if (fi.getLocal().equals(f)) {
				 IndFi = i;
			 } else {
				 i++;
			 }
		}
		Filial filial = Filial.getListaFilial().get(IndFi);
		i=0;
		
		// pegando o objeto CLiente
		for (Cliente cl : Cliente.getListaCliente()) {
			if (cl.getNome().equals(c)) {
				IndC = i;
			} else {
				i++;
			}
		}
		Cliente cliente = Cliente.getListaCliente().get(IndC);
		i=0;
		
		//pegando o objeto Vendedor
		for (Vendedor ve : filial.getListaVendedor()) {
			if (ve.getNome().equals(v)) {
				IndV = i;
			}else {
				i++;
			}
		}
		Vendedor vendedor = filial.getListaVendedor().get(IndV);
		i=0;
		
		//pegando o objeto Brinquedo
		for (Brinquedo br : filial.getEstoqueBrinquedo()) {
			if (br.getNome().equals(b)) {
				IndB = i;
			} else {
				i++;
			}
		}
		Brinquedo brinquedo = filial.getEstoqueBrinquedo().get(IndB);
		i=0;
		
		// Contruindo a nova Venda e adicionando ela na lista da filial certa
		Venda vendaNova = new Venda(vendedor, cliente, brinquedo, qtd, filial);
		filial.getListaVenda().add(vendaNova);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
}
