package logica.entidades.pickups.poderes;

import app.App;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderVelocidad extends PoderEspecial {
	
	private static final int VELOCIDAD_EXTRA = Integer.parseInt(App.configuration.getProperty("VelocidadTicsPoder"));
	
	public PoderVelocidad(int x, int y) {
		 super(x, y, 0, VELOCIDAD_EXTRA, false, false);
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPoderEspecialGrafico(RepositorioGraficoPickUpAbstracto.PODER_VELOCIDAD));
		}
		return miRepresentacion;
	}
}
