package logica.estados.personaje;

import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;

import logica.Escenario;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public class EstadoPersonajeNormal extends EstadoPersonaje {
	
	public EstadoPersonajeNormal(Personaje personaje, int direccionActual) {
		super(personaje, direccionActual);
	}

	@Override
	public void mover() {
		verificarCambioDireccion();
		if(puedeMover(personaje, direccionActual)) {
			//System.out.println("moviendo personaje");
			calcularPosicionDestino(personaje.getX(), personaje.getY(), direccionActual);
			personaje.setX(xDestino);
			personaje.setY(yDestino);
			if (!personaje.getZona().contieneCoordenadas(personaje)) {
				Escenario.getInstancia().reubicar(personaje);
			}
		} else {
			System.out.println("No se puede mover personaje");
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
