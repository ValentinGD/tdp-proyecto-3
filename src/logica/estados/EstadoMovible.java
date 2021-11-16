package logica.estados;

import java.util.ArrayList;
import java.util.List;

import logica.Escenario;
import logica.Zona;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;

public abstract class EstadoMovible {
	
	protected boolean colisionPared;
	
	protected int direccionActual;

	protected int xDestino, yDestino;
	
	protected Movible movible;
	
	protected EstadoMovible(Movible movible, int direccionActual) {
		this.movible = movible;
		this.direccionActual = direccionActual;
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
		
		System.out.println("visitando " + entidades.size() + " entidades.");
		
		//System.out.println("Entidades a comparar:");
		//for (Entidad e : entidades) {
			//System.out.println("\t" + e);
		//}

		colisionPared = false;
		calcularPosicionDestino(m, direccion);
		for (Entidad e : entidades) {
			e.aceptar(m);
		}
		//System.out.println("colsion pared: " + colisionPared);
		//if (colisionPared) {
			//System.out.println("NO mover--------------------------------------------------------------------------");
		//} else {
			//System.out.println("SI mover");
		//}
		return !colisionPared;
	}
	
	public void visitarPared(Pared pared) {
		colisionPared = colisionPared || pared.colisionaConEntidadEnPosicion(xDestino, yDestino);
		//if (colisionPared) {
			//System.out.println("\tColision con pared: " + pared);
			//System.out.println("No deberia moverse");
		//}
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
		//System.out.println("\tposicionOrigen: <x: " + m.getX() + ", y: " + m.getY() + ">");
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
		//System.out.println("\tposicionDestino: <x: " + xDestino + ", y: " + yDestino + ">");
	}
}
