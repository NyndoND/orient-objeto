package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import controle.ControleVendedor;
import main.DadoAleatorio;
import main.Filial;

class TesteVendedor {
	private ControleVendedor teste = new ControleVendedor();
	
	@Test
	void testAlterarVendedorIndex() {
		DadoAleatorio.addDados();
		String data = "12/12/2002";
		Date dataFormat = null;
		try {
			dataFormat = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String nome = Filial.getListaFilial().get(0).getListaVendedor().get(0).getNome();
		Double sal = Filial.getListaFilial().get(0).getListaVendedor().get(0).getSalario();
		teste.alterarVendedorIndex(0, 0, "Rodolfo", 42424, "Casa Bahia", 1414, dataFormat, 14.5, 0);
		String nomeNovo = Filial.getListaFilial().get(0).getListaVendedor().get(0).getNome();
		Double salNovo = Filial.getListaFilial().get(0).getListaVendedor().get(0).getSalario();
		
		assertFalse(nome.equalsIgnoreCase(nomeNovo));
		assertFalse(sal.equals(salNovo));
	}
	
	@Test
	void testRemoverVendedorIndex() {
		DadoAleatorio.addDados();
		int indexFil = teste.getVendedorListaFilialIndex(0);
		int size = Filial.getListaFilial().get(indexFil).getListaVendedor().size();
		
		teste.removerVendedorIndex(0);
		
		int sizeNovo = Filial.getListaFilial().get(indexFil).getListaVendedor().size();
		assertFalse(size == sizeNovo);
	}
	

}
