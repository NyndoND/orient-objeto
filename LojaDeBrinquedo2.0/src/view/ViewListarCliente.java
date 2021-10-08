package view;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ControleCliente;
import main.Cliente;
/**
 * Classe da tela de lista clientes 
 * @author renan
 *
 */
public class ViewListarCliente extends ViewListarPessoa{
	

	/**
	 * Metodo construtor simples, lista especificamnete apenas objetos cliente
	 */
	public ViewListarCliente () {
		super();
		
	}
	/**
	 * Metodo construtor porem pode-se forncer um model pra criar um lista com clientes filtrados 
	 * @param model
	 */
	public ViewListarCliente(DefaultTableModel model) {
		super();
		JTable tabela = getTabela();
		tabela.setModel(null);
		JScrollPane scroll = new JScrollPane(tabela);
		add(scroll);
	}
	
	/**
	 * Adiciona no model linhas com os dados de cada cliente 
	 */
	//Define que os dados da tabela vão ser tirados desse ArrayList
	@Override
	public void listarDados(DefaultTableModel model) {
		getControleCli().modelListarClientes(model);
	}
	
	/**
	 * Metodo sobrescrito para definir o que cada botao faz nessa tela
	 */
	//Definindo o que cada botão faz quando listar Clientes
	@Override
	public void actionPerformed(ActionEvent e) {
		if (getCadastrar()== e.getSource()) {
			JInternalFrame frame = new ViewCadCliente();
			DesktopMenu.addDesktop(frame);
			frame.toFront();
			frame.setVisible(true);
		}
		if (getAlterar()== e.getSource()) {
			int indexObj = getTabela().getSelectedRow();
			
			ViewAlterarCliente frame = new ViewAlterarCliente(indexObj);
			DesktopMenu.addDesktop(frame);
			frame.toFront();
			frame.setVisible(true);
			dispose();
		}
		if (getExcluir()== e.getSource()) {
			int indexObj = getTabela().getSelectedRow();
			getControleCli().removerClienteIndex(indexObj);
			dispose();
		}
	}

	/**
	 * filtra os clientes de acordo com o que foi digitado, primeiro por cpf depois por nome 
	 */
	@Override
	public void filtrarTabela(String digitado, DefaultTableModel model) {
			getControleCli().filtrarCliente(model, digitado);
	}

}
