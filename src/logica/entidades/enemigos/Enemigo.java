package logica.entidades.enemigos;

import app.App;
import logica.Visitor;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;
import logica.estados.enemigos.EstadoEnemigo;
import logica.estados.enemigos.Muerto;

public abstract class Enemigo extends Movible {
	
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

	
	public void aceptar(Visitor v) {
		v.visit(this);
	}
	
	@Override
	public void visit(Pared p) {
		estado.visitarPared(p);
	}
	
	public boolean esCambioDeDireccionValido(int direccion) {
		if (!esDireccionValida(direccion)) {
			return false;
		}
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
	public void visit(Personaje p) {
		p.visit(this);
	}

	public int getOrigenX() {
		return xOrigen;
	}
	
	public int getOrigenY() {
		return yOrigen;
	}

}