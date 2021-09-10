package main;

import java.util.Date;

public class Venda {
	private String formaPagamento;
	private int qtdVenda;
	private Date dataCompra;
	private Vendedor vendedor;
	private Cliente cliente;
	private Brinquedo brinquedo;
	private Filial local; //preciso arepsentar o local do Objeto Filial
	private double comissaoTotal;
	
	//construtor 
	public Venda(Vendedor v, Cliente c, Brinquedo b, int qtdVenda, Filial f) {
		this.vendedor = v;
		this.cliente = c;
		this.brinquedo = b;
		this.qtdVenda = qtdVenda;
		this.local = f;
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
	public double getComissaoTotal() {
		return comissaoTotal;
	}
	public void setComissaoTotal(double comissaoTotal) {
		this.comissaoTotal = comissaoTotal;
	}
	
}
