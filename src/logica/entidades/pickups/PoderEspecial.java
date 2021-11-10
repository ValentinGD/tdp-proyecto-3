package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PoderEspecial extends PickUpEspecial {
	

	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPocion();
	}

}
