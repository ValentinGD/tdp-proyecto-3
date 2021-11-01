package proyecto3;

public class Enemigo2 extends Enemigo {

	@Override
	public Enemigo getInstancia() {
		if(instancia==null)
			instancia=new Enemigo2();
		
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
