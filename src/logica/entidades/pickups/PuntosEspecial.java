package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class PuntosEspecial extends PickUpPuntos {

	public PuntosEspecial() {
		puntos=puntosG;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoGrande();
	}

}
