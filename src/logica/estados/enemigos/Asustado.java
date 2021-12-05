package logica.estados.enemigos;

import javax.swing.ImageIcon;
import logica.entidades.enemigos.Enemigo;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public class Asustado extends EstadoEnemigo {

	public Asustado(Enemigo enemigo) {
		super(enemigo);
	}

	@Override
	public void mover() {

	}

	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio) {
		return repositorio.getEnemigoAsustadoGrafico();
	}

}