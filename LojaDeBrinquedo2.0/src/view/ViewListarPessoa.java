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
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import controle.ControleCliente;
import controle.ControleVendedor;
import main.Cliente;

public abstract class ViewListarPessoa extends JInternalFrame implements ActionListener{

	private JButton botaoFil = null;
	private JToolBar barra = null;
	private JTextField pesquisa = null;
	
	private JTable tabela;
	private DefaultTableModel model;
	private JButton cadastrar;
	private JButton excluir;
	private JButton alterar;
	private JPanel botoes;
	private ControleCliente controleCli = new ControleCliente();
	private ControleVendedor controleVen = new ControleVendedor();

	public ViewListarPessoa() {
		super("Listar Pessoa", true, true, true, true);
		setSize(800,200);
		setLocation(30, 30);
		
		//Adicionando a barra de pesquisa em cima 
		barra = new JToolBar();
		pesquisa = new JTextField(50);
		botaoFil = new JButton(new IconeJButton().getIconeFiltrar());
		botaoFil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = null;
				model = new DefaultTableModel();
				Object[] columns = {"Nome", "Telefone", "Endereco"};
				model.setColumnIdentifiers(columns);
				filtrarTabela(pesquisa.getText(), model);
				tabela.setModel(model);
				
			}
		 });
		barra.add(pesquisa);
		barra.add(botaoFil);
		add(barra, BorderLayout.NORTH);
		
		//Adicionando os botes na parte de baixo da tela
		botoes = new JPanel();
		botoes.setLayout(new GridLayout());
		
		cadastrar = new JButton("Cadastrar");
		cadastrar.addActionListener(this);
		
		alterar = new JButton("Alterar");
		alterar.addActionListener(this);
		
		excluir = new JButton("Excluir");
		excluir.addActionListener(this);
		
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
		model = new DefaultTableModel();
		
		tabela.setBackground(Color.LIGHT_GRAY);
		tabela.setForeground(Color.black);
		tabela.setRowHeight(30);
		
		Object[] columns = {"Nome", "Telefone", "Endereco"}; //Definindo colunas
		model.setColumnIdentifiers(columns);
		
		listarDados(model);
		tabela.setModel(model);
		JScrollPane scroll = new JScrollPane(tabela);
		add(scroll);
	
		
	}
	
	
	public abstract void listarDados(DefaultTableModel model);
	
	public abstract void filtrarTabela(String digitado, DefaultTableModel model);
	
	
	public DefaultTableModel getModel() {
		return model;
	}


	public void setModel(DefaultTableModel model) {
		this.model = model;
	}


	public JButton getCadastrar() {
		return cadastrar;
	}


	public void setCadastrar(JButton cadastrar) {
		this.cadastrar = cadastrar;
	}


	public JButton getExcluir() {
		return excluir;
	}


	public void setExcluir(JButton excluir) {
		this.excluir = excluir;
	}


	public JButton getAlterar() {
		return alterar;
	}


	public void setAlterar(JButton alterar) {
		this.alterar = alterar;
	}


	public JTable getTabela() {
		return tabela;
	}


	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	
	public ControleCliente getControleCli() {
		return controleCli;
	}
	
	public ControleVendedor getControleVen() {
		return controleVen;
	}

}



