package logica.estados.personaje;

import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;

import logica.Escenario;
import logica.Zona;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public class EstadoPersonajeNormal extends EstadoPersonaje {
	
	public EstadoPersonajeNormal(Personaje personaje, int direccionActual) {
		super(personaje, direccionActual);
	}

	@Override
	public void mover() {
		calcularPosicionDestino(personaje.getX(), personaje.getY());
		if(puedeMover(personaje)){
			
		}
	}

	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoPersonaje repositorio) {
		ImageIcon img;
		switch(direccionActual) {
		case Movible.DIRECCION_ABAJO:
			img = repositorio.getMovibleAbajoGraifco();
			break;
		case Movible.DIRECCION_ARRIBA:
			img = repositorio.getMovibleArribaGraifco();
			break;
		case Movible.DIRECCION_DERECHA:
			img = repositorio.getMovibleDerechaGraifco();
			break;
		case Movible.DIRECCION_IZQUIERDA:
			img = repositorio.getMovibleIzquierdaGraifco();
			break;
		default:
			img = new ImageIcon();
			break;
		}
		return img;
	}
	
	public String toString() {
		return "estado personaje: normal";
	}
}
