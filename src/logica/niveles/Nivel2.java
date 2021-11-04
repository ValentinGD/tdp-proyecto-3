package logica.niveles;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.Posicion;

public class Nivel2 extends Nivel {

	public Nivel2() {
		pathMapa="\\Mapas\\Mapa2.txt";
		mapa = MapLoader.getMapa(3);
	}
	public Nivel getSiguienteNivel() {
		return new Nivel3();
	}
	public Mapa getMapa() {
		return mapa;
	}
}
