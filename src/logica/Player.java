package logica;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable{
	
	private String nombre;
	private Integer puntaje;
	
	public Player(String nombre, Integer puntaje) {
		this.nombre = nombre;
		this.puntaje = puntaje;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getPuntaje() {
		return this.puntaje;
	}

}