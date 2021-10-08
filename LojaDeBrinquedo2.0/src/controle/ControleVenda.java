package controle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.Brinquedo;
import main.Cliente;
import main.Filial;
import main.Venda;
import main.Vendedor;
	/**
	 * Classe responsavel por todos os metodos relacionados a objetos venda e estabele uma relaco intermediaria entra a view e main
	 * @author Renann de Oliveira
	 * @version 1.0 (Out 2021)
	 */
public class ControleVenda {
	
	public ControleVenda() {
		
	}
	/**
	 * Recebe um DefaultTableModel e adiciona linhas de acordo com todos os ArrayList de Venda, esse metodo é usado quando vão gerar
	 * a lista de Vendas na Interface gráfica  
	 * @param model
	 */
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
	
	/**
	 * Adiciona linhas na model de acordo com o que foi digitado, primeiro faz-se um filtro por nome do Cliente de cada Venda, se nenhum objeto for 
	 * coincidir com o que está sendo buscado, faz-se uma nova filtragem comparando o qu foi digitado com o nome do vendedor de cada Venda
	 * @param model
	 * @param digitado
	 */
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
	/**
	 * Cria e adiciona uma Venda de acordo com o que for fornecido, como é fornecido filial, cliente e vendedor como String, o metodo tambem faz uma 
	 * busca para poder pegar o objetos em suas classes originais e assim poder criar uma Venda.
	 * @param f
	 * @param c
	 * @param v
	 * @param qtd
	 * @param b
	 */
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
