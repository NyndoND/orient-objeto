package Main;

import java.util.ArrayList;

public class venda {
	
	private static ArrayList<venda> vendaLista = new ArrayList<venda>();
	public static ArrayList<venda> getVendaLista (){
		return vendaLista;
	}
	public static void adicionarVenda (venda v) {
		vendaLista.add(v);
	}
	public static void removerVenda (venda v) {
		vendaLista.remove(v); //inserir a lógica de remover a venda de acordo com o index dela
	}
}
