package logica.niveles;

import java.io.File;
import java.io.IOException;
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
	
	public Movible getMovibles() {
		return (Movible) mapa.getMovibles();
	}
	
	public PuntosNormal getPuntosNormales() {
		return (PuntosNormal) mapa.getPuntosNormales();
	}
	
	public PuntosEspecial getPuntosEspeciales() {
		return (PuntosEspecial) mapa.getPuntosEspeciales();
	}
	
	public PickUpEspecial getPickUpEspeciales() {
		return (PickUpEspecial) mapa.getPoderes();
	}
	
	public Pared getParedes() {
		return (Pared) mapa.getParedes();
	}
	
	public int getVelocidadEnemigo() {
		return velocidadEnemigo;
	}
	
	public int getVelocidadPersonaje() {
		return velocidadPersonaje;
	}
}
