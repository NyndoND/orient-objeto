package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Cliente;

public abstract class ViewListarPessoa extends JInternalFrame{

	
	private JTable tabela;
	private JButton cadastrar;
	private JButton excluir;
	private JButton alterar;
	private JPanel botoes;
	
	
	public ViewListarPessoa() {
		super("Listar Pessoa", true, true, true, true);
		setSize(800,200);
		setLocation(30, 30);
		
		//Adicionando os botes na parte de baixo da tela
		botoes = new JPanel();
		botoes.setLayout(new GridLayout());
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cadastrou alguem a�");
			}
		});
		
		alterar = new JButton("Alterar");
		alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Alterou alguem a�");
			}
		});
		
		excluir = new JButton("Excluir");
		excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.out.println("Excluiu alguem a�");
			}
		});
		
		botoes.add(cadastrar);
		botoes.add(alterar);
		botoes.add(excluir);
		add(botoes, BorderLayout.SOUTH);
		
		//Criando a tabela 
		tabela = new JTable() {
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
		
		Object[] columns = {"Nome", "Telefone", "Endereco"}; //Definindo colunas
		model.setColumnIdentifiers(columns);
		
		listarDados(model);
		
		JScrollPane scroll = new JScrollPane(tabela);
		add(scroll);
	
		
	}
	
	
	public abstract void listarDados(DefaultTableModel model);
}
