package logica.entidades;

import javax.swing.ImageIcon;

import app.App;
import logica.Visitor;
import logica.estados.personaje.EstadoPersonaje;
import logica.estados.personaje.EstadoPersonajeNormal;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Personaje extends Movible {
	
	private static Personaje instancia;
	
	protected EstadoPersonaje estado;
	
	private int vidas;
	private int direccionSiguiente;
	
	private Personaje() {
		super(0, 0);
		vidas = Integer.parseInt(App.configuration.getProperty("CantVidas"));
		direccionActual = Movible.DIRECCION_DERECHA;
		direccionSiguiente = direccionActual;
		estado = new EstadoPersonajeNormal(this, direccionActual);
	}

	public static Personaje getInstancia() {
		if (instancia == null) {
			instancia = new Personaje();
		}
		
		return instancia;
	}

	public void setDireccion(int direccion) {
		if (Movible.esDireccionValida(direccion)) {
			direccionSiguiente = direccion;
			System.out.println("Personaje::Se cambio la direccion: " + direccionSiguiente);
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
	
	@Override
	public String toString() {
		return "toString::Personaje: " + super.toString() + ", estado: <" + estado + ">";
	}
}
