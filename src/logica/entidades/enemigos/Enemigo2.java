package logica.entidades.enemigos;

import java.util.ArrayList;

import logica.Posicion;

public class Enemigo2 extends Enemigo {
	
	private static Enemigo2 instancia = null;

	private Enemigo2() {
		velocidad=1;
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
	public ArrayList<Posicion> mover() {
		return new ArrayList<Posicion>();
	}

}
