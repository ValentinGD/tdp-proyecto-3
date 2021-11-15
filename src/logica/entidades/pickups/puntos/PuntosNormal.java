package logica.entidades.pickups.puntos;

import javax.swing.ImageIcon;

import logica.Visitor;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class PuntosNormal extends PickUpPuntos {

	public PuntosNormal(int x, int y) {
		super(x, y);
		puntos=puntosC;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPuntoChico();

	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPuntoNormalGrafico());
		return miRepresentacion;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
