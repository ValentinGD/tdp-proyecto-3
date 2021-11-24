package logica.entidades.enemigos;

import java.util.ArrayList;

import app.App;
import logica.Escenario;
import logica.Visitor;
import logica.estados.enemigos.PersiguiendoEnemigo1;
import logica.estados.enemigos.PersiguiendoEnemigo2;
import logica.estados.enemigos.PersiguiendoEnemigo4;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo4 extends Enemigo {

	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo4"));
	private static Enemigo4 instancia = null;
	
	private Enemigo4() {
		super(new PersiguiendoEnemigo4());
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	public static Enemigo4 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo4();
		}
		return instancia;
	}
	
	@Override
	public void reset() {
		super.reset();
		estado = new PersiguiendoEnemigo4();
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	@Override
	public void perseguir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo4()));
		return miRepresentacion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Enemigo4: <" + super.toString() + ">";
	}

}
