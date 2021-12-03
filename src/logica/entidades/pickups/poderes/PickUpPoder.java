package logica.entidades.pickups.poderes;

import app.App;
import logica.Juego;
import logica.Visitor;
import logica.entidades.Personaje;
import logica.entidades.PickUp;

public abstract class PickUpPoder extends PickUp {
	
	private static final int TIEMPO_DURACION_PODER = Juego.TICS_POR_SEGUNDO * Integer.parseInt(App.configuration.getProperty("tiempoSegundosDuracionPoderes"));
	
	protected PickUpPoder(int x, int y, int puntos) {
		super(x, y);
		this.puntos = puntos;
	}
	
	public void aceptar(Visitor v) {
		v.visitarPickUpPoder(this);
	}
	
	public void aplicarPoder(Personaje personaje) {
		if (!comido) {
			//System.out.println("Aplicando poder de " + this);
			personaje.addTiempoPoder(TIEMPO_DURACION_PODER);
			comido = true;
		}
	}
}
