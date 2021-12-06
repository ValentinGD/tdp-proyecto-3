package logica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import app.App;
import logica.entidades.Entidad;
import vista.EntidadGrafica;
import vista.GUI;

public class Juego implements Runnable, Suscriptor {

	public static final int TICS_POR_SEGUNDO = Integer.parseInt(App.configuration.getProperty("TicsJuego"));

	private GUI gui;
	private Escenario escenario;
	private int puntaje;
	private Reloj reloj;
	private TopScores misTopScores;

	public Juego(TopScores misTopScores) {
		gui = new GUI(this);
		escenario = Escenario.getInstancia();
		escenario.setJuego(this);
		this.misTopScores = misTopScores;
		reloj = new Reloj(1000 / TICS_POR_SEGUNDO);
		reloj.suscribirse(this);
		puntaje = 0;
	}

	@Override
	public void run() {
		gui.showMenu();
	}

	public void start() {
		escenario.start();
	}

	public void agregarEntidades(List<Entidad> entidades) {
		gui.agregarEntidades(new ArrayList<EntidadGrafica>(entidades));
	}

	public void actualizarEntidades(List<EntidadGrafica> entidades) {
		gui.actualizarEntidades(entidades);
	}

	public void actualizarVidas(int cantVidas) {
		gui.actualizarVidas(cantVidas);
	}

	public void actualizarPuntaje(int p) {
		puntaje += p;
		gui.actualizarPuntaje(puntaje);
	}

	public String getPuntajeString() {
		return String.valueOf(puntaje);
	}

	public void gameOver() {
		if (reloj.isRunning()) {
			pararTiempo();
			procesarPuntaje();
			gui.showGameOver();
		}
	}

	/*
	 * Solo si el puntaje queda dentro de los top scores, se actualiza el archivo
	 * que almacena las mejores puntuaciones.
	 */
	private void procesarPuntaje() {
		boolean se_guardo_record = misTopScores.procesarPuntaje(puntaje);
		if (se_guardo_record) {
			try {
				FileOutputStream fileOutputStream = new FileOutputStream(App.configuration.getProperty("RutaRecords"));
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(misTopScores);
				objectOutputStream.flush();
				objectOutputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 0-> Mover arriba
	 * 1->Mover izquierda
	 * 2-> Mover abajo
	 * 3-> Mover derecha
	 * 
	 * @param tecla
	 */
	public synchronized void teclaPresionada(int tecla) {
		escenario.setDireccionPersonaje(tecla);
	}

	@Override
	public synchronized void actualizar() {
		escenario.tick();
		gui.actualizarEntidades(escenario.getEntidadesParaActualizar());
	}

	public void terminarNivel() {
		pararTiempo();
		gui.limpiarJuego();
	}

	public void cargarNuevoNivel() {
		gui.resetJuego();
		gui.setDimensionEscenario(escenario.getAlto(), escenario.getAncho());
		gui.agregarEntidades(escenario.getEntidadesParaActualizar());
		gui.showJuego();
		reloj.start();
	}

	public void pararTiempo() {
		try {
			reloj.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void reanudarTiempo() {
		reloj.start();
	}

	public List<Player> getTopScores() {
		return misTopScores.getPuntajes();
	}

	public void reiniciar() {
		puntaje = 0;
		gui.showMenu();
	}

}