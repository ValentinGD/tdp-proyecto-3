package vista;

import java.awt.event.ActionListener;
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

import app.App;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JuegoPanel extends JPanel {
	
	private RepositorioGraficoAbstracto repositorioGrafico;
	
	private JLabel [][] labels;
	
	private JPanel panelGrilla;
	private JPanel info_y_botones; //Contiene info para el jugador (puntaje, vidas) y botones para musica y ver scores.
	private JPanel panelPuntaje, panelVidas, panelAudio, panelLabelsVidas, panelBotonesAudio; 

	private JLabel lblPuntaje;
	private JLabel lblPuntos;
	
	private JLabel lblVidas;
	private JLabel lblCorazon_1;
	private JLabel lblCorazon_2;
	private JLabel lblCorazon_3;
	private JLabel lblCorazon_4;
	private JLabel lblCorazon_5;
	private JLabel lblCorazon_6;
	private JLabel lblMusica;

	private JButton btnStop;
	private JButton btnPlayPause;
	
	public JuegoPanel(RepositorioGraficoAbstracto repositorioGrafico, ActionListener gui) {
		this.repositorioGrafico = repositorioGrafico;
		System.out.println("creando panel de juego");
		
		setLayout(new BorderLayout(0, 0));
		
		panelGrilla = new JPanel();
		panelGrilla.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		add(panelGrilla, BorderLayout.CENTER);
		panelGrilla.setLayout(null);
		
		//cargarPosiciones(posiciones);
		
		info_y_botones = new JPanel();
		info_y_botones.setBorder(new EmptyBorder(10, 15, 10, 15));
		add(info_y_botones, BorderLayout.EAST);
		GridBagLayout gbl_info_y_botones = new GridBagLayout();
		gbl_info_y_botones.columnWidths = new int[]{0, 0};
		gbl_info_y_botones.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_info_y_botones.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_info_y_botones.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		info_y_botones.setLayout(gbl_info_y_botones);
		
		panelPuntaje = new JPanel();
		GridBagConstraints gbc_panelPuntaje = new GridBagConstraints();
		gbc_panelPuntaje.insets = new Insets(0, 0, 25, 0);
		gbc_panelPuntaje.fill = GridBagConstraints.BOTH;
		gbc_panelPuntaje.gridx = 0;
		gbc_panelPuntaje.gridy = 0;
		info_y_botones.add(panelPuntaje, gbc_panelPuntaje);
		panelPuntaje.setLayout(new BorderLayout(0, 0));
		
		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelPuntaje.add(lblPuntaje, BorderLayout.NORTH);
		
		lblPuntos = new JLabel("0");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 15));		
		panelPuntaje.add(lblPuntos, BorderLayout.SOUTH);
		
		panelVidas = new JPanel();
		GridBagConstraints gbc_panelVidas = new GridBagConstraints();
		gbc_panelVidas.insets = new Insets(0, 0, 25, 0);
		gbc_panelVidas.fill = GridBagConstraints.BOTH;
		gbc_panelVidas.gridx = 0;
		gbc_panelVidas.gridy = 1;
		info_y_botones.add(panelVidas, gbc_panelVidas);
		panelVidas.setLayout(new BorderLayout(0, 0));
		
		lblVidas = new JLabel("Vidas restantes:");
		lblVidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidas.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelVidas.add(lblVidas, BorderLayout.NORTH);
		
		panelLabelsVidas = new JPanel();
		panelVidas.add(panelLabelsVidas, BorderLayout.SOUTH);
		
		lblCorazon_6 = new JLabel(RepositorioGrafico.getPocion());
		panelLabelsVidas.add(lblCorazon_6);
		lblCorazon_6.setVisible(false);
		
		lblCorazon_5 = new JLabel(RepositorioGrafico.getPocion());
		panelLabelsVidas.add(lblCorazon_5);
		lblCorazon_5.setVisible(false);
		
		lblCorazon_4 = new JLabel(RepositorioGrafico.getPocion());
		panelLabelsVidas.add(lblCorazon_4);
		lblCorazon_4.setVisible(false);
		
		lblCorazon_3 = new JLabel(RepositorioGrafico.getPocion());
		panelLabelsVidas.add(lblCorazon_3);
		lblCorazon_3.setVisible(true);
		
		lblCorazon_2 = new JLabel(RepositorioGrafico.getPocion());
		panelLabelsVidas.add(lblCorazon_2);
		lblCorazon_2.setVisible(true);
		
		lblCorazon_1 = new JLabel(RepositorioGrafico.getPocion());
		panelLabelsVidas.add(lblCorazon_1);
		lblCorazon_1.setVisible(true);
		
		panelAudio = new JPanel();
		GridBagConstraints gbc_panelAudio = new GridBagConstraints();
		gbc_panelAudio.insets = new Insets(0, 0, 25, 0);
		gbc_panelAudio.fill = GridBagConstraints.BOTH;
		gbc_panelAudio.gridx = 0;
		gbc_panelAudio.gridy = 2;
		info_y_botones.add(panelAudio, gbc_panelAudio);
		panelAudio.setLayout(new BorderLayout(0, 0));
		
		lblMusica = new JLabel("La musiquita:");
		lblMusica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusica.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelAudio.add(lblMusica, BorderLayout.NORTH);
		
		panelBotonesAudio = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotonesAudio.getLayout();
		flowLayout.setHgap(10);
		panelAudio.add(panelBotonesAudio, BorderLayout.CENTER);

		btnStop = new JButton("");
		btnStop.setToolTipText("Detener m\u00FAsica");
		btnStop.setIcon(new ImageIcon(JuegoPanel.class.getResource(App.configuration.getProperty("ImagenStop"))));
		btnStop.setMargin(new Insets(2, 2, 2, 2));
		btnStop.addActionListener(gui);
		btnStop.setActionCommand("stop");
		panelBotonesAudio.add(btnStop);
		
		btnPlayPause = new JButton("");
		btnPlayPause.setToolTipText("Reproducir/pausar m\u00FAsica");
		btnPlayPause.setIcon(new ImageIcon(JuegoPanel.class.getResource(App.configuration.getProperty("ImagenPlayPause"))));
		btnPlayPause.setMargin(new Insets(2, 2, 2, 2));
		btnPlayPause.addActionListener(gui);
		btnPlayPause.setActionCommand("play_pause");
		panelBotonesAudio.add(btnPlayPause);
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