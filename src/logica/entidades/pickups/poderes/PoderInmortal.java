package logica.entidades.pickups.poderes;

import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderInmortal extends PoderEspecial {

	public PoderInmortal(int x, int y) {
		super(x, y, 0, 0, true, false);
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPoderEspecialGrafico(RepositorioGraficoPickUpAbstracto.PODER_INMORTAL));
		}
		return miRepresentacion;
	}
	
	public String toString() {
		return "Poder inmortal";
	}
}
