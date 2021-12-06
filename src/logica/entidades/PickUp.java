package logica.entidades;

import logica.Escenario;

public abstract class PickUp extends Entidad {

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
		comido = true;
		miZona.eliminar(this);
		miZona = null;
		Escenario.getInstancia().agregarEntidadParaActualizar(this);
	}

}