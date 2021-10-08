package controle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.Brinquedo;
import main.Eletronico;
import main.Filial;
import main.JogoDeCarta;
import main.JogoDeTabuleiro;
import main.Pelucia;
import main.Vendedor;


	/**
	 * Classe responsável por todos os métodos intermetidiadores entre o package View e o package main 
	 * @author Renann de Oliveira
	 * @version 1.0 (Out 2021)
	 */
public class ControleBrinquedo {
	
	
	public ControleBrinquedo() {
		
	}
	
	/**
	 * Retorna qual a posicao index da Filial de determinado objeto 
	 * @param int index, esse index é referente a posição do objeto que se quer buscar em uma lista gerada 
	 * @return int indexFilial
	 */
	public int getBrinquedoListaFilialIndex(int index) {
		
		int indexFilial = 0;
		int sizeAntigo = 0;
		int sizeNovo= 0;
		int indexBrin = 0;
		
		for (Filial f : Filial.getListaFilial()) {
			sizeNovo += f.getEstoqueBrinquedo().size();
			if( sizeAntigo < index) {
				if (index < sizeNovo) {
					break;
				} else {
					indexFilial++;
				}
				sizeAntigo += sizeNovo;
			}
		}
		indexBrin = index - sizeAntigo;
		
		return  indexFilial;
	}
	
	/**
	 * Retorna qual a posicao index da Filial de determinado objeto 
	 * @param int index, esse index é referente a posição do objeto que se quer buscar em uma lista gerada 
	 * @return int indexVendedor
	 */
	public int getBrinquedoListaEstoqueIndex (int index) {
		
		int indexFilial = 0;
		int sizeAntigo = 0;
		int sizeNovo= 0;
		int indexBrin = 0;
		
		for (Filial f : Filial.getListaFilial()) {
			sizeNovo += f.getEstoqueBrinquedo().size();
			if( sizeAntigo < index) {
				if (index < sizeNovo) {
					break;
				} else {
					indexFilial++;
				}
				sizeAntigo += sizeNovo;
			}
		}
		indexBrin = index - sizeAntigo;
		
		return indexBrin;
	}
	/**
	 * Recebe um DefaulTableModel e adiciona as linhas de acordo com os dados do ArrayList de brinquedos
	 * @param model
	 */
	public void modelListarBrinquedos(DefaultTableModel model) {
		for (Filial c : Filial.getListaFilial() ) {
			for (Brinquedo b : c.getEstoqueBrinquedo()) {
				String nome = b.getNome();
				double valor = b.getValor();
				int codigo = b.getCodigo();
				int faixaEtaria = b.getFaixaEtaria();
				Double comissao = b.getComissaoVendedor();
				
				Object[] rowData = {nome, valor, codigo, faixaEtaria, comissao};
				
				model.addRow(rowData);
			}
		}
	}
	
	/**
	 * Recebe um DeafaultTableModel e adiciona as linhas de acordo com os dados filtrados do ArrayList de brinquedos
	 * Primeiro é feita uma filtragem por Nome de brinquedos se nenhum deles coincidir com o que foi digitado e feita uma segunda filtragem 
	 * que busca por um codigo de brinquedo igual ao que foi digitado 
	 * @param model
	 * @param digitado
	 */
	public void filtrarBrinquedo(DefaultTableModel model, String digitado) {
		for(Filial f : Filial.getListaFilial()) {
			for (Brinquedo b : f.getEstoqueBrinquedo()) {
				if(b.getNome().equalsIgnoreCase(digitado)) {
					String nome = b.getNome();
					double valor = b.getValor();
					int codigo = b.getCodigo();
					int faixaEtaria = b.getFaixaEtaria();
					Double comissao = b.getComissaoVendedor();
					
					Object[] rowData = {nome, valor, codigo, faixaEtaria, comissao};
					
					model.addRow(rowData);
				} else if (Integer.toString(b.getCodigo()).equalsIgnoreCase(digitado)) {
					String nome = b.getNome();
					double valor = b.getValor();
					int codigo = b.getCodigo();
					int faixaEtaria = b.getFaixaEtaria();
					Double comissao = b.getComissaoVendedor();
					
					Object[] rowData = {nome, valor, codigo, faixaEtaria, comissao};
					
					model.addRow(rowData);
					
				}
			}
		}
	}
	
	/**
	 * Teste se o objeto selecionado da lista é um eletronico e retorna o objeto selecionado na sua classe de origem 
	 * @param index
	 * @return
	 */
	public Eletronico testaClasseEletronico (int index) {
		int indexFil = getBrinquedoListaFilialIndex(index);
		int indexBrin = getBrinquedoListaEstoqueIndex (index);
		Brinquedo b = Filial.getListaFilial().get(indexFil).getEstoqueBrinquedo().get(indexBrin);
		Eletronico elet = null;
		
		if( b instanceof Eletronico){
			elet = (Eletronico) b;
		}
		return elet;
	}
	/**
	 * Teste se o objeto selecionado da lista é um Jogo de carta e retorna o objeto selecionado na sua classe de origem 
	 * @param index
	 * @return
	 */
	public JogoDeCarta testaClasseCarta (int index) {
		int indexFil = getBrinquedoListaFilialIndex(index);
		int indexBrin = getBrinquedoListaEstoqueIndex (index);
		Brinquedo b = Filial.getListaFilial().get(indexFil).getEstoqueBrinquedo().get(indexBrin);
		JogoDeCarta carta = null;
		
		if( b instanceof JogoDeCarta){
			carta = (JogoDeCarta) b;
		}
		return carta;
	}
	/**
	 * Teste se o objeto selecionado da lista é Jogo de Tabuleiro e retorna o objeto selecioando na sua calsse de origem 
	 * @param index
	 * @return
	 */
	public JogoDeTabuleiro testaClasseTabuleiro (int index) {
		int indexFil = getBrinquedoListaFilialIndex(index);
		int indexBrin = getBrinquedoListaEstoqueIndex (index);
		Brinquedo b = Filial.getListaFilial().get(indexFil).getEstoqueBrinquedo().get(indexBrin);
		JogoDeTabuleiro tab = null;
		
		if( b instanceof JogoDeTabuleiro){
			tab = (JogoDeTabuleiro) b;
		}
		return tab;
	}
	/**
	 * Teste se o objeto selecionado da lista é Pelucia e retorna o objeto selecionado na sua calsse de origem 
	 * @param index
	 * @return
	 */
	public Pelucia testaClassePelucia (int index) {
		int indexFil = getBrinquedoListaFilialIndex(index);
		int indexBrin = getBrinquedoListaEstoqueIndex (index);
		Brinquedo b = Filial.getListaFilial().get(indexFil).getEstoqueBrinquedo().get(indexBrin);
		Pelucia pel = null;
		
		if( b instanceof Pelucia){
			pel = (Pelucia) b;
		}
		return pel;
	}
	
	/**
	 * Retorna o nome do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	
	public String getBrinquedoNome (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getNome();
	}
	/**
	 * Retorna o valor do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	public Double getBrinquedoValor (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getValor();
	}
	/**
	 * Retorna a descricao  do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	public String getBrinquedoDescricao (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getDescricao();
	}
	/**
	 * Retorna a faixa etaria do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	public int getBrinquedoFaixaEt (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getFaixaEtaria();
	}
	/**
	 * Retorna a comissao do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	public Double getBrinquedoComissao (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getComissaoVendedor();
	}
	/**
	 * Retorna o lucro do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	public Double getBrinquedoLucro (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getLucro();
	}
	/**
	 * Retorna o codigo do brinquedo selecionado na lista 
	 * @param indexFil
	 * @param indexBrin
	 * @return
	 */
	public int getBrinquedoCodigo (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getCodigo();
	}
	/**
	 * Retorna a fonte do Eletronico selecionado na lista 
	 * @param e
	 * @return
	 */
	public String getEletronicoFonte (Eletronico e) {
		
		return e.getFonteDeEnergia();
	}
	/**
	 * Retorna a garantia do Eeletronico selecionado na lista
	 * @param e
	 * @return
	 */
	public int getEletronicoGarantia (Eletronico e) {
		return e.getGarantia();
	}
	
	/**
	 * Retorna a quantidade de Carta do Jogo de Cartas selecionado na lista 
	 * @param c
	 * @return
	 */
	public int getCartaQtdCartas (JogoDeCarta c) {
		return c.getQtdCartas();
	}

	/**
	 * Retorna a quantidade de Jogadores do Jogo de Carta selecionado na lista 
	 * @param c
	 * @return
	 */
	public int getCartaQtdJogadores (JogoDeCarta c) {
		return c.getQtdJogadores();
	}
	
	/**
	 * Retorna o peso da Pelucia selecionada na lista 
	 * @param p
	 * @return
	 */
	public Double getPeluciaPeso (Pelucia p) {
		return p.getPeso();
		}
	/**
	 * Retorna a quantidade de jogadores do Jogo de tabuleiro selecionado na lista 
	 * @param t
	 * @return
	 */
	public int getTabuleiroQtdJogadores (JogoDeTabuleiro t) {
		return t.getQuantosJogadores();
	}
	
	/**
	 * Retorna o tempo medio de jogo do Jogo de tabuleiro selecionado na lista 
	 * @param t
	 * @return
	 */
	public Double getTabuleiroTempo (JogoDeTabuleiro t) {
		return t.getTempoMedio();
	}
	
	/**
	 * Cadastrar um Eletronico e adiciona ele na lista de brinquedos da Filial fornecida no parametro e com os atributos fornecidos
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param fonteEnergia
	 * @param garantia
	 * @param index
	 */
	public void cadastrarEletronicoIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, String fonteEnergia, int garantia, int index) {
		Eletronico eletronico = new Eletronico(nome, valor, descricao, faixaEt, comissao, lucro, codigo,fonteEnergia,garantia);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(eletronico);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Cadastrar um Jogo de Carta e adiciona ele na lista de brinquedos da Filial fornecida no parametro e com os atributos fornecidos
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param qtdCartas
	 * @param qtdJogadores
	 * @param index
	 */
	public void cadastrarCartaIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, int qtdCartas, int qtdJogadores, int index) {
		JogoDeCarta carta = new JogoDeCarta(nome, valor, descricao, faixaEt, comissao, lucro, codigo, qtdCartas, qtdJogadores);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(carta);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	/**
	 * Cadastra uma Pelucia e adiciona ela na lista de brinquedos da Filial fornecida no parametro e com os atributos fornecidos
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param peso
	 * @param index
	 */
	public void cadastrarPeluciaIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, Double peso, int index) {
		Pelucia pelucia= new Pelucia(nome, valor, descricao, faixaEt, comissao, lucro, codigo, peso);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(pelucia);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	/**
	 * Cadastrar um Jogo de tabuleiro e adiciona ele na lista de brinquedos da Filial fornecida no parametro e com os atributos fornecidos
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param qtdJogadores
	 * @param tempo
	 * @param index
	 */
	public void cadastrarTabuleiroIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, int qtdJogadores, Double tempo, int index) {
		JogoDeTabuleiro tabuleiro = new JogoDeTabuleiro(nome, valor, descricao, faixaEt, comissao, lucro, codigo, qtdJogadores, tempo);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(tabuleiro);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	/**
	 * Busca e altera um eletronico de acordo com os novo atributos fornecidos 
	 * @param indexFil
	 * @param indexBrin
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param fonteEnergia
	 * @param garantia
	 * @param newIndexFil
	 */
	public void alterarEletronicoIndex(int indexFil, int indexBrin,String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, String fonteEnergia, int garantia ,int newIndexFil) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		Brinquedo brin = filial.getEstoqueBrinquedo().get(indexBrin);
		Eletronico eletr = (Eletronico) brin;
		eletr.setNome(nome);
		eletr.setValor(valor);
		eletr.setDescricao(descricao);
		eletr.setFaixaEtaria(faixaEt);
		eletr.setComissaoVendedor(comissao);
		eletr.setLucro(lucro);
		eletr.setCodigo(codigo);
		eletr.setFonteDeEnergia(fonteEnergia);
		eletr.setGarantia(garantia);
		
		if (filial != Filial.getListaFilial().get(newIndexFil)) {
			filial.getEstoqueBrinquedo().remove(brin);
			Filial.getListaFilial().get(newIndexFil).getEstoqueBrinquedo().add(brin);
		}
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Busca e alterar um Jogo de carta de acordo com os novos atributos fornecidos 
	 * @param indexFil
	 * @param indexBrin
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param qtdCartas
	 * @param qtdJogadores
	 * @param newIndexFil
	 */
	public void alterarCartaIndex(int indexFil, int indexBrin,String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo,  int qtdCartas, int qtdJogadores ,int newIndexFil) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		Brinquedo brin = filial.getEstoqueBrinquedo().get(indexBrin);
		JogoDeCarta carta = (JogoDeCarta) brin;
		carta.setNome(nome);
		carta.setValor(valor);
		carta.setDescricao(descricao);
		carta.setFaixaEtaria(faixaEt);
		carta.setComissaoVendedor(comissao);
		carta.setLucro(lucro);
		carta.setCodigo(codigo);
		carta.setQtdCartas(qtdCartas);
		carta.setQtdJogadores(qtdJogadores);
		
		if (filial != Filial.getListaFilial().get(newIndexFil)) {
			filial.getEstoqueBrinquedo().remove(brin);
			Filial.getListaFilial().get(newIndexFil).getEstoqueBrinquedo().add(brin);
		}
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Busca e altera uma Pelucia de acordo com os novos parametros fornecidos 
	 * @param indexFil
	 * @param indexBrin
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param peso
	 * @param newIndexFil
	 */
	public void alterarPeluciaIndex(int indexFil, int indexBrin,String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, Double peso  ,int newIndexFil) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		Brinquedo brin = filial.getEstoqueBrinquedo().get(indexBrin);
		Pelucia pel = (Pelucia) brin;
		pel.setNome(nome);
		pel.setValor(valor);
		pel.setDescricao(descricao);
		pel.setFaixaEtaria(faixaEt);
		pel.setComissaoVendedor(comissao);
		pel.setLucro(lucro);
		pel.setCodigo(codigo);
		pel.setPeso(peso);
		
		if (filial != Filial.getListaFilial().get(newIndexFil)) {
			filial.getEstoqueBrinquedo().remove(brin);
			Filial.getListaFilial().get(newIndexFil).getEstoqueBrinquedo().add(brin);
		}
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Busca e alterar um jogo de tabuleiro de acordo com os novos parametros fornecidos 
	 * @param indexFil
	 * @param indexBrin
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param faixaEt
	 * @param comissao
	 * @param lucro
	 * @param codigo
	 * @param qtdJogadores
	 * @param tempo
	 * @param newIndexFil
	 */
	public void alterarTabuleiroIndex(int indexFil, int indexBrin,String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo,  int qtdJogadores, Double tempo ,int newIndexFil) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		Brinquedo brin = filial.getEstoqueBrinquedo().get(indexBrin);
		JogoDeTabuleiro tab = (JogoDeTabuleiro) brin;
		tab.setNome(nome);
		tab.setValor(valor);
		tab.setDescricao(descricao);
		tab.setFaixaEtaria(faixaEt);
		tab.setComissaoVendedor(comissao);
		tab.setLucro(lucro);
		tab.setCodigo(codigo);
		tab.setTempoMedio(tempo);
		tab.setQuantosJogadores(qtdJogadores);
		
		if (filial != Filial.getListaFilial().get(newIndexFil)) {
			filial.getEstoqueBrinquedo().remove(brin);
			Filial.getListaFilial().get(newIndexFil).getEstoqueBrinquedo().add(brin);
		}
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	/**
	 * Busca um objeto de acordo com o index dele na lista da view e em seguida exclui ele
	 * @param index
	 */
	public void removerBrinquedoIndex(int index) {
		int indexFil = getBrinquedoListaFilialIndex(index);
		int indexBrin = getBrinquedoListaEstoqueIndex (index);
		Filial.getListaFilial().get(indexFil).getEstoqueBrinquedo().remove(indexBrin);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	
}
