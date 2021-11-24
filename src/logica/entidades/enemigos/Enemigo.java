package logica.entidades.enemigos;

import app.App;
import logica.Visitor;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;
import logica.estados.enemigos.EstadoEnemigo;
import logica.estados.enemigos.Muerto;

public abstract class Enemigo extends Movible {
	
	protected int tiempoDescanso;
	
	protected EstadoEnemigo estado;

	protected Enemigo(EstadoEnemigo estadoInicial) {
		super(0, 0);
		estado = estadoInicial;
		this.velocidadEnTics = Integer.parseInt(App.configuration.getProperty("VelocidadTicsPersonaje"));
	}
	
	@Override
	public void reset() {
		super.reset();
		direccionActual = Movible.DIRECCION_ARRIBA;
	}

	public int getVelocidad() {
		return velocidadEnTics;
	}

	public void setVelocidad(int velociadad) {
		this.velocidadEnTics = velociadad;
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

	public void morir() {
		estado = new Muerto(this);
	}
	
	@Override
	public void mover() {
		ticCount++;
		
		if (ticCount == velocidadEnTics) {
			estado.mover();
			ticCount = 0;
		}
	}
	
	@Override
	public void visitarPersonaje(Personaje p) {
		p.visitarEnemigo(this);
	}

	public int getOrigenX() {
		return xOrigen;
	}
	
	public int getOrigenY() {
		return yOrigen;
	}
}
