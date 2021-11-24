package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class TopScores implements Serializable{

	private List<Integer> ranking;
	
	public TopScores() {
		this.ranking = new ArrayList<Integer>();
	}
	
	public void setPuntaje(int puntaje) {
		if(!ranking.isEmpty()) {
			boolean enconteMenor = false;
			int puntajes;
			for(int i = 0; i < ranking.size() && !enconteMenor; i++) {
				puntajes = ranking.get(i);
				//System.out.println("i: " + i + ", puntajes: " + puntajes);
				if(puntajes < puntaje) {
					ranking.add(i,puntaje);
					enconteMenor = true;
				}
			}
			if(!enconteMenor && ranking.size() < 10) {
				ranking.add(puntaje);
			}
			
			if(ranking.size() > 10)
				ranking.remove(ranking.size() - 1);
		}else {
			ranking.add(puntaje);
		}
	}
	
	public List<Integer> getPuntajes() {
		return this.ranking;
	}
}
