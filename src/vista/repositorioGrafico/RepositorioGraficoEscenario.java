package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public class RepositorioGraficoEscenario {
	
	protected String path;
	
	public RepositorioGraficoEscenario(String path) {
		this.path = path + "escenario/";
	}
	
	public ImageIcon getFondo() {
		return IconReader.readIcon(path + "fondo.png");
	}
	
	public ImageIcon getParedEsquinaInferiorDerecha() {
		return IconReader.readIcon(path + "pared_esquina_inferior_derecha.png");
	}
	
	public ImageIcon getParedEsquinaInferiorIzquierda() {
		return IconReader.readIcon(path + "pared_esquina_inferior_izquierda.png");
	}
	
	public ImageIcon getParedEsquinaSuperiorDerecha() {
		return IconReader.readIcon(path + "pared_esquina_superior_derecha.png");
	}
	
	public ImageIcon getParedEsquinaSuperiorIzquierda() {
		return IconReader.readIcon(path + "pared_esquina_superior_izquierda.png");
	}
	
	public ImageIcon getParedExtremoDerecho() {
		return IconReader.readIcon(path + "pared_extremo_derecho.png");
	}
	
	public ImageIcon getParedExtremoInferior() {
		return IconReader.readIcon(path + "pared_extremo_inferior.png");
	}
	
	public ImageIcon getParedExtremoIzquierdo() {
		return IconReader.readIcon(path + "pared_extremo_izquierdo.png");
	}
	
	public ImageIcon getParedExtremoSuperior() {
		return IconReader.readIcon(path + "pared_extremo_superior.png");
	}
	
	public ImageIcon getParedHorizontal() {
		return IconReader.readIcon(path + "pared_horizontal.png");
	}
	
	public ImageIcon getParedInterseccion() {
		return IconReader.readIcon(path + "pared_interseccion.png");
	}
	
	public ImageIcon getParedPunto() {
		return IconReader.readIcon(path + "pared_punto.png");
	}
	
	public ImageIcon getParedVertical() {
		return IconReader.readIcon(path + "pared_vertical.png");
	}
	
}