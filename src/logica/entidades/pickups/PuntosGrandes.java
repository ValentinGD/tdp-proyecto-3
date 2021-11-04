package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PuntosGrandes extends PickUpPuntos {

	public PuntosGrandes() {
		puntos=puntosG;
	}
	
	@Override
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoGrande();
	}
}
