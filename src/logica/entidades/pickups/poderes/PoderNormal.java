package logica.entidades.pickups.poderes;

import javax.swing.ImageIcon;

import logica.Visitor;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderNormal extends PickUpPoder {
	
	public PoderNormal(int x, int y) {
		super(x, y);
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPoderNormalGrafico());
		}
		return miRepresentacion;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPoder();
	}

}
