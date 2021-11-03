package logica.entidades.pickups;

import javax.swing.ImageIcon;

import logica.entidades.PickUp;
import vista.RepositorioGrafico;

public class PickUpEspecial extends PickUp {

	@Override
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoGrande();
	}

}
