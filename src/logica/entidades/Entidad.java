package logica.entidades;

import javax.swing.ImageIcon;

import logica.Zona;

public abstract class Entidad {
	protected int x;
	protected int y;
	protected Zona zona;

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Zona getZona() {
		return zona;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setZona(Zona z) {
		zona=z;
	}
	public abstract ImageIcon getRepresentacionGrafica();
}
