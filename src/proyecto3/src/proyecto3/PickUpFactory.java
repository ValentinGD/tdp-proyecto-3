package proyecto3;

public class PickUpFactory {

	public static PickUp createPuntosChicos() {
		return new  PuntosChicos();
	}
	public static PickUp createPuntosGrandes() {
		return new  PuntosGrandes();
	}
	public static PickUp createPocion() {
		return new  Pocion();
	}
	public static PickUp createPoder() {
		return new  Poder();
	}
}
