package logica.entidades.pickups.poderes;

import app.App;

public abstract class PoderEspecial extends PickUpPoder {
	
	private static final int PUNTOS_PODER_ESPECIAL = Integer.parseInt(App.configuration.getProperty("PuntosPoderEspecial"));

	protected PoderEspecial(int x, int y) {
		 super(x, y, PUNTOS_PODER_ESPECIAL);
	}
}
