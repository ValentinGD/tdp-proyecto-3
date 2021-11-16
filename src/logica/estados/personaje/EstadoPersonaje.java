package logica.estados.personaje;

import javax.swing.ImageIcon;

import logica.entidades.Personaje;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public abstract class EstadoPersonaje extends EstadoMovible {
	
	protected Personaje personaje;
	
	protected int direccionSiguiente;
	
	protected EstadoPersonaje(Personaje personaje, int direccionActual) {
		super(direccionActual);
		direccionSiguiente = direccionActual;
		this.personaje = personaje;
	}
	
	public void setDireccionSiguiente(int direccionSiguiente) {
		this.direccionSiguiente = direccionSiguiente;
	}

	protected void verificarCambioDireccion() {
		if (direccionActual != direccionSiguiente) {
			boolean giroPermitido = false;
			giroPermitido = estaEnUnaPosibleInterseccion(personaje) || (direccionActual + direccionSiguiente == 0);
			if (giroPermitido && puedeMover(personaje, direccionSiguiente)) {
				System.out.println("se puede cambiar de direccion");
				direccionActual = direccionSiguiente;
				personaje.setDireccion(direccionActual);
			} else {
				System.out.println("no se puede cambiar de direccion.");
			}
		}
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
