package logica.entidades.enemigos;

import app.App;
import logica.estados.enemigos.PersiguiendoEnemigo4;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo4 extends Enemigo {

	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo4"));

	public Enemigo4() {
		super(new PersiguiendoEnemigo4());
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	@Override
	public void reset() {
		super.reset();
		estado = new PersiguiendoEnemigo4();
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion
				.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo4()));
		return miRepresentacion;
	}

	@Override
	public String toString() {
		return "Enemigo4: <" + super.toString() + ">";
	}

}