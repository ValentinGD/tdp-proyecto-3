package logica.fabricas;

import logica.entidades.PickUp;
import logica.entidades.pickups.Pocion;
import logica.entidades.pickups.Poder;
import logica.entidades.pickups.PuntosChicos;
import logica.entidades.pickups.PuntosGrandes;

public class PickUpFactory {

	public static PickUp createPuntosChicos() {
		return new PuntosChicos();
	}
	public static PickUp createPuntosGrandes() {
		return new PuntosGrandes();
	}
	public static PickUp createPocion() {
		return new Pocion();
	}
	public static PickUp createPoder() {
		return new Poder();
	}
}
