package logica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.entidades.PickUp;
import logica.entidades.enemigos.*;
import logica.niveles.*;
import vista.EntidadGrafica;

public class Escenario {
	
	private static Escenario instancia;

	private static final int TAMANIO_ZONA = 4 * Entidad.TAMANIO;
	
	private List<EntidadGrafica> entidadesParaActualizar;
	private List<Movible> movibles;
	private List<Zona> zonas;
	
	private Zona[][] matrizZonas;
	
	private static Nivel nivel;
	//private Mapa nivel;
	
	private Personaje personaje;
	private Enemigo e1,e2,e3,e4;

	private Juego juego;
	private int cantPickUps;
	
	
	private Escenario() {
		zonas = new ArrayList<Zona>();
		movibles = new ArrayList<Movible>();
		entidadesParaActualizar = new ArrayList<EntidadGrafica>();
		personaje = Personaje.getInstancia();
	}
	
	public static Escenario getInstancia() {
		if (instancia == null) {
			instancia = new Escenario();
		}
		
		return instancia;
	}
	
	public boolean start() {
		System.out.println("cargando escenario inicial");

		nivel = new Nivel1();
		
		cargarEscenarioConMatriz();
		
		juego.cargarNuevoNivel();
		
		System.out.println("escenario inicial cargado");
		return true;
	}
	
	public void cargarEscenario() {
		//mapa = nivel.getMapa();
		
		crearZonas();
		List<Entidad> entidades= new ArrayList<Entidad>(); 
		Entidad entidad=null;
		Zona zona=null;
		int indexZona=0;
		
		entidades.addAll(nivel.getMovibles());
		entidades.addAll(nivel.getParedes());
		entidades.addAll(nivel.getPoderesEspeciales());
		entidades.addAll(nivel.getPuntosEspeciales());
		entidades.addAll(nivel.getPickUpsNormales());
		
		crearMatrizZonas();
		
		entidadesParaActualizar.addAll(entidades);
		
		Iterator<Entidad> itEntidades=entidades.iterator();
		while(itEntidades.hasNext()) {
			entidad=itEntidades.next();
			entidad.setX(entidad.getX() * Entidad.TAMANIO);
			entidad.setY(entidad.getY() * Entidad.TAMANIO);
			
			indexZona=localizarZona(entidad);
			zona=zonas.get(indexZona);
			
			entidad.setZona(zona);
			zona.addEntidad(entidad);
		}
	}
	
	public void cargarEscenarioConMatriz() {
		
		List<Entidad> entidades = new ArrayList<Entidad>();
		Zona zona;
		
		movibles.clear();
		movibles.addAll(nivel.getMovibles());
		
		System.out.println("movibles: " + movibles);
		
		entidades.addAll(nivel.getMovibles());
		entidades.addAll(nivel.getParedes());
		entidades.addAll(nivel.getPickUpsNormales());
		
		crearMatrizZonas();
		
		
		
		entidadesParaActualizar.clear();
		
		for(Entidad entidad : entidades) {
			zona = localizarZonaMatriz(entidad);
			if (zona == null) {
				System.out.println("zona no encontrada para entidad: " + entidad);
			} else {
				//System.out.println("zonaEncontrada para entidad: " + entidad);
				entidad.setZona(zona);
				zona.addEntidad(entidad);
				entidadesParaActualizar.add(entidad);
			}
		}
		
		System.out.println("zonas:");
		for (Zona[] arrZonas : matrizZonas) {
			System.out.println("\t" + Arrays.toString(arrZonas));
		}
	}
	
	private int localizarZona(Entidad e) {
		int numZona;
		int posX=e.getX();
		int posY=e.getY();
		int cantZonasHorizaontal=nivel.getAncho() / TAMANIO_ZONA;
		numZona=posY/TAMANIO_ZONA*cantZonasHorizaontal+posX/TAMANIO_ZONA;
		
		return numZona;
	}
	
	private Zona localizarZonaMatriz(Entidad e) {
		/*int numZona;
		int posX=e.getX();
		int posY=e.getY();
		int cantZonasHorizaontal=mapa.getAncho() / anchoZona;
		numZona=posY/anchoZona*cantZonasHorizaontal+posX/anchoZona;
		
		return numZona;*/
		
		for (int fila = 0; fila < matrizZonas.length; ++fila) {
			for (int columna = 0; columna < matrizZonas[fila].length; ++columna) {
				if (matrizZonas[fila][columna].contieneCoordenadas(e)) {
					return matrizZonas[fila][columna];
				}
			}
		}
		return null;
	}
	
	private void crearZonas() {
		zonas.clear();
		
		boolean irregularHorizontal = false;
		boolean irregularVertical = false;
		int cantZonasHorizaontal = nivel.getAncho() / TAMANIO_ZONA;
		int cantZonasVertical = nivel.getAlto() / TAMANIO_ZONA;
		
		if(nivel.getAncho() % TAMANIO_ZONA !=0) {
			cantZonasHorizaontal++;
			irregularHorizontal=true;
		}
		
		if(nivel.getAlto() % TAMANIO_ZONA !=0) {
			cantZonasVertical++;
			irregularVertical=true;
		}
		
		Zona zonaAux = null;
		for(int y=0;y<cantZonasVertical;y++) {
			for(int x=0;x<cantZonasHorizaontal;x++) {
				
				if(irregularHorizontal && !irregularVertical) {
					if(x==cantZonasHorizaontal-1) {
						zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,TAMANIO_ZONA,nivel.getAncho() % TAMANIO_ZONA);
					}else {
						zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,TAMANIO_ZONA,TAMANIO_ZONA);
					}
				}
				
				if(!irregularHorizontal && irregularVertical) {
					if(x==cantZonasVertical-1) {
						zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,nivel.getAlto() %TAMANIO_ZONA,TAMANIO_ZONA);
					}else {
						zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,TAMANIO_ZONA,TAMANIO_ZONA);
					}
				}
				
				if(irregularHorizontal && irregularVertical) {
					if(x==cantZonasHorizaontal-1) {
						zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,nivel.getAlto() % TAMANIO_ZONA,nivel.getAncho() %TAMANIO_ZONA);
					}else {
						zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,TAMANIO_ZONA,TAMANIO_ZONA);
					}
				}
				
				if(!irregularHorizontal && !irregularVertical) {
					zonaAux= new Zona(x*TAMANIO_ZONA,y*TAMANIO_ZONA,TAMANIO_ZONA,TAMANIO_ZONA);
				}

				zonas.add(zonaAux);
			}
		}
		
	}
	
	private void crearMatrizZonas() {
		System.out.println("ancho: " + nivel.getAncho());
		System.out.println("alto: " + nivel.getAlto());
		System.out.println("columnas: " + nivel.getCantColumnas());
		System.out.println("filas: " + nivel.getCantFilas());
		
		int anchoNivel = nivel.getAncho();
		int altoNivel = nivel.getAlto();
		int cantZonasHorizontal = anchoNivel / TAMANIO_ZONA;
		int cantZonasVertical = altoNivel / TAMANIO_ZONA;
		
		if(anchoNivel % TAMANIO_ZONA != 0) {
			cantZonasHorizontal++;
		}
		
		if(altoNivel % TAMANIO_ZONA != 0) {
			cantZonasVertical++;
		}
		
		matrizZonas = new Zona[cantZonasVertical][cantZonasHorizontal];
		
		for(int fila = 0; fila < cantZonasVertical; fila++) {
			for(int columna = 0; columna < cantZonasHorizontal; columna++) {
				
				int xZona = columna * TAMANIO_ZONA;
				int yZona = fila * TAMANIO_ZONA;
				
				int anchoZona = Math.min(anchoNivel - xZona, TAMANIO_ZONA);
				int altoZona = Math.min(altoNivel - yZona, TAMANIO_ZONA);
				
				matrizZonas[fila][columna] = new Zona(xZona, yZona, altoZona, anchoZona);
			}
		}
		
	}
	
	public void tick() {
		//System.out.println("actualizando escenario");
		entidadesParaActualizar.clear();
		
		for (Movible m : movibles) {
			//personaje.mover();
			m.mover();
		}
	}
	
	public void agregarEntidadParaActualizar(EntidadGrafica entidad) {
		if (!entidadesParaActualizar.contains(entidad)) {
			entidadesParaActualizar.add(entidad);
		}
	}
	
	public void setDireccionPersonaje(int direccion) {
		personaje.setDireccion(direccion);
	}
	

	public void setCantPickUps(int cantPickUps) {
		this.cantPickUps = cantPickUps;
	}
	
	public void setCantVidas(int cantVidas) {
		juego.actualizarVidas(cantVidas);
	}

	public List<EntidadGrafica> getEntidadesParaActualizar() {
		return entidadesParaActualizar;
	}
	
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
	public Zona getZonaAdyacente(Zona zona, int direccion) {
		
		int xZona = zona.getX() / TAMANIO_ZONA;
		int yZona = zona.getY() / TAMANIO_ZONA;
		
		
		
		if (matrizZonas[yZona][xZona] == zona) {
			
			//System.out.println("calculando zona adyacente");
			
			int xAdyacente = xZona;
			int yAdyacente = yZona;
			
			switch(direccion) {
			case Movible.DIRECCION_ABAJO:
				yAdyacente = Math.min(yAdyacente + 1, matrizZonas.length - 1);
				break;
			case Movible.DIRECCION_ARRIBA:
				yAdyacente = Math.max(yAdyacente - 1, 0);
				break;
			case Movible.DIRECCION_DERECHA:
				xAdyacente = Math.min(xAdyacente + 1, matrizZonas[yZona].length - 1);
				break;
			case Movible.DIRECCION_IZQUIERDA:
				xAdyacente = Math.max(xAdyacente - 1, 0);
				break;
			}
			
			//System.out.println("zona adyacente a " + zona + ": " + matrizZonas[yAdyacente][xAdyacente]);
			return matrizZonas[yAdyacente][xAdyacente];
			
		}
		return zona;
	}
	
	private void terminarNivel() {
		System.out.println("se termino el nivel. puntaje: " + juego.getPuntajeString());
		System.out.println("Personaje: " + personaje);
		if(nivel.getSiguienteNivel() != null) {
			
			nivel=nivel.getSiguienteNivel();
			
			juego.terminarNivel();
			
			cargarEscenarioConMatriz();
			
			juego.cargarNuevoNivel();
			
		}else {
			juego.gameOver();
		}
		System.out.println("Personaje: " + personaje);
	}
	
	public void eliminarPickUp(PickUp p) {
		juego.actualizarPuntaje(p.getPuntos());
		p.comer();
	}

	public int getAncho() {
		return nivel.getAncho();
	}
	
	public int getAlto() {
		return nivel.getAlto();
	}

	public void reubicar(Movible m) {
		if (!m.getZona().contieneCoordenadas(m)) {
			System.out.println("Hay que reubicar movible");
			
			Zona nuevaZona = getZonaAdyacente(m.getZona(), m.getDireccionActual());
			m.getZona().eliminar(m);
			
			//System.out.println("la zona " + m.getZona() + " contiene las coordenadas del movible: " + m.getZona().contieneCoordenadas(m));
			
			m.setZona(nuevaZona);
			nuevaZona.addEntidad(m);
			//System.out.println("\tSe reubico Movible: " + m);
			
//			if (!m.getZona().contieneCoordenadas(m)) {
//			//	System.out.println("Error: El movible no esta contenido en las coordenadas de la nueva zona");
//				if (!m.getZona().getEntidades().contains(m)) {
//				//	System.out.println("Error: El movible no fue agregado correctamente a su nueva zona");
//				}
//			}
			
		} else {
			//System.out.println("No se reubico. Distancia a borde: " + m.getZona().distanciaABorde(m));
		}
	}
	
//	public Posicion getPosicion(Posicion p) {
//		if (0 <= p.getX() && p.getX() < nivel.getMapa().getAncho() && 0 <= p.getY() && p.getY() < nivel.getMapa().getAlto()) {
//			return  posiciones[p.getY()][p.getX()];
//		}
//		return new Posicion(p.getX(), p.getY());
//	}
	
//	public PosicionGrafica[][] getPosicionesGraficas() {
//		return posiciones;
//	}


}
