package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import logica.Juego;
import logica.Posicion;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JFrame implements ActionListener {
	
	private MenuPanel menuPanel;
	private JuegoPanel juegoPanel;
	private static final int UP = KeyEvent.VK_UP;
	private static final int LEFT = KeyEvent.VK_LEFT;
	private static final int RIGHT = KeyEvent.VK_RIGHT;
	private static final int DOWN = KeyEvent.VK_DOWN;
	
	private Juego juego;
	
	public GUI(Juego juego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.juego = juego;
		
		menuPanel = new MenuPanel(this);
		setPanel(menuPanel);
	
	}
	
	private void setPanel(JPanel panel) {
		setContentPane(panel);
		pack();
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void showMenu() {
		setPanel(menuPanel);
	}
	
	public void showJuego(Posicion[][] posiciones) {
		juegoPanel = new JuegoPanel(posiciones);
		setPanel(juegoPanel);
	}

	@Override
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
	private class OyenteTecla extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("OyenteTecla::keyPressed");
			switch(e.getKeyCode()) {
			case UP:
				juego.teclaPresionada(0);
				break;
			case LEFT:
				juego.teclaPresionada(1);
				break;
			case RIGHT:
				juego.teclaPresionada(3);
				break;
			case DOWN:
				juego.teclaPresionada(2);
				break;
			default:
				break;
			};
		}
	}
}
