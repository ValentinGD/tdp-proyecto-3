package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class GameOverPanel extends JPanel {
	
	public GameOverPanel(String puntaje, ActionListener gui) {
		setLayout(new BorderLayout(0, 0));
		
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
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblGameOver = new JLabel("Game Over");
		panel_1.add(lblGameOver);
		lblGameOver.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblGameOver.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Volver al Menu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(gui);
		
		btnNewButton.setActionCommand("Volver Menu");
		panel_1.add(btnNewButton, BorderLayout.SOUTH);
	}
	
}