package main;

import java.util.ArrayList;

public class Filial {
	private String local;
	private Vendedor gerente; //Preciso principalmente apresentar nome dele 
	private double totalVendasMes;
	private double lucroMes;
	private int estoqueBrinquedoQtd;
	private ArrayList<Brinquedo> estoqueBrinquedo = new ArrayList<Brinquedo>();
	private ArrayList<Vendedor> listaVendedor= new ArrayList<Vendedor>();
	private ArrayList<Venda> listaVenda = new ArrayList<Venda>();
	
	public String toString() {
		return "Localizacao: " +local+ "\n Nome do Gerente: " + gerente.nome + "\n Estoque de Brinquedos: " + estoqueBrinquedoQtd + "\n Array" + estoqueBrinquedo;
	}

	//construtor
	public Filial(String l, Vendedor g) {
		this.local = l;
		this.gerente =g;
	}
	 
	//getters and setters 
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Vendedor getGerente() {
		return gerente;
	}
	public void setGerente(Vendedor gerente) {
		this.gerente = gerente;
	}
	public double getTotalVendasMes() {
		return totalVendasMes;
	}
	public void setTotalVendasMes(double totalVendasMes) {
		this.totalVendasMes = totalVendasMes;
	}
	public double getLucroMes() {
		return lucroMes;
	}
	public void setLucroMes(double lucroMes) {
		this.lucroMes = lucroMes;
	}
	
	public int getEstoqueBrinquedoQtd() {
		return estoqueBrinquedoQtd;
	}
	public void setEstoqueBrinquedoQtd(int estoqueBrinquedoQtd) {
		this.estoqueBrinquedoQtd = estoqueBrinquedoQtd;
	}
	public ArrayList<Brinquedo> getEstoqueBrinquedo() {
		return estoqueBrinquedo;
	}
	public void setEstoqueBrinquedo(ArrayList<Brinquedo> estoqueBrinquedo) {
		this.estoqueBrinquedo = estoqueBrinquedo;
	}
	public void addEstoqueBrinquedo (Brinquedo a) {
		 estoqueBrinquedo.add(a);
	}
	public ArrayList<Vendedor> getListaVendedor() {
		return listaVendedor;
	}
	public void setListaVendedor(ArrayList<Vendedor> listaVendedor) {
		this.listaVendedor = listaVendedor;
	}
	public void addVendedor(Vendedor a) {
		listaVendedor.add(a);
	}
	public ArrayList<Venda> getListaVenda() {
		return listaVenda;
	}
	public void setListaVenda(ArrayList<Venda> listaVenda) {
		this.listaVenda = listaVenda;
	}
	public void addVenda (Venda a) {
		listaVenda.add(a);
	}
}
