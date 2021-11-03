package logica;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import Mapas.MapLoader;
import vista.GUI;
import vista.PosicionGrafica;

public class Juego implements Runnable {
	
	private static Juego instancia;
	
	private static final int TICS_POR_SEGUNDO = 10;
	
	private GUI gui;
	private Escenario escenario;
	
	private Reloj reloj;
	
	private Juego() {
		gui = new GUI(this);
		escenario = Escenario.getInstancia();
		reloj = new Reloj(1000/TICS_POR_SEGUNDO);
		reloj.suscribirse(escenario);
	}
	
	public static Juego getInstancia() {
		if (instancia == null) {
			instancia = new Juego();
		}
		return instancia;
	}

	@Override
	public void run() {
		gui.showMenu();
	}
	
	public void start() {
		escenario.start();
		
		gui.showJuego(escenario.getPosicionesGraficas());
		
		reloj.start();
	}
	
	public void actualizarGraficos(ArrayList<PosicionGrafica> posiciones) {
		gui.actualizarJuego(posiciones);
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
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				escenario.setDireccionPersonaje(tecla);
			}
		});
	}

}
