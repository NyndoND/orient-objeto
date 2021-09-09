package main;

public abstract class Brinquedo {
	protected String nome;
	protected double valor;
	protected String descricao;
	protected int faixaEtaria;
	protected double comissaoVendedor;
	protected double lucro;
	protected int codigo;
	
	//constructor
	public Brinquedo(String nome, double valor, String descricao, int faixaEtaria, double comissaoVendedor,
			double lucro, int codigo) {
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
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
	public double getComissaoVendedor() {
		return comissaoVendedor;
	}
	public void setComissaoVendedor(double comissaoVendedor) {
		this.comissaoVendedor = comissaoVendedor;
	}
	public double getLucro() {
		return lucro;
	}
	public void setLucro(double lucro) {
		this.lucro = lucro;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
