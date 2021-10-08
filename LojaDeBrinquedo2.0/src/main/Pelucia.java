package main;

public class Pelucia extends Brinquedo{
	private double peso;

	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Peso: " + peso;
	}
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
