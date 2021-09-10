package main;

import java.util.Date;
import java.util.GregorianCalendar;

public class Main {
	public static void main(String[] args) {
		
	GregorianCalendar d = new GregorianCalendar();
	Date agora = d.getTime();
	
	//Dados de Brinquedos
	Eletronico e1 = new Eletronico ("dinossauro", 20.95, "descrição foda", 14, 0.05, 0.1, 222030230, "pilhas", 2);
	Eletronico e2 = new Eletronico ("lagartixa", 18.80, "descrição foda", 11, 0.05, 0.1, 225435430, "bateria", 1);
	JogoDeCarta jc1 = new JogoDeCarta("UNO", 20.56, "descricao", 14, 20.56, 0.02, 304200020, 42, 5);
	JogoDeCarta jc2 = new JogoDeCarta("Truco", 85.56, "descricao", 18, 0.01, 0.02, 304256020, 42, 4);
	Pelucia p1 = new Pelucia("ursinho", 25.66, "descricao",15 ,0.5, 0.01, 22356262, 20);
	Pelucia p2 = new Pelucia("bonequinho", 25.66, "descricao",15 ,0.5, 0.01, 22356262, 20);
	JogoDeTabuleiro jt1 = new JogoDeTabuleiro("Jogo da Vida", 42.50, "descricao", 11, 0.02, 0.03, 22053230, 5, 2);
	JogoDeTabuleiro jt2 = new JogoDeTabuleiro("Duna", 80.66, "descricao", 18, 0.01, 0.04, 24543230, 8, 4);
	
	
	//Dados de Clientes e Vendedores
	Cliente c1 = new Cliente ("Renann", 9969696, "Cidade_Ocidental");
	Cliente c2 = new Cliente ("Igor", 3214846, "Goiânia");
	Cliente c3 = new Cliente ("Robson", 31314, "Brasília");
	Vendedor v1 = new Vendedor ("Andre", 3164663, "Brasília", 32132132, agora,850);
	Vendedor v2 = new Vendedor ("Kamila", 1314132, "lago sul", 31465463, agora,1600);
	Vendedor v3 = new Vendedor ("Teixeira", 32131, "Gama", 1321634, agora,3000);
	
	//Dados de Filial e Venda
	Filial f1 = new Filial("Brasília",v1);
	Filial f2 = new Filial("Valparaiso", v2);
	Venda vd1 = new Venda(v1, c1, e1, 1, f1);
	Venda vd2 = new Venda(v2, c2, jc1, 2, f2);
	Venda vd3 = new Venda(v2, c1, p2, 3, f2);
	Venda vd4 = new Venda(v3, c3, jt1, 5, f2);
	
	f1.addEstoqueBrinquedo(e1);
	f1.addEstoqueBrinquedo(e1); //teste para verificar se é possível adicionar objetos iguais 
	f1.addEstoqueBrinquedo(jc1);
	f1.addEstoqueBrinquedo(p1);
	f1.addEstoqueBrinquedo(jt1);
	
//	System.out.println(e1.toString());
//	System.out.println(jc1.toString());
//	System.out.println(p1.toString());
//	System.out.println(jt1.toString());
	System.out.println(f1.toString());
	}
}