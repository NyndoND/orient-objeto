package main;

/**
 * Classe modelo de Pelucia com metodos get e set de todos atributos 
 * @author renan
 *
 */
public class Pelucia extends Brinquedo{
	private double peso;
	
	/**
	 * metodo sobrescrito para facilitar a impressao no console de qualuqer metodo pelucia 
	 */
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Peso: " + peso;
	}
	
	/**
	 * metodo construtor de objetos pelucia com todos os atributos da classe 
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEtaria
	 * @param comissaoVendedor
	 * @param lucro
	 * @param codigo
	 * @param peso
	 */
	//constructor
	public Pelucia(String nome, Double valor, String descricao, int faixaEtaria, Double comissaoVendedor, Double lucro, int codigo, Double peso) {
		super(nome, valor, descricao, faixaEtaria, comissaoVendedor, lucro, codigo);
		this.peso = peso;
	}
	
	//getters and setters
	public double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}

}
