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

public class GUI extends JFrame implements ActionListener {
	
	private MenuPanel menuPanel;
	private JuegoPanel juegoPanel;
	
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
	
}
