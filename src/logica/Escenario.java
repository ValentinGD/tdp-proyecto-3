package logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.entidades.enemigos.*;
import logica.niveles.*;
import vista.PosicionGrafica;

public class Escenario implements Suscriptor {
	
	private static Escenario instancia;
	
	private Zona zona[];
	
	private static final int cantZona=0;
	private static Nivel nivel;
	
	private static Personaje pj;
	
	//-------------------------------
	private Posicion[][] posiciones;
	private Juego juego;
	private Mapa mapa;
	private Personaje personaje;
	private Enemigo e1,e2,e3,e4;
	private int cantPickUps;
	
	private List<Movible> movibles;
	
	private Escenario() {
	}
	
	public static Escenario getInstancia() {
		if (instancia == null) {
			instancia = new Escenario();
		}
		
		return instancia;
	}
	
	public Escenario(Zona z[], int cpu, Nivel n) {
		zona=new Zona[cantZona];
		for(int i=0;i<z.length;i++) {
			zona[i]=z[i];
			pj.getInstancia();
			//e1.getInstancia();
		}
		nivel=n;
		setCantPickUps(cpu);
	}
	
	public boolean start() {
		System.out.println("cargando escenario inicial");
		this.juego = Juego.getInstancia();

		nivel = new Nivel1();
		
		cargarEscenario();
		
		System.out.println("escenario inicial cargado");
		return true;
	}
	
	public void cargarEscenario() {
		System.out.println("cargando escenario");
		movibles = new ArrayList<Movible>();
		
		Mapa mapa = nivel.getMapa();
		posiciones = mapa.getPosiciones();
		
		if (mapa == Mapa.MAPA_VACIO) {
			System.out.println("MAPA INVALIDO.");
		} else {
			cantPickUps = mapa.getcantPickup();
			
			movibles.addAll(mapa.getMovibles());
			
			personaje = Personaje.getInstancia();
			
			juego.actualizarVidas(personaje.getVidas());
		}
		
		System.out.println("escenario cargado");
	}
	
	@Override
	public void actualizar() {
		//System.out.println("actualizando escenario");
		ArrayList<PosicionGrafica> posicionesModificadas = new ArrayList<PosicionGrafica>();
		for (Movible m : movibles) {
			posicionesModificadas.addAll(m.mover());
			juego.actualizarVidas(personaje.getVidas());
		}
		//System.out.println("posicionesModificadas: " + posicionesModificadas);
		if (!posicionesModificadas.isEmpty()) {
			juego.actualizarGraficos(posicionesModificadas);
		}
	}
	
	public void setDireccionPersonaje(int direccion) {
		personaje.setDireccion(direccion);
	}
	

	public void setCantPickUps(int cantPickUps) {
		this.cantPickUps = cantPickUps;
	}
	
	public void eliminarPickUp(Posicion p) {
		if(p.hayPickUp()) {
			Juego.actualizarPuntaje(p.getPickUp().getPuntos());
			p.setPickUp(null);
			--cantPickUps;
			if(cantPickUps==0) {
				terminarNivel();
			}
		}
	}
	private void terminarNivel() {
		System.out.println("se termino el nivel. puntaje: " + Juego.getPuntajeString());
		System.out.println("Personaje: " + personaje.getPosicion());
		if(nivel.getSiguienteNivel()!=null) {
			nivel=nivel.getSiguienteNivel();
			cargarEscenario();
			juego.actualizarMapa(nivel.getMapa().getPosiciones());
		}else {
			juego.gameOver();
		}
		System.out.println("Personaje: " + personaje.getPosicion());
	}
	
	public Posicion getPosicion(Posicion p) {
		if (0 <= p.getX() && p.getX() < nivel.getMapa().getAncho() && 0 <= p.getY() && p.getY() < nivel.getMapa().getAlto()) {
			return  posiciones[p.getY()][p.getX()];
		}
		return new Posicion(p.getX(), p.getY());
	}
	
	public PosicionGrafica[][] getPosicionesGraficas() {
		return posiciones;
	}
}
