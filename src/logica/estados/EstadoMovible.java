package logica.estados;

import javax.swing.ImageIcon;

import logica.entidades.Pared;

public interface EstadoMovible {
	
	public void mover();
	
	public boolean puedeMover();
	
	public void visitarPared(Pared Pared);
}
