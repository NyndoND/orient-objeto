package view;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import main.Cliente;
import main.Filial;
import main.Vendedor;

public class ViewListarVendedor extends ViewListarPessoa{
	
	public ViewListarVendedor() {
		super();
		
	}
	@Override
	public void listarDados(DefaultTableModel model) {
		getControleVen().modelListarVendedor(model);
	}
	
	//Definindo o que cada botão faz quando a Tela Listar Vendedores
	@Override
	public void actionPerformed(ActionEvent e) {
		if(getCadastrar()== e.getSource()) {
			JInternalFrame frame = new ViewCadVendedor();
			DesktopMenu.addDesktop(frame);
			frame.toFront();
			frame.setVisible(true);
		}
		if (getAlterar()== e.getSource()) {
			int indexObj = getTabela().getSelectedRow();
			
			ViewAlterarVendedor frame = new ViewAlterarVendedor(indexObj);
			DesktopMenu.addDesktop(frame);
			frame.toFront();
			frame.setVisible(true);
			dispose();
		}
		if (getExcluir()== e.getSource()) {
			int indexObj = getTabela().getSelectedRow();
			getControleVen().removerVendedorIndex(indexObj);
			dispose();
		}
		
	}
	@Override
	public void filtrarTabela(String digitado, DefaultTableModel model) {
		getControleVen().filtrarVendedor(model, digitado);
	}
}
