package logica.niveles;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.Posicion;

public class Nivel1 extends Nivel {

	public Nivel1() {
		pathMapa="Mapas/Mapa1.txt";
	}

	public Nivel getSiguienteNivel() {
		return new Nivel2();
	}

	@Override
	public Mapa getMapa() {
		return MapLoader.getMapa(1);
	}
}
