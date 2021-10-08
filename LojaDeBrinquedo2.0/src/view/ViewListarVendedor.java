package view;

import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

import main.Cliente;
import main.Filial;
import main.Vendedor;
/**
 * Classe da tela de lista vendedores 
 * @author renan
 *
 */
public class ViewListarVendedor extends ViewListarPessoa{
	
	/**
	 * Metodo construtor simples, apenas com execução do construtor da superClasse 
	 */
	public ViewListarVendedor() {
		super();
		
	}
	
	/**
	 * Metodo sobrescrito especificando que o model deve ser gerado usando a lista de vendedores de todas as filiais 
	 */
	@Override
	public void listarDados(DefaultTableModel model) {
		getControleVen().modelListarVendedor(model);
	}
	
	/**
	 * Metodo sobrescrito especificando que cada botão nessa tela fara uma acao diferente
	 * respectivamente cada botao, tera a acao de, cadastrar, alterar e excluir, desde que já se tenha selecionado algum objeto da lista
	 */
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
	/**
	 * troca o model que gera a tabela com todos os vendedores, por um model que possui apenas as linhas com dados dos vendedores que 
	 * correspodem a busca, primeiro filtrasse por cpf e em seguida por nome  
	 */
	@Override
	public void filtrarTabela(String digitado, DefaultTableModel model) {
		getControleVen().filtrarVendedor(model, digitado);
	}
}
