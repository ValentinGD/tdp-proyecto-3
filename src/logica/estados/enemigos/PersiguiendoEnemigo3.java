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
	public void mover() {
		actualizarDireccion();
		if (puedeMover(enemigo, enemigo.getDireccionActual())) {	
			calcularPosicionDestino(enemigo);
			enemigo.setPosicion(xDestino, yDestino);
			Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
			Escenario.getInstancia().reubicar(enemigo);	
		}
	}

	private void actualizarDireccion() {
		if(enemigo.puedeGirar()) {
			Personaje personaje = Personaje.getInstancia();
			
			int xObjetivo = 0; 
			int yObjetivo = 0;
			
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
			
			xObjetivo = Math.min(Escenario.getInstancia().getAncho(), yObjetivo);
			yObjetivo = Math.min(Escenario.getInstancia().getAlto(), yObjetivo);
			xObjetivo = Math.max(0, xObjetivo);
			yObjetivo = Math.max(0, yObjetivo);
			
			int [] direccionesValidas = calcularDireccionesValidas();
			int direccionDefinitiva = calcularMejorDireccion(xObjetivo,yObjetivo,direccionesValidas);
			
			if(!enemigo.esCambioDeDireccionValido(direccionDefinitiva)) {
				System.out.println("\\tERROR EN CALCULO DE DIRECCION DE ENEMIGO 3");
			}else {
				enemigo.setDireccionActual(direccionDefinitiva);
			}
		}
	}

	private int[] calcularDireccionesValidas() {
		int [] direccionesPosibles = new int []{
				Movible.DIRECCION_IZQUIERDA,
				Movible.DIRECCION_DERECHA,
				Movible.DIRECCION_ARRIBA,
				Movible.DIRECCION_ABAJO
		};
		
		List<Integer> direccionesValidas = new ArrayList<Integer>(direccionesPosibles.length);
		
		for(int direccion: direccionesPosibles) {
			if(enemigo.esCambioDeDireccionValido(direccion))
				if(puedeMover(enemigo,direccion))
					direccionesValidas.add(direccion);
		}
		int [] direccionesValidasArr = new int [direccionesValidas.size()];
		for(int i = 0; i < direccionesValidas.size(); i++)
			direccionesValidasArr[i] = direccionesValidas.get(i);
		
		return direccionesValidasArr;
	}
	
	private int calcularMejorDireccion(int xObjetivo, int yObjetivo, int[] direccionesValidas) {
		int mejorDireccion = enemigo.getDireccionActual();
		double distanciaMinima = Double.MAX_VALUE;
		double distanciaActual;
		for(int direccion: direccionesValidas) {
			calcularPosicionDestino(enemigo,direccion);
			distanciaActual = distancia(xDestino,yDestino,xObjetivo,yObjetivo);
			if((distanciaActual < distanciaMinima) && puedeMover(enemigo,direccion)) {
				mejorDireccion = direccion;
				distanciaMinima = distanciaActual;
			}
		}
		return mejorDireccion;
	}

	private double distancia(int x1, int y1, int x2, int y2) {
		return Math.hypot(x1 - x2, y1 - y2);
	}
}
