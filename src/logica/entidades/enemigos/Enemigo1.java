package logica.entidades.enemigos;

import app.App;
import logica.estados.enemigos.PersiguiendoEnemigo1;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo1 extends Enemigo {
	
	private static Enemigo1 instancia = null;
	
	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo1"));
	
	private Enemigo1() {
		super(new PersiguiendoEnemigo1());
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
		
	}

	public static Enemigo1 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo1();
		}
		return instancia;
	}
	
	@Override
	public void reset() {
		super.reset();
		estado = new PersiguiendoEnemigo1();
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	@Override
	public void perseguir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo1()));
		return miRepresentacion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Enemigo1: <" + super.toString() + ">";
	}

}
