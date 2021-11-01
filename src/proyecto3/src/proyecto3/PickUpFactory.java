package proyecto3;

public class PickUpFactory {

	public static PickUp createPuntosChicos() {
		return new  PuntosChicos();
	}
	public static PickUp createPuntosGrandes() {
		return new  PuntosGrandes();
	}
}
