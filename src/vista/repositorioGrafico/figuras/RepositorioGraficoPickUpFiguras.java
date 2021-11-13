package vista.repositorioGrafico.figuras;

import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class RepositorioGraficoPickUpFiguras extends RepositorioGraficoPickUpAbstracto {
	
	public static final String[] puntos = new String[] {
		"estrella_chica.png",
		"estrella.png",
		"rayo.png",
		"corazon.png"
	};
	
	public static final String[] poderes = new String[] {
		"estrella_grande.png",
		"frasco_amarillo.png",
		"frasco_naranja.png",
		"frasco_violeta.png"
	};
	
	public RepositorioGraficoPickUpFiguras(String path) {
		super(path, puntos, poderes);
	}
}
