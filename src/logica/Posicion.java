package logica;

import javax.swing.ImageIcon;

import logica.entidades.Personaje;
import logica.entidades.PickUp;
import logica.entidades.enemigos.Enemigo;
import vista.RepositorioGrafico;

public class Posicion {
	
	private int fila;
	private int columna;
	private boolean esHabitable;
	private PickUp pickUp;
	private int codeZona;
	private boolean esHabitableEnemigo;
	private Enemigo enemigo;
	private Personaje personaje;
	
	public Posicion(int fila, int columna, Enemigo enemigo) {
		this(fila, columna, true, true, null, 0, null, enemigo);
	}
	
	public Posicion(int fila, int columna, Personaje personaje) {
		this(fila, columna, true, true, null, 0, personaje, null);
	}
	
	public Posicion(int fila, int colum, boolean habitable, PickUp pu, int cz) {
		this(fila, colum, habitable, false, pu, cz, null, null);
	}
	public Posicion(int fila, int colum, boolean habitable,boolean habitableEnemigo, PickUp pu) {
		this(fila, colum, habitable, habitableEnemigo, pu, 0, null, null);
	}
	
	public Posicion(int fila, int columna, boolean esHabitable, boolean esHabitableEnemigo, PickUp pickUp, int codeZona, Personaje personaje, Enemigo enemigo) {
		this.fila = fila;
		this.columna = columna;
		this.esHabitable = esHabitable;
		this.esHabitableEnemigo = esHabitableEnemigo;
		this.pickUp = pickUp;
		this.codeZona = codeZona;
		this.personaje = personaje;
		this.enemigo = enemigo;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int celda) {
		this.fila = celda;
	}

	public int getColum() {
		return columna;
	}

	public void setColum(int colum) {
		this.columna = colum;
	}

	public boolean isHabitable() {
		return esHabitable;
	}

	public void setHabitable(boolean habitable) {
		this.esHabitable = habitable;
	}

	public boolean HayPickUp() {
		return pickUp!=null;
	}

	public void setHayPickUp(PickUp pu) {
		this.pickUp = pu;
	}
	
	public PickUp getPickUp() {
		return pickUp;
	}

	public int getCodeZona() {
		return codeZona;
	}

	public void setCodeZona(int codeZona) {
		this.codeZona = codeZona;
	}
	
	public Posicion clone() {
		return new Posicion(fila,columna,esHabitable,pickUp,codeZona);
	}
	public boolean isHabitableEnemigo() {
		return esHabitableEnemigo;
	}
	public void setHabitableEnemigo(boolean habitableEnemigo) {
		this.esHabitableEnemigo = habitableEnemigo;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		ImageIcon representacion = RepositorioGrafico.getFondo();
		
		if (personaje != null) {
			representacion = RepositorioGrafico.getPersonaje();
		} else if (enemigo != null) {
			representacion = enemigo.getRepresentacionGrafica();
		} else if (pickUp != null) {
			representacion = pickUp.getRepresentacionGrafica();
		} else if (!esHabitable && esHabitableEnemigo) {
			representacion = RepositorioGrafico.getParedEnemigo();
		} else if(!esHabitable && !esHabitableEnemigo) {
			representacion = RepositorioGrafico.getPared();
		}
		
		return representacion;
	}
}
