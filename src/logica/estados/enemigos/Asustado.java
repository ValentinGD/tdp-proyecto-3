package logica.estados.enemigos;

import javax.swing.ImageIcon;

import logica.entidades.enemigos.Enemigo;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public class Asustado extends EstadoEnemigo {

	public Asustado(Enemigo enemigo, int direccionActual) {
		super(enemigo, direccionActual);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean puedeMover() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio) {
		return repositorio.getEnemigoAsustadoGrafico();
	}


}
