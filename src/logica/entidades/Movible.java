package logica.entidades;

import logica.Entidad;
import logica.Escenario;
import logica.Posicion;

public abstract class Movible extends Entidad {

	public  void mover(int direccion) {
		Posicion aux=pos.clone();
		switch(direccion){
			case 0:
				
				aux.setFila(pos.getY()-1);
				if(Escenario.puedeMover(aux)) {
					pos.setFila(pos.getY()-1);
					Escenario.eliminarPickUp(pos);}
				
			break;
			
			case 1:
				
				aux.setColum(pos.getColum()-1);
				if(Escenario.puedeMover(aux)) {
					pos.setColum(pos.getColum()-1);
					Escenario.eliminarPickUp(pos);}
				
			break;
			
			case 2:
				
				aux.setFila(pos.getY()+1);
				if(Escenario.puedeMover(aux)) {
					pos.setFila(pos.getY()+1);
					Escenario.eliminarPickUp(pos);}

			break;
			
			case 3:
				
				aux.setColum(pos.getColum()+1);
				if(Escenario.puedeMover(aux)) {
					pos.setColum(pos.getColum()+1);
					Escenario.eliminarPickUp(pos);}
				
			break;
		}
	}
}
