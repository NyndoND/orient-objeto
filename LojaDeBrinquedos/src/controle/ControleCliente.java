package controle;

import main.Cliente;

public class ControleCliente {
	
	public ControleCliente() {
		
	 Cliente c = new Cliente("Rafael", 1232132, "aasdad");
	 
	 String nome = c.getNome(); 
	 c.setNome(c.getNome());
	}
	
	public void alterarCliente(Cliente c) {
	
		String nome = c.getNome(); 
		c.setNome(nome);
		int telefone = c.getTelefone();
		}
	
	public void adicionarCliente() {
		
	}
	
	public void removerCliente(Cliente c) {
		Cliente.getListaCliente().remove(c);
	}
}
