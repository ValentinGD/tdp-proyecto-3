package logica.estados.personaje;

import javax.swing.ImageIcon;

import logica.entidades.Movible;
import logica.entidades.Personaje;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public class EstadoPersonajeNormal extends EstadoPersonaje {

	public EstadoPersonajeNormal(Personaje personaje, int direccionActual) {
		super(personaje, direccionActual);
	}

	@Override
	public void mover() {
		if(puedeMover()){
			switch(direccionActual) {
			case Movible.DIRECCION_ABAJO:
				
				personaje.setY(personaje.getY()+1);
				System.out.println("Intenta mover abajo");
				
			break;
			case Movible.DIRECCION_ARRIBA:
				
				personaje.setY(personaje.getY()-1);
				System.out.println("Intenta mover arriba");
				
			break;
			case Movible.DIRECCION_DERECHA:
				
				personaje.setX(personaje.getX()+1);
				System.out.println("Intenta mover derecha");
				
			break;
			case Movible.DIRECCION_IZQUIERDA:
	
				personaje.setX(personaje.getX()-1);
	
			break;
			}
		}
	}

	@Override
	public boolean puedeMover() {
		// TODO Auto-generated method stub
		return true;
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
