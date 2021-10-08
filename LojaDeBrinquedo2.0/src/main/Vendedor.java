package main;

import java.util.Date;
/**
 * classe modelo de vendedor 
 * @author renan
 *
 */
public class Vendedor extends PessoaFisica{
	private double comissaoTotal;
	private Date dataContratacao;
	private double salario;
	
	/**
	 * Metodo sobrescrito  para imprimir no console qualquer objeto vendedor 
	 */
	@Override
	public String toString() {
		return "Nome:" + nome + "\n Telefone: " + telefone + "\n Endereco: " +  endereco + "\n CPF: " + cpf + "\n Data de Contratacao: " +  dataContratacao + "\n Salario: " + salario +"\n Comissao Acumulada: " + comissaoTotal;
	}
	/**
	 * metodos construtor de vendedor usando todos os atributos da classe modelo 
	 * @param nome
	 * @param telefone
	 * @param endereco
	 * @param cpf
	 * @param dataContratacao
	 * @param salario
	 */
	//construtor
	public Vendedor(String nome, int telefone, String endereco, int cpf, Date dataContratacao, double salario) {
		this.nome = nome;  //Note que eu estou usando uma forma diferente do construtor de Cliente, mas os dois funcionam da mesma forma
		this.telefone = telefone;
		this.endereco = endereco;
		this.cpf = cpf;
		this.dataContratacao = dataContratacao;
		this.salario = salario;
	}
	
	//getters and setters 
	public double getComissaoTotal() {
		return comissaoTotal;
	}
	public void setComissaoTotal(double comissaoTotal) {
		this.comissaoTotal = comissaoTotal;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	

}
