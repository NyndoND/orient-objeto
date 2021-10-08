package controle;

import java.util.ArrayList;

import main.Filial;
	/**
	 * Classe repons�vel por todos os m�todos intermediadores relacionados a Filial, estabelece uma rela��o indireta entre a view e main
	 */
public class ControleFilial {
	
	public ControleFilial() {
		
	}
	/**
	 * Transforma o ArrayList de Filial em um Array com apenas o local de cada Filial, usa-se isso para gerar a ComboBox de Filial
	 * @return
	 */
	public Object[] toArrayFilialLocal () {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Filial f : Filial.getListaFilial()) {
			nomes.add(f.getLocal());
		}
		return nomes.toArray();
	}
}
