package vista;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public MenuPanel(ActionListener gui) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTitulo = new JLabel("<html>Bienvenido<br>a otra copia<br>del Pacman!</html>");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(50, 0, 5, 0);
		gbc_lblTitulo.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblLogo = new JLabel(new ImageIcon(MenuPanel.class.getResource("/img/logo/logo-chico.png")));
		add(lblLogo);
		
		JButton btnComenzar = new JButton("Comenzar");
		btnComenzar.setActionCommand("comenzar");
		btnComenzar.addActionListener(gui);
		GridBagConstraints gbc_btnComenzar = new GridBagConstraints();
		gbc_btnComenzar.fill = GridBagConstraints.BOTH;
		gbc_btnComenzar.gridx = 0;
		gbc_btnComenzar.gridy = 1;
		add(btnComenzar, gbc_btnComenzar);

	}

}
