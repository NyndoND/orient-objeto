package main;

public class Pelucia extends Brinquedo{
	private double peso;

	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Peso: " + peso;
	}
	//constructor
	public Pelucia(String nome, double valor, String descricao, int faixaEtaria, double comissaoVendedor, double lucro, int codigo, double peso) {
		super(nome, valor, descricao, faixaEtaria, comissaoVendedor, lucro, codigo);
		this.peso = peso;
	}
	
	//getters and setters
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

}
