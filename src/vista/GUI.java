package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import logica.Juego;
import logica.entidades.Movible;
import vista.repositorioGrafico.figuras.RepositorioGraficoFiguras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
	
	private MenuPanel menuPanel;
	private JuegoPanel juegoPanel;
	
	private Juego juego;
	
	public GUI(Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("TdP-man");
		this.juego = juego;
		
		menuPanel = new MenuPanel(this);
		
		juegoPanel = new JuegoPanel(new RepositorioGraficoFiguras());
		juegoPanel.setFocusable(true);
		juegoPanel.addKeyListener(new GUIKeyListener());
		System.out.println("se creo el panel de juego");
		
		setPanel(menuPanel);
		setFocusable(true);
	}
	
	private void setPanel(JPanel panel) {
		setContentPane(panel);
		pack();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setFocusable(true);
	}
	
	public void showMenu() {
		setPanel(menuPanel);
	}
	
	public void showGameOver() {
		setPanel(new GameOverPanel(juego.getPuntajeString()));
	}
	
	public void showJuego() {
		setPanel(juegoPanel);
		juegoPanel.requestFocus();
	}

	public void setDimensionEscenario(int alto, int ancho) {
		juegoPanel.setDimensiones(alto, ancho);
	}	

	public void agregarEntidades(List<EntidadGrafica> entidades) {
		juegoPanel.agregarEntidades(entidades);
	}
	
	public void actualizarVidas(int cantVidas) {
		juegoPanel.actualizarVidas(cantVidas);
	}

	public void actualizarEntidades(List<EntidadGrafica> entidades) {
		juegoPanel.actualizarEntidades(entidades);
	}
	
	public void actualizarPuntaje(int puntaje) {
		juegoPanel.actualizarPuntaje(puntaje);
	}

	public void limpiarJuego() {
		juegoPanel.limpiar();
	}
	
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch (command) {
		case "comenzar":
			juego.start();
			break;
		default:
			break;
		}
	}
	
	private class GUIKeyListener extends KeyAdapter {
		
		private static final int ARRIBA = KeyEvent.VK_UP;
		private static final int ABAJO = KeyEvent.VK_DOWN;
		private static final int IZQUIERDA = KeyEvent.VK_LEFT;
		private static final int DERECHA = KeyEvent.VK_RIGHT;
		
		@Override
		public void keyTyped(KeyEvent e) {
			super.keyTyped(e);
			//System.out.println("keyTyped");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			super.keyReleased(e);
			//System.out.println("keyReleased");
		}
		
		public void keyPressed(KeyEvent e) {
			System.out.println("se apreto una tecla");
			switch (e.getKeyCode()) {
			case ARRIBA:
				juego.teclaPresionada(Movible.DIRECCION_ARRIBA);
				break;
			case ABAJO:
				juego.teclaPresionada(Movible.DIRECCION_ABAJO);
				break;
			case IZQUIERDA:
				juego.teclaPresionada(Movible.DIRECCION_IZQUIERDA);
				break;
			case DERECHA:
				juego.teclaPresionada(Movible.DIRECCION_DERECHA);
				break;
			default:
				break;
			}
		}
	}

}