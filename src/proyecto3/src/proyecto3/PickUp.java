package proyecto3;

public abstract class PickUp extends Entidad {
	protected int puntos;
	protected int tipoPickUp;
	protected static final int puntosC = 100;
	protected static final int puntosG = 200;
	protected static final int puntosPos = 200;
	protected static final int puntosPod = 200;
	
	public int getPuntos() {
		return puntos;
	}
	public int getTipoPickUp() {
		return tipoPickUp;
	}
}
