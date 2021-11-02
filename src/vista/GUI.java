package vista;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;

public class GUI extends JFrame {
	public GUI() {
		
		MenuPanel menuPanel = new MenuPanel();
		getContentPane().add(menuPanel, BorderLayout.CENTER);
	}

}
