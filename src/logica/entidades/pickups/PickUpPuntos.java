package logica.entidades.pickups;

import javax.swing.ImageIcon;

import logica.entidades.PickUp;
import vista.RepositorioGrafico;

public class PickUpPuntos extends PickUp {

	@Override
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoChico();
	}

}
