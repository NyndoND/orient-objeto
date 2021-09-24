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

import main.Cliente;
import main.Filial;
import main.Vendedor;
import main.Brinquedo;

public class ViewListarBrinquedo extends JInternalFrame{

	
	private JTable tabela;
	private JButton cadastrar;
	private JButton excluir;
	private JButton alterar;
	private JPanel botoes;
	
	public ViewListarBrinquedo() {
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
				tabela = new JTable();
				DefaultTableModel model = new DefaultTableModel();
				tabela.setModel(model);
				tabela.setBackground(Color.LIGHT_GRAY);
				tabela.setForeground(Color.black);
				tabela.setRowHeight(30);
				
				Object[] columns = {"Nome", "Valor", "Codigo", "Faixa Etaria", "Comissao Vend."}; //Definindo colunas
				model.setColumnIdentifiers(columns);
				
				for (Filial c : Filial.getListaFilial() ) {
					for (Brinquedo b : c.getEstoqueBrinquedo()) {
						String nome = b.getNome();
						double valor = b.getValor();
						int codigo = b.getCodigo();
						int faixaEtaria = b.getFaixaEtaria();
						Double comissao = b.getComissaoVendedor();
						
						Object[] rowData = {nome, valor, codigo, faixaEtaria, comissao};
						
						model.addRow(rowData);
					}
				}
				
				JScrollPane scroll = new JScrollPane(tabela);
				add(scroll);
				
	}
	
}
