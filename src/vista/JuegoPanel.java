package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import vista.repositorioGrafico.RepositorioGraficoAbstracto;

@SuppressWarnings("serial")
public class JuegoPanel extends JPanel {
	
	private RepositorioGraficoAbstracto repositorioGrafico;
	
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
	public JuegoPanel(RepositorioGraficoAbstracto repositorioGrafico) {
		this.repositorioGrafico = repositorioGrafico;
		System.out.println("creando panel de juego");
		
		setLayout(new BorderLayout(0, 0));
		
		panelGrilla = new JPanel();
		panelGrilla.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(panelGrilla, BorderLayout.CENTER);
		panelGrilla.setLayout(null);
		
		
		//cargarPosiciones(posiciones);
		
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
		
		lblCorazon_4 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_4, "6, 2");
		lblCorazon_4.setVisible(false);
		
		lblCorazon_3 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_3, "2, 6");
		lblCorazon_3.setVisible(true);
		
		lblCorazon_2 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_2, "2, 2");
		lblCorazon_2.setVisible(true);
		
		lblCorazon_1 = new JLabel(RepositorioGrafico.getPocion());
		panelVidas.add(lblCorazon_1, "6, 6");
		lblCorazon_1.setVisible(true);
		
	}

	public void agregarEntidades(List<EntidadGrafica> entidades) {
		limpiar();
		for (EntidadGrafica e : entidades) {
			//System.out.println("agregando entidad al panel grafico:");
			//System.out.println("panelGrilla: " + panelGrilla);
			//System.out.println("\te: " + e);
			//System.out.println("\trep: " + e.getRepresentacionGrafica(repositorioGrafico));
			panelGrilla.add(e.getRepresentacionGrafica(repositorioGrafico).getLabel());
		}
	}
	
	public void setDimensiones(int alto, int ancho) {
		panelGrilla.setPreferredSize(new Dimension(ancho + 4,  alto + 4));
		repaint();
	}

	public void actualizarVidas(int cantVidas) {
		switch(cantVidas){
		case 1:
			System.out.println("entro en vidas1");
			lblCorazon_1.setVisible(true);
			lblCorazon_1.repaint();
		break;
		case 2:
			System.out.println("entro en vidas2");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
		break;
		case 3:
			System.out.println("entro en vidas3");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
		break;
		case 4:
			System.out.println("entro en vidas4");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			lblCorazon_4.repaint();
		break;
		case 5:
			System.out.println("entro en vidas5");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_5.setVisible(true);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			lblCorazon_4.repaint();
			lblCorazon_5.repaint();
		break;
		case 6:
			System.out.println("entro en vidas6");
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_5.setVisible(true);
			lblCorazon_6.setVisible(true);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			lblCorazon_4.repaint();
			lblCorazon_5.repaint();
			lblCorazon_6.repaint();	
		break;
		}
	}
	
	public void actualizarEntidades(List<EntidadGrafica> entidades) {
		for (EntidadGrafica e : entidades) {
			e.getRepresentacionGrafica(repositorioGrafico).getLabel().repaint();
		}
	}
	
	public void actualizarPuntaje(int puntaje) {
		lblPuntos.setText(String.valueOf(puntaje));
		lblPuntos.repaint();
	}

	public void limpiar() {
		panelGrilla.removeAll();
	}
	
	public JLabel getLblPuntos() {
		return lblPuntos;
	}
}
