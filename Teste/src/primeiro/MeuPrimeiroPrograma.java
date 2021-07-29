package primeiro;

import DTO.Cliente;

public class MeuPrimeiroPrograma {

	public static void main(String[] args) {
		System.out.println("Hello Wolrd Java!");
		
		Cliente c1 = new Cliente();
		c1.setEndereco("qd15");
		c1.setNome("Renann");
		c1.setTelefone("99999-9999");
		
		System.out.println(c1.getNome());
		System.out.println(c1.getEndereco());
		System.out.println(c1.getTelefone());
		
		
	}

}
