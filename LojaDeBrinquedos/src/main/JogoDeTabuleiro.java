package main;

public class JogoDeTabuleiro extends Brinquedo{
	private int qtdJogadores;
	private double tempoMedio;
	
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Quantidade de Jogadores: " + qtdJogadores+ "\n Tempo Medio: " +tempoMedio;
	}
	//constructor
	public JogoDeTabuleiro(String nome, double valor, String descricao, int faixaEtaria, double comissaoVendedor, double lucro, int codigo, int quantosJogadores, double tempoMedio) {
		super(nome, valor, descricao, faixaEtaria, comissaoVendedor, lucro, codigo);
		this.qtdJogadores = quantosJogadores;
		this.tempoMedio = tempoMedio;
	}
	//getters and setters
	public int getQuantosJogadores() {
		return qtdJogadores;
	}
	public void setQuantosJogadores(int qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}
	public double getTempoMedio() {
		return tempoMedio;
	}
	public void setTempoMedio(double tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
	

}
