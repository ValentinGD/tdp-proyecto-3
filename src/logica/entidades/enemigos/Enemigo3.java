package logica.entidades.enemigos;

public class Enemigo3 extends Enemigo {

	@Override
	public Enemigo getInstancia() {
		if(instancia==null)
			instancia=new Enemigo3();
		
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
