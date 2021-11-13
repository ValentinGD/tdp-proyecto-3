package logica;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.entidades.enemigos.*;
import logica.niveles.*;
import vista.PosicionGrafica;

public class Escenario implements Suscriptor {
	
	private static Escenario instancia;
	
	private List<Zona> zonas;
	
	private static final int cantZona=0;
	private static final int ladoZona=4;
	private static Nivel nivel;
	
	private static Personaje pj;
	
	//-------------------------------
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
		
		crearZonas();
		ArrayList<Entidad> entidades= new ArrayList<Entidad>(); 
		Entidad entidad=null;
		Zona zona=null;
		int indexEntidades=0;
		int indexZona=0;
		entidades.addAll(nivel.getMovibles());
		entidades.addAll(nivel.getParedes());
		entidades.addAll(nivel.getPickUpEspeciales());
		entidades.addAll(nivel.getPuntosEspeciales());
		entidades.addAll(nivel.getPuntosNormales());
		
		Iterator<Entidad> itEntidades=entidades.iterator();
		while(itEntidades.hasNext()) {
			entidad=entidades.get(indexEntidades);
			indexEntidades++;
			indexZona=localizarZona(entidad);
			zona=zonas.get(indexZona);
			entidad.setZona(zona);
			zona.setEntidad(entidad);
		}
	}
	
	private int localizarZona(Entidad e) {
		int numZona=0;
		int posX=e.getX();
		int posY=e.getY();
		int cantZonasHorizaontal=mapa.getAncho() / ladoZona;
		numZona=posY/ladoZona*cantZonasHorizaontal+posX/ladoZona;
		
		return numZona;
	}
	private void crearZonas() {
		
		boolean irregularHorizontal=false;
		boolean irregularVertical=false;
		int cantZonasHorizaontal=mapa.getAncho() / ladoZona;
		int cantZonasVertical=mapa.getAlto() / ladoZona;
		
		if(mapa.getAncho() % ladoZona !=0) {
			cantZonasHorizaontal++;
			irregularHorizontal=true;
		}
		
		if(mapa.getAlto() % ladoZona !=0) {
			cantZonasVertical++;
			irregularVertical=true;
		}
		
		Zona zonaAux;
		for(int y=0;y<cantZonasVertical;y++) {
			for(int x=0;x<cantZonasHorizaontal;x++) {
				
				if(irregularHorizontal && !irregularVertical) {
					if(x==cantZonasHorizaontal-1) {
						zonaAux= new Zona(x*ladoZona,y*ladoZona,ladoZona,mapa.getAncho() %ladoZona);
						zonas.add(zonaAux);
					}else {
						zonaAux= new Zona(x*ladoZona,y*ladoZona,ladoZona,ladoZona);
						zonas.add(zonaAux);
					}
				}
				
				if(!irregularHorizontal && irregularVertical) {
					if(x==cantZonasVertical-1) {
						zonaAux= new Zona(x*ladoZona,y*ladoZona,mapa.getAlto() %ladoZona,ladoZona);
						zonas.add(zonaAux);
					}else {
						zonaAux= new Zona(x*ladoZona,y*ladoZona,ladoZona,ladoZona);
						zonas.add(zonaAux);
					}
				}
				
				if(irregularHorizontal && irregularVertical) {
					if(x==cantZonasHorizaontal-1) {
						zonaAux= new Zona(x*ladoZona,y*ladoZona,mapa.getAlto() % ladoZona,mapa.getAncho() %ladoZona);
						zonas.add(zonaAux);
					}else {
						zonaAux= new Zona(x*ladoZona,y*ladoZona,ladoZona,ladoZona);
						zonas.add(zonaAux);
					}
				}
				
				if(!irregularHorizontal && !irregularVertical) {
					zonaAux= new Zona(x*ladoZona,y*ladoZona,ladoZona,ladoZona);
					zonas.add(zonaAux);
				}
				
			}
		}
		
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
