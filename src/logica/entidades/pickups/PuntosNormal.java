package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PuntosNormal extends PickUpPuntos {

	public PuntosNormal() {
		puntos=puntosC;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoChico();

	}
	
}
