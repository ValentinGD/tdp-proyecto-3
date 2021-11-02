package logica;

import java.awt.EventQueue;

public class Juego {
	
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
