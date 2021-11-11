package logica.entidades;

import java.util.ArrayList;

import logica.Escenario;
import logica.Posicion;


public abstract class Movible extends Entidad {
	
	public static final int DIRECCION_DERECHA = 1;
	public static final int DIRECCION_IZQUIERDA = -1;
	public static final int DIRECCION_ARRIBA = -2;
	public static final int DIRECCION_ABAJO = 2;
	
	public abstract ArrayList<Posicion> mover();
	
	public static boolean esDireccionValida(int direccion) {
		return 	(direccion == DIRECCION_DERECHA) ||
				(direccion == DIRECCION_IZQUIERDA) ||
				(direccion == DIRECCION_ARRIBA) ||
				(direccion == DIRECCION_ABAJO);
	}
	
	/*
	public void mover(int direccion) {
		Posicion aux=pos.clone();
		switch(direccion){
			case 0:
				
				aux.setY(pos.getY()-1);
				if(Escenario.puedeMover(aux)) {
					pos.setY(pos.getY()-1);
					Escenario.eliminarPickUp(pos);}
				
			break;
			
			case 1:
				
				aux.setX(pos.getX()-1);
				if(Escenario.puedeMover(aux)) {
					pos.setX(pos.getX()-1);
					Escenario.eliminarPickUp(pos);}
				
			break;
			
			case 2:
				
				aux.setY(pos.getY()+1);
				if(Escenario.puedeMover(aux)) {
					pos.setY(pos.getY()+1);
					Escenario.eliminarPickUp(pos);}

			break;
			
			case 3:
				
				aux.setX(pos.getX()+1);
				if(Escenario.puedeMover(aux)) {
					pos.setX(pos.getX()+1);
					Escenario.eliminarPickUp(pos);}
				
			break;
		}
	}
	*/
	
	
}
