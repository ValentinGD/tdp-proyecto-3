package logica.entidades;

import java.util.List;

import app.App;
import logica.Escenario;
import logica.Visitor;
import logica.Zona;
import logica.entidades.enemigos.Enemigo;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.PickUpPuntos;
import logica.estados.personaje.EstadoPersonaje;
import logica.estados.personaje.EstadoPersonajeNormal;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Personaje extends Movible {

	private static Personaje instancia;
	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsPersonaje"));
	protected EstadoPersonaje estado;
	private int vidas;
	private int direccionSiguiente;
	private boolean esInmortal;
	private boolean puedeMatarEnemigos;
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

		resetPoderes();

		estaVivo = true;
	}

	public void setDireccion(int direccion) {
		boolean esDireccionValida = Movible.esDireccionValida(direccion);
		if (esDireccionValida) {
			direccionSiguiente = direccion;
		} else {

		}
	}

	@Override
	public synchronized void mover() {
		ticCount++;

		if (ticCount >= velocidadEnTics - velocidadExtra) {
			estado.mover();
			ticCount = 0;
		}

		if (ticsRestantesPoder <= 0) {
			resetPoderes();
		} else {
			ticsRestantesPoder--;
		}
	}

	private void resetPoderes() {
		esInmortal = false;
		puedeMatarEnemigos = false;

		ticsRestantesPoder = 0;
		velocidadExtra = 0;
	}

	@Override
	public void morir() {
		if (estaVivo) {
			estaVivo = false;
			vidas--;
			Escenario.getInstancia().murioPersonaje();
		}
	}

	@Override
	public void aceptar(Visitor v) {
		v.visit(this);
	}

	@Override
	public void visit(Pared p) {
		estado.visitarPared(p);
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoPersonaje()));
		return miRepresentacion;
	}

	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public void agregarVelocidad(int cantTicsAcelerados) {
		velocidadExtra += cantTicsAcelerados;
		velocidadExtra = Math.min(velocidadExtra, VELOCIDAD_INICIAL);
	}

	public void hacerInmortal() {
		esInmortal = true;
	}

	public void addTiempoPoder(int cantTics) {
		ticsRestantesPoder += cantTics;
	}

	public void hacerAsesinoDeEnemigos() {
		puedeMatarEnemigos = true;
	}

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

	@Override
	public void visit(PickUpPuntos p) {
		if (p.colisionaConEntidadEnPosicion(x, y)) {
			Escenario.getInstancia().eliminarPickUp(p);
		}
	}

	@Override
	public void visit(PickUpPoder p) {
		if (p.colisionaConEntidadEnPosicion(x, y)) {
			p.aplicarPoder(this);
			Escenario.getInstancia().eliminarPickUp(p);
		}
	}

	@Override
	public void visit(Enemigo e) {
		if (e.colisionaConEntidadEnPosicion(x, y)) {
			if (puedeMatarEnemigos) {
				e.morir();
			} else if (!esInmortal) {
				morir();
			}
		}
	}

	@Override
	public String toString() {
		return "Personaje: <" + super.toString() + ">";
	}

	public void resetVidas() {
		vidas = Escenario.CANTIDAD_INICIAL_DE_VIDAS;
		estaVivo = true;
	}

	public boolean puedeComerEnemigos() {
		return puedeMatarEnemigos;
	}

	public boolean esPoderoso() {
		return ticsRestantesPoder > 0;
	}

}