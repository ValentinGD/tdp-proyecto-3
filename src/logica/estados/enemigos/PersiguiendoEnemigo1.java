package logica.estados.enemigos;

import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;

public class PersiguiendoEnemigo1 extends PersiguiendoEnemigoAbstracto {

	public PersiguiendoEnemigo1() {
		super();
	}

	@Override
	public void mover() {
		if(puedeMover(enemigo, enemigo.getDireccionActual())) {
			switch(direccionActual) {
			case Movible.DIRECCION_ABAJO:
				
				enemigo.setY(enemigo.getY()+1);
				
			break;
			case Movible.DIRECCION_ARRIBA:
				
				enemigo.setY(enemigo.getY()-1);
				
			break;
			case Movible.DIRECCION_DERECHA:
				
				enemigo.setX(enemigo.getX()+1);
				
			break;
			case Movible.DIRECCION_IZQUIERDA:
	
				enemigo.setX(enemigo.getX()-1);
	
			break;
			}
		}else {
			calcularNuevaDireccion();
			mover();
		}
	}
	
	private void calcularNuevaDireccion() {
		int direccionEjeX=0;
		int direccionEjeY = 0;
		Personaje personaje = Personaje.getInstancia();
		
		if(enemigo.getX()-personaje.getX()<0) {
			direccionEjeX=Movible.DIRECCION_IZQUIERDA;
		}else {
			direccionEjeX=Movible.DIRECCION_DERECHA;
		}
		
		if(enemigo.getY()-personaje.getY()<0) {
			direccionEjeY=Movible.DIRECCION_ARRIBA;
		}else {
			direccionEjeY=Movible.DIRECCION_ABAJO;
		}
		
		if(Math.abs(enemigo.getX()-personaje.getX())<Math.abs(enemigo.getX()-personaje.getX())) {
			if(direccionEjeX!=direccionActual*(-1)){
				setDireccion(direccionEjeX);
				if(!puedeMover(enemigo, enemigo.getDireccionActual())) {
					if(direccionEjeY!=direccionActual*(-1)) {
						setDireccion(direccionEjeY);
							if(!puedeMover(enemigo, enemigo.getDireccionActual())) {
								setDireccion(direccionEjeY*(-1));
							}
					}else {
						setDireccion(direccionEjeY*(-1));
					}
				}
			}else {
				setDireccion(direccionEjeY);
				if(!puedeMover(enemigo, enemigo.getDireccionActual())) {
					setDireccion(direccionEjeY*(-1));
				}
			}
		}else {
			if(direccionEjeY!=direccionActual*(-1)){
				setDireccion(direccionEjeY);
				if(!puedeMover(enemigo, enemigo.getDireccionActual())) {
					if(direccionEjeX!=direccionActual*(-1)) {
						setDireccion(direccionEjeX);
						if(!puedeMover(enemigo, enemigo.getDireccionActual())) {
							setDireccion(direccionEjeX*(-1));
						}
					}else {
						setDireccion(direccionEjeX*(-1));
					}
				}
			}else {
					setDireccion(direccionEjeX);
					if(!puedeMover(enemigo, enemigo.getDireccionActual())) {
					setDireccion(direccionEjeX*(-1));
				}
			}
		}
	}
}
