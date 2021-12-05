package logica.entidades.enemigos;

import app.App;
import logica.estados.enemigos.PersiguiendoEnemigo2;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo2 extends Enemigo {
	
	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo2"));
	
	private final Enemigo1 enemigo1;
	
	public Enemigo2(Enemigo1 enemigo1) {
		super(new PersiguiendoEnemigo2(enemigo1));
		this.enemigo1 = enemigo1;
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}
	
	@Override
	public void reset() {
		super.reset();
		estado = new PersiguiendoEnemigo2(enemigo1);
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}


	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo2()));
		return miRepresentacion;
	}
	
	@Override
	public String toString() {
		return "Enemigo2: <" + super.toString() + ">";
	}

}