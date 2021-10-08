package main;
/**
 * Classe modelo de Jogos de Carta, com get e set de todos os atributos 
 * @author renan
 *
 */
public class JogoDeCarta extends Brinquedo{
	private int qtdCartas;
	private int qtdJogadores;
	
	/**
	 * Metodo toString sobrescrito para pode imprimir no console qualquer jogo de carta no console
	 */
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Quantidade de Cartas: " + qtdCartas+ "\n Quantidade de Jogadores: " +qtdJogadores;
	}
	/**
	 * metodo construtor de jogo de carta usando todos atributos da classe modelo
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEtaria
	 * @param comissaoVendedor
	 * @param lucro
	 * @param codigo
	 * @param qtdCartas
	 * @param qtdJogadores
	 */
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
