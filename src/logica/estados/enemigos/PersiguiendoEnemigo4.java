package logica.estados.enemigos;

import logica.Escenario;
import logica.entidades.Movible;
import logica.entidades.Personaje;

public class PersiguiendoEnemigo4 extends PersiguiendoEnemigoAbstracto {
	
	public PersiguiendoEnemigo4() {
		super();
	}

	public void mover() {
		if(puedeMover(enemigo, enemigo.getDireccionActual())) {
			//System.out.println("\tEl enemigo se puede mover hacia " + Movible.direccionToString(direccionActual));
			
			calcularPosicionDestino(enemigo);
			enemigo.setPosicion(xDestino, yDestino);
			Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
			Escenario.getInstancia().reubicar(enemigo);
			
			System.out.println("Objetivo Enemigo 4: <x: " + xObjetivo + ", y: " + yObjetivo + ">");

		}else {
			//System.out.println("El enemigo NO se puede mover hacia " + Movible.direccionToString(direccionActual));
		}
		if(enemigo.puedeGirar()) {
			calcularNuevaDireccion();
		}
	}
	
	private void calcularNuevaDireccion() {
		Personaje personaje = Personaje.getInstancia();
		
		int direccionEjeX=0;
		int direccionEjeY = 0;
		int mejorDireccion=0;
		int direccionAux=0;
		int nuevaDireccion=0;
		int diferenciaEnX=enemigo.getX()-personaje.getX();
		int diferenciaEnY=enemigo.getY()-personaje.getY();
		
		if(Math.abs(diferenciaEnX)< 8*36 & Math.abs(diferenciaEnY)< 8*36) {
			if(enemigo.getY()>9*36) {
				diferenciaEnY=enemigo.getY()-720;
			}else {
				diferenciaEnY=enemigo.getY()-36;
				
			}
			diferenciaEnX=enemigo.getX()-36;
		}
		
		
		if(diferenciaEnX < 0) {//si el personaje esta a la derecha
			direccionEjeX=Movible.DIRECCION_DERECHA;
		} else {
			direccionEjeX=Movible.DIRECCION_IZQUIERDA;
		}
		
		if(diferenciaEnY < 0) {//si el personaje esta abajo
			direccionEjeY=Movible.DIRECCION_ABAJO;
		} else {
			direccionEjeY=Movible.DIRECCION_ARRIBA;
		}
		
		//Este if se asegura que nos movamos en la direccion que nos acerque mas lento al personaje
		if(Math.abs(diferenciaEnX) <= Math.abs(diferenciaEnY)){//si la distancia en el eje X al personaje es menor que la distancia en el eje Y
			
			if(diferenciaEnX != 0) {//si el personaje no esta en la misma columna
				mejorDireccion = direccionEjeX;
				direccionAux = direccionEjeY;
			} else {
				mejorDireccion = direccionEjeY;
				direccionAux = direccionEjeX;
			}
			
		}else {
			
			if(diferenciaEnY != 0) {//si el personaje no esta en la misma fila
				mejorDireccion=direccionEjeY;
				direccionAux=direccionEjeX;
			} else {
				mejorDireccion=direccionEjeX;
				direccionAux=direccionEjeY;
			}
			
		}
		nuevaDireccion = calcularDireccion(mejorDireccion,direccionAux);
		if (!Movible.sonDireccionesOpuestas(nuevaDireccion, enemigo.getDireccionActual())) {
			enemigo.setDireccionActual(nuevaDireccion);
			//System.out.println("Se cambio la direccion del enemigo: " + Movible.direccionToString(nuevaDireccion));
		}
	}
	
	private int calcularDireccion(int direccion,int direccionAux) {
		int nuevaDireccion=0;
		int direccion1ra=0;
		int direccion2da=0;
		int direccion3ra=0;
		int marcador=0;
		if(Movible.sonDireccionesOpuestas(direccion, enemigo.getDireccionActual())) {
			marcador=+1;
		}
		if(Movible.sonDireccionesOpuestas(direccionAux, enemigo.getDireccionActual())) {
			marcador=+2;
		}
		if(Movible.sonDireccionesOpuestas(direccion*(-1), enemigo.getDireccionActual())) {
			marcador=+3;
		}
		switch(marcador) {
		case 0:
			
			direccion1ra=direccion;
			direccion2da=direccionAux;
			direccion3ra=direccion*(-1);
			
		break;
		case 1:
			
			direccion1ra=direccionAux;
			direccion2da=direccion*(-1);
			direccion3ra=direccionAux*(-1);
			
		break;
		case 2:
	
			direccion1ra=direccion;
			direccion2da=direccion*(-1);
			direccion3ra=direccionAux*(-1);
	
		break;
		case 3:
	
			direccion1ra=direccion;
			direccion2da=direccionAux;
			direccion3ra=direccionAux*(-1);
	
			break;
		}
	nuevaDireccion=verificarDireccion(direccion1ra,direccion2da,direccion3ra);
	return nuevaDireccion;
	}
	
	private int verificarDireccion(int d1, int d2, int d3) {
		int nuevaDireccion=enemigo.getDireccionActual();
		if(puedeMover(enemigo,d1)){
			nuevaDireccion=d1;
			//System.out.println("Puede mover d1");
		}else if(puedeMover(enemigo,d2)) {
				nuevaDireccion=d2;
				//System.out.println("Puede mover d2");
		}else if (puedeMover(enemigo,d3)) {
			nuevaDireccion=d3;
			//System.out.println("Puede mover d3");
		}
		
		return nuevaDireccion;
	}

	@Override
	protected void calcularCoordenadasObjetivo() {
		// TODO Auto-generated method stub
		
	}
}
