package logica;

import javax.swing.ImageIcon;

public abstract class Entidad {
	protected Posicion pos;

	public Posicion getPosicion() {
		return pos;
	}
	
	public void setPosicion(Posicion p) {
		pos = p;
	}
	
	public abstract ImageIcon getRepresentacionGrafica();
}
