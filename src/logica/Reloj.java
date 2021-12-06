package logica;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

public class Reloj implements Notificadora {

	private int tiempoEntreTics;
	private boolean running = false;
	private List<Suscriptor> suscriptores;

	private HiloDormilon t;

	public Reloj(int tiempo) {
		tiempoEntreTics = tiempo;
		suscriptores = new ArrayList<Suscriptor>();
	}

	public boolean isRunning() {
		return running;
	}

	public void start() {
		running = true;
		t = new HiloDormilon(tiempoEntreTics, this);
		t.start();
	}

	public int getTiempoEntreTics() {
		return tiempoEntreTics;
	}

	public void setTiempoEntreTics(int tiempoEntreTics) {
		this.tiempoEntreTics = tiempoEntreTics;
	}

	public void stop() throws InterruptedException {
		running = false;
		t.abortar();
		t.join();
	}

	@Override
	public void suscribirse(Suscriptor s) {
		if (!suscriptores.contains(s)) {
			suscriptores.add(s);
		}
	}

	@Override
	public void desuscribirse(Suscriptor s) {
		suscriptores.remove(s);
	}

	protected void notificar() {
		if (running) {
			for (Suscriptor s : suscriptores) {
				EventQueue.invokeLater(new Runnable() {
					@Override
					public void run() {
						s.actualizar();
					}
				});
			}
			start();
		}
	}

	private class HiloDormilon extends Thread {

		private int tiempoParaDormir;
		private Reloj reloj;
		private boolean abortado;

		public HiloDormilon(int tiempoParaDormir, Reloj reloj) {
			this.tiempoParaDormir = tiempoParaDormir;
			this.reloj = reloj;
			abortado = false;
		}

		@Override
		public void run() {
			try {
				sleep(tiempoParaDormir);
				if (!abortado) {
					reloj.notificar();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void abortar() {
			abortado = true;
		}
	}

}