package logica.estados.enemigos;

import java.util.ArrayList;
import java.util.List;

import logica.Escenario;
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
			yObjetivo = personaje.getY() + 4;
			break;
		
		case Movible.DIRECCION_ARRIBA:
			xObjetivo = personaje.getX() - 2;
			yObjetivo = personaje.getY() - 4;
			break;
			
		case Movible.DIRECCION_DERECHA:
			xObjetivo = personaje.getX() + 4;
			yObjetivo = personaje.getY();
			break;
			
		case Movible.DIRECCION_IZQUIERDA:
			xObjetivo = personaje.getX() - 4;
			yObjetivo = personaje.getY();
			break;
		}
		
	}
}
