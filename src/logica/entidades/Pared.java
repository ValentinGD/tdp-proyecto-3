package logica.entidades;

import javax.swing.ImageIcon;

import logica.Visitor;
import logica.entidades.Entidad;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Pared extends Entidad{

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
		v.visitarPared(this);
	}
	
	public String toString() {
		return "Pared: <x: " + x + ", y: " + y + ">";
	}
}
