package Main;

import java.util.ArrayList;

public class produto {
	
private static ArrayList<produto> estoque = new ArrayList<produto>();
	
	//pegar listta
	public static ArrayList<produto> getEstoque() {
		return estoque;
	}
	
	//adicionar na lista
	public static void adicionarProduto (produto p) {
		estoque.add(p);
	}
	
	//Deletar da lista 
	public static void remover (produto p) {
		estoque.remove(p); //Adicionar a lógica pra remover pelo título e verificar se tem estoque
	}
	
	private String nomeDoProduto;
	private String descricao;
	private String valorDeCompra;
	private String porcentagem;
	private int quantidade;
	
	//Constutor 
	public produto(String nomeDoProduto, String descricao, String valorDeCompra, String porcentagem, int quantidade) {
		this.nomeDoProduto = nomeDoProduto;
		this.descricao = descricao;
		this.valorDeCompra = valorDeCompra;
		this.porcentagem = porcentagem;
		this.quantidade = quantidade;
	}
	
	//Imprimir produto
	public static String imprimirProduto (produto p) {
		return " Nome do Produto: " + p.getNome() + "\n Descricao: " + p.getDescricao() + "\n Valor de Compra: " + p.getValorDeCompra() +"\n Porcentagem de Lucro: " + p.getPorcentagem() + "\n Quantidade em estoque: " + p.getQuantidade();
	}

//	Get and Set das Strings
	public String getNome() {
		return nomeDoProduto;
	}
	public void setNome(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorDeCompra() {
		return valorDeCompra;
	}

	public void setValorDeCompra(String valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}

	public String getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(String porcentagem) {
		this.porcentagem = porcentagem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
