package logica.estados.enemigos;

import logica.Escenario;
import logica.entidades.Entidad;

public class PersiguiendoEnemigo4 extends PersiguiendoEnemigoAbstracto {
	
	public PersiguiendoEnemigo4() {
		super();
	}

	/**
	 * Calcula la direccion mas optima hacia el objetivo, estos son el personaje, 
	 * si enemigo4 esta a mas de 8 cuadrados, sino la esquina inferior izquierda
	 */
	protected void calcularCoordenadasObjetivo() {
		double distancia = distancia(enemigo.getX(), enemigo.getY(), personaje.getX(), personaje.getY());
		
		if(distancia < 8 * Entidad.TAMANIO) {
			xObjetivo = Entidad.TAMANIO;
			yObjetivo = Escenario.getInstancia().getAlto() - Entidad.TAMANIO;
		} else {
			xObjetivo = personaje.getX();
			yObjetivo = personaje.getY();
		}
	}
}