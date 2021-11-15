package logica.estados.personaje;

import javax.swing.ImageIcon;

import logica.entidades.Personaje;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public abstract class EstadoPersonaje extends EstadoMovible {
	
	protected Personaje personaje;
	
	protected EstadoPersonaje(Personaje personaje, int direccionActual) {
		super(direccionActual);
		this.personaje = personaje;
	}
	
	public abstract void mover();
	
	public abstract ImageIcon getRepresentacionGrafica(RepositorioGraficoPersonaje repositorio);
	
//	public static Posicion calcularSiguientePosicion(Personaje personaje, int direccion) {
//		Posicion pos = null;//personaje.getPosicion();
//		int nextX = pos.getX();
//		int nextY = pos.getY();
//		if (direccion == Movible.DIRECCION_IZQUIERDA) {
//			nextX--;
//		}
//		if (direccion == Movible.DIRECCION_DERECHA) {
//			nextX++;
//		}
//		if (direccion == Movible.DIRECCION_ARRIBA) {
//			nextY--;
//		}
//		if (direccion == Movible.DIRECCION_ABAJO) {
//			nextY++;
//		}
//		return new Posicion(nextY, nextX);
//	}
//	
//	public static boolean puedeMover(Posicion nuevaPosicion) {
//		return nuevaPosicion.esHabitable();
//	}
}
