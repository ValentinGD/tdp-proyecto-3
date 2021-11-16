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
		if(puedeMover(enemigo, direccionActual)) {
			switch(direccionActual) {
			case Movible.DIRECCION_ABAJO:
				
				enemigo.setY(enemigo.getY()+1);
				Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
				Escenario.getInstancia().reubicar(enemigo);
				
			break;
			case Movible.DIRECCION_ARRIBA:
				
				enemigo.setY(enemigo.getY()-1);
				Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
				Escenario.getInstancia().reubicar(enemigo);
				
			break;
			case Movible.DIRECCION_DERECHA:
				
				enemigo.setX(enemigo.getX()+1);
				Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
				Escenario.getInstancia().reubicar(enemigo);
				
			break;
			case Movible.DIRECCION_IZQUIERDA:
	
				enemigo.setX(enemigo.getX()-1);
				Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
				Escenario.getInstancia().reubicar(enemigo);
	
			break;
			}

		}else {
		}
		if(enemigo.puedeGirar()) {
		calcularNuevaDireccion();}
	}
	
	private void calcularNuevaDireccion() {
		int direccionEjeX=0;
		int direccionEjeY = 0;
		Personaje personaje = Personaje.getInstancia();
		
		
		if(enemigo.getX()-personaje.getX()<0) {
			direccionEjeX=Movible.DIRECCION_DERECHA;
		}else {
			direccionEjeX=Movible.DIRECCION_IZQUIERDA;
		}
		
		if(enemigo.getY()-personaje.getY()<0) {
			direccionEjeY=Movible.DIRECCION_ABAJO;
		}else {
			direccionEjeY=Movible.DIRECCION_ARRIBA;
		}
		int diferenciaEnX=Math.abs(enemigo.getX()-personaje.getX());
		int diferenciaEnY=Math.abs(enemigo.getY()-personaje.getY());
		
		if(diferenciaEnX<diferenciaEnY && diferenciaEnX!= 0) {
			if((Movible.sonDireccionesOpuestas(direccionActual, direccionEjeX) && (puedeMover(enemigo, direccionEjeX)))){
				setDireccion(direccionEjeX);
				enemigo.setDireccionActual(direccionEjeX);
			}else {
				if((Movible.sonDireccionesOpuestas(direccionActual, direccionEjeY) && (puedeMover(enemigo, direccionEjeY)))) {
					setDireccion(direccionEjeY);
					enemigo.setDireccionActual(direccionEjeY);
				}else {
						if(Movible.sonDireccionesOpuestas(direccionActual, direccionEjeX*(-1)) && (puedeMover(enemigo, direccionEjeX))){
							setDireccion(direccionEjeX*(-1));
							enemigo.setDireccionActual(direccionEjeX*(-1));
						}else {
							setDireccion(direccionEjeY*(-1));
							enemigo.setDireccionActual(direccionEjeY*(-1));
						}
				}
			}
		}else {
			if((Movible.sonDireccionesOpuestas(direccionActual, direccionEjeY) && (puedeMover(enemigo, direccionEjeY)))) {
				setDireccion(direccionEjeY);
				enemigo.setDireccionActual(direccionEjeY);
			}else {
				if((Movible.sonDireccionesOpuestas(direccionActual, direccionEjeX) && (puedeMover(enemigo, enemigo.getDireccionActual())))){
					setDireccion(direccionEjeX);
					enemigo.setDireccionActual(direccionEjeX);
				}else {
					if((Movible.sonDireccionesOpuestas(direccionActual, direccionEjeY*(-1)) && (puedeMover(enemigo, direccionEjeY*(-1))))) {
						setDireccion(direccionEjeY*(-1));
						enemigo.setDireccionActual(direccionEjeY*(-1));
					}else {
					setDireccion(direccionEjeX*(-1));
					enemigo.setDireccionActual(direccionEjeX*(-1));
					}
				}
			}
		}
	}
	private boolean unicaDireccion() {
		boolean d1,d2,d3,d4;
		d1=puedeMover(enemigo,Movible.DIRECCION_ARRIBA) && Movible.DIRECCION_ARRIBA!= direccionActual*(-1);
		d2=puedeMover(enemigo,Movible.DIRECCION_ABAJO) && Movible.DIRECCION_ABAJO!= direccionActual*(-1);
		d3=puedeMover(enemigo,Movible.DIRECCION_DERECHA) && Movible.DIRECCION_DERECHA!= direccionActual*(-1);
		d4=puedeMover(enemigo,Movible.DIRECCION_IZQUIERDA) && Movible.DIRECCION_IZQUIERDA!= direccionActual*(-1);
		return d1 || d2 || d3 || d4;
	}
}
