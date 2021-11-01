package logica;

public class Zona {
	
	private Posicion zona[];
	private static final int tamZona = 0;
	
	public Zona(Posicion z[]) {
		zona=new Posicion[tamZona];
		for(int i=0;i<z.length;i++) {
			zona[i]=z[i];
		}
	}
	
	public Posicion[] getZona() {
		return zona;
	}

	public void setZona(Posicion z[]) {
		for(int i=0;i<z.length;i++) {
			zona[i]=z[i];
		}
	}
	
}
