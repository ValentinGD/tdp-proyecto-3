package Mapas;

import java.util.ArrayList;
import java.util.List;

import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PuntosEspecial;
import logica.entidades.pickups.puntos.PuntosNormal;

public class Mapa {
	
	
	private List<Movible> movibles;
	private List<PuntosNormal> puntosNormales;
	private List<PuntosEspecial> puntosEspeciales;
	private List<PickUpPoder> poderes;
	private List<Pared> paredes;
	private int cantPickup;
	private int cantColumnas;
	private int cantFilas;
	
	public Mapa() {
		cantFilas = 0;
		cantColumnas = 0;
		cantPickup = 0;
		movibles = new ArrayList<Movible>();
		puntosNormales = new ArrayList<PuntosNormal>();
		puntosEspeciales = new ArrayList<PuntosEspecial>();
		poderes = new ArrayList<PickUpPoder>();
		paredes = new ArrayList<Pared>();
	}
	
	public int getcantPickup() {
		return cantPickup;
	}
	
	public List<Movible> getMovibles(){
		return movibles;
	}
	
	public List<PuntosNormal> getPickUpsNormales(){
		return puntosNormales;
	}
	
	public List<PuntosEspecial> getPuntosEspeciales(){
		return puntosEspeciales;
	}
	
	public List<PickUpPoder> getPoderesEspeciales(){
		return poderes;
	}
	
	public List<Pared> getParedes(){
		return paredes;
	}
	
	public void addMovible(Movible m){
		//System.out.println("agregando movible");
		ajustarTamanioYPosicion(m);
		m.setOrigen();
		movibles.add(m);
	}
	
	public void addPickUpNormal(PuntosNormal pN){
		//System.out.println("agregando pickup normal");
		cantPickup++;
		ajustarTamanioYPosicion(pN);
		puntosNormales.add(pN);
	}
	
	public void addPuntosEspecial(PuntosEspecial pE){
		//System.out.println("agregando puntos especial");
		cantPickup++;
		ajustarTamanioYPosicion(pE);
		puntosEspeciales.add(pE);
	}
	
	public void addPoderEspecial(PickUpPoder p){
		//System.out.println("agregando poder especial");
		cantPickup++;
		ajustarTamanioYPosicion(p);
		poderes.add(p);
	}
	
	public void addParedes(Pared p){
		//System.out.println("agregando pared");
		ajustarTamanioYPosicion(p);
		paredes.add(p);
	}
	
	public int getAncho() {
		return (cantColumnas + 1) * Entidad.TAMANIO;
	}
	
	public int getAlto() {
		return (cantFilas + 1) * Entidad.TAMANIO;
	}
	
	public int getCantFilas() {
		return cantFilas;
	}
	
	public int getCantColumnas() {
		return cantColumnas;
	}
	
	private void ajustarTamanioYPosicion(Entidad e) {
		cantFilas = Math.max(cantFilas, e.getY());
		cantColumnas = Math.max(cantColumnas, e.getX());
		e.setX(e.getX() * Entidad.TAMANIO);
		e.setY(e.getY() * Entidad.TAMANIO);
	}
}
