package logica.entidades;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class Personaje extends Movible {
	private int vidas;
	private static Personaje instancia;

	private Personaje() {
		vidas = 3;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public static Personaje getInstancia() {
		if (instancia == null) {
			instancia = new Personaje();
		}
		
		return instancia;
	}

	public void mover() {

	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPersonaje();
	}
}
