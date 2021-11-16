package logica.entidades.pickups.puntos;

import javax.swing.ImageIcon;

import logica.Visitor;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PuntosEspecial extends PickUpPuntos {

	public PuntosEspecial(int x, int y) {
		super(x, y);
		puntos=puntosG;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoGrande();
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPuntoEspecialGrafico(RepositorioGraficoPickUpAbstracto.PUNTOS_1));
		return miRepresentacion;
	}

}
