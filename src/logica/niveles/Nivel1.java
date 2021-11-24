package logica.niveles;

public class Nivel1 extends Nivel {

	public Nivel1() {
		super(1);
	}

	public Nivel getSiguienteNivel() {
		return new Nivel2();
	}

	@Override
	public String toString() {
		return "Nivel 1";
	}
}
