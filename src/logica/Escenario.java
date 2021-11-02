package logica;

import logica.entidades.Personaje;
import logica.entidades.enemigos.Enemigo;
import logica.niveles.Nivel;

public class Escenario {

	private Zona zona[];
	private int cantPickUps;
	private static final int cantZona=0;
	private static Nivel nivel;
	private static Enemigo e1,e2,e3,e4;
	private static Personaje pj;
	
	public Escenario(Zona z[], int cpu, Nivel n) {
		zona=new Zona[cantZona];
		for(int i=0;i<z.length;i++) {
			zona[i]=z[i];
			pj.getInstancia();
			e1.getInstancia();
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
	
	public static void eliminarPickUp(Posicion p) {
		if(p.HayPickUp())
			p.setHayPickUp(null);
	}
	
	public static void moverPersonaje(int direccion) {
		pj.mover(direccion);
	}
	
	public static boolean puedeMover(Posicion p) {
		return nivel.getPosicionGrilla(p.getFila(), p.getColum()).isHabitable();
	}
	
	public static boolean puedeMoverEnemigo(Posicion p) {
		return nivel.getPosicionGrilla(p.getFila(), p.getColum()).isHabitableEnemigo();
	}
	
	public static void posEnemigo1(Posicion p) {
		e1.setPosicion(p.getFila(), p.getColum());
	}
	public static void posEnemigo2(Posicion p) {
		e2.setPosicion(p.getFila(), p.getColum());
	}
	public static void posEnemigo3(Posicion p) {
		e3.setPosicion(p.getFila(), p.getColum());
	}
	public static void posEnemigo4(Posicion p) {
		e4.setPosicion(p.getFila(), p.getColum());
	}
	public static void posPersonaje(Posicion p) {
		pj.setPosicion(p.getFila(), p.getColum());
	}
}
