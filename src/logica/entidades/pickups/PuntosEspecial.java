package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PuntosEspecial extends PickUpPuntos {

	public PuntosEspecial(int x, int y) {
		puntos=puntosG;
		this.x=x;
		this.y=y;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoGrande();
	}

}
