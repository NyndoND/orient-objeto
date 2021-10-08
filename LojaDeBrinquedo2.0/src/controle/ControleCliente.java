package controle;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.Cliente;
import view.DesktopMenu;
import view.ViewCadCliente;

/**
 * Classe responsável por todos os métodos intermetidiadores relacionados a objetos cliente, e fazer uma
 * ligacao  entre o package View e o package main 
 * @author Renann de Oliveira
 * @version 1.0 (Out 2021)
 */
public class ControleCliente {
	
	
	public ControleCliente() {
		
	}
	
	/**
	 * Retorna o nome de um objeto Cliente de acordo com o seu index na lista da view 
	 * @param index
	 * @return
	 */
	public String getClienteNome(int index) {
		
		Cliente cliente = Cliente.getListaCliente().get(index);
		String nome = cliente.getNome();
		return nome;
	}
	
	/**
	 * Retorna o telefone de um cliente de acordo com o seu index na lista da view 
	 * @param index
	 * @return
	 */
	public String getClienteTelefone(int index) {
		Cliente cliente = Cliente.getListaCliente().get(index);
		String telefone = Integer.toString(cliente.getTelefone());
		return telefone;
	}
	
	/**
	 * Retorna o endereco de um cliente de acordo com o seu index na lista da view 
	 * @param index
	 * @return
	 */
	public String getEnderecoCliente(int index) {
		Cliente cliente = Cliente.getListaCliente().get(index);
		String endereco = cliente.getEndereco();
		return endereco;
	}
	
	/**
	 * Adiciona ao model que ele recebe, linhas de acordo com os dados do ArrayList de clientes
	 * @param model
	 */
	public void modelListarClientes(DefaultTableModel model) {
		for (Cliente c : Cliente.getListaCliente() ) {
			String nome = c.getNome();
			int telefone = c.getTelefone();
			String endereco = c.getEndereco();
			
			Object[] rowData = {nome, telefone, endereco};
			
			model.addRow(rowData);
		}
	}
	
	/**
	 * Modifica o model que gera lista da view, em vez de adicinar linhas com os dados de todos os objetos do ArrayList de Cliente, adiciona apenas
	 * o dados dos clientes filtrados por cpf (em que o cpf é igual ao que foi digitado), e se não der nenhum resultado filtra por nome (em que o nome é igual ao que foi digitado 
	 * @param model
	 * @param digitado
	 */
	public void filtrarCliente(DefaultTableModel model, String digitado) {
		for (Cliente c : Cliente.getListaCliente()) {
			if(Integer.toString(c.getCpf()).equalsIgnoreCase(digitado)) {
				String nome = c.getNome();
				int telefone = c.getTelefone();
				String endereco = c.getEndereco();
				
				Object[] rowData = {nome, telefone, endereco};
				model.addRow(rowData);
			} else if(c.getNome().equalsIgnoreCase(digitado)) {
				String nome = c.getNome();
				int telefone = c.getTelefone();
				String endereco = c.getEndereco();
				
				Object[] rowData = {nome, telefone, endereco};
				model.addRow(rowData);
			}
		}
	}
	
	/**
	 * Altera o client fornrcido no parametros de acordo com os novos atributos fornecidos 
	 * @param c
	 * @param nome
	 * @param telefone
	 * @param endereco
	 */
	public void alterarCliente(Cliente c, String nome, int telefone, String endereco) {
	
		c.setNome(nome);
		c.setTelefone(telefone);
		c.setEndereco(endereco);
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
		}
	
	/**
	 * Busca o cliente de acordo com o nome fornecido e altera ele com os novos atributos 
	 * @param nome
	 * @param nomeNovo
	 * @param telefone
	 * @param endereco
	 */
	public void alterarClienteNome(String nome, String nomeNovo, int telefone, String endereco) {
		int i = 0;
		int IndC = 0;
		for(Cliente c : Cliente.getListaCliente()) {
			if (c.getNome().equals(nome)) {
				IndC = i;
			} else {
				i++;
			}
		}
		Cliente cliente = Cliente.getListaCliente().get(IndC);
		cliente.setNome(nomeNovo);
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * busca o objeto cliente de acordo com o index e altera com os novos atributos fornecidos 
	 * @param index
	 * @param nome
	 * @param telefone
	 * @param endereco
	 */
	public void alterarClienteIndex (int index, String nome, int telefone, String endereco) {
		Cliente cliente = Cliente.getListaCliente().get(index);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Cria e adiciona o novo cliente criado na lista de clientes
	 * @param nome
	 * @param telefone
	 * @param endereco
	 */
	public void cadastrarCliente(String nome, int telefone, String endereco) {
		
		Cliente cliente = new Cliente(nome, telefone, endereco);
		Cliente.getListaCliente().add(cliente);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	/**
	 * remove o objetos cliente fornecido da lista de clientes
	 */
	public void removerCliente(Cliente c) {
		Cliente.getListaCliente().remove(c);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * remove um objeto cliente de acordo com o nome do cliente
	 * @param nome
	 */
	public void removerClienteNome(String nome) {
		int i = 0;
		int IndC = 0;
		for(Cliente c : Cliente.getListaCliente()) {
			if (c.getNome().equals(nome)) {
				IndC = i;
			} else {
				i++;
			}
		}
		Cliente cliente = Cliente.getListaCliente().get(IndC);
		Cliente.getListaCliente().remove(cliente);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * remove um objeto cliente de acordo com o index dele no ArrayList de clientes
	 * @param index
	 */
	public void removerClienteIndex(int index) {
		Cliente.getListaCliente().remove(index);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
