package logica.entidades.enemigos;

import app.App;
import logica.Visitor;
import logica.estados.enemigos.PersiguiendoEnemigo1;
import logica.estados.enemigos.PersiguiendoEnemigo2;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo2 extends Enemigo {
	
	private static Enemigo2 instancia = null;

	private Enemigo2() {
		super(new PersiguiendoEnemigo2());
		estado.setEnemigo(this);
		velocidad = Integer.parseInt(App.configuration.getProperty("VelocidadEnemigo2"));
	}

	public static Enemigo2 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo2();
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
		estado.mover();
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
