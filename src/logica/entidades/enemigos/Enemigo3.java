package logica.entidades.enemigos;

import java.util.ArrayList;

import app.App;
import logica.Escenario;
import logica.Visitor;
import logica.estados.enemigos.PersiguiendoEnemigo1;
import logica.estados.enemigos.PersiguiendoEnemigo2;
import logica.estados.enemigos.PersiguiendoEnemigo3;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo3 extends Enemigo {

	private static final int VELOCIDAD_INICIAL = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo3"));
	private static Enemigo3 instancia = null;
	
	private Enemigo3() {
		super(new PersiguiendoEnemigo3());
		estado.setEnemigo(this);
		velocidadEnTics = VELOCIDAD_INICIAL;
	}

	public static Enemigo3 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo3();
		}
		return instancia;
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
		// TODO Auto-generated method stub
		return "Enemigo3: <" + super.toString() + ">";
	}

	@Override
	public void perseguir() {
		// TODO Auto-generated method stub
		
	}
}
