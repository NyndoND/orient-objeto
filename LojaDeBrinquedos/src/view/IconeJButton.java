package view;

import javax.swing.ImageIcon;

public class IconeJButton {
	
	private ImageIcon imagem;
	private String 
			cadastrar = "./imagens/imgNovo.png", 
			editar = "./imagens/imgEditar.png", 
			excluir = "./imagens/imgExcluir.png", 
			sair = ".//imagens/imgSair.png",
			confirmar = "./imagens/imgConfirmar.png",
			filtrar = "./imagens/imgFiltrar.png",
			selecionar = "./imagens/imgSelecionar.png",
			gerarArquivo = "./imagens/imgGerarArquivo.png";
	
	public ImageIcon getIconeCadastrar() {
		return new ImageIcon(cadastrar);
	}
	
	public ImageIcon getIconeEditar() {
		return new ImageIcon(editar);
	}

	public ImageIcon getIconeExcluir() {
		return new ImageIcon(excluir);
	}
	
	public ImageIcon getIconeSair() {
		return new ImageIcon(sair);
	}

	public ImageIcon getIconeConfirmar() {
		return new ImageIcon(confirmar);
	}
	
	public ImageIcon getIconeFiltrar() {
		return new ImageIcon(filtrar);
	}
	
	public ImageIcon getIconeSelecionar() {
		return new ImageIcon(selecionar);
	}
	
	public ImageIcon getIconeGerarArquivo() {
		return new ImageIcon(gerarArquivo);
	}
}
