package logica;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import Mapas.MapLoader;
import vista.GUI;
import vista.GameOverPanel;
import vista.PosicionGrafica;

public class Juego implements Runnable {
	
	private static Juego instancia;
	
	private static final int TICS_POR_SEGUNDO = 10;
	
	private GUI gui;
	private Escenario escenario;
	private static int puntaje;
	private Reloj reloj;
	
	private Juego() {
		gui = new GUI(this);
		escenario = Escenario.getInstancia();
		reloj = new Reloj(1000/TICS_POR_SEGUNDO);
		reloj.suscribirse(escenario);
		puntaje=0;
	}
	
	public static void actualizarPuntaje(int p) {
		puntaje=puntaje+p;
		System.out.println(getPuntajeString());
	}
	
	public static String getPuntajeString() {
		return ""+puntaje;
	}
	
	public void gameOver() {
		reloj.stop();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui.showGameOver();
			}
		});
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
		
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				escenario.start();
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui.showJuego(escenario.getPosicionesGraficas());
			}
		});
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				reloj.start();
			}
		});
		
		
	}
	
	public actualizarMapa() {
		gui.actualizarMapa();
	}
	
	public void actualizarGraficos(ArrayList<PosicionGrafica> posiciones) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui.actualizarJuego(posiciones);
			}
		});
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
