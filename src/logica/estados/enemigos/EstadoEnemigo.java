package logica.estados.enemigos;

import javax.swing.ImageIcon;

import logica.entidades.enemigos.Enemigo;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public abstract class EstadoEnemigo extends EstadoMovible {

	protected Enemigo enemigo;

	protected EstadoEnemigo(Enemigo enemigo) {
		super(enemigo);
		this.enemigo = enemigo;
	}

	protected EstadoEnemigo() {
		this(null);
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public abstract ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio);

}