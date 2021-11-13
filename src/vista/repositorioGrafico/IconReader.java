package vista.repositorioGrafico;

import javax.swing.ImageIcon;

import vista.RepositorioGrafico;

public class IconReader {
	public static ImageIcon readIcon(String path) {
		return new ImageIcon(IconReader.class.getResource(path));
	}
}
