package logica;

import java.util.ArrayList;
import java.util.List;

import logica.entidades.Entidad;

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
	
	public boolean contiene(Entidad e) {
		return contiene(e.getX(), e.getY());
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
	
	public void setEntidad(Entidad entidad) {
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
}
