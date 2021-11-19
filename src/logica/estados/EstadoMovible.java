package logica.estados;

import java.util.ArrayList;
import java.util.List;

import logica.Escenario;
import logica.Zona;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.enemigos.Enemigo;

public abstract class EstadoMovible {
	
	protected boolean colisionPared;

	protected int xDestino, yDestino;
	
	protected Movible movible;
	
	protected EstadoMovible(Movible movible) {
		this.movible = movible;
		colisionPared = false;
	}
	
	public abstract void mover();

	public boolean puedeMover(Movible m, int direccion) {
		Zona zona = m.getZona();
		List<Entidad> entidades = new ArrayList<Entidad>(zona.getEntidades());
		
		if (zona.estaEnElBorde(m, direccion)) {
			//System.out.println("el movible <" + m + "> esta al borde de la zona: " + zona);
			Zona zonaAdyacente = Escenario.getInstancia().getZonaAdyacente(zona, direccion);
			if (zona != zonaAdyacente) {
				entidades.addAll(zonaAdyacente.getEntidades());
			}
		}
		
		if (m instanceof Enemigo) {
			//System.out.println("\tvisitando " + entidades.size() + " entidades.");
			//System.out.println("\tEntidades a comparar:");
			for (Entidad e : entidades) {
				if (e instanceof Pared) {
					//System.out.println("\t\t" + e);
				}
			}
		}

		colisionPared = false;
		calcularPosicionDestino(m, direccion);
		for (Entidad e : entidades) {
			e.aceptar(m);
		}
		//System.out.println("colsion pared: " + colisionPared);
//		if (m instanceof Movible) {
//			if (colisionPared) {
//				System.out.println("NO mover--------------------------------------------------------------------------");
//			} else {
//				System.out.println("SI mover");
//			}
//		}
		return !colisionPared;
	}
	
	public void visitarPared(Pared pared) {
		colisionPared = colisionPared || pared.colisionaConEntidadEnPosicion(xDestino, yDestino);
//		if (movible instanceof Enemigo) {
//			if (colisionPared) {
//				//System.out.println("\t\t\tColision con pared: " + pared + ": " + pared.colisionaConEntidadEnPosicion(xDestino, yDestino));
//				//System.out.println("No deberia moverse");
//			}
//		}
		//System.out.println("Distancia pared: " + Math.hypot(pared.getX() - xDestino, pared.getY() - yDestino));
//		int distanciaX = Math.abs(pared.getX() - xDestino);
//		int distanciaY = Math.abs(pared.getY() - yDestino);
//		
//		switch (direccionActual) {
//		case Movible.DIRECCION_IZQUIERDA:
//			//System.out.println("Chequeando colision izquierda");
//			colisionPared = (distanciaY < Entidad.TAMANIO) && (pared.getX() + Entidad.TAMANIO >= xDestino);
//			break;
//		case Movible.DIRECCION_DERECHA:
//			//System.out.println("Chequeando colision derecha");
//			colisionPared = (distanciaY < Entidad.TAMANIO) && (pared.getX() > xDestino);
//			break;
//		case Movible.DIRECCION_ARRIBA:
//			//System.out.println("Chequeando colision arriba");
//			colisionPared = (distanciaX < Entidad.TAMANIO) && (pared.getY() < yDestino);
//			break;
//		case Movible.DIRECCION_ABAJO:
//			//System.out.println("Chequeando colision abajo");
//			colisionPared = (distanciaX < Entidad.TAMANIO) && (pared.getY() < yDestino);
//			break;
//		}
//		if (colisionPared) {
//			System.out.println("Se detecto una colision:\n\tpared: " + pared);
//		}
	}
	
	protected void calcularPosicionDestino(Movible m) {
		calcularPosicionDestino(m, m.getDireccionActual());
	}
	
	protected void calcularPosicionDestino(Movible m, int direccion) {
		//if (m instanceof Enemigo) System.out.println("\tposicionOrigen: <x: " + m.getX() + ", y: " + m.getY() + ">");
		xDestino = m.getX();
		yDestino = m.getY();
		
		switch(direccion) {
		case Movible.DIRECCION_ABAJO:
			yDestino += Movible.VELOCIDAD;
			break;
		case Movible.DIRECCION_ARRIBA:
			yDestino -= Movible.VELOCIDAD;
			break;
		case Movible.DIRECCION_DERECHA:
			xDestino += Movible.VELOCIDAD;
			break;
		case Movible.DIRECCION_IZQUIERDA:
			xDestino -= Movible.VELOCIDAD;
			break;
		default:
			break;
		}
		//if (m instanceof Enemigo) System.out.println("\tposicionDestino: <x: " + xDestino + ", y: " + yDestino + ">");
	}
}
