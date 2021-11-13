package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PoderNormal extends PickUpEspecial {
	
	public PoderNormal(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPoder();
	}

}
