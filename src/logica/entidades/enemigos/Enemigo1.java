package logica.entidades.enemigos;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import app.App;
import logica.Visitor;
import logica.entidades.Movible;
import logica.estados.enemigos.PersiguiendoEnemigo1;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public class Enemigo1 extends Enemigo {
	
	private static Enemigo1 instancia = null;
	
	private Enemigo1() {
		super(new PersiguiendoEnemigo1());
		estado.setEnemigo(this);
		velocidad = Integer.parseInt(App.configuration.getProperty("VelocidadEnemigo1"));;
	}

	public static Enemigo1 getInstancia() {
		if (instancia == null) {
			instancia = new Enemigo1();
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
		miRepresentacion.setImageIcon(estado.getRepresentacionGrafica(repositorioGrafico.getRepositorioGraficoEnemigo1()));
		return miRepresentacion;
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover() {
		estado.mover();
		
	}

}
