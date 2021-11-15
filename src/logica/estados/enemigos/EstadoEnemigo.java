package logica.estados.enemigos;

import javax.swing.ImageIcon;

import logica.entidades.Movible;
import logica.entidades.enemigos.Enemigo;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public abstract class EstadoEnemigo implements EstadoMovible {
	
	protected Enemigo enemigo;
	
	protected int direccionActual;
	
	protected EstadoEnemigo(Enemigo enemigo, int direccionInicial) {
		this.enemigo = enemigo;
		direccionActual = direccionInicial;
	}
	
	protected EstadoEnemigo() {
		this(null, Movible.DIRECCION_ARRIBA);
	}
	
	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}
	
	public void setDireccion(int direccionActual) {
		this.direccionActual = direccionActual;
	}
	
	public abstract ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio);
}
