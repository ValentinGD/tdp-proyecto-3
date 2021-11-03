package logica;

import javax.swing.ImageIcon;

public abstract class Entidad {
	protected Posicion pos;

	public Posicion getPosicion() {
		return pos;
	}
	public void setPosicion(int fila, int columna) {
		pos.setFila(fila);
		pos.setColum(columna);
	}
	
	public abstract ImageIcon getRepresentacionGrafica();
}
