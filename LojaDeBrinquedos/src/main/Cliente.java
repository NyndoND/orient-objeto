package main;

import java.util.ArrayList;

public class Cliente extends PessoaFisica {
	private double credito;
	private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	
	public static void listarClientes() {
		int i=0;
		for (Cliente c : getListaCliente()) {
			System.out.println("\n----Cliente N�"+ i + "----\n" + c.toString());
			i++;
			}
	}
	
	//Busca de CLientes pelo nome
	public static void buscaClienteNome(String nome) {
		int i=0;
		int IndCli = 0;
		for(Cliente c : getListaCliente()) {
			if (c.getNome().equals(nome)) {
				IndCli = i;
			} else {
				i++;
			}
		} 
		if (i == getListaCliente().size()) {
			System.out.println("\n Cliente n�o encontrado!!");
		} else { System.out.println(getListaCliente().get(IndCli).toString());
		}
	}
	
	//Busca de Cliente por CPF
	public void buscaClienteCpf(int cpf) {
		int i=0;
		int IndCli = 0;
		for(Cliente c : getListaCliente()) {
			if (c.getCpf() == cpf) {
				IndCli = i;
			} else {
				i++;
			}
		} 
		if (i == getListaCliente().size()) {
			System.out.println("\n Cliente n�o encontrado!!");
		} else { System.out.println(getListaCliente().get(IndCli).toString());
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Telefone: " + telefone + "\n Endereco: " + endereco + "\n cpf: " + cpf + "\n Credito Disp.: " + credito;
	}
	//construtor
	public Cliente(String n, int t, String e) {
		nome = n;
		telefone = t;
		endereco = e;
	}
	//getters and setters
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	public static ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	public static void setListaCliente(ArrayList<Cliente> listaCliente) {
		Cliente.listaCliente = listaCliente;
	}
	public static void addCliente(Cliente c) {
		listaCliente.add(c);
	}
	public static void removeCliente(Cliente c) {
		listaCliente.remove(c);
	}
}
