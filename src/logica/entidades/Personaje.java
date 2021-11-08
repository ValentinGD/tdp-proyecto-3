package logica.entidades;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import logica.Escenario;
import logica.Posicion;
import logica.estados.personaje.EstadoPersonaje;
import logica.estados.personaje.EstadoPersonajeNormal;
import vista.RepositorioGrafico;

public class Personaje extends Movible {
	
	private static Personaje instancia;
	
	private EstadoPersonaje estado;
	
	private int vidas;
	private int direccionActual;
	private int direccionSiguiente;
	
	private Personaje() {
		vidas = 3;
		direccionActual = Movible.DIRECCION_DERECHA;
		direccionSiguiente = direccionActual;
		estado = new EstadoPersonajeNormal();
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public void setDireccion(int direccion) {
		if (Movible.esDireccionValida(direccion)) {
			direccionSiguiente = direccion;
			System.out.println("Personaje::Se cambio la direccion: " + direccionSiguiente);
		}
	}

	public static Personaje getInstancia() {
		if (instancia == null) {
			instancia = new Personaje();
		}
		
		return instancia;
	}
	
	public ArrayList<Posicion> mover() {
		//System.out.println("moviendo personaje");
		Posicion posiblePosicionEnNuevaDireccion = Escenario.getInstancia().getPosicion(EstadoPersonaje.calcularSiguientePosicion(getInstancia(), direccionSiguiente));
		if (posiblePosicionEnNuevaDireccion.esHabitable()) {
			direccionActual = direccionSiguiente;
		}
		return estado.mover(this, direccionActual);
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPersonaje();
	}
	
	public String toString() {
		return "x: " + x + ", y: " + y + ", direccion: " + direccionActual + ", estado: " + estado; 
	}

}
