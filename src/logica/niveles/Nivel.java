package logica.niveles;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import Mapas.Mapa;
import logica.Escenario;
import logica.Posicion;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.PickUp;
import logica.entidades.pickups.PickUpEspecial;
import logica.entidades.pickups.PuntosEspecial;
import logica.entidades.pickups.PuntosNormal;
import logica.fabricas.PickUpFactory;


public abstract class Nivel {
	
	protected Mapa mapa;
	protected int velocidadEnemigo;
	protected int velocidadPersonaje;
	
	public Mapa getMapa() {
		return mapa;
	}
	
	public List<Movible> getMovibles() {
		return (List<Movible>) mapa.getMovibles();
	}
	
	public List<PuntosNormal> getPuntosNormales() {
		return (List<PuntosNormal>) mapa.getPuntosNormales();
	}
	
	public List<PuntosEspecial> getPuntosEspeciales() {
		return (List<PuntosEspecial>) mapa.getPuntosEspeciales();
	}
	
	public List<PickUpEspecial> getPickUpEspeciales() {
		return (List<PickUpEspecial>) mapa.getPoderes();
	}
	
	public List<Pared> getParedes() {
		return (List<Pared>) mapa.getParedes();
	}
	
	public int getVelocidadEnemigo() {
		return velocidadEnemigo;
	}
	
	public int getVelocidadPersonaje() {
		return velocidadPersonaje;
	}
	
	public int getAncho() {
		return mapa.getAncho();
	}
	
	public int getAlto() {
		return mapa.getAlto();
	}
}
