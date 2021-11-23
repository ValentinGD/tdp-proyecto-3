package logica.entidades;

import app.App;
import logica.Escenario;

public abstract class PickUp extends Entidad {

	protected static final int puntosC = Integer.parseInt(App.configuration.getProperty("PuntosChicos"));
	protected static final int puntosG = Integer.parseInt(App.configuration.getProperty("PuntosGrandes"));
	protected static final int puntosPos = Integer.parseInt(App.configuration.getProperty("PuntosPosion"));
	protected static final int puntosPod = Integer.parseInt(App.configuration.getProperty("PuntosPoderes"));

	protected int puntos;
	
	protected boolean comido;
	
	protected PickUp(int x, int y) {
		super(x, y);
		comido = false;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public void comer() {
		//System.out.println("pickup comido");
		comido = true;
		miZona.eliminar(this);
		miZona = null;
		Escenario.getInstancia().agregarEntidadParaActualizar(this);
	}
	
}
