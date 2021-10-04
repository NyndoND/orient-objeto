package controle;

import java.util.Date;

import main.Filial;
import main.Vendedor;

public class ControleVendedor {

	public ControleVendedor () {
		
	}
	
	public void cadastrarVendedor(String nome, int telefone, String endereco, int cpf, Date data, double salario, Filial f) {
		Vendedor vendedor = new Vendedor(nome, telefone, endereco, cpf, data, salario);
		f.addVendedor(vendedor);
	}
	
	public void alterarVendedor(Vendedor v) {
		
	}
	public void alterarVendedor(String nome) {
		
	}
	public void removerVendedor(String nome) {
		
	}
	
	public void removerVendedor(Vendedor v) {
		
	}
}
