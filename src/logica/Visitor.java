package logica;

import logica.entidades.Pared;
import logica.entidades.Personaje;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PickUpPuntos;

public interface Visitor {
	
	public void visitarEnemigo(Enemigo e);
	public void visitarPersonaje(Personaje p);
	public void visitarPickUpPuntos(PickUpPuntos p);
	public void visitarPickUpPoder(PickUpPoder p);
	public void visitarPared(Pared p);
}
