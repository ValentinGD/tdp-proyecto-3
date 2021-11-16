package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public class RepositorioGraficoPersonaje extends RepositorioGraficoMovibleAbstracto {
	
	public RepositorioGraficoPersonaje(String path) {
		super(path);
		this.path += "personaje/";
	}
	
	public ImageIcon getPersonajePoderosoGrafico() {
		return IconReader.readIcon(path + "personaje_poderoso.png");
	}

	@Override
	public ImageIcon getMovibleIzquierdaGrafico() {
		return IconReader.readIcon(path + "personaje_normal_izquierda.png");
	}

	@Override
	public ImageIcon getMovibleDerechaGrafico() {
		return IconReader.readIcon(path + "personaje_normal_derecha.png");
	}

	@Override
	public ImageIcon getMovibleArribaGrafico() {
		return IconReader.readIcon(path + "personaje_normal_arriba.png");
	}

	@Override
	public ImageIcon getMovibleAbajoGrafico() {
		return IconReader.readIcon(path + "personaje_normal_abajo.png");
	}

	@Override
	public ImageIcon getMovibleMuertoGrafico() {
		return IconReader.readIcon(path + "personaje_muerto.png");
	}

}