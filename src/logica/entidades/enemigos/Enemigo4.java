package logica.entidades.enemigos;

public class Enemigo4 extends Enemigo {

	private static Enemigo4 instancia = null;
	
	private Enemigo4() {
		velocidad=1;
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

}
