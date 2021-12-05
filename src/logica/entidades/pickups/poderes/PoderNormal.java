package logica.entidades.pickups.poderes;

import app.App;
import logica.entidades.Personaje;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class PoderNormal extends PickUpPoder {
	
	private static final int PUNTOS_PODER_NORMAL = Integer.parseInt(App.configuration.getProperty("PuntosPoderNormal"));
	
	public PoderNormal(int x, int y) {
		super(x, y, PUNTOS_PODER_NORMAL);
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPoderNormalGrafico());
		}
		return miRepresentacion;
	}
	
	@Override
	public void aplicarPoder(Personaje personaje) {
		super.aplicarPoder(personaje);
		personaje.hacerInmortal();
		personaje.hacerAsesinoDeEnemigos();
	}
	
	public String toString() {
		return "Poder normal";
	}

}