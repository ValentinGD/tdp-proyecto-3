package logica.fabricas;

import logica.entidades.PickUp;
import logica.entidades.pickups.PoderEspecial;
import logica.entidades.pickups.PoderNormal;
import logica.entidades.pickups.PuntosChicos;
import logica.entidades.pickups.PuntosEspecial;

public class PickUpFactory {

	public static PickUp createPuntosChicos() {
		return new PuntosChicos();
	}
	public static PickUp createPuntosGrandes() {
		return new PuntosEspecial();
	}
	public static PickUp createPocion() {
		return new PoderEspecial();
	}
	public static PickUp createPoder() {
		return new PoderNormal();
	}
}
