package logica.entidades;

import java.util.List;

import app.App;
import logica.Escenario;
import logica.Visitor;
import logica.Zona;
import logica.estados.personaje.EstadoPersonaje;
import logica.estados.personaje.EstadoPersonajeNormal;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.puntos.*;

public class Personaje extends Movible {
	
	private static Personaje instancia;
	
	protected EstadoPersonaje estado;
	
	private int vidas;
	private int direccionSiguiente;
	
	private boolean direccionActualizada;
	
	private Personaje() {
		super(0, 0);
		vidas = Integer.parseInt(App.configuration.getProperty("CantVidas"));
		direccionActual = Movible.DIRECCION_DERECHA;
		direccionSiguiente = direccionActual;
		direccionActualizada = true;
		estado = new EstadoPersonajeNormal(this, direccionActual);
	}

	public static Personaje getInstancia() {
		if (instancia == null) {
			instancia = new Personaje();
		}
		
		return instancia;
	}

	public void setDireccion(int direccion) {
		if (Movible.esDireccionValida(direccion) && direccionActualizada && (direccion != direccionActual)) {
			direccionSiguiente = direccion;
			direccionActualizada = false;
			//System.out.println("Personaje::Se cambio la direccion: " + direccionSiguiente);
		} else {
			//System.out.println("Personaje::No se puede cambiar de direccion");
		}
	}
	
	public void mover() {
		estado.mover();
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
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
	
	public void setDireccionActual(int direccion) {
		if (Movible.esDireccionValida(direccion)) {
			direccionActual = direccion;
		}
	}
	
	public void actualizarDireccion() {
		direccionActual = direccionSiguiente;
		direccionActualizada = true;
	}
	
	public void comerPickUp() {
		Zona zona = getZona();
		List<Entidad> entidades = zona.getEntidades();
		for (Entidad e : entidades) {
			e.aceptar(this);
		}
	}
	
	public void visitarPickUpPuntos(PickUpPuntos p) {
		if(this.getX()==p.getX() && this.getY()==p.getY()) {
			Escenario.getInstancia().eliminarPickUp(p);
		}
	}
	public void visitarPickUpPoder(PickUpPoder p) {
		p.aplicarPoder(this);
		if(this.getX()==p.getX() && this.getY()==p.getY()) {
			Escenario.getInstancia().eliminarPickUp(p);
		}
	}

	public void setPosicion(int xDestino, int yDestino) {
		x = xDestino;
		y = yDestino;
	}
}
