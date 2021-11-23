package logica.entidades.enemigos;

import java.util.ArrayList;

import app.App;
import logica.Visitor;
import logica.estados.enemigos.PersiguiendoEnemigo2;
import logica.estados.enemigos.PersiguiendoEnemigo4;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

public class Enemigo4 extends Enemigo {

	private static Enemigo4 instancia = null;
	
	private Enemigo4() {
		super(new PersiguiendoEnemigo4());
		estado.setEnemigo(this);
		velocidadEnTics = Integer.parseInt(App.configuration.getProperty("VelocidadTicsEnemigo4"));;
	}

	public static Enemigo4 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo4();
		}
		return instancia;
	}

	@Override
	public void perseguir() {
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
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
