package vista;

import javax.swing.JPanel;
import app.App;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import javax.swing.Box;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.GradientPaint;

/*
 * Generación de la GUI de bienvenida al juego.
 */

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	private boolean musica_al_inicio;
	
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
	
	public MenuPanel(ActionListener gui) {
		setOpaque(false);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
				
		JPanel panelLabels = new JPanel();
		panelLabels.setOpaque(false);
		panelLabels.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelLabels.setLayout(new BorderLayout(10, 0));
		add(panelLabels);
		
		JLabel lblTitulo = new JLabel(App.configuration.getProperty("Bienvenida"));
		lblTitulo.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setFocusable(false);
		panelLabels.add(lblTitulo, BorderLayout.WEST);
		
		JLabel lblLogo = new JLabel(new ImageIcon(MenuPanel.class.getResource(App.configuration.getProperty("Logo"))));
		lblLogo.setBorder(new EmptyBorder(0, 0, 0, 20));
		lblLogo.setFocusable(false);
		panelLabels.add(lblLogo, BorderLayout.EAST);
		
		JPanel panelBotonYSonido = new JPanel();
		panelBotonYSonido.setOpaque(false);
		panelBotonYSonido.setBorder(new EmptyBorder(10, 0, 10, 0));
		add(panelBotonYSonido);
		
		JButton btnComenzar = new JButton("Comenzar \uD83D\uDD79");
		btnComenzar.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnComenzar.setPreferredSize(new Dimension(180, 40));
		btnComenzar.setMnemonic('c');
		btnComenzar.setMargin(new Insets(2, 10, 2, 10));
		btnComenzar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, Color.DARK_GRAY));
		btnComenzar.setActionCommand("comenzar");
		btnComenzar.addActionListener(gui);
		panelBotonYSonido.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
		panelBotonYSonido.add(btnComenzar);
		
		JCheckBox cbSonido = new JCheckBox("M\u00FAsica");
		cbSonido.setOpaque(false);
		cbSonido.setMnemonic('m');
		cbSonido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				musica_al_inicio = cbSonido.isSelected();
			}
		});
		panelBotonYSonido.add(cbSonido);
		
		JPanel panelAyudaControles = new JPanel();
		panelAyudaControles.setOpaque(false);
		panelAyudaControles.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelAyudaControles.setLayout(new BorderLayout(0, 0));
		add(panelAyudaControles);
		
		JPanel panelTablaControles = new JPanel();
		panelTablaControles.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panelTablaControles.setBackground(Color.WHITE);
		panelTablaControles.setLayout(new BoxLayout(panelTablaControles, BoxLayout.Y_AXIS));
		panelAyudaControles.add(panelTablaControles, BorderLayout.CENTER);
		
		JLabel lblTituloControles = new JLabel("Controles:");
		lblTituloControles.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTituloControles.setBorder(new EmptyBorder(5, 0, 5, 0));
		lblTituloControles.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloControles.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTablaControles.add(lblTituloControles);

		JPanel panelTextoControles = new JPanel();
		panelTextoControles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelTextoControles.setBackground(Color.WHITE);
		panelTextoControles.setBorder(new EmptyBorder(5, 0, 5, 0));
		panelTextoControles.setLayout(new GridLayout(4, 2, 0, 2));
		panelTablaControles.add(panelTextoControles);
		
		JLabel lbl_f1 = new JLabel("\u2191");
		lbl_f1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_f1.setHorizontalAlignment(SwingConstants.CENTER);
		panelTextoControles.add(lbl_f1);
		
		JLabel lbl_t1 = new JLabel("Arriba");
		lbl_t1.setVerticalAlignment(SwingConstants.BOTTOM);
		panelTextoControles.add(lbl_t1);
		
		JLabel lbl_f2 = new JLabel("\u2190");
		lbl_f2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_f2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTextoControles.add(lbl_f2);
		
		JLabel lbl_t2 = new JLabel("Izquierda");
		lbl_t2.setVerticalAlignment(SwingConstants.BOTTOM);
		panelTextoControles.add(lbl_t2);
		
		JLabel lbl_f3 = new JLabel("\u2193");
		lbl_f3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_f3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTextoControles.add(lbl_f3);
		
		JLabel lbl_t3 = new JLabel("Abajo");
		lbl_t3.setVerticalAlignment(SwingConstants.BOTTOM);
		panelTextoControles.add(lbl_t3);
		
		JLabel lbl_f4 = new JLabel("\u2192");
		lbl_f4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_f4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panelTextoControles.add(lbl_f4);
		
		JLabel lbl_t4 = new JLabel("Derecha");
		lbl_t4.setVerticalAlignment(SwingConstants.BOTTOM);
		panelTextoControles.add(lbl_t4);
		
		Component horizontalStrut_izq = Box.createHorizontalStrut(75);
		panelAyudaControles.add(horizontalStrut_izq, BorderLayout.WEST);
		
		Component horizontalStrut_der = Box.createHorizontalStrut(75);
		panelAyudaControles.add(horizontalStrut_der, BorderLayout.EAST);
	}

	public boolean esta_activada_musica_al_inicio() {
		return musica_al_inicio;
	}
	
}