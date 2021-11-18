package logica.estados.enemigos;

import logica.Escenario;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;

public class PersiguiendoEnemigo1 extends PersiguiendoEnemigoAbstracto {

	public PersiguiendoEnemigo1() {
		super();
	}

	@Override
	public void mover() {
		if (enemigo.getDireccionActual() != direccionActual) {
			System.out.println("ERROR EN DIRECCION ACTUAL DE ENEMIGO 1 -----------------------------------------------------------");
		}
		if(puedeMover(enemigo, direccionActual)) {
			//System.out.println("\tEl enemigo se puede mover hacia " + Movible.direccionToString(direccionActual));
			
			switch(direccionActual) {
			
				case Movible.DIRECCION_ABAJO:
					
					enemigo.setY(enemigo.getY()+Movible.VELOCIDAD);
					Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
					Escenario.getInstancia().reubicar(enemigo);
					
				break;
				case Movible.DIRECCION_ARRIBA:
					
					enemigo.setY(enemigo.getY()-Movible.VELOCIDAD);
					Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
					Escenario.getInstancia().reubicar(enemigo);
					
				break;
				case Movible.DIRECCION_DERECHA:
					
					enemigo.setX(enemigo.getX()+Movible.VELOCIDAD);
					Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
					Escenario.getInstancia().reubicar(enemigo);
					
				break;
				case Movible.DIRECCION_IZQUIERDA:
		
					enemigo.setX(enemigo.getX()-Movible.VELOCIDAD);
					Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
					Escenario.getInstancia().reubicar(enemigo);
		
				break;
			}

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
		
		if(diferenciaEnX<0) {
			direccionEjeX=Movible.DIRECCION_DERECHA;
		} else {
			direccionEjeX=Movible.DIRECCION_IZQUIERDA;
		}
		
		if(diferenciaEnY<0) {
			direccionEjeY=Movible.DIRECCION_ABAJO;
		} else {
			direccionEjeY=Movible.DIRECCION_ARRIBA;
		}
		
		if(Math.min(diferenciaEnX, diferenciaEnY) == diferenciaEnX ){
			
			if(diferenciaEnX!=0) {
				mejorDireccion=direccionEjeX;
				direccionAux=direccionEjeY;
			} else {
				mejorDireccion=direccionEjeY;
				direccionAux=direccionEjeX;
			}
			
		}else {
			
			if(diferenciaEnY!=0) {
				mejorDireccion=direccionEjeY;
				direccionAux=direccionEjeX;
			} else {
				mejorDireccion=direccionEjeX;
				direccionAux=direccionEjeY;
			}
			
		}
		direccionActual=calcularDireccion(mejorDireccion,direccionAux);
		enemigo.setDireccionActual(direccionActual);
	}
	
	private int calcularDireccion(int direccion,int direccionAux) {
		int nuevaDireccion=0;
		int direccion1ra=0;
		int direccion2da=0;
		int direccion3ra=0;
		int marcador=0;
		if(Movible.sonDireccionesOpuestas(direccion, direccionActual)) {
			marcador=+1;
		}
		if(Movible.sonDireccionesOpuestas(direccionAux, direccionActual)) {
			marcador=+2;
		}
		if(Movible.sonDireccionesOpuestas(direccion*(-1), direccionActual)) {
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
		int nuevaDireccion=0;
		if(puedeMover(enemigo,d1)){
			nuevaDireccion=d1;
			//System.out.println("Puede mover d1");
		}else if(puedeMover(enemigo,d2)) {
				nuevaDireccion=d2;
				//System.out.println("Puede mover d2");
		}else {
			nuevaDireccion=d3;
			//System.out.println("Puede mover d3");
		}
		
		return nuevaDireccion;
	}
}
