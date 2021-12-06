package logica.niveles;

import java.util.List;

import Mapas.MapLoader;
import Mapas.Mapa;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PuntosEspecial;
import logica.entidades.pickups.puntos.PuntosNormal;

public abstract class Nivel {

	protected Mapa mapa;
	protected int velocidadEnemigo;
	protected int velocidadPersonaje;

	protected Nivel(int numeroMapa) {
		mapa = MapLoader.getMapa(numeroMapa);
	}

	public List<Movible> getMovibles() {
		return mapa.getMovibles();
	}

	public List<PuntosNormal> getPickUpsNormales() {
		return mapa.getPickUpsNormales();
	}

	public List<PuntosEspecial> getPuntosEspeciales() {
		return mapa.getPuntosEspeciales();
	}

	public List<PickUpPoder> getPoderesEspeciales() {
		return mapa.getPoderesEspeciales();
	}

	public List<Pared> getParedes() {
		return mapa.getParedes();
	}

	public int getVelocidadEnemigo() {
		return velocidadEnemigo;
	}

	public int getVelocidadPersonaje() {
		return velocidadPersonaje;
	}

	public int getAlto() {
		return mapa.getAlto();
	}

	public int getAncho() {
		return mapa.getAncho();
	}

	public int getCantFilas() {
		return mapa.getCantFilas();
	}

	public int getCantColumnas() {
		return mapa.getCantColumnas();
	}

	public abstract Nivel getSiguienteNivel();

	public int getCantPickUps() {
		return mapa.getcantPickup();
	}

	@Override
	public abstract String toString();

}