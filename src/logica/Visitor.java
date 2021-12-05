package logica;

import logica.entidades.Pared;
import logica.entidades.Personaje;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PickUpPuntos;

public interface Visitor {
	
	public void visit(Enemigo e);
	public void visit(Personaje p);
	public void visit(PickUpPuntos p);
	public void visit(PickUpPoder p);
	public void visit(Pared p);

}