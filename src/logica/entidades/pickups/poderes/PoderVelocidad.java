package logica.entidades.pickups.poderes;

import app.App;
import logica.entidades.Personaje;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderVelocidad extends PoderEspecial {

	public PoderVelocidad(int x, int y) {
		 super(x, y,Integer.parseInt(App.configuration.getProperty("PuntosPoderNormal"))
                 ,0,Integer.parseInt(App.configuration.getProperty("VelocidadTicsPoder"))
                 ,true,true,Integer.parseInt(App.configuration.getProperty("tiempoDuracionPoderes")));
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

	public void aplicarPoder(Personaje personaje) {
		personaje.agregarVelocidad(5);
	}
}
