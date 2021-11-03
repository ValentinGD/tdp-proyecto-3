package logica;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class Reloj implements Notificadora {
	
	private int tiempoEntreTics;
	private boolean running = false;
	private List<Suscriptor> suscriptores;
	private int cantSuscriptores;
	
	//private long tiempoDeInicio;
	
	public Reloj(int tiempo) {
		tiempoEntreTics = tiempo;
		suscriptores=new ArrayList<Suscriptor>();
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
	
	@Override
	public void suscribirse(Suscriptor s) {
		if (suscriptores.contains(s)) { 
			suscriptores.add(s);
		}
	}

	@Override
	public void desuscribirse(Suscriptor s) {
		suscriptores.remove(s);
		
	}

	@Override
	public void notificar() {
		for (Suscriptor s : suscriptores) {
			s.actualizar();
		}
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

	
}