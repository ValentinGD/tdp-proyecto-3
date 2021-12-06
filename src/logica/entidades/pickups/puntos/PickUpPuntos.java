package logica.entidades.pickups.puntos;

import logica.Visitor;
import logica.entidades.PickUp;

public abstract class PickUpPuntos extends PickUp {

	protected PickUpPuntos(int x, int y) {
		super(x, y);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit(this);
	}

}