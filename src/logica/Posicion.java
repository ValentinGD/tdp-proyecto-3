package logica;

import logica.entidades.PickUp;

public class Posicion {
	
	private int fila;
	private int colum;
	private boolean habitable;
	private PickUp pickUp;
	private int codeZona;
	private boolean habitableEnemigo;
	
	public Posicion(int fila, int colum, boolean habitable, PickUp pu, int cz) {
		this.setFila(fila);
		this.setColum(colum);
		this.setHabitable(habitable);
		this.setHayPickUp(pu);
		this.setCodeZona(cz);
	}
	public Posicion(int fila, int colum, boolean habitable,boolean habitableEnemigo, PickUp pu) {
		this.setFila(fila);
		this.setColum(colum);
		this.setHabitable(habitable);
		this.setHayPickUp(pu);
		this.setHabitableEnemigo(habitableEnemigo);}

	public int getFila() {
		return fila;
	}

	public void setFila(int celda) {
		this.fila = celda;
	}

	public int getColum() {
		return colum;
	}

	public void setColum(int colum) {
		this.colum = colum;
	}

	public boolean isHabitable() {
		return habitable;
	}

	public void setHabitable(boolean habitable) {
		this.habitable = habitable;
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
		return new Posicion(fila,colum,habitable,pickUp,codeZona);
	}
	public boolean isHabitableEnemigo() {
		return habitableEnemigo;
	}
	public void setHabitableEnemigo(boolean habitableEnemigo) {
		this.habitableEnemigo = habitableEnemigo;
	}
	
}
