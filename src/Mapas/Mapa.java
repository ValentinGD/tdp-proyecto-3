package Mapas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import logica.Posicion;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.PickUp;
import logica.entidades.pickups.PickUpEspecial;
import logica.entidades.pickups.PickUpPuntos;
import logica.entidades.pickups.PuntosEspecial;
import logica.entidades.pickups.PuntosNormal;

public class Mapa {
	
	
	private List<Movible> movibles;
	private List<PuntosNormal> puntosNormales;
	private List<PuntosEspecial> puntosEspeciales;
	private List<PickUpEspecial> poderes;
	private List<Pared> paredes;
	private int cantPickup;
	private int ancho;
	private int alto;
	
	public Mapa(int ancho, int alto) {
		this.alto=alto;
		this.ancho=ancho;
	}
	
	public int getcantPickup() {
		return cantPickup;
	}
	
	public List<Movible> getMovibles(){
		return movibles;
	}
	
	public List<PuntosNormal> getPuntosNormales(){
		return puntosNormales;
	}
	
	public List<PuntosEspecial> getPuntosEspeciales(){
		return puntosEspeciales;
	}
	
	public List<PickUpEspecial> getPoderes(){
		return poderes;
	}
	
	public List<Pared> getParedes(){
		return paredes;
	}
	
	public void addMovibles(Movible m){
		movibles.add(m);
	}
	
	public void addPuntosNormales(PuntosNormal pN){
		puntosNormales.add(pN);
	}
	
	public void addPuntosEspeciales(PuntosEspecial pE){
		puntosEspeciales.add(pE);
	}
	
	public void addPoderes(PickUpEspecial p){
		poderes.add(p);
	}
	
	public void addParedes(Pared p){
		paredes.add(p);
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
}
