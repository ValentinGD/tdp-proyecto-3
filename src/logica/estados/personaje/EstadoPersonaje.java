package logica.estados.personaje;

import java.util.ArrayList;

import logica.Posicion;
import logica.entidades.Personaje;

public abstract class EstadoPersonaje {
	
	public abstract ArrayList<Posicion> mover(Personaje personaje, int direccionActual);
}
