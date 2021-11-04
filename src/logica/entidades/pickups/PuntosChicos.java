package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PuntosChicos extends PickUpPuntos {

	public PuntosChicos() {
		puntos=puntosC;
	}
	
	@Override
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoChico();
	}
}
