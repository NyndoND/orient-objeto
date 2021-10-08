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

public class ControleBrinquedo {
	
	public ControleBrinquedo() {
		
	}
	
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
	
	public String getBrinquedoNome (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getNome();
	}
	
	public Double getBrinquedoValor (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getValor();
	}
	
	public String getBrinquedoDescricao (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getDescricao();
	}
	
	public int getBrinquedoFaixaEt (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getFaixaEtaria();
	}
	
	public Double getBrinquedoComissao (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getComissaoVendedor();
	}
	
	public Double getBrinquedoLucro (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getLucro();
	}
	
	public int getBrinquedoCodigo (int indexFil, int indexBrin) {
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getEstoqueBrinquedo().get(indexBrin).getCodigo();
	}
	
	public String getEletronicoFonte (Eletronico e) {
		
		return e.getFonteDeEnergia();
	}
	
	public int getEletronicoGarantia (Eletronico e) {
		return e.getGarantia();
	}
	
	public int getCartaQtdCartas (JogoDeCarta c) {
		return c.getQtdCartas();
	}

	public int getCartaQtdJogadores (JogoDeCarta c) {
		return c.getQtdJogadores();
	}
	
	public Double getPeluciaPeso (Pelucia p) {
		return p.getPeso();
		}
	
	public int getTabuleiroQtdJogadores (JogoDeTabuleiro t) {
		return t.getQuantosJogadores();
	}
	
	public Double getTabuleiroTempo (JogoDeTabuleiro t) {
		return t.getTempoMedio();
	}
	
	public void cadastrarEletronicoIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, String fonteEnergia, int garantia, int index) {
		Eletronico eletronico = new Eletronico(nome, valor, descricao, faixaEt, comissao, lucro, codigo,fonteEnergia,garantia);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(eletronico);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void cadastrarCartaIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, int qtdCartas, int qtdJogadores, int index) {
		JogoDeCarta carta = new JogoDeCarta(nome, valor, descricao, faixaEt, comissao, lucro, codigo, qtdCartas, qtdJogadores);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(carta);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void cadastrarPeluciaIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, Double peso, int index) {
		Pelucia pelucia= new Pelucia(nome, valor, descricao, faixaEt, comissao, lucro, codigo, peso);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(pelucia);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void cadastrarTabuleiroIndex(String nome, Double valor, String descricao, int faixaEt, Double comissao, Double lucro, int codigo, int qtdJogadores, Double tempo, int index) {
		JogoDeTabuleiro tabuleiro = new JogoDeTabuleiro(nome, valor, descricao, faixaEt, comissao, lucro, codigo, qtdJogadores, tempo);
		Filial.getListaFilial().get(index).getEstoqueBrinquedo().add(tabuleiro);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
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
	
	public void removerBrinquedoIndex(int index) {
		int indexFil = getBrinquedoListaFilialIndex(index);
		int indexBrin = getBrinquedoListaEstoqueIndex (index);
		Filial.getListaFilial().get(indexFil).getEstoqueBrinquedo().remove(indexBrin);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	
}
