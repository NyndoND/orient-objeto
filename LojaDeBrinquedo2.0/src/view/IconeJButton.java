package view;

import javax.swing.ImageIcon;

/**
 * Classe para deifinir os metodos das imagens dos botpes da barra superior de ferramentas 
 * @author renan
 *
 */
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
	
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeCadastrar() {
		return new ImageIcon(cadastrar);
	}
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeEditar() {
		return new ImageIcon(editar);
	}
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeExcluir() {
		return new ImageIcon(excluir);
	}
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeSair() {
		return new ImageIcon(sair);
	}
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeConfirmar() {
		return new ImageIcon(confirmar);
	}
	
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeFiltrar() {
		return new ImageIcon(filtrar);
	}
	
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeSelecionar() {
		return new ImageIcon(selecionar);
	}
	/**
	 * Retorna uma imagem para botão 
	 * @return
	 */
	public ImageIcon getIconeGerarArquivo() {
		return new ImageIcon(gerarArquivo);
	}
}
