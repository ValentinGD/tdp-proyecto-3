package logica.niveles;

public class Nivel3 extends Nivel {

	public Nivel3() {
		super(3);
	}

	@Override
	public Nivel getSiguienteNivel() {
		return null;
	}

	@Override
	public String toString() {
		return "Nivel 3";
	}

}