package Mapas;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import logica.Escenario;
import logica.Posicion;
import logica.entidades.Personaje;
import logica.entidades.PickUp;
import logica.entidades.enemigos.Enemigo1;
import logica.entidades.enemigos.Enemigo2;
import logica.entidades.enemigos.Enemigo3;
import logica.entidades.enemigos.Enemigo4;
import logica.fabricas.PickUpFactory;

public class MapLoader {

	private static final String rutaMapas = "/Mapas/Mapa";
	private static final String extensionArchivos = ".txt";

	public static Posicion[][] getMapa(int numeroMapa) throws FileNotFoundException, URISyntaxException {
		Posicion[][] posiciones = new Posicion[][] {};
		String ruta = rutaMapas + numeroMapa + extensionArchivos;
		String linea;
		Scanner scanner = new Scanner(new File(MapLoader.class.getResource(ruta).toURI()));
		int fila = 0;

		if (scanner.hasNextLine()) {
			linea = scanner.nextLine();

			posiciones = new Posicion[linea.length()][linea.length()];

			System.out.println("cargando linea: " + linea);
			cargarLinea(posiciones[fila], linea, fila);
			fila++;

			while (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				System.out.println("cargando linea: " + linea);
				cargarLinea(posiciones[fila], linea, fila);
				fila++;
			}

		}
		scanner.close();

		System.out.println("Se cargo el mapa: " + numeroMapa);
		System.out.println("Cantidad de filas: " + fila);
		return posiciones;
	}

	private static void cargarLinea(Posicion[] posiciones, String linea, int fila) {
		char[] caracteres = linea.toCharArray();
		for (int i = 0; i < caracteres.length && i < posiciones.length; ++i) {
			posiciones[i] = caracterAPosicion(caracteres[i], fila, i);
		}
	}

	/**
	 * Punto chico -> '*' Punto grande -> '#' Poder -> 'P' Pocion -> 'V' Pared ->
	 * 'X' Pared que atraviesan los enemigos -> '-' Enemigo -> '1, 2, 3, 4'
	 * Personaje -> 'A'
	 * 
	 * @param c
	 * @return
	 */
	private static Posicion caracterAPosicion(char c, int fila, int colum) {
		Posicion pos = new Posicion(fila, colum, true, true, null);
		PickUp pu;
		switch (c) {

		case '*':
			pu = PickUpFactory.createPuntosChicos();
			pos = new Posicion(fila, colum, true, true, pu);
			break;

		case '#':
			pu = PickUpFactory.createPuntosGrandes();
			pos = new Posicion(fila, colum, true, true, pu);
			break;

		case 'X':
			pos = new Posicion(fila, colum, false, false, null);
			break;

		case 'P':
			pu = PickUpFactory.createPoder();
			pos = new Posicion(fila, colum, true, true, pu);
			break;

		case 'V':
			pu = PickUpFactory.createPocion();
			pos = new Posicion(fila, colum, true, true, pu);
			break;

		case 'A':
			pos = new Posicion(fila, colum, Personaje.getInstancia());
			// Escenario.posPersonaje(pos);
			break;

		case '-':
			pos = new Posicion(fila, colum, false, true, null);
			// Escenario.posPersonaje(pos);
			break;

		case '1':
			pos = new Posicion(fila, colum, Enemigo1.getInstancia());
			// Escenario.posEnemigo1(pos);
			break;

		case '2':
			pos = new Posicion(fila, colum, Enemigo2.getInstancia());
			// Escenario.posEnemigo2(pos);
			break;

		case '3':
			pos = new Posicion(fila, colum, Enemigo3.getInstancia());
			// Escenario.posEnemigo3(pos);
			break;

		case '4':
			pos = new Posicion(fila, colum, Enemigo4.getInstancia());
			// Escenario.posEnemigo4(pos);
			break;

		case ' ':
			pos = new Posicion(fila, colum, true, true, null);
			break;

		default:
			break;
		}

		return pos;
	}
}
