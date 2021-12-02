package vista;

import javax.swing.JPanel;
import app.App;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	public MenuPanel(ActionListener gui) {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new BorderLayout(7, 7));

		JLabel lblTitulo = new JLabel(App.configuration.getProperty("Bienvenida"));
		lblTitulo.setBorder(new EmptyBorder(0, 15, 10, 10));
		lblTitulo.setFocusable(false);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.WEST);
		
		JLabel lblLogo = new JLabel(new ImageIcon(MenuPanel.class.getResource(App.configuration.getProperty("Logo"))));
		lblLogo.setBorder(new EmptyBorder(0, 10, 10, 15));
		lblLogo.setFocusable(false);
		add(lblLogo, BorderLayout.EAST);
		
		JPanel panelBotonYSonido = new JPanel();
		panelBotonYSonido.setBorder(new EmptyBorder(0, 15, 0, 15));
		add(panelBotonYSonido, BorderLayout.SOUTH);
		panelBotonYSonido.setLayout(new BorderLayout(40, 0));
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setFont(new Font("Monospaced", Font.BOLD, 18));
		btnComenzar.setPreferredSize(new Dimension(120, 40));
		btnComenzar.setMnemonic('c');
		btnComenzar.setMargin(new Insets(2, 10, 2, 10));
		btnComenzar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, Color.DARK_GRAY));
		btnComenzar.setActionCommand("comenzar");
		btnComenzar.addActionListener(gui);
		panelBotonYSonido.add(btnComenzar, BorderLayout.CENTER);
		
		JCheckBox cbSonido = new JCheckBox("M\u00FAsica");
		cbSonido.setVisible(false);
		cbSonido.setMnemonic('m');
		panelBotonYSonido.add(cbSonido, BorderLayout.EAST);
		
		JPanel panelControles = new JPanel();
		panelControles.setBorder(UIManager.getBorder("TitledBorder.border"));
		panelControles.setBackground(new Color(255, 239, 213));
		add(panelControles, BorderLayout.NORTH);
		panelControles.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTituloControles = new JLabel("Controles:");
		lblTituloControles.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloControles.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTituloControles.setBorder(new EmptyBorder(5, 0, 5, 0));
		panelControles.add(lblTituloControles, BorderLayout.NORTH);
		
		JLabel lblControles = new JLabel("<html>\u2191 Arriba<br>\u2190 Izquierda<br>\u2193 Abajo<br>\u2192 Derecha</html>");
		lblControles.setHorizontalAlignment(SwingConstants.CENTER);
		lblControles.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblControles.setBorder(new EmptyBorder(5, 0, 5, 0));
		panelControles.add(lblControles, BorderLayout.SOUTH);
	}

}