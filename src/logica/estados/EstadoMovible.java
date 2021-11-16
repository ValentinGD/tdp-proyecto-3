package logica.estados;

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
	
	protected EstadoMovible(int direccionActual) {
		this.direccionActual = direccionActual;
		colisionPared = false;
	}
	
	public abstract void mover();

	public boolean puedeMover(Movible m, int direccion) {
		calcularPosicionDestino(m.getX(), m.getY(), direccion);
		Zona zona = m.getZona();
		List<Entidad> entidades = zona.getEntidades();
		if (zona.distanciaABorde(m) <= Entidad.TAMANIO) {
			Zona zonaAdyacente = Escenario.getInstancia().getZonaAdyacente(zona, direccionActual);
			entidades.addAll(zonaAdyacente.getEntidades());
		}
		colisionPared = false;
		for (Entidad e : entidades) {
			e.aceptar(m);
		}
		return !colisionPared;
	}
	
	public void visitarPared(Pared pared) {
		//System.out.println("Distancia pared: " + Math.hypot(pared.getX() - xDestino, pared.getY() - yDestino));
		int distanciaX = Math.abs(pared.getX() - xDestino);
		int distanciaY = Math.abs(pared.getY() - yDestino);
		
		switch (direccionActual) {
		case Movible.DIRECCION_IZQUIERDA:
			//System.out.println("Chequeando colision izquierda");
			colisionPared = (distanciaY < Entidad.TAMANIO) && (pared.getX() + Entidad.TAMANIO >= xDestino);
			break;
		case Movible.DIRECCION_DERECHA:
			//System.out.println("Chequeando colision derecha");
			colisionPared = (distanciaY < Entidad.TAMANIO) && (pared.getX() > xDestino);
			break;
		case Movible.DIRECCION_ARRIBA:
			//System.out.println("Chequeando colision arriba");
			colisionPared = (distanciaX < Entidad.TAMANIO) && (pared.getY() < yDestino);
			break;
		case Movible.DIRECCION_ABAJO:
			//System.out.println("Chequeando colision abajo");
			colisionPared = (distanciaX < Entidad.TAMANIO) && (pared.getY() < yDestino);
			break;
		}
		if (colisionPared) {
			System.out.println("Se detecto una colision:\n\tpared: " + pared);
		}
	}
	
	protected boolean estaEnUnaPosibleInterseccion(Movible m) {
		return (m.getX() % Entidad.TAMANIO == 0) && (m.getY() % Entidad.TAMANIO == 0);
	}
	
	protected void calcularPosicionDestino(int x, int y, int direccion) {
		xDestino = x;
		yDestino = y;
		
		switch(direccion) {
		case Movible.DIRECCION_ABAJO:
			++yDestino;
			break;
		case Movible.DIRECCION_ARRIBA:
			--yDestino;
			break;
		case Movible.DIRECCION_DERECHA:
			++xDestino;
			break;
		case Movible.DIRECCION_IZQUIERDA:
			--xDestino;
			break;
		default:
			break;
		}
	}
}
