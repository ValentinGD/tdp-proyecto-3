package logica;

import java.util.ArrayList;
import java.util.List;

import logica.entidades.Entidad;
import logica.entidades.Movible;

public class Zona {
	
	private int x;
	private int y;
	private int alto;
	private int ancho;
	private List<Entidad> entidades;
	
	public Zona(int x, int y, int alto, int ancho) {
		this.x=x;
		this.y=y;
		this.alto = alto;
		this.ancho = ancho;
		entidades = new ArrayList<Entidad>();
	}
	
	public boolean contiene(int x, int y) {
		return (this.x <= x) && (x < this.x + ancho) && (this.y <= y) && (y < this.y + alto);
	}
	
	public boolean contieneCoordenadas(Entidad e) {
		return contiene(e.getX(), e.getY());
	}
	
//	public int distanciaABorde(Entidad e) {
//		
//		int distanciaIzquierda = e.getX() - x;
//		int distanciaDerecha = (x + ancho) - (e.getX() + Entidad.TAMANIO);
//		int distanciaArriba = e.getY() - y;
//		int distanciaAbajo = (y + alto) - (e.getY() + Entidad.TAMANIO);
//		
//		
//		
//		return Math.min(Math.min(Math.abs(e.getX() - x), Math.abs(e.getY() - y)), Math.min(Math.abs(e.getX() + ancho - x), Math.abs(e.getY() + alto - y)));
//	}
	
	public boolean estaEnElBorde(Movible m) {
		return estaEnElBorde(m, m.getDireccionActual());
	}
	
	public boolean estaEnElBorde(Movible m, int direccion) {
		boolean estaEnBordeIzquierdo 	= (m.getX() <= x) && direccion == Movible.DIRECCION_IZQUIERDA;
		boolean estaEnBordeDerecho		= (m.getX() + Entidad.TAMANIO >= x + ancho) && direccion == Movible.DIRECCION_DERECHA;
		boolean estaEnBordeArriba	 	= (m.getY() <= y) && direccion == Movible.DIRECCION_ARRIBA;
		boolean estaEnBordeAbajo		= (m.getY() + Entidad.TAMANIO >= y + alto) && direccion == Movible.DIRECCION_ABAJO;
		
		boolean estaEnBorde = estaEnBordeIzquierdo || estaEnBordeDerecho || estaEnBordeArriba || estaEnBordeAbajo;
		return contieneCoordenadas(m) && (estaEnBorde);
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public List<Entidad> getEntidades() {
		return entidades;
	}

	public void setEntidades(List<Entidad> entidades) {
		this.entidades = entidades;
	}
	
	public void addEntidad(Entidad entidad) {
		entidades.add(entidad);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "x: " + x + ", y: " + y + ", ancho: " + ancho + ", alto: " + alto;
	}

	public void eliminar(Entidad e) {
		entidades.remove(e);
	}
}
