package vista;

import javax.swing.JPanel;

import logica.Juego;
import logica.Posicion;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

@SuppressWarnings("serial")
public class JuegoPanel extends JPanel {
	
	private JLabel [][] labels;
	
	private JLabel lblPuntos;
	private JPanel panelGrilla;
	private JLabel lblCorazon_1;
	private JLabel lblCorazon_2;
	private JLabel lblCorazon_3;
	private JLabel lblCorazon_4;
	private JLabel lblCorazon_5;
	private JLabel lblCorazon_6;
	
	/**
	 * Create the panel.
	 */
	public JuegoPanel(PosicionGrafica[][] posiciones) {
		System.out.println("creando panel de juego");
		
		
		
		setLayout(new BorderLayout(0, 0));
		
		panelGrilla = new JPanel();
		add(panelGrilla, BorderLayout.CENTER);
		GridBagLayout gbl_panelGrilla = new GridBagLayout();
		panelGrilla.setLayout(gbl_panelGrilla);
		
		cargarPosiciones(posiciones);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblPuntaje = new GridBagConstraints();
		gbc_lblPuntaje.insets = new Insets(10, 10, 10, 10);
		gbc_lblPuntaje.gridx = 0;
		gbc_lblPuntaje.gridy = 0;
		panel_1.add(lblPuntaje, gbc_lblPuntaje);
		
		lblPuntos = new JLabel("0");
		GridBagConstraints gbc_lblPuntos = new GridBagConstraints();
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		gbc_lblPuntos.insets = new Insets(0, 0, 5, 0);
		gbc_lblPuntos.gridx = 0;
		gbc_lblPuntos.gridy = 1;
		panel_1.add(lblPuntos, gbc_lblPuntos);
		
		JPanel panelVidas = new JPanel();
		GridBagConstraints gbc_panelVidas = new GridBagConstraints();
		gbc_panelVidas.fill = GridBagConstraints.BOTH;
		gbc_panelVidas.gridx = 0;
		gbc_panelVidas.gridy = 2;
		panel_1.add(panelVidas, gbc_panelVidas);
		
		lblCorazon_6 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_6, "2, 4");
		lblCorazon_6.setVisible(false);
		
		lblCorazon_5 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_5, "6, 4");
		lblCorazon_5.setVisible(false);
		
		JLabel lblCorazon_4 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_4, "6, 2");
		lblCorazon_4.setVisible(false);
		
		JLabel lblCorazon_3 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_3, "2, 6");
		lblCorazon_3.setVisible(true);
		
		JLabel lblCorazon_2 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_2, "2, 2");
		lblCorazon_2.setVisible(true);
		
		JLabel lblCorazon_1 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_1, "6, 6");
		lblCorazon_1.setVisible(true);
		
	}

	public void actualizarVidas(int cantVidas) {
		switch(cantVidas){
		case 1:
			System.out.println("entro en vidas");
			lblCorazon_1.setVisible(true);
		break;
		case 2:
			System.out.println("entro en vidas");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
		break;
		case 3:
			System.out.println("entro en vidas");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
		break;
		case 4:
			System.out.println("entro en vidas");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
		break;
		case 5:
			System.out.println("entro en vidas");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_5.setVisible(true);
		break;
		case 6:
			System.out.println("entro en vidas");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_5.setVisible(true);
			lblCorazon_6.setVisible(true);
		break;
		}
	}
	
	public void actualizarGraficos(ArrayList<PosicionGrafica> posiciones) {
		for (PosicionGrafica p : posiciones) {
			JLabel label = labels[p.getY()][p.getX()];
			label.setIcon(p.getRepresentacionGrafica());
			label.repaint();
			lblPuntos.setText(Juego.getPuntajeString());
			lblPuntos.repaint();
		}
	}

	
	public JLabel getLblPuntos() {
		return lblPuntos;
	}

	public void actualizarMapa(PosicionGrafica[][] posiciones) {
		removeAll();
		cargarPosiciones(posiciones);
		panelGrilla.repaint();
	}
	
	private void cargarPosiciones(PosicionGrafica[][] posiciones) {
		int alto = posiciones.length;
		int ancho = posiciones[0].length;
		labels = new JLabel[alto][ancho];
		
		for (int y = 0; y < alto; ++y) {
			for (int x = 0; x < ancho; ++x) {
				//System.out.println(posiciones[y][x]);
				JLabel lblNewLabel = new JLabel(posiciones[y][x].getRepresentacionGrafica());
				GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
				gbc_lblNewLabel.gridx = x;
				gbc_lblNewLabel.gridy = y;
				panelGrilla.add(lblNewLabel, gbc_lblNewLabel);

				labels[y][x] = lblNewLabel;
				labels[y][x].repaint();
			}
		}
	}
}
