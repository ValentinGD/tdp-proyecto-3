package logica.estados.enemigos;

import javax.swing.ImageIcon;

import logica.entidades.Movible;
import logica.entidades.enemigos.Enemigo;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public abstract class DescansandoEnemigoAbstracto extends EstadoEnemigo {
	
	
	protected DescansandoEnemigoAbstracto(Enemigo enemigo, int direccionActual) {
		super(enemigo, direccionActual);
	}

	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio) {
		ImageIcon img;
		switch(direccionActual) {
		case Movible.DIRECCION_ABAJO:
			img = repositorio.getMovibleAbajoGrafico();
			break;
		case Movible.DIRECCION_ARRIBA:
			img = repositorio.getMovibleArribaGrafico();
			break;
		case Movible.DIRECCION_DERECHA:
			img = repositorio.getMovibleDerechaGrafico();
			break;
		case Movible.DIRECCION_IZQUIERDA:
			img = repositorio.getMovibleIzquierdaGrafico();
			break;
		default:
			img = new ImageIcon();
			break;
		}
		return img;
	}
}
