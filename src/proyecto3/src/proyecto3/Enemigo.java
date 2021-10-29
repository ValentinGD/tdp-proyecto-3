package proyecto3;

public abstract class Enemigo extends Movible {
protected int velocidad;
protected int tiempoDescanso;
protected Enemigo instancia;
protected EstadoEnemigo estado;

protected Enemigo() {
	velocidad=1;
}

public int getVelocidad() {
	return velocidad;
}

public void setVelocidad(int velociadad) {
	this.velocidad = velociadad;
}

public int getTiempoDescanso() {
	return tiempoDescanso;
}

public void setTiempoDescanso(int tiempoDescanso) {
	this.tiempoDescanso = tiempoDescanso;
}

public abstract Enemigo getInstancia() ;
public abstract void perseguir();
public abstract void descansar();
public abstract void morir();
public abstract void asustarse();

}