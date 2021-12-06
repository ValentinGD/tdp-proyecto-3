package logica.estados.enemigos;

import logica.entidades.enemigos.Enemigo1;

public class PersiguiendoEnemigo2 extends PersiguiendoEnemigoAbstracto {

	protected Enemigo1 enemigo1;

	public PersiguiendoEnemigo2(Enemigo1 enemigo1) {
		super();
		this.enemigo1 = enemigo1;
	}

	@Override
	protected void calcularCoordenadasObjetivo() {
		xObjetivo = personaje.getX() + (personaje.getX() - enemigo1.getX());
		yObjetivo = personaje.getY() + (personaje.getY() - enemigo1.getY());
	}

}