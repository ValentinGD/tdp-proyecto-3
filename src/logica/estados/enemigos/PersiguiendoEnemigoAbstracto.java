package logica.estados.enemigos;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import logica.Escenario;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public abstract class PersiguiendoEnemigoAbstracto extends EstadoEnemigo {
	
	protected int xObjetivo;
	protected int yObjetivo;
	
	protected Personaje personaje;
	
	protected PersiguiendoEnemigoAbstracto() {
		super();
		personaje = Personaje.getInstancia();
	}
	
	public void mover() {
		actualizarDireccion();
		if (puedeMover(enemigo, enemigo.getDireccionActual())) {
			
			calcularPosicionDestino(enemigo);
			enemigo.setPosicion(xDestino, yDestino);
			Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
			Escenario.getInstancia().reubicar(enemigo);
			
		}
	}
	
	protected void actualizarDireccion() {
		if (enemigo.puedeGirar()) {
			
			calcularCoordenadasObjetivo();
			
			xObjetivo = Math.min(Escenario.getInstancia().getAncho(), xObjetivo);
			yObjetivo = Math.min(Escenario.getInstancia().getAlto(), yObjetivo);
			
			xObjetivo = Math.max(0, xObjetivo);
			yObjetivo = Math.max(0, yObjetivo);

			int [] direccionesValidas = calcularDireccionesValidas();
			
			int direccionDefinitiva = calcularMejorDireccion(xObjetivo, yObjetivo, direccionesValidas);
			
			if (!enemigo.esCambioDeDireccionValido(direccionDefinitiva)) {
				System.out.println("\tERROR EN CALCULO DE DIRECCION DE ENEMIGO 2");
			} else {
				enemigo.setDireccionActual(direccionDefinitiva);
			}
		}
	}
	
	protected abstract void calcularCoordenadasObjetivo();
	
	protected int[] calcularDireccionesValidas() {
		List<Integer> direccionesValidas = new ArrayList<Integer>(Movible.DIRECCIONES_POSIBLES.length);
		
		for (int direccion : Movible.DIRECCIONES_POSIBLES) {
			if (enemigo.esCambioDeDireccionValido(direccion)) {
				if (puedeMover(enemigo, direccion)) {
					direccionesValidas.add(direccion);
				}
			}
		}
		
		int [] direccionesValidasArr = new int[direccionesValidas.size()];
		for (int i = 0; i < direccionesValidas.size(); ++i) {
			direccionesValidasArr[i] = direccionesValidas.get(i);
		}
		
		return direccionesValidasArr;
	}

	/**
	 * Devuelve la direccion en la que el enemigo debe moverse para que la distancia hacia su objetivo sea la minima posible.
	 * @param direccionesValidas
	 * @return
	 */
	protected int calcularMejorDireccion(int xObjetivo, int yObjetivo, int[] direccionesValidas) {
		int mejorDireccion = enemigo.getDireccionActual();
		double distanciaMinima = Double.MAX_VALUE;
		double distanciaActual;
		for (int direccion : direccionesValidas) {
			calcularPosicionDestino(enemigo, direccion);
			distanciaActual = distancia(xDestino, yDestino, xObjetivo, yObjetivo);
			if ((distanciaActual < distanciaMinima) && puedeMover(enemigo, direccion)) {
				mejorDireccion = direccion;
				distanciaMinima = distanciaActual;
			}
		}
		return mejorDireccion;
	}

	protected double distancia(int x1, int y1, int x2, int y2) {
		return Math.hypot(x1 - x2, y1 - y2);
	}

	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio) {
		ImageIcon img;
		if (!Personaje.getInstancia().puedeComerEnemigos()) {
			switch(enemigo.getDireccionActual()) {
			case Movible.DIRECCION_ABAJO:
				img = repositorio.getMovibleAbajoGrafico();
				break;
			case Movible.DIRECCION_ARRIBA:
				img = repositorio.getMovibleArribaGrafico();
				break;
			case Movible.DIRECCION_DERECHA:
				img = repositorio.getMovibleDerechaGrafico();
				break;
			case Movible.DIRECCION_IZQUIERDA:
				img = repositorio.getMovibleIzquierdaGrafico();
				break;
			default:
				img = new ImageIcon();
				break;
			}
		} else {
			img = repositorio.getEnemigoAsustadoGrafico();
		}
		return img;
	}
}
