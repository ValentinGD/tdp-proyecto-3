package logica.niveles;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Mapas.Mapa;
import logica.Escenario;
import logica.Posicion;
import logica.entidades.PickUp;
import logica.fabricas.PickUpFactory;


public abstract class Nivel {
	
	protected String pathMapa;
	protected Mapa mapa;
	
	public abstract Nivel getSiguienteNivel();
	public abstract Mapa getMapa();
}
