package view;

import java.awt.*;  
import java.awt.event.*;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DesktopMenu extends JFrame{
	
	private JDesktopPane desktop = new JDesktopPane();
	private JMenuBar menubar = new JMenuBar();
	
	public static void main(String [] args) {
		DesktopMenu teste = new DesktopMenu();
	}
	
	public DesktopMenu() {
		 int inset = 50;
		 Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, tamanhoTela.width-100, tamanhoTela.height-100);
		setTitle("Loja de Brinquedos");
		setContentPane(desktop);
		
		JMenu mPrincipal = new JMenu("Cadastrar");
		mPrincipal.setMnemonic(KeyEvent.VK_Q); // pelo jeito a tecla atalho não funciona para o esse item MenuPrincipal
		
		JMenu mFilho = new JMenu("Pessoa");
		mFilho.setMnemonic(KeyEvent.VK_W); //tecla atalho 

		JMenuItem mItem = new JMenuItem("Cliente");
		mItem.setMnemonic(KeyEvent.VK_E); //tecla atalho 
		
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Até deu bom!!");
					JInternalFrame frame = new ViewCadCliente();
					frame.setVisible(true);
					desktop.add(frame);
					frame.toFront();
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null; 
		
		mItem = new JMenuItem("Vendedor");
		mItem.setMnemonic(KeyEvent.VK_R); //tecla atalho 
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Até deu bom!!");
					JInternalFrame frame = new ViewCadVendedor();
					frame.setVisible(true);
					desktop.add(frame);
					frame.toFront();
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mPrincipal.add(mFilho);
		mFilho = null;
		mItem = null;
		
		mFilho = new JMenu("Brinquedo");
		mFilho.setMnemonic(KeyEvent.VK_Z); //tecla atalho 
		
		mItem = new JMenuItem("Eletronico");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Eletronico");
					JInternalFrame frame = new ViewCadEletronico();
					frame.setVisible(true);
					desktop.add(frame);
					frame.toFront();
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null;
		
		mItem = new JMenuItem("Carta");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Carta");
					JInternalFrame frame = new ViewCadCarta();
					frame.setVisible(true);
					desktop.add(frame);
					frame.toFront();
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null;
		
		mItem = new JMenuItem("Pelucia");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Pelucia");
					JInternalFrame frame = new ViewCadPelucia();
					frame.setVisible(true);
					desktop.add(frame);
					frame.toFront();
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null;
		
		mItem = new JMenuItem("Tabuleiro");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Tabuleiro");
					JInternalFrame frame = new ViewCadTabuleiro();
					frame.setVisible(true);
					desktop.add(frame);
					frame.toFront();
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mPrincipal.add(mFilho);
		menubar.add(mPrincipal);
		mItem = null;
		mFilho = null;
		mPrincipal = null;
		
		mPrincipal = new JMenu("Buscar");
		
		mFilho = new JMenu("Pessoa");
		
		mItem = new JMenuItem("Cliente");
		mFilho.add(mItem);
		mItem = new JMenuItem("Vendedor");
		mFilho.add(mItem);
		
		mPrincipal.add(mFilho);
		mFilho = null;
		
		mFilho = new JMenu("Brinquedo");
		
		mItem = new JMenuItem("Eletronico");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Eletronico");
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null;
		
		mItem = new JMenuItem("Carta");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Carta");
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null;
		
		mItem = new JMenuItem("Pelucia");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Pelucia");
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mItem = null;
		
		mItem = new JMenuItem("Tabuleiro");
		mItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					System.out.println("Tabuleiro");
				}catch(Exception r){
					r.printStackTrace();
				}
			}
		});
		
		mFilho.add(mItem);
		mPrincipal.add(mFilho);
		menubar.add(mPrincipal);
		
		
		setJMenuBar(menubar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
}
