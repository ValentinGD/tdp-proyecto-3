package logica.entidades;

import app.App;
import logica.Visitor;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PickUpPuntos;

public abstract class Movible extends Entidad implements Visitor {
	
	public static final int DIRECCION_DERECHA = 1;
	public static final int DIRECCION_IZQUIERDA = -1;
	public static final int DIRECCION_ARRIBA = -2;
	public static final int DIRECCION_ABAJO = 2;
	
	public static final int [] DIRECCIONES_POSIBLES = new int[] {
		DIRECCION_IZQUIERDA,
		DIRECCION_DERECHA,
		DIRECCION_ARRIBA,
		DIRECCION_ABAJO
	};
	
	public static final int VELOCIDAD = Integer.parseInt(App.configuration.getProperty("VelocidadMovible"));
	
	protected boolean chocaste;
	
	protected int xOrigen;
	protected int yOrigen;

	protected int direccionActual;
	
	protected int velocidadEnTics;
	protected int ticCount;
	
	protected Movible(int x, int y) {
		super(x, y);
		xOrigen = x;
		yOrigen = y;
		chocaste = false;
		ticCount = 0;
		direccionActual = DIRECCION_DERECHA;
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

	public void setPosicion(int xDestino, int yDestino) {
		x = xDestino;
		y = yDestino;
	}
	
	public static boolean esDireccionValida(int direccion) {
		return 	(direccion == DIRECCION_DERECHA) ||
				(direccion == DIRECCION_IZQUIERDA) ||
				(direccion == DIRECCION_ARRIBA) ||
				(direccion == DIRECCION_ABAJO);
	}

	@Override
	public void visit(Enemigo e) {}

	@Override
	public void visit(Personaje p) {}

	@Override
	public void visit(PickUpPuntos p) {}

	@Override
	public void visit(PickUpPoder p) {}

	public int getDireccionActual() {
		return direccionActual;
	}
	
	public void setDireccionActual(int direccionActual) {
		this.direccionActual=direccionActual;
	}
	
	public boolean puedeGirar() {
		return (x % Entidad.TAMANIO == 0) && (y % Entidad.TAMANIO == 0);
	}
	
	public static boolean sonDireccionesOpuestas(int direccion1, int direccion2) {
		return direccion1 + direccion2 == 0;
	}
	
	public static String direccionToString(int direccion) {
		switch(direccion) {
		case DIRECCION_ARRIBA:
			return "ARRIBA";
		case DIRECCION_ABAJO:
			return "ABAJO";
		case DIRECCION_IZQUIERDA:
			return "IZQUIERDA";
		case DIRECCION_DERECHA:
			return "DERECHA";
		default:
			return "<DIRECCION INVALIDA: " + direccion + ">";
		}
	}

	public static int getDireccionOpuesta(int direccion) {
		return direccion * (-1);
	}

	public void reset() {
		x = xOrigen;
		y = yOrigen;
		ticCount = 0;
	}
	
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y + ", direccion: " + direccionToString(direccionActual) + ", zona: " + miZona; 
	}

}