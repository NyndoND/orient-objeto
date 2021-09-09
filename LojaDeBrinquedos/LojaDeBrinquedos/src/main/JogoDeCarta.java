package main;

public class JogoDeCarta extends Brinquedo{
	private int qtdCartas;
	private int qtdJogadores;
	
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Quantidade de Cartas: " + qtdCartas+ "\n Quantidade de Jogadores: " +qtdJogadores;
	}
	
	//constructor
	public JogoDeCarta(String nome, double valor, String descricao, int faixaEtaria, double comissaoVendedor, double lucro, int codigo, int qtdCartas, int qtdJogadores) {
		super(nome, valor, descricao, faixaEtaria, comissaoVendedor, lucro, codigo);
		this.qtdCartas = qtdCartas;
		this.qtdJogadores = qtdJogadores;
	}
	//getters and setters
	public int getQtdCartas() {
		return qtdCartas;
	}
	public void setQtdCartas(int qtdCartas) {
		this.qtdCartas = qtdCartas;
	}
	public int getQtdJogadores() {
		return qtdJogadores;
	}
	public void setQtdJogadores(int qtdJogadores) {
		this.qtdJogadores = qtdJogadores;
	}

}
