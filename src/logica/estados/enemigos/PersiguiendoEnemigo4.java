package logica.estados.enemigos;

import logica.Escenario;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Personaje;

public class PersiguiendoEnemigo4 extends PersiguiendoEnemigoAbstracto {
	
	public PersiguiendoEnemigo4() {
		super();
	}


	protected void calcularCoordenadasObjetivo() {
		int diferenciaEnX=enemigo.getX()-personaje.getX();
		int diferenciaEnY=enemigo.getY()-personaje.getY();
		
		if(Math.abs(diferenciaEnX)< 8*Entidad.TAMANIO & Math.abs(diferenciaEnY)< 8*Entidad.TAMANIO) {
			diferenciaEnY=enemigo.getY()-Entidad.TAMANIO*Escenario.getInstancia().getAlto();
			diferenciaEnX=enemigo.getX()-Entidad.TAMANIO;
		}
		
		
		if(diferenciaEnX < 0) {//si el personaje esta a la derecha
			xObjetivo=Movible.DIRECCION_DERECHA;
		} else {
			xObjetivo=Movible.DIRECCION_IZQUIERDA;
		}
		
		if(diferenciaEnY < 0) {//si el personaje esta abajo
			yObjetivo=Movible.DIRECCION_ABAJO;
		} else {
			yObjetivo=Movible.DIRECCION_ARRIBA;
		}
		
	}
}
