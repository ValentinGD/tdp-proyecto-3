package logica.estados.enemigos;

import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Personaje;

public class PersiguiendoEnemigo3 extends PersiguiendoEnemigoAbstracto {

	public PersiguiendoEnemigo3() {
		super();
	}

	@Override
	protected void calcularCoordenadasObjetivo() {
		Personaje personaje = Personaje.getInstancia();
		
		xObjetivo = 0; 
		yObjetivo = 0;
		
		switch (personaje.getDireccionActual()) {
		case Movible.DIRECCION_ABAJO:
			xObjetivo = personaje.getX();
			yObjetivo = personaje.getY() + 4 * Entidad.TAMANIO;
			break;
		
		case Movible.DIRECCION_ARRIBA:
			xObjetivo = personaje.getX() - 2 * Entidad.TAMANIO;
			yObjetivo = personaje.getY() - 4 * Entidad.TAMANIO;
			break;
			
		case Movible.DIRECCION_DERECHA:
			xObjetivo = personaje.getX() + 4 * Entidad.TAMANIO;
			yObjetivo = personaje.getY();
			break;
			
		case Movible.DIRECCION_IZQUIERDA:
			xObjetivo = personaje.getX() - 4 * Entidad.TAMANIO;
			yObjetivo = personaje.getY();
			break;
		}

		System.out.println("Personaje: <x: " + personaje.getX() + ", y: " + personaje.getX() + ", dir: " + Movible.direccionToString(personaje.getDireccionActual()) + ">");
		System.out.println("Objetivo Enemigo 3: <x: " + xObjetivo + ", y: " + yObjetivo + ">");
	}
}
