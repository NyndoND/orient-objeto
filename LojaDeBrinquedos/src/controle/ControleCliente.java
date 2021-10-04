package controle;

import main.Cliente;

public class ControleCliente {
	
	public ControleCliente() {
		
	}
	
	public void alterarCliente(Cliente c, String nome, int telefone, String endereco) {
	
		c.setNome(nome);
		c.setTelefone(telefone);
		c.setEndereco(endereco);
		}
	
	public void alterarClienteNome(String nome, String nomeNovo, int telefone, String endereco) {
		int i = 0;
		int IndC = 0;
		for(Cliente c : Cliente.getListaCliente()) {
			if (c.getNome().equals(nome)) {
				IndC = i;
			} else {
				i++;
			}
		}
		Cliente cliente = Cliente.getListaCliente().get(IndC);
		cliente.setNome(nomeNovo);
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
	}
	
	public void cadastrarCliente(String nome, int telefone, String endereco) {
		
		Cliente cliente = new Cliente(nome, telefone, endereco);
		Cliente.getListaCliente().add(cliente);
	}
	
	public void removerClienteNome(String nome) {
		int i = 0;
		int IndC = 0;
		for(Cliente c : Cliente.getListaCliente()) {
			if (c.getNome().equals(nome)) {
				IndC = i;
			} else {
				i++;
			}
		}
		Cliente cliente = Cliente.getListaCliente().get(IndC);
		Cliente.getListaCliente().remove(cliente);
//		Cliente.getListaCliente().remove(Cliente.getListaCliente().get(IndC));
	}
	
	public void removerCliente(Cliente c) {
		Cliente.getListaCliente().remove(c);
	}
}
