package logica.fabricas;

import Mapas.MapLoader;
import Mapas.Mapa;

public class MapaFactory {
	private Mapa mapa;
	
	public void numeroMapa(int nroMapa) {
		getMapa(nroMapa);
	}
	private Mapa getMapa(int nroMapa) {
		MapLoader.getMapa(nroMapa)
		return mapa;
	}
}
