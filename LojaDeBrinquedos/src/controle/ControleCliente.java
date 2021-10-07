package controle;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.Cliente;
import view.DesktopMenu;
import view.ViewCadCliente;

public class ControleCliente {
	
	public ControleCliente() {
		
	}
	
	
	public String getClienteNome(int index) {
		
		Cliente cliente = Cliente.getListaCliente().get(index);
		String nome = cliente.getNome();
		return nome;
	}
	
	public String getClienteTelefone(int index) {
		Cliente cliente = Cliente.getListaCliente().get(index);
		String telefone = Integer.toString(cliente.getTelefone());
		return telefone;
	}
	
	public String getEnderecoCliente(int index) {
		Cliente cliente = Cliente.getListaCliente().get(index);
		String endereco = cliente.getEndereco();
		return endereco;
	}
	
	public void modelListarClientes(DefaultTableModel model) {
		for (Cliente c : Cliente.getListaCliente() ) {
			String nome = c.getNome();
			int telefone = c.getTelefone();
			String endereco = c.getEndereco();
			
			Object[] rowData = {nome, telefone, endereco};
			
			model.addRow(rowData);
		}
	}
	
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
	
	public void alterarCliente(Cliente c, String nome, int telefone, String endereco) {
	
		c.setNome(nome);
		c.setTelefone(telefone);
		c.setEndereco(endereco);
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
		}
	
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
	
	public void alterarClienteIndex (int index, String nome, int telefone, String endereco) {
		Cliente cliente = Cliente.getListaCliente().get(index);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setEndereco(endereco);
		JOptionPane.showMessageDialog(null, "Alterado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void cadastrarCliente(String nome, int telefone, String endereco) {
		
		Cliente cliente = new Cliente(nome, telefone, endereco);
		Cliente.getListaCliente().add(cliente);
		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	public void removerCliente(Cliente c) {
		Cliente.getListaCliente().remove(c);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
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
	
	public void removerClienteIndex(int index) {
		Cliente.getListaCliente().remove(index);
		JOptionPane.showMessageDialog(null, "Removido com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
