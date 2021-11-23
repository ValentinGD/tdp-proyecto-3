package logica.entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import app.App;
import logica.Escenario;
import logica.Visitor;
import logica.Zona;
import logica.estados.personaje.EstadoPersonaje;
import logica.estados.personaje.EstadoPersonajeNormal;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.*;

public class Personaje extends Movible {

	private static Personaje instancia;
	
	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsPersonaje"));
	
	protected EstadoPersonaje estado;
	
	private int vidas;
	
	private int direccionSiguiente;
	
	private boolean esInvencible;
	private boolean puedeMatarEnemigo;
	private boolean tieneVelocidadExtra;
	
	private int ticsRestantesPoder;
	private int velocidadExtra;
	
	private boolean estaVivo;
	
	private Personaje() {
		super(0, 0);

		vidas = Escenario.CANTIDAD_INICIAL_DE_VIDAS;
		
		reset();
	}

	public static Personaje getInstancia() {
		if (instancia == null) {
			instancia = new Personaje();
		}
		
		return instancia;
	}
	
	@Override
	public void reset() {
		super.reset();
		
		direccionActual = Movible.DIRECCION_DERECHA;
		direccionSiguiente = direccionActual;
		
		velocidadEnTics = VELOCIDAD_INICIAL;
		estado = new EstadoPersonajeNormal(this, direccionActual);
		
		esInvencible = false;
		puedeMatarEnemigo = false;
		tieneVelocidadExtra = false;
		
		ticsRestantesPoder = 0;
		velocidadExtra = 0;
		
		estaVivo = true;
	}

	public void setDireccion(int direccion) {
		boolean esDireccionValida = Movible.esDireccionValida(direccion);
		if (esDireccionValida) {
			direccionSiguiente = direccion;
			//System.out.println("Personaje::Se cambio la direccion: " + direccionToString(direccionSiguiente));
		} else {
			//System.out.println("Personaje::No se puede cambiar de direccion");
		}
	}
	
	public synchronized void mover() {
		ticCount++;
		
		if (ticCount >= velocidadEnTics - velocidadExtra) {
			estado.mover();
			ticCount = 0;
		}
//		System.out.println("movido");
	}

	@Override
	public void morir() {
		if (estaVivo) {
			estaVivo = false;
			vidas--;
			System.out.println("Murio el personaje. Vidas: " + vidas);
			Escenario.getInstancia().murioPersonaje();
		}
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarPersonaje(this);
	}
	
	@Override
	public void visitarPared(Pared p) {
		estado.visitarPared(p);
	}
	
	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoPersonaje()));
		//System.out.println("representacion personaje: " + miRepresentacion);
		return miRepresentacion;
	}
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
//	@Override
//	public String toString() {
//		return "Personaje::toString: " + super.toString() + ", estado: <" + estado + ">";
//	}

	public int getDireccionSiguiente() {
		return direccionSiguiente;
	}
	
	public void actualizarDireccion() {
		direccionActual = direccionSiguiente;
	}
	
	public void comerPickUp() {
		Zona zona = getZona();
		List<Entidad> entidades = zona.getEntidades();
		for (Entidad e : entidades) {
			e.aceptar(this);
		}
	}

//	public void chocarConEnemigo() {
//		Zona zona = getZona();
//		List<Entidad> entidades = zona.getEntidades();
//		for (Entidad e : entidades) {
//			e.aceptar(this);
//		}
//	}
	
	public void visitarPickUpPuntos(PickUpPuntos p) {
		if(this.getX()==p.getX() && this.getY()==p.getY()) {
			Escenario.getInstancia().eliminarPickUp(p);
		}
	}
	public void visitarPickUpPoder(PickUpPoder p) {
		p.aplicarPoder(this);
		if(p.colisionaConEntidadEnPosicion(x, y)) {
			System.out.println("sobre poder");
			Escenario.getInstancia().eliminarPickUp(p);
		}
	}
	
	public void visitarEnemigo(Enemigo e) {
		if (e.colisionaConEntidadEnPosicion(x, y)) {
			System.out.println("El personaje colisiono con: " + e);
			System.out.println("Personaje: " + toString());
			if (puedeMatarEnemigo) {
				e.morir();
			} else if (!esInvencible) {
				morir();
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Personaje: <" + super.toString() + ">";
	}

	public void resetVidas() {
		vidas = Escenario.CANTIDAD_INICIAL_DE_VIDAS;
		estaVivo = true;
	}
}
