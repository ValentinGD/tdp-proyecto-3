package logica.entidades.enemigos;

import javax.swing.ImageIcon;

import logica.Notificadora;
import logica.Suscriptor;
import logica.entidades.Movible;
import logica.estados.enemigos.EstadoEnemigo;
import vista.RepositorioGrafico;

public abstract class Enemigo extends Movible {
	protected int velocidad;
	protected int tiempoDescanso;
	protected EstadoEnemigo estado;

	protected Enemigo() {
		velocidad = 1;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velociadad) {
		this.velocidad = velociadad;
	}

	public int getTiempoDescanso() {
		return tiempoDescanso;
	}

	public void setTiempoDescanso(int tiempoDescanso) {
		this.tiempoDescanso = tiempoDescanso;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getEnemigoVivo();
	}

	public abstract void perseguir();

	public abstract void descansar();

	public abstract void morir();

	public abstract void asustarse();

}
