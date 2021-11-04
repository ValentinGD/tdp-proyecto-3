package logica.estados.personaje;

import java.util.ArrayList;

import logica.Posicion;
import logica.entidades.Movible;
import logica.entidades.Personaje;

public abstract class EstadoPersonaje {
	
	public abstract ArrayList<Posicion> mover(Personaje personaje, int direccionActual);
	
	public static Posicion calcularSiguientePosicion(Personaje personaje, int direccion) {
		Posicion pos = personaje.getPosicion();
		int nextX = pos.getX();
		int nextY = pos.getY();
		if (direccion == Movible.DIRECCION_IZQUIERDA) {
			nextX--;
		}
		if (direccion == Movible.DIRECCION_DERECHA) {
			nextX++;
		}
		if (direccion == Movible.DIRECCION_ARRIBA) {
			nextY--;
		}
		if (direccion == Movible.DIRECCION_ABAJO) {
			nextY++;
		}
		return new Posicion(nextY, nextX);
	}
	
	public static boolean puedeMover(Posicion nuevaPosicion) {
		return nuevaPosicion.esHabitable();
	}
}
