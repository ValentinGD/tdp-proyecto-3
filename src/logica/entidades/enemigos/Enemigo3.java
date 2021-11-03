package logica.entidades.enemigos;

import java.util.ArrayList;

import logica.Posicion;

public class Enemigo3 extends Enemigo {

	private static Enemigo3 instancia = null;
	
	private Enemigo3() {
		velocidad=1;
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
	public ArrayList<Posicion> mover() {
		// TODO Auto-generated method stub
		return null;
	}

}
