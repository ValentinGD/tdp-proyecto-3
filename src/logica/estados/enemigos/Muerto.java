package logica.estados.enemigos;

import javax.swing.ImageIcon;

import logica.entidades.enemigos.Enemigo;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public class Muerto extends EstadoEnemigo {

	protected Muerto(Enemigo enemigo) {
		super(enemigo);
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio) {
		return repositorio.getMovibleMuertoGrafico();
	}

}
