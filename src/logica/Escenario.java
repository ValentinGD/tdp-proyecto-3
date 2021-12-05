package logica;

import java.util.ArrayList;
import java.util.List;
import app.App;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.entidades.PickUp;
import logica.niveles.*;
import vista.EntidadGrafica;

public class Escenario {
	
	private static Escenario instancia;

	private static final int TAMANIO_ZONA = 4 * Entidad.TAMANIO;

	public static final int CANTIDAD_INICIAL_DE_VIDAS = Integer.parseInt(App.configuration.getProperty("CantVidas"));
	
	private List<EntidadGrafica> entidadesParaActualizar;
	private List<Movible> movibles;
	
	private Zona[][] matrizZonas;
	private static Nivel nivel;
	private Personaje personaje;
	private Juego juego;
	private int cantPickUps;
	private boolean murioPersonaje;

	private Escenario() {
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
		nivel = new Nivel1();
		cargarEscenarioConMatriz();
		juego.cargarNuevoNivel();
		cantPickUps = nivel.getCantPickUps();
		juego.actualizarVidas(CANTIDAD_INICIAL_DE_VIDAS);
		return true;
	}
	
	public void cargarEscenarioConMatriz() {
		murioPersonaje = false;
		
		List<Entidad> entidades = new ArrayList<Entidad>();
		Zona zona;
		
		movibles.clear();
		movibles.addAll(nivel.getMovibles());
		
		entidades.addAll(nivel.getMovibles());
		entidades.addAll(nivel.getParedes());
		entidades.addAll(nivel.getPickUpsNormales());
		entidades.addAll(nivel.getPoderesEspeciales());
		entidades.addAll(nivel.getPuntosEspeciales());
		
		crearMatrizZonas();
		
		for(Movible m : movibles) {
			m.reset();
		}
		
		personaje.resetVidas();
		entidadesParaActualizar.clear();
		
		for(Entidad entidad : entidades) {
			zona = localizarZonaMatriz(entidad);
			if (zona == null) {
				System.out.println("zona no encontrada para entidad: " + entidad);
			} else {
				entidad.setZona(zona);
				zona.addEntidad(entidad);
				entidadesParaActualizar.add(entidad);
			}
		}
	}
	
	private Zona localizarZonaMatriz(Entidad e) {
		int xZona = e.getX() / TAMANIO_ZONA;
		int yZona = e.getY() / TAMANIO_ZONA;
		
		return matrizZonas[yZona][xZona];
	}
	
	private void crearMatrizZonas() {
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
		if(cantPickUps==0) {
			terminarNivel();
		}
		
		if (!murioPersonaje) {
			entidadesParaActualizar.clear();
			for (Movible m : movibles) {
				m.mover();
			}
		} else {
			procesarMuertePersonaje();
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
			
			return matrizZonas[yAdyacente][xAdyacente];
			
		}
		return zona;
	}
	
	private void terminarNivel() {
		Nivel siguienteNivel = nivel.getSiguienteNivel();
		
		if ((cantPickUps == 0) && (siguienteNivel != null)) {
			nivel = siguienteNivel;
			cantPickUps=nivel.getCantPickUps();
			juego.terminarNivel();
			cargarEscenarioConMatriz();
			juego.cargarNuevoNivel();
		} else {
			juego.gameOver();
		}
	}
	
	public void eliminarPickUp(PickUp p) {
		juego.actualizarPuntaje(p.getPuntos());
		p.comer();
		cantPickUps -= 1;
	}

	public int getAncho() {
		return nivel.getAncho();
	}
	
	public int getAlto() {
		return nivel.getAlto();
	}

	public void reubicar(Movible m) {
		if (!m.getZona().contieneCoordenadas(m)) {
			Zona nuevaZona = getZonaAdyacente(m.getZona(), m.getDireccionActual());
			m.getZona().eliminar(m);
			m.setZona(nuevaZona);
			nuevaZona.addEntidad(m);
		} else {

		}
	}

	public void murioPersonaje() {
		murioPersonaje = true;
	}
	
	private void procesarMuertePersonaje() {
		if (personaje.getVidas() == 0) {
			terminarNivel();
		} else {
			juego.pararTiempo();
			for (Movible m : movibles) {
				m.reset();
				ubicarEnZona(m);
			}
			juego.reanudarTiempo();
		}
		murioPersonaje = false;
		juego.actualizarVidas(personaje.getVidas());
	}
	
	public void ubicarEnZona(Movible m) {
		Zona nuevaZona = localizarZonaMatriz(m);
		m.getZona().eliminar(m);
		nuevaZona.addEntidad(m);
		m.setZona(nuevaZona);
	}

}