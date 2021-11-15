package logica;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import Mapas.MapLoader;
import app.App;
import logica.entidades.Entidad;
import vista.EntidadGrafica;
import vista.GUI;
import vista.GameOverPanel;

public class Juego implements Runnable, Suscriptor  {
	
	private static final int TICS_POR_SEGUNDO = Integer.parseInt(App.configuration.getProperty("TicsJuego"));
	
	private GUI gui;
	private Escenario escenario;
	private int puntaje;
	private Reloj reloj;
	
	public Juego() {
		gui = new GUI(this);
		escenario = Escenario.getInstancia();
		escenario.setJuego(this);
		
		reloj = new Reloj(1000/TICS_POR_SEGUNDO);
		reloj.suscribirse(this);
		puntaje=0;
	}

	@Override
	public void run() {
		gui.showMenu();
	}
	
	public void start() {
		escenario.start();
		//gui.showJuego();
	}
	
	public void agregarEntidades(List<Entidad> entidades) {
		gui.agregarEntidades(new ArrayList<EntidadGrafica>(entidades));
	}
	
	public void actualizarEntidades(List<EntidadGrafica> entidades) {
		gui.actualizarEntidades(entidades);
	}

	public void actualizarVidas(int cantVidas) {
		gui.actualizarVidas(cantVidas);
		System.out.println("Entro en actualizarVidas");
	}
	
	public void actualizarPuntaje(int p) {
		puntaje += p;
		gui.actualizarPuntaje(puntaje);
	}
	
	public String getPuntajeString() {
		return String.valueOf(puntaje);
	}
	
	public void gameOver() {
		reloj.stop();
		gui.showGameOver();
    }
	
	/**
	 * 0-> Mover arriba
	 * 1-> Mover izquierda
	 * 2-> Mover abajo
	 * 3-> Mover derecha
	 * 
	 * @param tecla
	 */
	public synchronized void teclaPresionada(int tecla) {
		escenario.setDireccionPersonaje(tecla);
	}

	@Override
	public void actualizar() {
		escenario.tick();
		gui.actualizarEntidades(escenario.getEntidadesParaActualizar());
	}

	public void terminarNivel() {
		reloj.stop();
		gui.limpiarJuego();
	}

	public void cargarNuevoNivel() {
		gui.setDimensionEscenario(escenario.getAlto(), escenario.getAncho());
		gui.agregarEntidades(escenario.getEntidadesParaActualizar());
		System.out.println("se agregaron " + escenario.getEntidadesParaActualizar().size() + " entidades.");
		gui.showJuego();
		reloj.start();
	}
}
