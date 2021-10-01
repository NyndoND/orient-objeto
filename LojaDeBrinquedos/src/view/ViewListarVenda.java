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
import javax.swing.table.DefaultTableModel;

import main.Brinquedo;
import main.Filial;
import main.Venda;

public class ViewListarVenda extends JInternalFrame{

	private JTable tabela;
	private JButton cadastrar;
	private JButton excluir;
	private JButton alterar;
	private JPanel botoes;
	public ViewListarVenda() {
		super("Listar Brinquedos", true, true, true, true);
		setSize(800,200);
		setLocation(30, 30);
		
		//Adicionando os botes na parte de baixo da tela
				botoes = new JPanel();
				botoes.setLayout(new GridLayout());
				
				cadastrar = new JButton("Cadastrar");
				cadastrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Cadastrou alguem aí");
					}
				});
				
				alterar = new JButton("Alterar");
				alterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Alterou alguem aí");
					}
				});
				
				excluir = new JButton("Excluir");
				excluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Excluiu alguem aí");
					}
				});
				
				botoes.add(cadastrar);
				botoes.add(alterar);
				botoes.add(excluir);
				add(botoes, BorderLayout.SOUTH);
				
				//Criando a tabela 
				tabela = new JTable(){
					@Override
					public boolean isCellEditable(int row, int column) {                
		                return false;               
					};
				};
				DefaultTableModel model = new DefaultTableModel();
				tabela.setModel(model);
				tabela.setBackground(Color.LIGHT_GRAY);
				tabela.setForeground(Color.black);
				tabela.setRowHeight(30);
				
				Object[] columns = {"Vendedor", "Cliente", "Brinquedo", "Quantidade", "Local"}; //Definindo colunas
				model.setColumnIdentifiers(columns);
				
				for (Filial c : Filial.getListaFilial() ) {
					for (Venda v : c.getListaVenda()) {
						String vendedor = v.getVendedor().getNome();
						String cliente = v.getCliente().getNome();
						String brinquedo = v.getBrinquedo().getNome();
						int quantidade = v.getQtdVenda();
						String local = v.getLocal().getLocal();
						
						Object[] rowData = {vendedor, cliente, brinquedo, quantidade, local};
						
						model.addRow(rowData);
					}
				}
				
				JScrollPane scroll = new JScrollPane(tabela);
				add(scroll);
				
	}
}
