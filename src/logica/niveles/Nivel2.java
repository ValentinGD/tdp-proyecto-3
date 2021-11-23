package logica.niveles;

public class Nivel2 extends Nivel {

	public Nivel2() {
		super(2);
	}
	
	public Nivel getSiguienteNivel() {
		return new Nivel3();
	}

	@Override
	public String toString() {
		return "Nivel 2";
	}
}
