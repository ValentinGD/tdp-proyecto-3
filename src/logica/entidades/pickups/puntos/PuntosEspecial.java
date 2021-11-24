package logica.entidades.pickups.puntos;

import javax.swing.ImageIcon;

import app.App;
import logica.Visitor;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PuntosEspecial extends PickUpPuntos {

	private static final int PUNTOS_ESPECIAL = Integer.parseInt(App.configuration.getProperty("PuntosEspecial"));
	
	public PuntosEspecial(int x, int y) {
		super(x, y);
		puntos = PUNTOS_ESPECIAL;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoGrande();
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPuntoEspecialGrafico(RepositorioGraficoPickUpAbstracto.PUNTOS_1));
		}
		return miRepresentacion;
	}

}
