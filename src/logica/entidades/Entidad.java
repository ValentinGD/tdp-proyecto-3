package logica.entidades;

import javax.swing.ImageIcon;

import logica.Zona;

public abstract class Entidad {
	protected int x;
	protected int y;
	protected Zona miZona;
	protected int ancho;
	protected int alto;

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Zona getZona() {
		return miZona;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return ancho;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setZona(Zona z) {
		miZona=z;
	}
	
	public void setAncho(int a) {
		ancho=a;
	}
	
	public void setAlto(int a) {
		alto=a;
	}
	
	
	public abstract ImageIcon getRepresentacionGrafica();
}
