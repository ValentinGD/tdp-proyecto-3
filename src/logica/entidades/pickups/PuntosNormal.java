package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PuntosNormal extends PickUpPuntos {

	public PuntosNormal(int x, int y) {
		puntos=puntosC;
		this.x=x;
		this.y=y;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoChico();

	}
	
}
