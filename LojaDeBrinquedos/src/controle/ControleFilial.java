package controle;

import java.util.ArrayList;

import main.Filial;

public class ControleFilial {

	public ControleFilial() {
		
	}
	
	public Object[] toArrayFilialLocal () {
		ArrayList<String> nomes = new ArrayList<String>(); 
		for (Filial f : Filial.getListaFilial()) {
			nomes.add(f.getLocal());
		}
		return nomes.toArray();
	}
}
