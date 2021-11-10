package Mapas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import logica.Posicion;
import logica.entidades.Entidad;
import logica.entidades.Movible;

public class Mapa {
	
	
	private List<Entidad> entidades;
	private int cantPickup;
	
	public Mapa(String path) {
		
	}
	
	public int getcantPickup() {
		return cantPickup;
	}
	
	
	
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
}
