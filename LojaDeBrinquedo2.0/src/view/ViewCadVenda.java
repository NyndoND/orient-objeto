package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controle.ControleVenda;
import main.Brinquedo;
import main.Cliente;
import main.Filial;
import main.Vendedor;

/**
 * Classe da tela de cadastrar venda 
 * @author renan
 *
 */
public class ViewCadVenda {
	
	JComboBox<Object> filialField = new JComboBox<>();
	JComboBox<Object> produtoField = new JComboBox<>();
	JComboBox<Object> clienteField = new JComboBox<>();
	JComboBox<Object> vendedorField = new JComboBox<>();
	JTextField qtdField = new JTextField();
	JLabel imagem1 = new JLabel("");
	JLabel imagem2 = new JLabel("");
	JButton realizar = new JButton ("Realizar Venda");
	
	
	/**
	 * Construtor da tela venda que pede como parametro da JDesktopPane, é criado usando todos os atibutos da classe 
	 * @param d
	 */
	public ViewCadVenda(JDesktopPane d) {
		
		ControleVenda controle = new ControleVenda();
		//Titulo
		JLabel titulo = new JLabel("Fun Happy");
		titulo.setBounds(30,30,300,60);
		titulo.setForeground(Color.BLACK);
		titulo.setFont(new Font("Algerian", Font.BOLD, 50));
		//titulo.setHorizontalAlignment(SwingConstants.TRAILING);
		d.add(titulo);
		
		//Adicionando os campos para preencher
		JLabel nomeProduto = new JLabel("Nome do Produto:");
		JLabel nomeCliente = new JLabel("Nome do Cliente:");
		JLabel nomeVendedor = new JLabel("Nome do Vendedor:");
		JLabel qtd = new JLabel("Quantidade:");
		JLabel filial = new JLabel("Filial:");
		
		
		filial.setBounds(30, 150, 300, 30);
		filial.setFont(new Font("Algerian", Font.BOLD, 30));
		
		nomeCliente.setBounds(30, 200, 300, 30);
		nomeCliente.setFont(new Font("Algerian", Font.BOLD, 30));
		
		nomeVendedor.setBounds(30, 250, 300, 30);
		nomeVendedor.setFont(new Font("Algerian", Font.BOLD, 30));
		
		qtd.setBounds(30, 300, 300, 30);
		qtd.setFont(new Font("Algerian", Font.BOLD, 30));

		nomeProduto.setBounds(30, 350, 300, 30);
		nomeProduto.setFont(new Font("Algerian", Font.BOLD, 30));
		
		d.add(filial);
		d.add(nomeProduto);
		d.add(nomeCliente);
		d.add(nomeVendedor);
		d.add(qtd);
		
		
		filialField.setBounds(320, 150, 300, 30);
		clienteField.setBounds(320, 200, 300, 30);
		vendedorField.setBounds(320, 250, 300, 30);
		qtdField.setBounds(320, 300, 300, 30);
		produtoField.setBounds(320, 350, 300, 30);
		
		filialField.setModel(filialComboBox());
		filialField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				vendedorField();
				produtoField();
			}
			});
		clienteField.setModel(clienteComboBox());
		vendedorField.setModel(vendedorComboBox(filialField.getSelectedIndex())); // pra iniciar já com algo selecionado
		produtoField.setModel(produtoComboBox(filialField.getSelectedIndex())); // pra iniciar já com algo selecionado
		
		d.add(filialField);
		d.add(produtoField);
		d.add(clienteField);
		d.add(vendedorField);
		d.add(qtdField);
		
		realizar.setBounds(320, 400, 300, 30);
		realizar.setBackground(Color.ORANGE);
		realizar.setForeground(Color.DARK_GRAY);
		realizar.setFont(new Font("Algerian", Font.BOLD, 20));
		realizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Venda cadastrada com sucesso!");
				controle.cadastrarVenda(getFilialField(),getClienteField (),getVendedorField(), getQtdField(), getBrinquedoField());
			}
		});
		
		d.add(realizar);
		
		//adicionando imagens 
		imagem1.setBounds(680, 0, 495, 500);
		imagem1.setIcon(new ImageIcon(ViewCadVenda.class.getResource("/view/images/criancas1.png")));
		d.add(imagem1);
		
		imagem2.setBounds(0, 280, 550, 310);
		imagem2.setIcon(new ImageIcon(ViewCadVenda.class.getResource("/view/images/criancas3.png")));
		d.add(imagem2);
		
	}
	/**
	 * modifica as opcoes de vendedor que aparecem de acordo com a filial selecionada 
	 */
	public void vendedorField () {
		vendedorField.setModel(vendedorComboBox(filialField.getSelectedIndex()));
	}
	
	/**
	 * modifica as opcoes de brinquedos que aparecem de acordo com a filial selecionada
	 */
	public void produtoField() {
		produtoField.setModel(produtoComboBox(filialField.getSelectedIndex()));
	}
	
	public DefaultComboBoxModel<Object> clienteComboBox(){
		return new DefaultComboBoxModel<>(clienteArray());
	}
	/**
	 * Transforma um ArrayList em Array apenas com nomes
	 * @return
	 */
	public Object[] clienteArray() {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Cliente c : Cliente.getListaCliente()) {
			nomes.add(c.getNome());
		}
		return nomes.toArray();
	}
	
	public DefaultComboBoxModel<Object> produtoComboBox(int index){
		return new DefaultComboBoxModel<>(produtoArray(index));
	}
	
	/**
	 * Transforma um ArrayList em Array apenas com os nomes de brinquedos
	 * @param index
	 * @return
	 */
	public Object[] produtoArray(int index) {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Brinquedo b : Filial.getListaFilial().get(index).getEstoqueBrinquedo()) {
			nomes.add(b.getNome());
		}
		return nomes.toArray();
	}
	
	public DefaultComboBoxModel<Object> vendedorComboBox(int index){
		return new DefaultComboBoxModel<>(vendedorArray(index));
	}
	
	/**
	 * Transforma um ArrayList em Array apenas com nomes de vendedores
	 * @param index
	 * @return
	 */
	public Object[] vendedorArray(int index) {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Vendedor v : Filial.getListaFilial().get(index).getListaVendedor()) {
			nomes.add(v.getNome());
		}
		return nomes.toArray();
	}
	
	public DefaultComboBoxModel<Object> filialComboBox(){
		return new DefaultComboBoxModel<>(filialArray());
	}
	
	/**
	 * Transforma um ArrayList em Array apenas com o local das filiais 
	 * @return
	 */
	public Object[] filialArray() {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Filial f : Filial.getListaFilial()) {
			nomes.add(f.getLocal());
		}
		return nomes.toArray();
	}

	/**
	 * Converte pra String a opcao selecionada pelo usuario 
	 * @return
	 */
	public String getFilialField() {
		String nome = filialField.getSelectedItem().toString();
		return nome;
	}
	
	/**
	 * Converte pra String a opcao selecionada pelo usuario 
	 * @return
	 */
	public String getVendedorField() {
		String nome = vendedorField.getSelectedItem().toString();
		return nome;
	}
	
	/**
	 * Converte pra String a opcao selecionada pelo usuario 
	 * @return
	 */
	public String getBrinquedoField() {
		String nome = produtoField.getSelectedItem().toString();
		return nome;
	}

	/**
	 * Converte pra String a opcao selecionada pelo usuario 
	 * @return
	 */
	public String getClienteField () {
		String nome = clienteField.getSelectedItem().toString();
		return nome;
	}
	
	/**
	 * Retorna o que foi digitado pelo usuario no campo 
	 * @return
	 */
	public int getQtdField() {
		int qtd = Integer.parseInt(qtdField.getText());
		return qtd;
	}
}
