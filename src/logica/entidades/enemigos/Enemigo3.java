package logica.entidades.enemigos;

import java.util.ArrayList;

import app.App;
import logica.Visitor;
import logica.estados.enemigos.PersiguiendoEnemigo2;
import logica.estados.enemigos.PersiguiendoEnemigo3;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo3 extends Enemigo {

	private static Enemigo3 instancia = null;
	
	private Enemigo3() {
		super(new PersiguiendoEnemigo3());
		estado.setEnemigo(this);
		velocidad = Integer.parseInt(App.configuration.getProperty("VelocidadEnemigo3"));;
	}

	public static Enemigo3 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo3();
		}
		return instancia;
	}

	@Override
	public void perseguir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void descansar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asustarse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo4()));
		return miRepresentacion;
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
