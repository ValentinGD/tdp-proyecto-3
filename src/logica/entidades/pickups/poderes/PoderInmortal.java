package logica.entidades.pickups.poderes;

import logica.entidades.Personaje;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderInmortal extends PoderEspecial {

	public PoderInmortal(int x, int y) {
		super(x, y);
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
	
	@Override
	public void aplicarPoder(Personaje personaje) {
		super.aplicarPoder(personaje);
		personaje.hacerInmortal();
	}
	
	public String toString() {
		return "Poder inmortal";
	}
}
