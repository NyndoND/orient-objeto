package main;

import java.util.ArrayList;
/**
 * Classe modelo de Filial com alguns metodos para modificar e pegar os atributos especificos 
 * @author renan
 *
 */
public class Filial {
	private String local;
	private Vendedor gerente; //Preciso principalmente apresentar nome dele 
	private double totalVendasMes;
	private double lucroMes;
	private int estoqueBrinquedoQtd;
	private ArrayList<Brinquedo> estoqueBrinquedo = new ArrayList<Brinquedo>();
	private ArrayList<Vendedor> listaVendedor= new ArrayList<Vendedor>();
	private ArrayList<Venda> listaVenda = new ArrayList<Venda>();
	private static ArrayList<Filial> listaFilial = new ArrayList<Filial>();
	
	/**
	 * Metodo toString sobrescrito para facilitar a impressõa de qualquer objeto filial no console
	 */
	public String toString() {
		return " Localizacao: " +local+ "\n Nome do Gerente: " + gerente.nome + "\n Estoque de Brinquedos: " + estoqueBrinquedoQtd + "\n Total Venda Mes: " + totalVendasMes;
	}
	
	/**
	 * Meotodo para buscar um brinquedo pelo nome e imprimir no console
	 * @param nome
	 */
	//Busca de Brinquedos por nome
	public void buscaBrinquedosNome(String nome) {
		int i=0;
		int IndBrinq = 0;
		for(Brinquedo b : this.getEstoqueBrinquedo()) {
			if (b.getNome().equals(nome)) {
				IndBrinq = i;
			} else {
				i++;
			}
		} 
		if (i == this.getEstoqueBrinquedo().size()) {
			System.out.println("\n Brinquedo não encontrado!!");
		} else { System.out.println(this.getEstoqueBrinquedo().get(IndBrinq).toString());
		}
	}
	/**
	 * Busca brinquedo pelo codigo e o imprime no console
	 * @param codigo
	 */
	//Busca por código
	public void buscaBrinquedosCod(int codigo) {
		int i=0;
		int IndBrinq = 0;
		for(Brinquedo b : this.getEstoqueBrinquedo()) {
			if (b.getCodigo() == codigo) {
				IndBrinq = i;
			} else {
				i++;
			}
		} 
		if (i == this.getEstoqueBrinquedo().size()) {
			System.out.println("\n Brinquedo não encontrado!!");
		} else { System.out.println(this.getEstoqueBrinquedo().get(IndBrinq).toString());
		}
	}
	
	/**
	 * busca vendedor por nome e o imprime no console 
	 * @param nome
	 */
	//Busca Vendedor por Nome
	public void buscaVendedorNome(String nome) {
		int i=0;
		int Ind = 0;
		for(Vendedor v: this.getListaVendedor()) {
			if (v.getNome().equals(nome)) {
				Ind = i;
			} else {
				i++;
			}
		} 
		if (i == this.getListaVendedor().size()) {
			System.out.println("\n Vendedor não encontrado!!");
		} else { System.out.println(this.getListaVendedor().get(Ind).toString());
		}
	}
	
	/**
	 * busca vendedor por cpf e o imprimi no console
	 * @param cpf
	 */
	// Busca Vendedro por cpf
	public void buscaVendedorCpf(int cpf) {
		int i=0;
		int Ind = 0;
		for(Vendedor v: this.getListaVendedor()) {
			if (v.getCpf() == cpf) {
				Ind = i;
			} else {
				i++;
			}
		} 
		if (i == this.getListaVendedor().size()) {
			System.out.println("\n Vendedor não encontrado!!");
		} else { System.out.println(this.getListaVendedor().get(Ind).toString());
		}
	}
	
	/**
	 * busca vendedor por salario e o imprimi no console
	 * @param salario
	 */
	//Busca Vendedor por salario
	public void buscaVendedorSalario(int salario) {
		int i=0;
		int Ind = 0;
		for(Vendedor v: this.getListaVendedor()) {
			if (v.getSalario() == salario) {
				Ind = i;
			} else {
				i++;
			}
		} 
		if (i == this.getListaVendedor().size()) {
			System.out.println("\n Vendedor não encontrado!!");
		} else { System.out.println(this.getListaVendedor().get(Ind).toString());
		}
	}
	
	/**
	 * lista todos os brinquedos da filial no console 
	 */
	//Listar o estoqueBrinquedo
	public void listarBrinquedos () {
		int i = 0;
		for (Brinquedo b : this.getEstoqueBrinquedo()) {
		System.out.println("\n----Brinquedo N°"+ i + "----\n" + b.toString());
		i++;
		}
	}
	
	/**
	 * lista todos os vendedores da filial no console
	 */
	//Listar a listaVendedor
	public void listarVendedores() {
		int i=0;
		for (Vendedor v : this.getListaVendedor()) {
			System.out.println("\n----Vendedor N°"+ i + "----\n" + v.toString());
			i++;
			}
	}
	
	/**
	 * lista todas as venda da filial no console
	 */
	//Listar a listaVenda
	public void listarVendas() {
		int i=0;
		for (Venda v : this.getListaVenda()) {
			System.out.println("\n----Venda N°"+ i + "----\n" + v.toString());
			i++;
			}
	}
	
	/**
	 * Metodo construtor de filial usando como atributo uma String que vai ser o local e um vendedor que vai ser o gerente
	 * @param l
	 * @param g
	 */
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
	public void removeEstoqueBrinquedo(Brinquedo a) {
		estoqueBrinquedo.remove(a);
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
	public void removeVendedor(Vendedor a) {
		listaVendedor.remove(a);
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
	public void removeVenda (Venda a) {
		listaVenda.remove(a);
	}
	public static ArrayList<Filial> getListaFilial() {
		return listaFilial;
	}
	public static void setListaFilial(ArrayList<Filial> listaFilial) {
		Filial.listaFilial = listaFilial;
	}
	public static void addFilial (Filial a) {
		listaFilial.add(a);
	}
	public static void removeFilial (Filial a) {
		listaFilial.remove(a);
	}
}
