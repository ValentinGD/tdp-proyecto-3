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
			Zona zonaAdyacente = Escenario.getInstancia().getZonaAdyacente(zona, direccion);
			if (zona != zonaAdyacente) {
				entidades.addAll(zonaAdyacente.getEntidades());
			}
		}

		colisionPared = false;
		calcularPosicionDestino(m, direccion);
		for (Entidad e : entidades) {
			e.aceptar(m);
		}

		return !colisionPared;
	}
	
	public void visitarPared(Pared pared) {
		colisionPared = colisionPared || pared.colisionaConEntidadEnPosicion(xDestino, yDestino);
	}
	
	protected void calcularPosicionDestino(Movible m) {
		calcularPosicionDestino(m, m.getDireccionActual());
	}
	
	protected void calcularPosicionDestino(Movible m, int direccion) {
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
	}

}