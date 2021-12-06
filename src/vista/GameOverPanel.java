package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/*
 * Generación de la GUI que se muestra cuando se pierde el juego.
 * Se da la opción de volver al inicio para jugar otra vez, o salir.
 */

@SuppressWarnings("serial")
public class GameOverPanel extends JPanel {

	public GameOverPanel(String puntaje, ActionListener gui) {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_label_botones = new JPanel();
		panel_label_botones.setBackground(new Color(252, 58, 58));
		panel_label_botones.setBorder(
				new CompoundBorder(new LineBorder(new Color(255, 200, 0), 5), new EmptyBorder(10, 10, 10, 10)));
		panel_label_botones.setLayout(new BoxLayout(panel_label_botones, BoxLayout.Y_AXIS));
		add(panel_label_botones, BorderLayout.CENTER);

		JLabel lblGameOver = new JLabel("\u00A1 Game Over !");
		lblGameOver.setBorder(new EmptyBorder(20, 0, 20, 0));
		lblGameOver.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblGameOver.setFont(new Font("Arial Black", Font.BOLD, 45));
		lblGameOver.setHorizontalTextPosition(SwingConstants.CENTER);
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		panel_label_botones.add(lblGameOver);

		JPanel panel_botones = new JPanel();
		panel_botones.setBorder(new EmptyBorder(20, 0, 0, 0));
		FlowLayout flowLayout = (FlowLayout) panel_botones.getLayout();
		flowLayout.setHgap(20);
		panel_botones.setOpaque(false);
		panel_label_botones.add(panel_botones);

		JButton btnReiniciar = new JButton("Volver al men\u00FA");
		btnReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnReiniciar.setMnemonic('m');
		btnReiniciar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReiniciar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new EmptyBorder(7, 15, 7, 15)));
		btnReiniciar.addActionListener(gui);
		btnReiniciar.setActionCommand("Volver Menu");
		panel_botones.add(btnReiniciar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setMnemonic('s');
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalir.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new EmptyBorder(7, 15, 7, 15)));
		btnSalir.setAlignmentX(0.5f);
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_botones.add(btnSalir);

		JPanel panel_con_puntaje = new JPanel();
		panel_con_puntaje.setBackground(Color.BLACK);
		panel_con_puntaje.setBorder(new EmptyBorder(10, 15, 10, 15));
		panel_con_puntaje.setLayout(new BorderLayout(0, 5));
		add(panel_con_puntaje, BorderLayout.SOUTH);

		JLabel lblMensaje = new JLabel("Gracias por jugar con nosotros!");
		lblMensaje.setOpaque(true);
		lblMensaje.setForeground(Color.WHITE);
		lblMensaje.setBackground(Color.BLACK);
		lblMensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMensaje.setFont(new Font("Consolas", Font.PLAIN, 20));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		panel_con_puntaje.add(lblMensaje, BorderLayout.NORTH);

		JLabel lblPuntaje = new JLabel("Su puntaje es: " + puntaje);
		lblPuntaje.setOpaque(true);
		lblPuntaje.setBackground(Color.BLACK);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setFont(new Font("Consolas", Font.PLAIN, 20));
		panel_con_puntaje.add(lblPuntaje, BorderLayout.SOUTH);
	}

}