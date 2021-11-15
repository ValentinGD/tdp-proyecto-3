package logica.entidades;

import logica.Visitor;
import logica.Zona;
import vista.EntidadGrafica;
import vista.RepresentacionGrafica;

public abstract class Entidad implements EntidadGrafica {
	
	public static final int TAMANIO = 30;
	
	protected int x;
	protected int y;
	protected Zona miZona;
	
	protected RepresentacionGrafica miRepresentacion;
	
	protected Entidad(int x, int y) {
		miRepresentacion = new RepresentacionGrafica(TAMANIO, this);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Zona getZona() {
		return miZona;
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
	
	public abstract void aceptar(Visitor v);
	
	public String toString() {
		return super.toString() + ", x: " + x + ", y: " + y;
	}
}
