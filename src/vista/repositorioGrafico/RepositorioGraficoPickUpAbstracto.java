package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public abstract class RepositorioGraficoPickUpAbstracto {
	
	/**
	 * UNO
	 */
	public static final int PUNTOS_1 = 1;
	public static final int PUNTOS_2 = 2;
	public static final int PUNTOS_3 = 3;
	
	public static final int PODER_VELOCIDAD = 1;
	public static final int PODER_INMORTAL = 2;
	public static final int PODER_3 = 3;
	
	protected String [] puntos;
	protected String [] poderes;
	protected String path;
	
	/**
	 * Construye un repositorio grafico para pickups
	 * @param path path a la carpeta que contiene el repositorio
	 * @param puntos nombre de los archivos que representaran pickups de puntos
	 * @param poderes nombre de los archivos que representaran pickups de poderes
	 */
	protected RepositorioGraficoPickUpAbstracto(String path, String[] puntos, String[] poderes) {
		this.path = path + "pickups/";
		this.puntos = puntos;
		this.poderes = poderes;
	}
	
	public ImageIcon getPickUpPuntoNormalGrafico() {
		return IconReader.readIcon(path + puntos[0]);
	}
	
	public ImageIcon getPickUpPoderNormalGrafico() {
		return IconReader.readIcon(path + poderes[0]);
	}
	
	public ImageIcon getPickUpPuntoEspecialGrafico(int tipo) {
		tipo = Math.max(1, tipo);
		tipo = Math.min(tipo, puntos.length - 1);
		return IconReader.readIcon(path + puntos[tipo]);
	}
	
	public ImageIcon getPickUpPoderEspecialGrafico(int tipo) {
		tipo = Math.max(1, tipo);	
		tipo = Math.min(tipo, poderes.length - 1);
		return IconReader.readIcon(path + poderes[tipo]);
	}
	
}