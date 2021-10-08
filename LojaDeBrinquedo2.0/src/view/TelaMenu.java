package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaMenu implements ActionListener {
	
	private JFrame frame = new JFrame ("Menu inicial");
	private JLabel titulo = new JLabel ("Menu Principal");
	private JButton botao1 = new JButton ("Clientes");
	private JButton botao2 = new JButton ("Filial");
	private JButton botao3 = new JButton ("Vendedores");
	
	public TelaMenu() {
		
		titulo.setFont(new Font ("Arial", Font.BOLD, 20));
		titulo.setBounds(180, 10, 500, 20);
		botao1.setBounds(150, 80, 200, 50);
		botao2.setBounds(150, 140, 200, 50);
		botao3.setBounds(150, 200, 200, 50);
		frame.setSize(500, 500);
		
		frame.setLayout(null);
		
		frame.add(titulo);
		frame.add(botao1);
		frame.add(botao2);
		frame.add(botao3);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if (src == botao1) {
			System.out.println("chama nenem");
		}else {
			System.out.println("vish é o Braian");
		}
	}
	public static void main(String[] args) {
	TelaMenu menu = new TelaMenu();
	
	menu.botao1.addActionListener(menu);
	menu.botao2.addActionListener(menu);
	menu.botao3.addActionListener(menu);
	
	}
}
