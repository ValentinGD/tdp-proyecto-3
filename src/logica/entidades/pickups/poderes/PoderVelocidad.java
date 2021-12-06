package logica.entidades.pickups.poderes;

import app.App;
import logica.entidades.Personaje;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderVelocidad extends PoderEspecial {

	private static final int VELOCIDAD_EXTRA = Integer.parseInt(App.configuration.getProperty("VelocidadTicsPoder"));

	public PoderVelocidad(int x, int y) {
		super(x, y);
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

	@Override
	public void aplicarPoder(Personaje personaje) {
		super.aplicarPoder(personaje);
		personaje.agregarVelocidad(VELOCIDAD_EXTRA);
	}

	@Override
	public String toString() {
		return "Poder velocidad";
	}

}