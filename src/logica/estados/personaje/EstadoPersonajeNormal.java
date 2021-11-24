package logica.estados.personaje;

import javax.swing.ImageIcon;
import logica.Escenario;
import logica.entidades.Movible;
import logica.entidades.Personaje;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public class EstadoPersonajeNormal extends EstadoPersonaje {
	
	public EstadoPersonajeNormal(Personaje personaje, int direccionActual) {
		super(personaje);
	}

	@Override
	public void mover() {
		verificarCambioDireccion();
		if(puedeMover(personaje, personaje.getDireccionActual())) {
			//System.out.println("moviendo personaje");
			
			calcularPosicionDestino(personaje);
			personaje.setPosicion(xDestino, yDestino);
			Escenario.getInstancia().agregarEntidadParaActualizar(personaje);
			Escenario.getInstancia().reubicar(personaje);
			
			//System.out.println("Entidades en la zona del personaje:");
			//for (Entidad e : personaje.getZona().getEntidades()) {
				//System.out.println("\t" + e);
			//}
		} else {
			//System.out.println("No se puede mover personaje");
		}
	}

	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoPersonaje repositorio) {
		ImageIcon img;
		if (!personaje.esPoderoso()) {
			switch(personaje.getDireccionActual()) {
			case Movible.DIRECCION_ABAJO:
				img = repositorio.getMovibleAbajoGrafico();
				break;
			case Movible.DIRECCION_ARRIBA:
				img = repositorio.getMovibleArribaGrafico();
				break;
			case Movible.DIRECCION_DERECHA:
				img = repositorio.getMovibleDerechaGrafico();
				break;
			case Movible.DIRECCION_IZQUIERDA:
				img = repositorio.getMovibleIzquierdaGrafico();
				break;
			default:
				img = new ImageIcon();
				break;
			}
		} else {
			img = repositorio.getPersonajePoderosoGrafico();
		}
		return img;
	}
	
	public String toString() {
		return "estado personaje: normal";
	}
}
