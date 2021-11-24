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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
