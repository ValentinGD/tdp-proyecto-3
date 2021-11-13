package logica.entidades;

import javax.swing.ImageIcon;

import logica.entidades.Entidad;

public class Pared extends Entidad{

	public Pared(int x, int y) {
		this.x=x;
		this.y=y;
		
	}

	@Override
	public ImageIcon getRepresentacionGrafica() {
		return null;
	}
}
