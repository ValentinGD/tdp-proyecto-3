package logica.estados.enemigos;

import java.util.ArrayList;
import java.util.List;

import logica.Escenario;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.enemigos.Enemigo1;

public class PersiguiendoEnemigo2 extends PersiguiendoEnemigoAbstracto {

	public PersiguiendoEnemigo2() {
		super();
	}

	@Override
	public void mover() {
		//System.out.println("Moviendo enemigo 2");
		actualizarDireccion();
		if (puedeMover(enemigo, enemigo.getDireccionActual())) {
			
			calcularPosicionDestino(enemigo);
			enemigo.setPosicion(xDestino, yDestino);
			Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
			Escenario.getInstancia().reubicar(enemigo);
			
		}
	}

	private void actualizarDireccion() {
		if (enemigo.puedeGirar()) {
			
			Personaje personaje = Personaje.getInstancia();
			Enemigo enemigo1 = Enemigo1.getInstancia();
			
			int xObjetivo = personaje.getX() + (personaje.getX() - enemigo1.getX());
			int yObjetivo = personaje.getY() + (personaje.getY() - enemigo1.getY());
			
			xObjetivo = Math.min(Escenario.getInstancia().getAncho(), xObjetivo);
			yObjetivo = Math.min(Escenario.getInstancia().getAlto(), yObjetivo);
			
			xObjetivo = Math.max(0, xObjetivo);
			yObjetivo = Math.max(0, yObjetivo);

//			System.out.println("\txObjetivo: " + xObjetivo);
//			System.out.println("\tyObjetivo: " + yObjetivo);
			
			int [] direccionesPosibles = new int[] {
				Movible.DIRECCION_IZQUIERDA,
				Movible.DIRECCION_DERECHA,
				Movible.DIRECCION_ARRIBA,
				Movible.DIRECCION_ABAJO
			};
			
//			System.out.println("\tDirecciones posibles: ");
//			for (int direccion : direccionesPosibles) {
//				System.out.println("\t\t" + Movible.direccionToString(direccion));
//			}
			
			int [] direccionesValidas = calcularDireccionesValidas(direccionesPosibles);
			
//			System.out.println("\tDirecciones validas: ");
//			for (int direccion : direccionesValidas) {
//				System.out.println("\t\t" + Movible.direccionToString(direccion));
//			}
			
			int direccionDefinitiva = calcularMejorDireccion(xObjetivo, yObjetivo, direccionesValidas);
			
//			System.out.println("\tDireccion definitiva: ");
//			System.out.println("\t\t" + Movible.direccionToString(direccionDefinitiva));
			
			if (!enemigo.esCambioDeDireccionValido(direccionDefinitiva)) {
				System.out.println("\tERROR EN CALCULO DE DIRECCION DE ENEMIGO 2");
			} else {
				enemigo.setDireccionActual(direccionDefinitiva);
			}
		}
	}
	
	private int[] calcularDireccionesValidas(int... direcciones) {
		List<Integer> direccionesValidas = new ArrayList<Integer>(direcciones.length);
		
		for (int direccion : direcciones) {
			if (enemigo.esCambioDeDireccionValido(direccion)) {
				//System.out.println("Es direccion valida: " + Movible.direccionToString(direccion));
				if (puedeMover(enemigo, direccion)) {
					direccionesValidas.add(direccion);
				}
			}
			
		}
		
//		System.out.println("\tdirecciones validas calculadas:");
//		for (int d : direccionesValidas) {
//			System.out.println("\t\t" + Movible.direccionToString(d));
//		}
		
		int [] direccionesValidasArr = new int[direccionesValidas.size()];
		for (int i = 0; i < direccionesValidas.size(); ++i) {
			direccionesValidasArr[i] = direccionesValidas.get(i);
		}
		
		return direccionesValidasArr;
	}

	/**
	 * @param direcciones
	 * @return
	 */
	private int calcularMejorDireccion(int xObjetivo, int yObjetivo, int... direcciones) {
		int mejorDireccion = enemigo.getDireccionActual();
		double distanciaMinima = Double.MAX_VALUE;
		for (int direccion : direcciones) {
			calcularPosicionDestino(enemigo, direccion);
			double distanciaActual = distancia(xDestino, yDestino, xObjetivo, yObjetivo);
//			System.out.println("Distancia hacia " + Movible.direccionToString(direccion) + ": " + distanciaActual);
			if (distanciaActual < distanciaMinima && puedeMover(enemigo, direccion)) {
				mejorDireccion = direccion;
				distanciaMinima = distanciaActual;
			}
		}
		return mejorDireccion;
	}

	/**
	 * Calcula la direccion que falta en 
	 * @param direcciones
	 * @return
	 */
	private int getDireccionRestante(int... direcciones) {
		boolean estaLaOpuesta;
		
		for (int direccion : direcciones) {
			estaLaOpuesta = false;
			
			for (int posibleOpuesta : direcciones) {
				estaLaOpuesta = estaLaOpuesta || Movible.sonDireccionesOpuestas(direccion, posibleOpuesta);
			}
			
			if (!estaLaOpuesta) {
				return Movible.getDireccionOpuesta(direccion);
			}
		}
		return Movible.DIRECCION_DERECHA;
	}

	private int calcularDireccionOptimaEjeX(int xObjetivo) {
		int direccion = Movible.DIRECCION_DERECHA;
		
		if (xObjetivo < enemigo.getX()) {
			direccion = Movible.DIRECCION_IZQUIERDA;
		}
		
		return direccion;
	}
	
	private int calcularDireccionOptimaEjeY(int yObjetivo) {
		int direccion = Movible.DIRECCION_ABAJO;
		
		if (yObjetivo < enemigo.getY()) {
			direccion = Movible.DIRECCION_ARRIBA;
		}
		
		return direccion;
	}
	
	private double distancia(int x1, int y1, int x2, int y2) {
		return Math.hypot(x1 - x2, y1 - y2);
	}
}
