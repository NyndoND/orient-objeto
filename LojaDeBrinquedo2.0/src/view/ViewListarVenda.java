package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import controle.ControleVenda;
import main.Brinquedo;
import main.Filial;
import main.Venda;
/**
 * Classe da tela de listar venda 
 * @author renan
 *
 */
public class ViewListarVenda extends JInternalFrame{

	private JTable tabela;
	private DefaultTableModel model;
	
	private JButton botaoFil = null;
	private JToolBar barra = null;
	private JTextField pesquisa = null;
	
	private ControleVenda controle = new ControleVenda(); 
	
	/**
	 * Metodo construtor da classe, cria a tela que lista todas as vendas
	 */
	public ViewListarVenda() {
		super("Listar Brinquedos", true, true, true, true);
		setSize(800,500);
		setLocation(30, 30);
		
		//Adicionando a barra de pesquisa em cima 
		barra = new JToolBar();
		pesquisa = new JTextField(50);
		botaoFil = new JButton(new IconeJButton().getIconeFiltrar());
		botaoFil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = null;
				model = new DefaultTableModel();
				Object[] columns = {"Vendedor", "Cliente", "Brinquedo", "Quantidade", "Local"};
				model.setColumnIdentifiers(columns);
				filtrarTabela(pesquisa.getText(), model);
				tabela.setModel(model);
			}
		 });
		barra.add(pesquisa);
		barra.add(botaoFil);
		add(barra, BorderLayout.NORTH);
				
				//Criando a tabela 
				tabela = new JTable(){
					@Override
					public boolean isCellEditable(int row, int column) {                
		                return false;               
					};
				};
				model = new DefaultTableModel();
				tabela.setModel(model);
				tabela.setBackground(Color.LIGHT_GRAY);
				tabela.setForeground(Color.black);
				tabela.setRowHeight(30);
				
				Object[] columns = {"Vendedor", "Cliente", "Brinquedo", "Quantidade", "Local"}; //Definindo colunas
				model.setColumnIdentifiers(columns);
				
				
				listarDados(model);
				JScrollPane scroll = new JScrollPane(tabela);
				add(scroll);
				
	}
	
	/**
	 * Adiciona no model as linhas com os dados de cada venda
	 * @param model
	 */
	public void listarDados(DefaultTableModel model) {
		controle.modelListarVenda(model);
	}
	
	/**
	 * Filtra a tabela, gerando um novo model apenas com as linhas das venda que a filtragem coincide 
	 * @param digitado
	 * @param model
	 */
	public void filtrarTabela(String digitado, DefaultTableModel model) {
		controle.filtrarVenda(model, digitado);
	}
}
