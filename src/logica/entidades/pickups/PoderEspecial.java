package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PoderEspecial extends PickUpEspecial {
	

	public PoderEspecial(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPocion();
	}

}
