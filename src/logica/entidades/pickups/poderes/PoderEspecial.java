package logica.entidades.pickups.poderes;

import app.App;
import logica.Visitor;
import logica.entidades.Personaje;

public abstract class PoderEspecial extends PickUpPoder {
	
	protected PoderEspecial(int x, int y, int puntos, int vidasExtras, int aumentoVelocidad, boolean inmortalidad, boolean matarEnemigo, int tiempoDuracion) {
		 super(x, y,Integer.parseInt(App.configuration.getProperty("PuntosPoderNormal"))
                 ,0,Integer.parseInt(App.configuration.getProperty("VelocidadTicsPoder"))
                 ,true,true,Integer.parseInt(App.configuration.getProperty("tiempoDuracionPoderes")));
	}
	
	public void aplicarPoder(Personaje personaje) {
		personaje.setVidas(personaje.getVidas()+1);
	}
}
