package logica.estados.enemigos;

public class PersiguiendoEnemigo1 extends PersiguiendoEnemigoAbstracto {

	public PersiguiendoEnemigo1() {
		super();
	}

	@Override
	protected void calcularCoordenadasObjetivo() {
		xObjetivo = personaje.getX();
		yObjetivo = personaje.getY();
	}

}