package main;

import java.util.Date;

public class Venda {
	private String formaPagamento;
	private int qtdVenda;
	private Date dataCompra;
	private Vendedor vendedor; private String nomeVendedor;
	private Cliente cliente; private String nomeCliente;
	private Brinquedo brinquedo; private String nomeBrinquedo;
	private Filial local; private String nomeFilial;
	private double comissaoVenda;
	private double valorTotal;
	
	
	
	public void atualizarEstoqueBrinquedo() {
		getLocal().getEstoqueBrinquedo().remove(brinquedo);
	}
	
	public void calcularValorTotal() {
		setValorTotal(qtdVenda * brinquedo.getValor());
	}
	
	public void calcularComissao() {
		setComissaoVenda(brinquedo.getValor() * brinquedo.getComissaoVendedor() * qtdVenda);
	}
	
	public void acrescentarComissão () {
		getVendedor().setComissaoTotal(getVendedor().getComissaoTotal() + getComissaoVenda());
	}
	
	public void acrescentarVendaMes () {
		getLocal().setTotalVendasMes(getLocal().getTotalVendasMes() + getValorTotal());
	}
	
	
	public String toString() {
		return " Cliente: " + cliente.getNome() + "\n Vendedor:" + vendedor.getNome() + "\n Data da Compra: " + dataCompra + "\n Brinquedo: " + brinquedo.getNome() +"\n Quantidade: "+ qtdVenda +"\n Filial: " + local.getLocal() + "\n Valor Total: " + valorTotal + "\n Forma de pagamento: " + formaPagamento + "\n" + local ;
	}



	//construtor 
	public Venda(Vendedor v, Cliente c, Brinquedo b, int qtdVenda, Filial f) {
		this.vendedor = v;
		this.cliente = c;
		this.brinquedo = b;
		this.qtdVenda = qtdVenda;
		this.local = f;
		
		atualizarEstoqueBrinquedo();
		calcularValorTotal();
		calcularComissao();
		acrescentarComissão();
		acrescentarVendaMes();
	}
	
	//construtor criado de última hora pois percebi que não faz sentido eu criar usando os objetos em si 
	public Venda(String nomeF, String nomeC, String nomeV, int qtdVenda, String nomeB ) {
		this.nomeVendedor = nomeV;
		this.nomeCliente = nomeC;
		this.nomeBrinquedo = nomeB;
		this.nomeFilial = nomeF;
		this.qtdVenda = qtdVenda;
	}
	
	//getters and Setters
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public int getQtdVenda() {
		return qtdVenda;
	}
	public void setQtdVenda(int qtdVenda) {
		this.qtdVenda = qtdVenda;
	}
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Brinquedo getBrinquedo() {
		return brinquedo;
	}
	public void setBrinquedo(Brinquedo brinquedo) {
		this.brinquedo = brinquedo;
	}
	public Filial getLocal() {
		return local;
	}
	public void setLocal(Filial local) {
		this.local = local;
	}
	public double getComissaoVenda() {
		return comissaoVenda;
	}
	public void setComissaoVenda(double comissaoVenda) {
		this.comissaoVenda = comissaoVenda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
