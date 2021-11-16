package logica.estados.personaje;

import javax.swing.ImageIcon;

import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public abstract class EstadoPersonaje extends EstadoMovible {
	
	protected Personaje personaje;
	
	protected EstadoPersonaje(Personaje personaje) {
		super(personaje, personaje.getDireccionActual());
		this.personaje = personaje;
	}

	protected void verificarCambioDireccion() {
		if (personaje.getDireccionActual() != personaje.getDireccionSiguiente()) {
			//System.out.println("Chequeando cambio de direccion");
			boolean sonDireccionesOpuestas = Movible.sonDireccionesOpuestas(personaje.getDireccionActual(), personaje.getDireccionSiguiente());
			boolean giroPermitido = personaje.puedeGirar() || sonDireccionesOpuestas;
			
			if (giroPermitido && puedeMover(personaje, personaje.getDireccionSiguiente())) {
				//System.out.println("se puede cambiar de direccion");
				direccionActual = personaje.getDireccionSiguiente();
				personaje.actualizarDireccion();
				if (personaje.getDireccionActual() != personaje.getDireccionSiguiente()) {
//					System.out.println("Error en seteo de direcciones de personaje.-----------------------------------------------");
//					System.out.println("\tpersonaje.getDireccionActual(): " + personaje.getDireccionActual());
//					System.out.println("personaje.getDireccionSiguiente(): " + personaje.getDireccionSiguiente());
				}
			} else {
//				System.out.println("no se puede cambiar de direccion.");
//				System.out.println("\tdirecciones opuestas: " + sonDireccionesOpuestas);
//				System.out.println("\tgiro permitido: " + giroPermitido);
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
