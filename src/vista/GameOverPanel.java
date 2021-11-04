package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GameOverPanel extends JPanel {
	public GameOverPanel(String puntaje) {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblGameOver.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblGameOver, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblMensaje = new JLabel("Gracias por jugar con nosotros!");
		panel.add(lblMensaje, BorderLayout.NORTH);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Su puntaje es: " + puntaje);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setName("lblPuntaje");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel, BorderLayout.SOUTH);
	}
	
}