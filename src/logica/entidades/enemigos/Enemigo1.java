package logica.entidades.enemigos;

import java.util.ArrayList;

import logica.Posicion;

public class Enemigo1 extends Enemigo {
	
	private static Enemigo1 instancia = null;
	
	private Enemigo1() {
		velocidad=1;
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
	public ArrayList<Posicion> mover() {
		return new ArrayList<Posicion>();
	}

}
