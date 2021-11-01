package proyecto3;

public class Enemigo1 extends Enemigo {

	private Enemigo1() {
		velocidad=1;
	}

	@Override
	public Enemigo getInstancia() {
		if(instancia==null)
			instancia=new Enemigo1();
		
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
