package logica;

import java.awt.EventQueue;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import Mapas.MapLoader;
import vista.GUI;

public class Juego implements Runnable {
	
	private GUI gui;
	private Escenario escenario;
	
	public Juego() {
		gui = new GUI(this);
		//escenario = new Escenario();
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
