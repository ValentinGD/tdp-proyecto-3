package vista;

import java.awt.Image;

import javax.swing.ImageIcon;

import app.App;

public class RepositorioGrafico {

	private static int indexRepositorio = 0;

	private static final int DEFAULT_ICON_SIZE = 30;

	private static final String[] opcionesRepositorios = new String[] { "/img/prueba/" };

	private static final int INDEX_FONDO = 0;
	private static final int INDEX_PARED = 1;
	private static final int INDEX_PERSONAJE = 2;
	private static final int INDEX_ENEMIGO_VIVO = 3;
	private static final int INDEX_ENEMIGO_MUERTO = 4;
	private static final int INDEX_ENEMIGO_ASUSTADO = 5;
	private static final int INDEX_PUNTO_CHICO = 6;
	private static final int INDEX_PUNTO_GRANDE = 7;
	private static final int INDEX_PARED_ENEMIGO = 8;
	private static final int INDEX_POCION = 9;
	private static final int INDEX_PODER = 10;

	private static final ImageIcon[] iconos = new ImageIcon[11];

	private static void cargarRepositorio() {
		String path = opcionesRepositorios[indexRepositorio];
		iconos[INDEX_FONDO] = resize(new ImageIcon(
				RepositorioGrafico.class.getResource(path + App.configuration.getProperty("ImagenFondo"))));
		iconos[INDEX_PARED] = resize(new ImageIcon(
				RepositorioGrafico.class.getResource(path + App.configuration.getProperty("ImagenPared"))));
		iconos[INDEX_PERSONAJE] = resize(new ImageIcon(RepositorioGrafico.class
				.getResource(path + App.configuration.getProperty("ImagenPersonaje_con_fondo"))));
		iconos[INDEX_ENEMIGO_VIVO] = resize(new ImageIcon(RepositorioGrafico.class
				.getResource(path + App.configuration.getProperty("ImagenEnemigo_vivo_con_fondo"))));
		iconos[INDEX_ENEMIGO_MUERTO] = resize(new ImageIcon(RepositorioGrafico.class
				.getResource(path + App.configuration.getProperty("ImagenEnemigo_muerto_con_Fondo"))));
		iconos[INDEX_ENEMIGO_ASUSTADO] = resize(new ImageIcon(RepositorioGrafico.class
				.getResource(path + App.configuration.getProperty("ImagenEnemigo_asustado_con_fondo"))));
		iconos[INDEX_PUNTO_CHICO] = resize(new ImageIcon(RepositorioGrafico.class
				.getResource(path + App.configuration.getProperty("ImagenPunto_chico_con_fondo"))));
		iconos[INDEX_PUNTO_GRANDE] = resize(new ImageIcon(RepositorioGrafico.class
				.getResource(path + App.configuration.getProperty("ImagenPunto_grande_con_fondo"))));
		iconos[INDEX_PARED_ENEMIGO] = resize(new ImageIcon(
				RepositorioGrafico.class.getResource(path + App.configuration.getProperty("ImagenPared_enemigos"))));
		iconos[INDEX_POCION] = resize(new ImageIcon(
				RepositorioGrafico.class.getResource(path + App.configuration.getProperty("ImagenCorazon_con_fondo"))));
		iconos[INDEX_PODER] = resize(new ImageIcon(
				RepositorioGrafico.class.getResource(path + App.configuration.getProperty("ImagenRayo_con_fondo"))));
	}

	private static ImageIcon resize(ImageIcon icono) {
		Image img = icono.getImage();
		img = img.getScaledInstance(DEFAULT_ICON_SIZE, DEFAULT_ICON_SIZE, Image.SCALE_FAST);
		icono.setImage(img);
		return icono;
	}

	public static void setRepositorio(int indexRepositorio) {
		RepositorioGrafico.indexRepositorio = indexRepositorio % opcionesRepositorios.length;
		cargarRepositorio();
	}

	public static ImageIcon getFondo() {
		return iconos[INDEX_FONDO];
	}

	public static ImageIcon getPared() {
		return iconos[INDEX_PARED];
	}

	public static ImageIcon getPersonaje() {
		return iconos[INDEX_PERSONAJE];
	}

	public static ImageIcon getPuntoChico() {
		return iconos[INDEX_PUNTO_CHICO];
	}

	public static ImageIcon getPuntoGrande() {
		return iconos[INDEX_PUNTO_GRANDE];
	}

	public static ImageIcon getEnemigoVivo() {
		return iconos[INDEX_ENEMIGO_VIVO];
	}

	public static ImageIcon getParedEnemigo() {
		return iconos[INDEX_PARED_ENEMIGO];
	}

	public static ImageIcon getPocion() {
		return iconos[INDEX_POCION];
	}

	public static ImageIcon getPoder() {
		return iconos[INDEX_PODER];
	}

	static {
		cargarRepositorio();
	}

}