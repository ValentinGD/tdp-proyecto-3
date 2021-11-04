package logica.entidades.pickups;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class Poder extends PickUpEspecial {
	
	@Override
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPoder();
	}
}
