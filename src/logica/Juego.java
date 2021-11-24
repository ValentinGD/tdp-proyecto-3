package logica;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	private TopScores misTopScores;
	
	public Juego() {
		gui = new GUI(this);
		escenario = Escenario.getInstancia();
		escenario.setJuego(this);
		
		misTopScores = new TopScores();
		try {
			FileInputStream fileInputStream = new FileInputStream("./mayoresPuntajes.tdp");
			ObjectInputStream objectInputStram = new ObjectInputStream(fileInputStream);
			misTopScores = (TopScores) objectInputStram.readObject();
			objectInputStram.close();
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
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
		misTopScores.setPuntaje(puntaje);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("mayoresPuntajes.tdp");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(misTopScores);
			objectOutputStream.flush();
			objectOutputStream.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		pararTiempo();
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
	public synchronized void actualizar() {
		escenario.tick();
		gui.actualizarEntidades(escenario.getEntidadesParaActualizar());
	}

	public void terminarNivel() {
		pararTiempo();
		gui.limpiarJuego();
	}

	public void cargarNuevoNivel() {
		gui.setDimensionEscenario(escenario.getAlto(), escenario.getAncho());
		gui.agregarEntidades(escenario.getEntidadesParaActualizar());
		System.out.println("se agregaron " + escenario.getEntidadesParaActualizar().size() + " entidades.");
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
	
	public List<Integer> getTopScores() {
		return misTopScores.getPuntajes();
	}
	
	public void reiniciar() {
		puntaje = 0;
		gui.showMenu();
	}
}
