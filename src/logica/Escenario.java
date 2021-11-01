package logica;

import logica.entidades.Personaje;
import logica.niveles.Nivel;

public class Escenario implements Suscriptor {

	private Zona zona[];
	private int cantPickUps;
	private static final int cantZona=0;
	private static Nivel nivel;
	private Personaje pj;
	private int puntaje;
	
	public Escenario(Zona z[], int cpu, Nivel n) {
		zona=new Zona[cantZona];
		for(int i=0;i<z.length;i++) {
			zona[i]=z[i];
		}
		nivel=n;
		setCantPickUps(cpu);
		puntaje=0;
	}

	public int getCantPickUps() {
		return cantPickUps;
	}

	public void setCantPickUps(int cantPickUps) {
		this.cantPickUps = cantPickUps;
	}
	
	public void eliminarPickUp(Posicion p) {
		if(p.HayPickUp())
			p.setPickUp(null);
	}
	
	public static boolean puedeMover(Posicion p) {
		return nivel.getPosicionGrilla(p.getFila(), p.getColum()).isHabitable();
	}

	public void actualizar() {
		// TODO Auto-generated method stub
		
	}
	
	public void levantarPickUp() {
		int filaPJ= pj.getPosicion().getFila();
		int columPJ=pj.getPosicion().getColum();
		int tipoPU=nivel.getPosicionGrilla(filaPJ, columPJ).getPickUp().getTipoPickUp();
		int puntosPU=nivel.getPosicionGrilla(filaPJ, columPJ).getPickUp().getPuntos();
		switch(tipoPU) {
			case 0:
				sumarPuntos(puntosPU);
			break;
			case 1:
				sumarPuntos(puntosPU);
			break;
			case 2:
				pj.setVidas(pj.getVidas()+1);
				sumarPuntos(puntosPU);
			break;
			case 3:
				//Lo que haga el poder
				sumarPuntos(puntosPU);
			break;
		}
		eliminarPickUp(nivel.getPosicionGrilla(filaPJ, columPJ));
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public void sumarPuntos(int p) {
		puntaje=+p;
	}
}
