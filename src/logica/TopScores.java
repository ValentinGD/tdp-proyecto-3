package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import vista.NuevoRecord;

@SuppressWarnings("serial")
public class TopScores implements Serializable{

	private List<Player> ranking;
	//Internamente es una lista de 10 elementos, con las mejores puntuaciones ordenadas de mayor a menor (izquierda a derecha).
	
	public TopScores() {
		this.ranking = new ArrayList<Player>();
	}
	
	/*
	 * Si es un puntaje que entra dentro de los 10 mejores, se guardara en el listado.
	 * El retorno indica si la lista fue efectivamente actualizada con un nuevo record.
	 */
	public boolean procesarPuntaje(int puntaje_nuevo) {
		boolean se_guardo_record = false;
		if (!ranking.isEmpty()) {
			boolean enconteMenor = false;
			int puntaje_aux;
			for (int i = 0; i < ranking.size() && !enconteMenor; i++) {
				puntaje_aux = ranking.get(i).getPuntaje();
				if (puntaje_aux < puntaje_nuevo) {
					guardarEnLista(i, puntaje_nuevo);
					enconteMenor = true;
					se_guardo_record = true;
				}
			}
			if (!enconteMenor && ranking.size() < 10) {
				guardarEnLista(-1, puntaje_nuevo);
				se_guardo_record = true;
			}
			if (ranking.size() > 10) {
				ranking.remove(ranking.size() - 1);
			}
		} else {
			guardarEnLista(-1, puntaje_nuevo);
			se_guardo_record = true;
		}
		return se_guardo_record;
	}
	
	private String solicitarNombre() {
		NuevoRecord nuevo_record = new NuevoRecord();
		return nuevo_record.cartel_solicitar_nombre();
	}
	
	/*
	 * Solicita el nombre del jugador y luego lo guarda en la lista junto con el puntaje.
	 * Si pos = -1 guarda al final de la lista, caso contrario guarda en la posición pos. 
	 */
	private void guardarEnLista(int pos, int puntaje) {
		String nombre = solicitarNombre();
		if (nombre != null && !nombre.isBlank()) {
			if (pos == -1) {
				ranking.add(new Player(nombre, puntaje));
			}
			else {
				ranking.add(pos, new Player(nombre, puntaje));
			}
		}
	}
	
	public List<Player> getPuntajes() {
		return this.ranking;
	}

}