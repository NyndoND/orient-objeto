package main;

import java.util.ArrayList;
/**
 * Classe abtrata de depois é extendida por Cliente e Vendedor
 * @author renan
 *
 */
public class Cliente extends PessoaFisica {
	private double credito;
	private static ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
	
	/**
	 * Metodo simples para listar toda o ArrayList de cliente no console
	 */
	public static void listarClientes() {
		int i=0;
		for (Cliente c : getListaCliente()) {
			System.out.println("\n----Cliente N°"+ i + "----\n" + c.toString());
			i++;
			}
	}
	
	/**
	 * Metodo simples de buscar clinete por nome no ArrayList de cliente
	 * @param nome
	 */
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
			System.out.println("\n Cliente não encontrado!!");
		} else { System.out.println(getListaCliente().get(IndCli).toString());
		}
	}
	
	/**
	 * Metodo simples de busca cliente pelo CPF no ArrayList de cliente
	 * @param cpf
	 */
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
			System.out.println("\n Cliente não encontrado!!");
		} else { System.out.println(getListaCliente().get(IndCli).toString());
		}
	}
	
	/**
	 * Sobrescrevi o metodo toString(), para poder imprimir facilmente qualquer objeto cliente no console
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + "\n Telefone: " + telefone + "\n Endereco: " + endereco + "\n cpf: " + cpf + "\n Credito Disp.: " + credito;
	}
	/**
	 * Construtor de cliente, cria um cliente apenas com os atributos nome, telefone e endereco
	 * @param n
	 * @param t
	 * @param e
	 */
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
