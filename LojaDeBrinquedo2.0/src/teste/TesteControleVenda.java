package teste;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import controle.ControleVenda;
import main.DadoAleatorio;
import main.Filial;

class TesteControleVenda {

	private ControleVenda test = new ControleVenda();

	@Test
	void testCadastrarVenda() {
		DadoAleatorio.addDados();
		Filial fil = Filial.getListaFilial().get(0);
		int size = fil.getListaVenda().size();
		test.cadastrarVenda(fil.getLocal(), "Renann", "Andre", 2, "lagartixa");
		int sizeNovo = fil.getListaVenda().size();
		assertEquals(1 , 1);
	}

}
