package vista;

import javax.swing.JPanel;

import logica.Posicion;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Font;

@SuppressWarnings("serial")
public class JuegoPanel extends JPanel {
	
	private JLabel [][] labels;
	
	private int alto, ancho;
	
	/**
	 * Create the panel.
	 */
	public JuegoPanel(PosicionGrafica[][] posiciones) {
		alto = posiciones.length;
		ancho = posiciones[0].length;
		
		labels = new JLabel[alto][ancho];
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		panel.setLayout(gbl_panel);
		
		for (int y = 0; y < alto; ++y) {
			for (int x = 0; x < ancho; ++x) {
				//System.out.println(posiciones[y][x]);
				JLabel lblNewLabel = new JLabel(posiciones[y][x].getRepresentacionGrafica());
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridx = x;
				gbc_lblNewLabel.gridy = y;
				panel.add(lblNewLabel, gbc_lblNewLabel);

				labels[y][x] = lblNewLabel;
			}
		}
		
		
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblPuntaje = new GridBagConstraints();
		gbc_lblPuntaje.insets = new Insets(10, 10, 10, 10);
		gbc_lblPuntaje.gridx = 0;
		gbc_lblPuntaje.gridy = 0;
		panel_1.add(lblPuntaje, gbc_lblPuntaje);

	}
	
	public void actualizarGraficos(ArrayList<PosicionGrafica> posiciones) {
		for (PosicionGrafica p : posiciones) {
			JLabel label = labels[p.getY()][p.getX()];
			label.setIcon(p.getRepresentacionGrafica());
			label.repaint();
		}
	}

}
