package Mapas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import logica.Posicion;
import logica.entidades.Movible;

public class Mapa {
	
	public static final Mapa MAPA_VACIO = new Mapa(0, 0);
	
	private Posicion[][] posiciones;
	private int cantPickup;
	private int cantEnemigos;
	
	private ArrayList<Movible> movibles;
	
	public Mapa(int alto, int ancho) {
		posiciones = new Posicion[alto][ancho];
		cantPickup = 0;
		cantEnemigos = 0;
		movibles = new ArrayList<Movible>();
	}
	
	public Posicion[][] getPosiciones() {
		return posiciones;
	}
	
	public void addPosicion(Posicion p) {
		posiciones[p.getY()][p.getX()] = p;
		if (p.hayPickUp()) {
			cantPickup++;
		}
		if (p.getEnemigo() != null) {
			cantEnemigos++;
			//movibles.add(p.getEnemigo());
		}
		if (p.getPersonaje() != null) {
			movibles.add(p.getPersonaje());
		}
	}
	
	public int getcantPickup() {
		return cantPickup;
	}
	
	public int getCantEnemigos() {
		return cantEnemigos;
	}
	
	public int getAncho() {
		if (getAlto() > 0) {
			return posiciones[0].length;
		}
		return 0;
	}
	
	public int getAlto() {
		return posiciones.length;
	}
	
	public ArrayList<Movible> getMovibles() {
		return movibles;
	}
	
	public String toString() {
		String s =  "alto: " + getAlto() + ", ancho: " + getAncho() + "\n";
		s += "posiciones:\n";
		for (Posicion[] fila : posiciones) {
			s += "\t" + Arrays.deepToString(fila) + "\n";
		}
		return s;
	}
}
