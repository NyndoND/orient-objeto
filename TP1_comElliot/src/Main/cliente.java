package Main;


import java.util.ArrayList;

public class cliente {
	
	private String nome;
	private String endereco;
	private String telefone;
	
	public cliente() {}
	
	//Get and Set nome
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Get and Set endereco
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//Get and Set telefone
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//Construtor
	public cliente(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	//Imprimir cliente
	public static String imprimirCliente (cliente c) {
		return " Nome: " + c.getNome() + "\n Endereco: " + c.getEndereco() + "\n Telefone:" + c.getTelefone() + "\n";
	}
	
	//Lista de Cliente
private static ArrayList<cliente> clienteLista = new ArrayList<cliente>();
	
	//Pegar clienteLista
	public static ArrayList<cliente> getClienteLista() {
		return clienteLista;
	}
	
	//adicionar na lista
	public static void adicionarCliente (cliente c) {
		clienteLista.add(c);
	}
}
