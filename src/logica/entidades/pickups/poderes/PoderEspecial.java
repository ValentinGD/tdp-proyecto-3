package logica.entidades.pickups.poderes;

import logica.Visitor;

public abstract class PoderEspecial extends PickUpPoder {
	
	protected PoderEspecial(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
	}
}
