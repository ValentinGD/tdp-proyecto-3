package vista;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import logica.entidades.Entidad;

public class RepresentacionGrafica {
	
	private JLabel label;
	
	private Entidad entidad;
	
	private int tam;
	
	public RepresentacionGrafica(int tam, Entidad entidad) {
		label = new JLabel();
		label.setBackground(Color.GREEN);
		this.tam = tam;
		this.entidad = entidad;
	}
	
	public JLabel getLabel() {
		int x = entidad.getX() - tam / 2 + 2;
		int y = entidad.getY() - tam / 2 + 2;
		label.setBounds(x, y, tam, tam);
		return label;
	}
	
	public void setImageIcon(ImageIcon icon) {
		label.setIcon(resize(icon));
		//System.out.println("icono colocado");
	}
	
	private ImageIcon resize(ImageIcon icono) {
		Image img = icono.getImage();
		img = img.getScaledInstance(tam, tam, Image.SCALE_FAST);
		icono.setImage(img);
		return icono;
	}
}
