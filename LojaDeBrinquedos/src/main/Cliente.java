package main;

import java.util.ArrayList;

public class Cliente extends PessoaFisica {
	private double credito;
	private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	
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
}
