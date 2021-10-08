package main;
/**
 * Classe modelo de brinquedo, reposável por determinar os métodos e o contrutor do objeto
 * @author renan
 *
 */
public abstract class Brinquedo {
	protected String nome;
	protected double valor;
	protected String descricao;
	protected int faixaEtaria;
	protected double comissaoVendedor;
	protected double lucro;
	protected int codigo;
	
	/**
	 * Construtor de objetos Brinquedo, cria objeto brinquedo de acordo com os atributos recebidos 
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEtaria
	 * @param comissaoVendedor
	 * @param lucro
	 * @param codigo
	 */
	//construtor
	public Brinquedo(String nome, Double valor, String descricao, int faixaEtaria, Double comissaoVendedor,
			Double lucro, int codigo) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.descricao = descricao;
		this.faixaEtaria = faixaEtaria;
		this.comissaoVendedor = comissaoVendedor;
		this.lucro = lucro;
		this.codigo = codigo;
	}
	
	//getters e setters 
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getFaixaEtaria() {
		return faixaEtaria;
	}
	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}
	public Double getComissaoVendedor() {
		return comissaoVendedor;
	}
	public void setComissaoVendedor(Double comissaoVendedor) {
		this.comissaoVendedor = comissaoVendedor;
	}
	public Double getLucro() {
		return lucro;
	}
	public void setLucro(Double lucro) {
		this.lucro = lucro;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
