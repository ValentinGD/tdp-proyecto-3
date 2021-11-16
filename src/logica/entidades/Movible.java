package logica.entidades;

import logica.Visitor;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PickUpPuntos;
import logica.estados.EstadoMovible;

public abstract class Movible extends Entidad implements Visitor {
	
	public static final int DIRECCION_DERECHA = 1;
	public static final int DIRECCION_IZQUIERDA = -1;
	public static final int DIRECCION_ARRIBA = -2;
	public static final int DIRECCION_ABAJO = 2;
	
	protected boolean chocaste;
	
	protected int xOrigen;
	protected int yOrigen;

	protected int direccionActual;
	
	protected int velocidadEnTics;
	protected int ticCount;
	
	protected Movible(int x, int y) {
		super(x, y);
		chocaste = false;
		ticCount = 0;
		direccionActual = DIRECCION_ARRIBA;
	}
	
	public abstract void mover();
	
	public abstract void morir();
	
	protected void chocar() {
		chocaste = true;
	}
	
	public boolean chocaste() {
		return chocaste;
	}
	
	public void setOrigen() {
		xOrigen = x;
		yOrigen = y;
	}
	
	public static boolean esDireccionValida(int direccion) {
		return 	(direccion == DIRECCION_DERECHA) ||
				(direccion == DIRECCION_IZQUIERDA) ||
				(direccion == DIRECCION_ARRIBA) ||
				(direccion == DIRECCION_ABAJO);
	}
	

	@Override
	public void visitarEnemigo(Enemigo e) {}

	@Override
	public void visitarPersonaje(Personaje p) {}

	@Override
	public void visitarPickUpPuntos(PickUpPuntos p) {}

	@Override
	public void visitarPickUpPoder(PickUpPoder p) {}
	
	public String toString() {
		return "x: " + x + ", y: " + y + ", direccion: " + direccionActual + ", zona: " + miZona; 
	}

	public int getDireccionActual() {
		return direccionActual;
	}
}
