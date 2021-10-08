package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import controle.ControleCliente;
import main.Cliente;
import main.DadoAleatorio;
import view.DesktopMenu;

class TesteControleCliente {
	
	private ControleCliente teste = new ControleCliente();
	
	@Test
	public void testGetClienteNome() {
		DadoAleatorio.addDados();
		String nometest = teste.getClienteNome(0);
		assertEquals(nometest, "Renann");
	}

	@Test
	public void testRemoverClienteIndex() {
		DadoAleatorio.addDados();
		int size = Cliente.getListaCliente().size();
		teste.removerClienteIndex(0);
		int sizeNovo = Cliente.getListaCliente().size();
		assertEquals(size - 1, sizeNovo);
	}

}
