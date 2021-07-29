package Main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Scanner entradaString = new Scanner(System.in);
		
		cliente b = new cliente ("Andre", "rua Arniqueiras", "6122222");
		cliente d = new cliente ("Beatriz", "rua Madeira", "61333333");
		cliente e = new cliente ("Dante", "rua Namoira", "6144444");
		cliente f = new cliente ("Efumir", "rua Mandaloriano", "91444444");
		cliente g = new cliente ("Galgir", "rua ChamaNenem", "76333333");
		cliente h = new cliente ("Heracles", "rua Anakim", "61666666");
		cliente i = new cliente ("Iridia", "rua Numero0", "6142422");
		cliente j = new cliente ("Julio", "rua Groelhas", "7800090");
		cliente k = new cliente ("Kafha", "rua Eredem", "3497804");
		cliente l = new cliente ("Lenora", "rua Destrio", "243243424");
		cliente.adicionarCliente(b);
		cliente.adicionarCliente(d);
		cliente.adicionarCliente(e);
		cliente.adicionarCliente(f);
		cliente.adicionarCliente(g);
		cliente.adicionarCliente(h);
		cliente.adicionarCliente(i);
		cliente.adicionarCliente(j);
		cliente.adicionarCliente(k);
		cliente.adicionarCliente(l);
		
		
		produto q = new produto ("Queijo"," Comida de brinquedo","R$ 10","2%", 6);
		produto r = new produto ("Radio"," toca música","R$ 15","3%", 7);
		produto s = new produto ("Sanfona","instrumeto de brinquedo","R$ 25","4%", 8);
		produto t = new produto ("Tatu","animal de pelúcia","R$ 30","5%", 9);
		produto u = new produto ("Uva","comida de brinquedo","R$ 35","6%", 10);
		produto v = new produto ("Velotrol"," bicicleta mínuscula que muita gente queria ter, mas não teve","R$ 40","7%", 11);
		produto w = new produto ("Wolwerine","Action Figure","R$ 45","8%", 12);
		produto x = new produto ("X-man equipe","Action figures muito caros","R$ 50","9%", 13);
		produto y = new produto ("Year Pearl"," Viagem no tempo","R$ 55","4%", 14);
		produto z = new produto ("Zacarias","boneco de pelúcia","R$ 60","5%", 15);
		produto.adicionarProduto(q);
		produto.adicionarProduto(r);
		produto.adicionarProduto(s);
		produto.adicionarProduto(t);
		produto.adicionarProduto(u);
		produto.adicionarProduto(v);
		produto.adicionarProduto(w);
		produto.adicionarProduto(x);
		produto.adicionarProduto(y);
		produto.adicionarProduto(z);
		
		int menu;
		
		do {
			exibirMenu(); //chama o método Menu, que está definido lá embaixo
			menu = entrada.nextInt();
			 switch(menu) {
			 case 1: //Cadastro Cliente
				 cadastroCliente(entrada, entradaString);
				 break;
			 case 2: //Busca Cliente
				 buscaCliente(entrada, entradaString);
				 break;
			 case 3: //Cadastro Produto
				 cadastroProduto(entrada, entradaString);
				 break;
			 case 4: //Busca Produto
				 buscaProduto(entrada, entradaString);
				 break;
			 case 5: //Cadastro venda
				 cadastroVenda(entrada);
				 break;
			 case 6: //Listar estoque
				 listarEstoque();
				 break;
			 case 7: //Sair
				 System.out.println("Encerrando...");
				 break;
			default: 
				System.out.println("\nDigite outro número, opção inválida!");
			 }
		} while(menu != 7);
		
	} //fim método Main

	public static void listarEstoque() {
		int ii = 0;
		 for ( produto p : produto.getEstoque()) {
			 System.out.println("\n====Produto N°" + ii +"========\n"+ produto.imprimirProduto(p));
			 ii++;
		 }
	}

	public static void cadastroVenda(Scanner entrada) {
		int sair;
		System.out.println("\nPor favor selecione um dos CLIENTES listados pelo número:");
		 int i1 = 0;
		 for (cliente c : cliente.getClienteLista()) {
			 System.out.println("====Cliente N°" + i1 +"========\n"+ cliente.imprimirCliente(c));
			 i1++;
		 }
		 int resp2 = entrada.nextInt();
		 System.out.println("Cliente selecionado: \n"+cliente.imprimirCliente(cliente.getClienteLista().get(resp2)));
		 
		 i1=0;
		 System.out.println("\nPor favor selecione um dos PRODUTOS listados pelo número:");
		 do {
		 for (produto p : produto.getEstoque()) {
			 System.out.println("====Produto N°" + i1 +"========\n"+ produto.imprimirProduto(p));
			 i1++;
		 }
		 i1=0;
		 resp2 = entrada.nextInt();
		 produto selecProd = produto.getEstoque().get(resp2);
		 System.out.println("\nQual foi a quantidade vendida?");
		 resp2 = entrada.nextInt();
		 if (selecProd.getQuantidade() >= 0 ) {
			int total = selecProd.getQuantidade() - resp2;
			if ( total >= 0) {
				selecProd.setQuantidade(total);
			} else {
				System.out.println("\nEssa quantidade não está disponível"); 
				} 
		 } else {
			 System.out.println("\nEsta item está fora de estoque!");
		 }
		 System.out.println("\nQuantidade restante " + selecProd.getQuantidade());
		 System.out.println("\nDeseja cadastrar outra venda?\n 1-sim\n 2-não");
		 sair = entrada.nextInt();
		 
		 } while (sair != 2);
	}

	public static void buscaProduto(Scanner entrada, Scanner entradaString) {
		String nomeDoProduto;
		System.out.println("\nDigite o nome do produto:");
		 nomeDoProduto = entradaString.nextLine();
		 int i3 = 0;
		 int IndProd = 0;
		 for (produto p : produto.getEstoque()) {
			 if (p.getNome().equals(nomeDoProduto)) {
				 IndProd = i3;
			 } else {
				 i3++;
			 }
		 }
		 if (i3 == produto.getEstoque().size()) {
			 System.out.println("\nProduto, não cadastrado!");
		 } else {
			 produto produtoBusca = produto.getEstoque().get(IndProd);
			 System.out.println(produto.imprimirProduto(produtoBusca));
			 System.out.println("\nDeseja alterar algum dado?\n 1-sim\n 2-não");
			 int resp1 = entrada.nextInt();
			 switch (resp1) {
			 case 1: 
				 System.out.println("Novo nome:");
				 produtoBusca.setNome(entradaString.nextLine());
				 System.out.println("Novo descricao: ");
				 produtoBusca.setDescricao(entradaString.nextLine());
				 System.out.println("Novo valor de compra: ");
				 produtoBusca.setValorDeCompra(entradaString.nextLine());
				 System.out.println("Novo porcentagem: ");
				 produtoBusca.setPorcentagem(entradaString.nextLine());
				 System.out.println("Novo quantidade: ");
				 produtoBusca.setQuantidade(entrada.nextInt());
				 break;
			 case 2:
				 System.out.println("\nOs dados não foram alterados!");
				 break;
			default: System.out.println("\nOpcao inválida!");
			 }
		}
	}

	public static void cadastroProduto(Scanner entrada, Scanner entradaString) {
		int quantidade;
		String nomeDoProduto;
		String descricao;
		String valorDeCompra;
		String porcentagem;
		System.out.println("\nQuantos produtos você quer cadastrar?");
		 int ProdutoQtd = entrada.nextInt();
		 for (int iiii=1; iiii<=ProdutoQtd ; iiii++) {
			 System.out.println(iiii + "°-" + "Nome do produto: ");
			 nomeDoProduto = entradaString.nextLine();
			 System.out.println(iiii + "°-" + "Descrição: ");
			 descricao = entradaString.nextLine();
			 System.out.println(iiii + "°-" + "Valor de compra: ");
			 valorDeCompra = entradaString.nextLine();
			 System.out.println(iiii + "°-" + "Porcentagem de lucro: ");
			 porcentagem = entradaString.nextLine();
			 System.out.println(iiii + "°-" + "Quantidade em estoque: ");
			 quantidade = entrada.nextInt();
			 
			 produto p = new produto (nomeDoProduto, descricao, valorDeCompra, porcentagem, quantidade);
			 produto.adicionarProduto(p);
		 }
	}

	public static void buscaCliente(Scanner entrada, Scanner entradaString) {
		String nome;
		System.out.println("\nDigite o nome do cliente que você quer pesquisar:");
		 nome = entradaString.nextLine();
//				 cliente.pesquisarNome(nome);
		 int i2 = 0;
		 int IndCli = 0;
		 for(cliente p:cliente.getClienteLista()){
			 if (p.getNome().equals(nome)) {
				 IndCli = i2;
			 } else {
				 i2++;
			 }
		 }
		 if (i2 == cliente.getClienteLista().size()) {
			 System.out.println("\nCliente, não cadastrado!");
		 } else {
			 cliente clienteBusca = cliente.getClienteLista().get(IndCli);
			 System.out.println(cliente.imprimirCliente(cliente.getClienteLista().get(IndCli)));
			 System.out.println("Deseja alterar algum dado?\n 1-sim\n 2-não");
			 int resp = entrada.nextInt();
			 switch (resp) {
			 case 1:
				 System.out.println("Novo nome:");
				 clienteBusca.setNome(entradaString.nextLine());
				 System.out.println("Novo endereco: ");
				 clienteBusca.setEndereco(entradaString.nextLine());
				 System.out.println("Novo telefone: ");
				 clienteBusca.setTelefone(entradaString.nextLine());
				 break;
			 case 2: 
				 System.out.println("\nOs dados não foram alterados!");
				 break;
			 default: System.out.println("\nOpcao inválida!");
			 }
		 }
	}

	public static void cadastroCliente(Scanner entrada, Scanner entradaString) {
		String nome;
		String endereco;
		String telefone;
		System.out.println("Quantos clientes você gostaria de cadastrar?");
		 int qtd = entrada.nextInt();
//				 int i = 0;
//				 while (qtd != i) {
		 for(int iii=1;iii<=qtd;iii++) {
			 
			 System.out.println( iii + "°- " + "Nome: ");
			 nome = entradaString.nextLine();
//					 c.setNome(entrada.nextLine());
			 
			 System.out.println(iii + "°- " + "Endereço: ");
			 endereco = entradaString.nextLine();
//					 c.setEndereco(entrada.nextLine());
			 
			 System.out.println(iii + "°- " + "Telefone: ");
			 telefone = entradaString.nextLine();
//					 c.setTelefone(entrada.nextLine());
			 cliente c = new cliente (nome,endereco,telefone);
			 
			 cliente.adicionarCliente (c);
		 }
	}
	
	public static void exibirMenu() {
		System.out.println("\n>>>>>>>>> MENU <<<<<<<<<");
		System.out.println("1-Cadastro de novo cliente");
		System.out.println("2- Busca por cliente");
		System.out.println("3- Cadastro de novo produto");
		System.out.println("4- Busca por produto");
		System.out.println("5- Cadastro de venda");
		System.out.println("6- Mostrar produtos em estoque");
		System.out.println("7- Sair");
	}

}// fim CLASS MAIN
