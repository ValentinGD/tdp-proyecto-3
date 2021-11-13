package logica.entidades.enemigos;

import java.util.ArrayList;

import app.App;
import logica.Posicion;

public class Enemigo4 extends Enemigo {

	private static Enemigo4 instancia = null;
	
	private Enemigo4() {
		velocidad = Integer.parseInt(App.configuration.getProperty("VelocidadEnemigo1"));;
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
	public ArrayList<Posicion> mover() {
		return new ArrayList<Posicion>();
	}

}
