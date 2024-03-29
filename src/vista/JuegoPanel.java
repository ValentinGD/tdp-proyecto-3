package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import app.App;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;

@SuppressWarnings("serial")
public class JuegoPanel extends JPanel {

	private RepositorioGraficoAbstracto repositorioGrafico;

	private JPanel panelGrilla;
	private JPanel info_y_botones; // Contiene info para el jugador (puntaje, vidas) y botones para musica y ver
									// scores.
	private JPanel panelPuntaje, panelVidas, panelAudio, panelLabelsVidas, panelBotonesAudio, panelControles;

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

	private JLabel lblTituloControles;
	private JLabel lblControles;

	private GUI miGui;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		int w = getWidth();
		int h = getHeight();
		Color color1 = Color.YELLOW;
		Color color2 = new Color(255, 145, 61);
		GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, w, h);
	}

	public JuegoPanel(RepositorioGraficoAbstracto repositorioGrafico, GUI gui) {
		this.repositorioGrafico = repositorioGrafico;
		miGui = gui;

		setLayout(new BorderLayout(0, 0));

		panelGrilla = new JPanel();
		panelGrilla.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelGrilla.setLayout(null);
		add(panelGrilla, BorderLayout.CENTER);

		info_y_botones = new JPanel();
		info_y_botones.setOpaque(false);
		info_y_botones.setBorder(new EmptyBorder(10, 15, 10, 15));
		GridBagLayout gbl_info_y_botones = new GridBagLayout();
		gbl_info_y_botones.columnWidths = new int[] { 0, 0 };
		gbl_info_y_botones.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_info_y_botones.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_info_y_botones.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		info_y_botones.setLayout(gbl_info_y_botones);
		add(info_y_botones, BorderLayout.EAST);

		panelPuntaje = new JPanel();
		panelPuntaje.setOpaque(false);
		GridBagConstraints gbc_panelPuntaje = new GridBagConstraints();
		gbc_panelPuntaje.insets = new Insets(0, 0, 25, 0);
		gbc_panelPuntaje.fill = GridBagConstraints.BOTH;
		gbc_panelPuntaje.gridx = 0;
		gbc_panelPuntaje.gridy = 0;
		panelPuntaje.setLayout(new BorderLayout(0, 0));
		info_y_botones.add(panelPuntaje, gbc_panelPuntaje);

		lblPuntaje = new JLabel("Puntaje:");
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelPuntaje.add(lblPuntaje, BorderLayout.NORTH);

		lblPuntos = new JLabel("0");
		lblPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelPuntaje.add(lblPuntos, BorderLayout.SOUTH);

		panelVidas = new JPanel();
		panelVidas.setOpaque(false);
		GridBagConstraints gbc_panelVidas = new GridBagConstraints();
		gbc_panelVidas.insets = new Insets(0, 0, 25, 0);
		gbc_panelVidas.fill = GridBagConstraints.BOTH;
		gbc_panelVidas.gridx = 0;
		gbc_panelVidas.gridy = 1;
		panelVidas.setLayout(new BorderLayout(0, 0));
		info_y_botones.add(panelVidas, gbc_panelVidas);

		lblVidas = new JLabel("Vidas restantes:");
		lblVidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidas.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelVidas.add(lblVidas, BorderLayout.NORTH);

		panelLabelsVidas = new JPanel();
		panelLabelsVidas.setOpaque(false);
		panelVidas.add(panelLabelsVidas, BorderLayout.SOUTH);

		lblCorazon_6 = new JLabel(RepositorioGrafico.getPocion());
		lblCorazon_6.setVisible(false);
		panelLabelsVidas.add(lblCorazon_6);

		lblCorazon_5 = new JLabel(RepositorioGrafico.getPocion());
		lblCorazon_5.setVisible(false);
		panelLabelsVidas.add(lblCorazon_5);

		lblCorazon_4 = new JLabel(RepositorioGrafico.getPocion());
		lblCorazon_4.setVisible(false);
		panelLabelsVidas.add(lblCorazon_4);

		lblCorazon_3 = new JLabel(RepositorioGrafico.getPocion());
		lblCorazon_3.setVisible(false);
		panelLabelsVidas.add(lblCorazon_3);

		lblCorazon_2 = new JLabel(RepositorioGrafico.getPocion());
		lblCorazon_2.setVisible(false);
		panelLabelsVidas.add(lblCorazon_2);

		lblCorazon_1 = new JLabel(RepositorioGrafico.getPocion());
		lblCorazon_1.setVisible(false);
		panelLabelsVidas.add(lblCorazon_1);

		panelAudio = new JPanel();
		panelAudio.setOpaque(false);
		GridBagConstraints gbc_panelAudio = new GridBagConstraints();
		gbc_panelAudio.insets = new Insets(0, 0, 25, 0);
		gbc_panelAudio.fill = GridBagConstraints.BOTH;
		gbc_panelAudio.gridx = 0;
		gbc_panelAudio.gridy = 2;
		panelAudio.setLayout(new BorderLayout(0, 0));
		info_y_botones.add(panelAudio, gbc_panelAudio);

		lblMusica = new JLabel("M\u00FAsica:");
		lblMusica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusica.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelAudio.add(lblMusica, BorderLayout.NORTH);

		panelBotonesAudio = new JPanel();
		panelBotonesAudio.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panelBotonesAudio.getLayout();
		flowLayout.setHgap(10);
		panelAudio.add(panelBotonesAudio, BorderLayout.CENTER);

		btnStop = new JButton("");
		btnStop.setFocusable(false);
		btnStop.setMnemonic('s');
		btnStop.setToolTipText("Detener m\u00FAsica");
		btnStop.setIcon(new ImageIcon(JuegoPanel.class.getResource(App.configuration.getProperty("ImagenStop"))));
		btnStop.setMargin(new Insets(2, 2, 2, 2));
		btnStop.addActionListener(gui);
		btnStop.setActionCommand("stop_audio");
		panelBotonesAudio.add(btnStop);

		btnPlayPause = new JButton("");
		btnPlayPause.setFocusable(false);
		btnPlayPause.setMnemonic('p');
		btnPlayPause.setToolTipText("Reproducir/pausar m\u00FAsica");
		btnPlayPause
				.setIcon(new ImageIcon(JuegoPanel.class.getResource(App.configuration.getProperty("ImagenPlayPause"))));
		btnPlayPause.setMargin(new Insets(2, 2, 2, 2));
		btnPlayPause.addActionListener(gui);
		btnPlayPause.setActionCommand("play_pause_audio");
		panelBotonesAudio.add(btnPlayPause);

		panelControles = new JPanel();
		panelControles.setBorder(UIManager.getBorder("TitledBorder.border"));
		panelControles.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelControles = new GridBagConstraints();
		gbc_panelControles.insets = new Insets(0, 15, 25, 15);
		gbc_panelControles.fill = GridBagConstraints.BOTH;
		gbc_panelControles.gridx = 0;
		gbc_panelControles.gridy = 3;
		panelControles.setLayout(new BorderLayout(0, 0));
		info_y_botones.add(panelControles, gbc_panelControles);

		lblTituloControles = new JLabel("Controles:");
		lblTituloControles.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblTituloControles.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloControles.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelControles.add(lblTituloControles, BorderLayout.NORTH);

		lblControles = new JLabel("<html>\u2191 Arriba<br>\u2190 Izquierda<br>\u2193 Abajo<br>\u2192 Derecha</html>");
		lblControles.setHorizontalAlignment(SwingConstants.CENTER);
		lblControles.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblControles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panelControles.add(lblControles, BorderLayout.SOUTH);

		JButton btnRecords = new JButton("<html><center>Ver mejores<br>puntuaciones</center></html>");
		btnRecords.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MejoresJugadores();
			}
		});
		btnRecords.setFocusable(false);
		btnRecords.setMnemonic('v');
		GridBagConstraints gbc_btnRecords = new GridBagConstraints();
		gbc_btnRecords.insets = new Insets(0, 0, 5, 0);
		gbc_btnRecords.gridx = 0;
		gbc_btnRecords.gridy = 4;
		info_y_botones.add(btnRecords, gbc_btnRecords);
	}

	public void agregarEntidades(List<EntidadGrafica> entidades) {
		limpiar();
		for (EntidadGrafica e : entidades) {
			panelGrilla.add(e.getRepresentacionGrafica(repositorioGrafico).getLabel());
		}
	}

	public void setDimensiones(int alto, int ancho) {
		panelGrilla.setPreferredSize(new Dimension(ancho + 4, alto + 4));
		repaint();
	}

	public void actualizarVidas(int cantVidas) {
		switch (cantVidas) {
		case 1:
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(false);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			break;
		case 2:
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(false);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			break;
		case 3:
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(false);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			lblCorazon_4.repaint();
			break;
		case 4:
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_5.setVisible(false);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			lblCorazon_4.repaint();
			lblCorazon_5.repaint();
			break;
		case 5:
			lblCorazon_1.setVisible(true);
			lblCorazon_2.setVisible(true);
			lblCorazon_3.setVisible(true);
			lblCorazon_4.setVisible(true);
			lblCorazon_5.setVisible(true);
			lblCorazon_6.setVisible(false);
			lblCorazon_1.repaint();
			lblCorazon_2.repaint();
			lblCorazon_3.repaint();
			lblCorazon_4.repaint();
			lblCorazon_5.repaint();
			lblCorazon_6.repaint();
			break;
		case 6:
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

	public void MejoresJugadores() {
		miGui.mostrarPuntajes();
	}

}