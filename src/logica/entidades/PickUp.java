package logica.entidades;

import logica.Entidad;

public abstract class PickUp extends Entidad {
protected int puntos;
protected static final int puntosC = 100;
protected static final int puntosG = 200;
protected static final int puntosPos = 200;
protected static final int puntosPod = 200;

public int getPuntos() {
	return puntos;
}
}
