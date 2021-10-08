package main;
/**
 * Classe modelo de jogos de tabuleiro com metodos get e set de todos os atributos 
 * @author renan
 *
 */
public class JogoDeTabuleiro extends Brinquedo{
	private int qtdJogadores;
	private double tempoMedio;
	
	/**
	 * Metodo sobrescrito para imprimir qualquer objeto jogo de carta no console
	 */
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Quantidade de Jogadores: " + qtdJogadores+ "\n Tempo Medio: " +tempoMedio;
	}
	/**
	 * Metodo constutor usando todos os atributos da classe e cria um novo jogo de tabuleiro de acordo com os atributos fornecidos 
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEtaria
	 * @param comissaoVendedor
	 * @param lucro
	 * @param codigo
	 * @param quantosJogadores
	 * @param tempo
	 */
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
