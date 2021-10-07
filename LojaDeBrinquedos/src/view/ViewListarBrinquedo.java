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

import controle.ControleBrinquedo;
import main.Cliente;
import main.Eletronico;
import main.Filial;
import main.JogoDeCarta;
import main.JogoDeTabuleiro;
import main.Pelucia;
import main.Vendedor;
import main.Brinquedo;

public class ViewListarBrinquedo extends JInternalFrame{

	private JButton botaoFil = null;
	private JToolBar barra = null;
	private JTextField pesquisa = null;
	
	private JTable tabela;
	private DefaultTableModel model;
	private JButton cadastrar;
	private JButton excluir;
	private JButton alterar;
	private JPanel botoes;
	
	private ControleBrinquedo controle = new ControleBrinquedo();
	
	public ViewListarBrinquedo() {
		super("Listar Brinquedos", true, true, true, true);
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
						Object[] columns = {"Nome", "Valor", "Codigo", "Faixa Etaria", "Comissao Vend."};
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
				
				alterar = new JButton("Alterar");
				alterar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int indexObj = getTabela().getSelectedRow();
						if(controle.testaClasseEletronico(indexObj) != null) {
							Eletronico eletr = controle.testaClasseEletronico(indexObj);
							ViewAlterarEletronico frame = new ViewAlterarEletronico(indexObj, eletr);
							DesktopMenu.addDesktop(frame);
							frame.toFront();
							frame.setVisible(true);
							dispose();
						} else if (controle.testaClasseCarta(indexObj) != null) {
							JogoDeCarta carta = controle.testaClasseCarta(indexObj);
							ViewAlterarCarta frame = new ViewAlterarCarta(indexObj,carta);
							DesktopMenu.addDesktop(frame);
							frame.toFront();
							frame.setVisible(true);
							dispose();
						} else if (controle.testaClassePelucia(indexObj) != null) {
							Pelucia pelucia = controle.testaClassePelucia(indexObj);
							ViewAlterarPelucia frame = new ViewAlterarPelucia(indexObj, pelucia);
							DesktopMenu.addDesktop(frame);
							frame.toFront();
							frame.setVisible(true);
							dispose();
						}else if (controle.testaClasseTabuleiro(indexObj) != null) {
							JogoDeTabuleiro tab = controle.testaClasseTabuleiro(indexObj);
							ViewAlterarTabuleiro frame = new ViewAlterarTabuleiro(indexObj, tab);
							DesktopMenu.addDesktop(frame);
							frame.toFront();
							frame.setVisible(true);
							dispose();
						}
					}
				});
				
				excluir = new JButton("Excluir");
				excluir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int indexObj = getTabela().getSelectedRow();
						controle.removerBrinquedoIndex(indexObj);
						dispose();
					}
				});
				
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
				model = new DefaultTableModel();
				tabela.setModel(model);
				tabela.setBackground(Color.LIGHT_GRAY);
				tabela.setForeground(Color.black);
				tabela.setRowHeight(30);
				
				Object[] columns = {"Nome", "Valor", "Codigo", "Faixa Etaria", "Comissao Vend."}; //Definindo colunas
				model.setColumnIdentifiers(columns);
				listarDados(model);
				JScrollPane scroll = new JScrollPane(tabela);
				add(scroll);
				
	}
	public void listarDados(DefaultTableModel model) {
		controle.modelListarBrinquedos(model);
	}
	
	public void filtrarTabela(String digitado, DefaultTableModel model) {
		controle.filtrarBrinquedo(model, digitado);
	}

	public JTable getTabela() {
		return tabela;
	}

	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	
	
}
