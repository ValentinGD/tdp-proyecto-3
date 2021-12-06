package logica.entidades.pickups.puntos;

import javax.swing.ImageIcon;

import app.App;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class PuntosNormal extends PickUpPuntos {

	private static final int PUNTOS_PUNTOS_NORMAL = Integer.parseInt(App.configuration.getProperty("PuntosNormal"));

	public PuntosNormal(int x, int y) {
		super(x, y);
		puntos = PUNTOS_PUNTOS_NORMAL;
	}

	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoChico();
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPuntoNormalGrafico());
		}
		return miRepresentacion;
	}

}