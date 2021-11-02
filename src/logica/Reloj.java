package logica;

import java.awt.EventQueue;

public class Reloj implements Notificadora {
	
	private int tiempoEntreTics;
	private boolean running = false;
	private Suscriptor suscriptores[];
	private int cantSuscriptores;
	
	//private long tiempoDeInicio;
	
	public Reloj(int tiempo) {
		tiempoEntreTics = tiempo;
		suscriptores=new Suscriptor[10];
		cantSuscriptores=0;
	}
	
	public void start() {
		running = true;
		Thread t = new HiloDormilon(tiempoEntreTics, this);
		t.start();
	}
	
	public int getTiempoEntreTics() {
		return tiempoEntreTics;
	}

	public void setTiempoEntreTics(int tiempoEntreTics) {
		this.tiempoEntreTics = tiempoEntreTics;
	}
	
	public void stop() {
		running = false;
	}
	
	private class HiloDormilon extends Thread {
		
		private int tiempoParaDormir;
		private Reloj reloj;
		
		public HiloDormilon(int tiempoParaDormir, Reloj reloj) {
			this.tiempoParaDormir = tiempoParaDormir;
			this.reloj = reloj;
		}
		
		@Override
		public void run() {
			try {
				sleep(tiempoParaDormir);
				reloj.notificar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void suscribirse(Suscriptor s) {
		suscriptores[cantSuscriptores]=s;
		cantSuscriptores++;
	}

	@Override
	public void desuscribirse(Suscriptor s) {
		for(int i=0;i<cantSuscriptores;i++) {
			if(suscriptores[i]==s) {
				suscriptores[i]=null;
				cantSuscriptores--;
			}
		}
		
	}

	@Override
	public void notificar() {
		for(int i=0;i<cantSuscriptores;i++) {
			suscriptores[i].actualizar();
		}	
	}
}