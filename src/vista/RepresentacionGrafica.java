package vista;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.Escenario;
import logica.entidades.Entidad;
import logica.entidades.Movible;

public class RepresentacionGrafica {
	
	private JLabel label;
	
	private Entidad entidad;
	
	private int tam;
	
	public RepresentacionGrafica(int tam, Entidad entidad) {
		label = new JLabel();
		this.tam = tam;
		this.entidad = entidad;
	}
	
	public JLabel getLabel() {
		int x = entidad.getX() + 2;
		int y = entidad.getY() + 2;
		label.setBounds(x, y, tam, tam);
		return label;
	}
	
	public void setImageIcon(ImageIcon icon) {
		if (icon != null) {
			label.setIcon(resize(icon));
		} else {
			label.setIcon(null);
		}
	}
	
	private ImageIcon resize(ImageIcon icono) {
		Image img = icono.getImage();
		img = img.getScaledInstance(tam, tam, Image.SCALE_FAST);
		icono.setImage(img);
		return icono;
	}

}