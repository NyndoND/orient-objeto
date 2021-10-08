package main;
/**
 * Classe modelo de Eletronico, com os metodos e atributos
 * @author renan
 *
 */
public class Eletronico extends Brinquedo {
	private String fonteDeEnergia;
	private int garantia;
	
	/**
	 * Metodo toString sobrescrito para facilitar a impressão de qualquer objeto eletronico no console
	 */
	//método para formatar a impressão desse objeto
	public String toString() {
		return "Nome: "+nome+ "\n Valor: " +valor+ "\n Descricao: "+descricao+ "\n Codigo: " +codigo+ "\n Fonte de enegia: " + fonteDeEnergia+ "\n Garantia: " +garantia;
	}
	
	/**
	 * Metodo construtor de eletronico com preenchimento de todos os atributos de acordo com o que for fornecido 
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEtaria
	 * @param comissaoVendedor
	 * @param lucro
	 * @param codigo
	 * @param fonteDeEnergia
	 * @param garantia
	 */
	//constructor
	public Eletronico(String nome, double valor, String descricao, int faixaEtaria, double comissaoVendedor, double lucro, int codigo, String fonteDeEnergia, int garantia) {
		super(nome, valor, descricao, faixaEtaria, comissaoVendedor, lucro, codigo);
		this.fonteDeEnergia = fonteDeEnergia;
		this.garantia = garantia;
	}
	
	
	//getters and setters
	public String getFonteDeEnergia() {
		return fonteDeEnergia;
	}
	public void setFonteDeEnergia(String fonteDeEnergia) {
		this.fonteDeEnergia = fonteDeEnergia;
	}
	public int getGarantia() {
		return garantia;
	}
	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}
}
