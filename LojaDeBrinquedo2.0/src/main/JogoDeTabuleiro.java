package main;

public class JogoDeTabuleiro extends Brinquedo{
	private int qtdJogadores;
	private double tempoMedio;
	
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Quantidade de Jogadores: " + qtdJogadores+ "\n Tempo Medio: " +tempoMedio;
	}
	//constructor
	public JogoDeTabuleiro(String nome, Double valor, String descricao, int faixaEtaria, Double comissaoVendedor, Double lucro, int codigo, int quantosJogadores, Double tempo) {
		super(nome, valor, descricao, faixaEtaria, comissaoVendedor, lucro, codigo);
		this.qtdJogadores = quantosJogadores;
		this.tempoMedio = tempo;
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
	public void setTempoMedio(Double tempoMedio) {
		this.tempoMedio = tempoMedio;
	}
	

}
