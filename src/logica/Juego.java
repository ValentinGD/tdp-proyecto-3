package logica;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import Mapas.MapLoader;
import vista.GUI;

public class Juego implements Runnable {
	
	private static final int TICS_POR_SEGUNDO = 10;
	
	private GUI gui;
	private Escenario escenario;
	
	private Reloj reloj;
	
	public Juego() {
		gui = new GUI(this);
		//escenario = new Escenario();
		reloj = new Reloj(1000/TICS_POR_SEGUNDO);
	}

	@Override
	public void run() {
		gui.showMenu();
	}
	
	public void start() {
		try {
			gui.showJuego(MapLoader.getMapa(1));
		} catch (FileNotFoundException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				Escenario.moverPersonaje(tecla);
			}
		});
	}

}
