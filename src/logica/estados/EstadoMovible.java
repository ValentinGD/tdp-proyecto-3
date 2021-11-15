package logica.estados;

import java.util.List;

import logica.Zona;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;

public abstract class EstadoMovible {
	
	protected boolean colisionPared;
	
	protected int direccionActual;

	protected int xDestino, yDestino;
	
	protected Movible movible;
	
	protected EstadoMovible(int direccionActual) {
		this.direccionActual = direccionActual;
		colisionPared = false;
	}
	
	public abstract void mover();

	public boolean puedeMover(Movible m) {
		Zona zona = m.getZona();
		List<Entidad> entidades = zona.getEntidades();
		colisionPared = false;
		for (Entidad e : entidades) {
			e.aceptar(m);
		}
		return colisionPared;
	}
	
	public void visitarPared(Pared pared) {
		if (Math.hypot(pared.getX() - xDestino, pared.getY() - yDestino) < Entidad.TAMANIO) {
			colisionPared = true;
		}
	}
	
	protected void calcularPosicionDestino(int x, int y) {
		xDestino = x;
		yDestino = y;
		
		switch(direccionActual) {
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
