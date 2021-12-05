package logica.entidades;

import javax.swing.ImageIcon;
import logica.Visitor;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class ParedFantasma extends Entidad {

	public ParedFantasma(int x, int y) {
		super(x, y);
	}

	public ImageIcon getRepresentacionGrafica() {
		return null;
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		
	}

}