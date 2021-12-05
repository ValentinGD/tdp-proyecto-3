package logica.entidades.enemigos;

import app.App;
import logica.estados.enemigos.PersiguiendoEnemigo3;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo3 extends Enemigo {

	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo3"));
	
	public Enemigo3() {
		super(new PersiguiendoEnemigo3());
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}
	
	@Override
	public void reset() {
		super.reset();
		estado = new PersiguiendoEnemigo3();
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo3()));
		return miRepresentacion;
	}
	
	@Override
	public String toString() {
		return "Enemigo3: <" + super.toString() + ">";
	}

	@Override
	public void perseguir() {

	}

}