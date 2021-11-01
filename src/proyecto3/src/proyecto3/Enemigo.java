package proyecto3;

public abstract class Enemigo extends Movible implements Notificadora {
	protected int velocidad;
	protected int tiempoDescanso;
	protected Enemigo instancia;
	protected EstadoEnemigo estado;
	protected Suscriptor listaSuscriptores[];
	protected int cantSuscriptores;
	
	protected Enemigo() {
		velocidad=1;
		cantSuscriptores=0;
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

	@Override
	public void suscribirse(Suscriptor s) {
		listaSuscriptores[cantSuscriptores]=s;
	}

	@Override
	public void desuscribirse(Suscriptor s) {
		for(int i=0;i<listaSuscriptores.length;i++) {
			if(listaSuscriptores[i]==s) {
				listaSuscriptores[i]=null;
				cantSuscriptores=0;
			}
		}
	}

	@Override
	public void notificar() {
		for(int i=0;i<listaSuscriptores.length;i++)
			listaSuscriptores[i].actualizar();
	}
}
