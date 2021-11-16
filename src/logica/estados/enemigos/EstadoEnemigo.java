package logica.estados.enemigos;

import javax.swing.ImageIcon;

import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.enemigos.Enemigo;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public abstract class EstadoEnemigo extends EstadoMovible {
	
	protected Enemigo enemigo;
	
	protected EstadoEnemigo(Enemigo enemigo, int direccionInicial) {
		super(enemigo, direccionInicial);
		this.enemigo = enemigo;
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
