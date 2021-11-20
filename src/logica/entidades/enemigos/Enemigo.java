package logica.entidades.enemigos;


import app.App;
import logica.Visitor;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.estados.enemigos.EstadoEnemigo;

public abstract class Enemigo extends Movible {
	protected int velocidad;
	protected int tiempoDescanso;
	
	protected EstadoEnemigo estado;

	protected Enemigo(EstadoEnemigo estadoInicial) {
		super(0, 0);
		estado = estadoInicial;
		velocidad = Integer.parseInt(App.configuration.getProperty("VelocidadEnemigo"));
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
	
	public void aceptar(Visitor v) {
		v.visitarEnemigo(this);
	}
	@Override
	public void visitarPared(Pared p) {
		estado.visitarPared(p);
	}
	
	public boolean esCambioDeDireccionValido(int direccion) {
		if (!esDireccionValida(direccion)) {
			return false;
		}
		
//		if (!Movible.sonDireccionesOpuestas(direccion, direccionActual)) {
//			System.out.println("Cambiar de " + direccionToString(direccionActual) + " a " + direccionToString(direccionActual) + " ES posible");
//		}
		return !Movible.sonDireccionesOpuestas(direccion, direccionActual);
	}
	
	public abstract void perseguir();

	public abstract void descansar();

	public abstract void morir();

	public abstract void asustarse();

}
