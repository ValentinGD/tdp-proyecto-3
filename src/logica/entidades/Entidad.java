package logica.entidades;

import app.App;
import logica.Visitor;
import logica.Zona;
import vista.EntidadGrafica;
import vista.RepresentacionGrafica;

public abstract class Entidad implements EntidadGrafica {
	
	public static final int TAMANIO = Integer.parseInt(App.configuration.getProperty("TamanioEntidad"));
	
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
	
	public boolean colisionaConEntidadEnPosicion(int xEntidad, int yEntidad) {
		boolean contiene = false;
		
		boolean dentroLimitesIzquierda 	= (x - TAMANIO) < xEntidad;
		boolean dentroLimitesDerecha 	= 				   xEntidad < (x + TAMANIO);
		
		boolean dentroLimitesArriba 	= (y - TAMANIO) < yEntidad;
		boolean dentroLimitesAbajo		= 				  yEntidad < (y + TAMANIO);
		
		contiene = dentroLimitesIzquierda && dentroLimitesDerecha && dentroLimitesArriba && dentroLimitesAbajo;
		
		return contiene;
	}
	
	public abstract void aceptar(Visitor v);
	
	public String toString() {
		return super.toString() + ", x: " + x + ", y: " + y;
	}

}