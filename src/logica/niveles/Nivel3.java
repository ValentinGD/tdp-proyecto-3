package logica.niveles;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.Posicion;

public class Nivel3 extends Nivel {

	public Nivel3() {
		pathMapa="Mapas\\Mapa3.txt";
		mapa = MapLoader.getMapa(3);
	}
	
	public Nivel getSiguienteNivel() {
		return null;
	}
	public Mapa getMapa() {
		return mapa;
	}
}
