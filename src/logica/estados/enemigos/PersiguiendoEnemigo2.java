package logica.estados.enemigos;

import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.entidades.enemigos.Enemigo1;

public class PersiguiendoEnemigo2 extends PersiguiendoEnemigoAbstracto {
	
	protected Enemigo1 enemigo1;
	
	public PersiguiendoEnemigo2() {
		super();
		enemigo1 = Enemigo1.getInstancia();
	}

	@Override
	protected void calcularCoordenadasObjetivo() {
		xObjetivo = personaje.getX() + (personaje.getX() - enemigo1.getX());
		yObjetivo = personaje.getY() + (personaje.getY() - enemigo1.getY());
	}
}
