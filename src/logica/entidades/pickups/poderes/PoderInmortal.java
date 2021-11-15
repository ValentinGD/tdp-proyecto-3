package logica.entidades.pickups.poderes;

import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderInmortal extends PoderEspecial {

	public PoderInmortal(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPoderEspecialGrafico(RepositorioGraficoPickUpAbstracto.PODER_INMORTAL));
		return miRepresentacion;
	}

}
