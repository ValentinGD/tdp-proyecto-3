package logica.entidades;

import logica.Visitor;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Pared extends Entidad {

	public Pared(int x, int y) {
		super(x, y);
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoEscenario().getParedPunto());
		return miRepresentacion;
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit(this);
	}

	@Override
	public String toString() {
		return "Pared: <x: " + x + ", y: " + y + ">";
	}

}