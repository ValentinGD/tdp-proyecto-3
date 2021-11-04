package logica.estados.personaje;

import java.util.ArrayList;

import logica.Escenario;
import logica.Posicion;
import logica.entidades.Movible;
import logica.entidades.Personaje;

public class EstadoPersonajeNormal extends EstadoPersonaje {

	@Override
	public ArrayList<Posicion> mover(Personaje personaje, int direccionActual) {
		ArrayList<Posicion> posicionesModificadas = new ArrayList<Posicion>();
		Posicion nuevaPosicion = Escenario.getInstancia().getPosicion(calcularSiguientePosicion(personaje, direccionActual));
		
		if (puedeMover(nuevaPosicion)) {
			posicionesModificadas.add(personaje.getPosicion());
			posicionesModificadas.add(nuevaPosicion);
			
			personaje.getPosicion().setPersonaje(null);
			personaje.setPosicion(nuevaPosicion);
			personaje.getPosicion().setPersonaje(personaje);
			if (nuevaPosicion.hayPickUp()) {
				Escenario.getInstancia().eliminarPickUp(nuevaPosicion);
			}
		}
		
		return posicionesModificadas;
	}
	
	
	
	

}
