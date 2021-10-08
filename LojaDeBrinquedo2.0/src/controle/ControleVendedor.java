package controle;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.Cliente;
import main.Filial;
import main.Vendedor;

public class ControleVendedor {

	public ControleVendedor () {
		
	}
	
	public int getVendedorListaFilialIndex (int index) {
		/*
		 * A logica se baseia na busca pelo Index, contudo temos que fazer essa busca em uma lista
		 * que é gerada com outras listas, basicamente pegamos o index do que queremos, depois
		 * verificamos em qual intervalo ele se encontra comparando o tamanho de cada lista, depois 
		 * para descobrir especificamente em qual posição ele está subtraimos o valor do index que buscamos
		 * pelo valor da soma do "tamanho" de todos intervalos anteriores.
		 * EX: imagine 10 lapis, 6 azuis e 4 vermelhos, e vc escolheu o lapis de index 6 (ou seja o 7° lapis)
		 * 6 não é menor que 6 (tamanho do conjunto de lapis azul), logo vamos para o proximo conjunto, 6 é menor 
		 * que 13, logo ele está nesse úlitmo conjunto (lapis vermelhos), contudo se subtrairmos, 6 (index do seu lapis)
		 * menos 6 (numero total de itens de todos os conjuntos passados), temos 0 que é o index do seu lapis
		 * no conjunto de lapis vermelhos. 
		 */
		int indexFilial = 0;
		int sizeAntigo = 0;
		int sizeNovo= 0;
		int indexVen = 0;
		
		for (Filial f : Filial.getListaFilial()) {
			sizeNovo += f.getListaVendedor().size();
			if( sizeAntigo < index) {
				if (index < sizeNovo) {
					break;
				} else {
					indexFilial++;
				}
				sizeAntigo += sizeNovo;
			}
		}
		indexVen = index - sizeAntigo;
		
		return  indexFilial;
	}
	
	public int getVendedorListaVendedorIndex (int index) {
		int indexFilial = 0;
		int sizeAntigo = 0;
		int sizeNovo= 0;
		int indexVen = 0;
		
		for (Filial f : Filial.getListaFilial()) {
			sizeNovo += f.getListaVendedor().size();
			if( sizeAntigo < index) {
				if (index < sizeNovo) {
					break;
				} else {
					indexFilial++;
				}
				sizeAntigo += sizeNovo;
			}
		}
		indexVen = index - sizeAntigo;
		
		return  indexVen;
	}
	
	public void filtrarVendedor(DefaultTableModel model, String digitado) {
		for(Filial f : Filial.getListaFilial()) {
			for (Vendedor v : f.getListaVendedor()) {
				if(Integer.toString(v.getCpf()).equalsIgnoreCase(digitado)) {
					String nome = v.getNome();
					int telefone = v.getTelefone();
					String endereco = v.getEndereco();
				
					Object[] rowData = {nome, telefone, endereco};
					model.addRow(rowData);
				} else if(v.getNome().equalsIgnoreCase(digitado)) {
					String nome = v.getNome();
					int telefone = v.getTelefone();
					String endereco = v.getEndereco();
				
					Object[] rowData = {nome, telefone, endereco};
					model.addRow(rowData);
				}
			}
		}
	}
	
	
	public String getVendedorNome (int indexFil, int indexVen) {
		
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getListaVendedor().get(indexVen).getNome();
	}
	
	public String getVendedorTelefone (int indexFil, int indexVen) {
		
		Filial filial = Filial.getListaFilial().get(indexFil);
		return Integer.toString(filial.getListaVendedor().get(indexVen).getTelefone());
	}
	
	public String getVendedorEndereco(int indexFil, int indexVen) {
		
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getListaVendedor().get(indexVen).getEndereco();
	}
	
	public String getVendedorCpf(int indexFil, int indexVen) {
		
		Filial filial = Filial.getListaFilial().get(indexFil);
		return Integer.toString(filial.getListaVendedor().get(indexVen).getCpf());
	}
	
	public String getVendedorDataContrato(int indexFil, int indexVen) {
		
		Filial filial = Filial.getListaFilial().get(indexFil);
		return filial.getListaVendedor().get(indexVen).getDataContratacao().toString();
	}
	
	public String getVendedorSalario(int indexFil, int indexVen) {
		
		Filial filial = Filial.getListaFilial().get(indexFil);
		return Double.toString(filial.getListaVendedor().get(indexVen).getSalario());
	}
	
	public void modelListarVendedor(DefaultTableModel model) {
		//é importante perceber que ele adiciona os vendedores na ordem que as filiais estão no ArrayList
		for (Filial c : Filial.getListaFilial() ) {
			for (Vendedor v : c.getListaVendedor()) {
				String nome = v.getNome();
				int telefone = v.getTelefone();
				String endereco = v.getEndereco();
				
				Object[] rowData = {nome, telefone, endereco};
				
				model.addRow(rowData);
			}
		}
	}
	public void cadastrarVendedor(String nome, int telefone, String endereco, int cpf, Date data, double salario, int index) {
		Vendedor vendedor = new Vendedor(nome, telefone, endereco, cpf, data, salario);
		Filial.getListaFilial().get(index).addVendedor(vendedor);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void alterarVendedorIndex(int indexFil, int indexVen, String nome, int telefone, String endereco, int cpf, Date data, double salario, int newIndexFil) {
		Filial filial = Filial.getListaFilial().get(indexFil); 
		Vendedor vendedor = filial.getListaVendedor().get(indexVen);
		vendedor.setNome(nome);
		vendedor.setTelefone(telefone);
		vendedor.setEndereco(endereco);
		vendedor.setCpf(cpf);
		vendedor.setDataContratacao(data);
		vendedor.setSalario(salario);
		
		if(filial != Filial.getListaFilial().get(newIndexFil)) {
			filial.getListaVendedor().remove(vendedor);
			Filial.getListaFilial().get(newIndexFil).getListaVendedor().add(vendedor);
		}
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void removerVendedorIndex(int index) {
		int indexFil = getVendedorListaFilialIndex(index);
		int indexVen = getVendedorListaVendedorIndex(index);
		Filial.getListaFilial().get(indexFil).getListaVendedor().remove(indexVen);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);

	}
	
	public void removerVendedor(Vendedor v) {
		
	}
}
