package logica.entidades.pickups.poderes;


import app.App;
import logica.Juego;
import logica.Visitor;
import logica.entidades.Personaje;
import logica.entidades.PickUp;

public abstract class PickUpPoder extends PickUp {
	
	private static final int TIEMPO_DURACION_PODER = Juego.TICS_POR_SEGUNDO * Integer.parseInt(App.configuration.getProperty("tiempoSegundosDuracionPoderes"));

	private final int vidasExtras;
	private final int aumentoVelocidad;
	private final boolean inmortalidad;
	private final boolean matarEnemigo;
	
	protected PickUpPoder(int x, int y, int puntos, int vidasExtras, int aumentoVelocidad, boolean inmortalidad, boolean matarEnemigo) {
		super(x, y);
		this.puntos = puntos;
		this.vidasExtras = vidasExtras;
		this.aumentoVelocidad = aumentoVelocidad;
		this.inmortalidad = inmortalidad;
		this.matarEnemigo = matarEnemigo;
	}
	
	public void aceptar(Visitor v) {
		v.visitarPickUpPoder(this);
	}
	
	public void aplicarPoder(Personaje personaje) {
		if (!comido) {
			System.out.println("Aplicando poder de " + this);
			personaje.addTiempoPoder(TIEMPO_DURACION_PODER);
			personaje.setVidas(personaje.getVidas() + vidasExtras);
			personaje.agregarVelocidad(aumentoVelocidad);
			if (inmortalidad) personaje.hacerInmortal();
			if (matarEnemigo) personaje.hacerAsesinoDeEnemigos();
			comido = true;
		}
	}
}
