package view;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ControleCliente;
import main.Cliente;

public class ViewListarCliente extends ViewListarPessoa{
	

	public ViewListarCliente () {
		super();
		
	}
	
	public ViewListarCliente(DefaultTableModel model) {
		super();
		JTable tabela = getTabela();
		tabela.setModel(null);
		JScrollPane scroll = new JScrollPane(tabela);
		add(scroll);
	}
	
	//Define que os dados da tabela vão ser tirados desse ArrayList
	@Override
	public void listarDados(DefaultTableModel model) {
		getControleCli().modelListarClientes(model);
	}

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

	@Override
	public void filtrarTabela(String digitado, DefaultTableModel model) {
			getControleCli().filtrarCliente(model, digitado);
	}

}
