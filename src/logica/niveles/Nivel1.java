package logica.niveles;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.Posicion;

public class Nivel1 extends Nivel {
	
	private Mapa mapa;

	public Nivel1() {
		pathMapa="Mapas/Mapa1.txt";
		mapa = MapLoader.getMapa(1);
	}

	public Nivel getSiguienteNivel() {
		return new Nivel2();
	}

	@Override
	public Mapa getMapa() {
		return mapa;
	}
}
