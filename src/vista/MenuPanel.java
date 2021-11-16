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

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	public MenuPanel(ActionListener gui) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BorderLayout(7, 7));

		JLabel lblTitulo = new JLabel(App.configuration.getProperty("Bienvenida"));
		lblTitulo.setFocusable(false);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(lblTitulo, BorderLayout.WEST);
		
		JLabel lblLogo = new JLabel(new ImageIcon(MenuPanel.class.getResource(App.configuration.getProperty("Logo"))));
		lblLogo.setFocusable(false);
		add(lblLogo, BorderLayout.EAST);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, Color.DARK_GRAY, Color.DARK_GRAY));
		btnComenzar.setMargin(new Insets(2, 10, 2, 10));
		btnComenzar.setMnemonic('C');
		btnComenzar.setActionCommand("comenzar");
		btnComenzar.addActionListener(gui);
		btnComenzar.setPreferredSize(new Dimension(40, 40));
		add(btnComenzar, BorderLayout.SOUTH);
	}

}