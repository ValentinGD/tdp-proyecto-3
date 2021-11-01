package proyecto3;

public interface Notificadora {

	public void suscribirse(Suscriptor s);
	public void desuscribirse(Suscriptor s);
	public void notificar();
}
