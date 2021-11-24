package logica.entidades.pickups.poderes;

import app.App;

public abstract class PoderEspecial extends PickUpPoder {
	
	private static final int PUNTOS_PODER_ESPECIAL = Integer.parseInt(App.configuration.getProperty("PuntosPoderEspecial"));

	protected PoderEspecial(int x, int y, int vidasExtras, int aumentoVelocidad, boolean inmortalidad, boolean matarEnemigo) {
		 super(x, y, PUNTOS_PODER_ESPECIAL, vidasExtras, aumentoVelocidad, inmortalidad, matarEnemigo);
	}
}
