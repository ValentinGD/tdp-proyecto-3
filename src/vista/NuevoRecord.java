package vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * GUI para pedirle al usuario que ingrese su nombre.
 * Esto se muestra solo en caso de que el puntaje entre dentro de los top scores. 
 */

public class NuevoRecord {

	JFrame f;

	public NuevoRecord() {
		f = new JFrame();
	}

	public String cartel_solicitar_nombre() {
		String nombre = JOptionPane.showInputDialog(f, "Ingrese su nombre:", "TdP-man - NUEVO RECORD",
				JOptionPane.PLAIN_MESSAGE);
		return nombre;
	}

}