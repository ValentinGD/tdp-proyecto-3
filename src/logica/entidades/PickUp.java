package logica.entidades;

import app.App;

public abstract class PickUp extends Entidad {

	protected static final int puntosC = Integer.parseInt(App.configuration.getProperty("PuntosChicos"));
	protected static final int puntosG = Integer.parseInt(App.configuration.getProperty("PuntosGrandes"));
	protected static final int puntosPos = Integer.parseInt(App.configuration.getProperty("PuntosPosion"));
	protected static final int puntosPod = Integer.parseInt(App.configuration.getProperty("PuntosPoderes"));

	protected int puntos;	
	
	protected PickUp(int x, int y) {
		super(x, y);
	}

	public int getPuntos() {
		return puntos;
	}
	
}
