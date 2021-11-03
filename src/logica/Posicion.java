package logica;

import javax.swing.ImageIcon;

import logica.entidades.Personaje;
import logica.entidades.PickUp;
import logica.entidades.enemigos.Enemigo;
import vista.PosicionGrafica;
import vista.RepositorioGrafico;

public class Posicion implements PosicionGrafica {
	
	private int y;
	private int x;
	private boolean esHabitable;
	private PickUp pickUp;
	private int codeZona;
	private boolean esHabitableEnemigo;
	private Enemigo enemigo;
	private Personaje personaje;
	
	public Posicion(int fila, int columna) {
		this(fila, columna, false, false, null, 0, null, null);
	}
	
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
		this.y = fila;
		this.x = columna;
		this.esHabitable = esHabitable;
		this.esHabitableEnemigo = esHabitableEnemigo;
		this.pickUp = pickUp;
		this.codeZona = codeZona;
		this.personaje = personaje;
		this.enemigo = enemigo;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public boolean esHabitable() {
		return esHabitable;
	}

	public void setHabitable(boolean habitable) {
		this.esHabitable = habitable;
	}

	public boolean hayPickUp() {
		return pickUp!=null;
	}

	public void setPickUp(PickUp pu) {
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
	
	public Enemigo getEnemigo() {
		return enemigo;
	}

	public void setEnemigo(Enemigo enemigo) {
		this.enemigo = enemigo;
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public Posicion clone() {
		return new Posicion(y,x,esHabitable,pickUp,codeZona);
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
	
	public String toString() {
		return "<x: " + x + ", y: " + y + ", Personaje: " + personaje + ", enemigo: " + enemigo + ", pickup: " + pickUp + ", habitable: " + esHabitable + ", habitableEnemigo: " + esHabitableEnemigo + ", codigoZona: " + codeZona + ">";
	}
}
