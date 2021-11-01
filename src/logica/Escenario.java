package logica;

import logica.entidades.Personaje;
import logica.niveles.Nivel;

public class Escenario {

	private Zona zona[];
	private int cantPickUps;
	private static final int cantZona=0;
	private static Nivel nivel;
	
	public Escenario(Zona z[], int cpu, Nivel n) {
		zona=new Zona[cantZona];
		for(int i=0;i<z.length;i++) {
			zona[i]=z[i];
		}
		nivel=n;
		setCantPickUps(cpu);
	}

	public int getCantPickUps() {
		return cantPickUps;
	}

	public void setCantPickUps(int cantPickUps) {
		this.cantPickUps = cantPickUps;
	}
	
	public void eliminarPickUp(Posicion p) {
		if(p.HayPickUp())
			p.setHayPickUp(null);
	}
	
	public static boolean puedeMover(Posicion p) {
		return nivel.getPosicionGrilla(p.getFila(), p.getColum()).isHabitable();
	}
}
