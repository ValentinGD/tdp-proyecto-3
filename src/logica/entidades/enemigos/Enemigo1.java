package logica.entidades.enemigos;

import app.App;
import logica.estados.enemigos.PersiguiendoEnemigo1;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo1 extends Enemigo {
	
	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo1"));
	
	public Enemigo1() {
		super(new PersiguiendoEnemigo1());
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
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

	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo1()));
		return miRepresentacion;
	}
	
	@Override
	public String toString() {
		return "Enemigo1: <" + super.toString() + ">";
	}

}