package logica.entidades.pickups.poderes;


import logica.Visitor;
import logica.entidades.Personaje;
import logica.entidades.PickUp;

public abstract class PickUpPoder extends PickUp {

	protected PickUpPoder(int x, int y, int puntos, int vidasExtras, int aumentoVelocidad, boolean inmortalidad, boolean matarEnemigo, int tiempoDuracion) {
		super(x, y);
	}
	
	public void aceptar(Visitor v) {
		v.visitarPickUpPoder(this);
	}
	
	public abstract void aplicarPoder(Personaje personaje);
}
