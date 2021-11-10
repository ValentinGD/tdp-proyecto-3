package Mapas;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import logica.Entidad;
import logica.Escenario;
import logica.Posicion;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;
import logica.entidades.PickUp;
import logica.entidades.enemigos.Enemigo1;
import logica.entidades.enemigos.Enemigo2;
import logica.entidades.enemigos.Enemigo3;
import logica.entidades.enemigos.Enemigo4;
import logica.entidades.pickups.PickUpEspecial;
import logica.entidades.pickups.PoderEspecial;
import logica.entidades.pickups.PoderNormal;
import logica.entidades.pickups.PuntosEspecial;
import logica.entidades.pickups.PuntosNormal;
import logica.fabricas.PickUpFactory;

public class MapLoader {

	private static final String rutaMapas = "/Mapas/Mapa";
	private static final String extensionArchivos = ".txt";
	
	public static Mapa getMapa(int nroMapa) {
		String ruta = rutaMapas + nroMapa + extensionArchivos;
		return getMapa(ruta);
	}

	private static Mapa getMapa(String path) {
		Mapa mapa;
		String linea;
		int fila = 0;
		
		try (Scanner scanner = new Scanner(new File(MapLoader.class.getResource(path).toURI()))) {
			if (scanner.hasNextLine()) {
				linea = scanner.nextLine();
				
				mapa = new Mapa();
				
				
				
				//System.out.println("cargando linea: " + linea);
				cargarLinea(mapa, linea, fila);
				fila++;

				while (scanner.hasNextLine()) {
					linea = scanner.nextLine();
					//System.out.println("cargando linea: " + linea);
					cargarLinea(mapa, linea, fila);
					fila++;
				}
				
			
		} catch (FileNotFoundException | URISyntaxException e) {
			mapa = Mapa.MAPA_VACIO;
		}
		

		

		//System.out.println("Se cargo el mapa: " + numeroMapa);
		//System.out.println("Cantidad de filas: " + fila);
		//System.out.println("mapa creado: " + mapa);
		return mapa;
	}

	private static void cargarLinea(Mapa mapa, String linea, int fila) {
		char[] caracteres = linea.toCharArray();
		for (int i = 0; i < caracteres.length && i < caracteres.length; ++i) {
			caracterAEntidad(caracteres[i], mapa);
		}
	}

	/**
	 * Punto chico -> '*'
	 * Punto grande -> '#'
	 * Poder -> 'P'
	 * Pocion -> 'V'
	 * Pared -> 'X'
	 * Pared que atraviesan los enemigos -> '-'
	 * Enemigo -> '1', '2', '3', '4'
	 * Personaje -> 'A'
	 * 
	 * @param c
	 * @return
	 */
	private static void caracterAEntidad(char c, Mapa m) {
		Entidad entidad;
		switch (c) {

		case '*':
			entidad = new PuntosNormal();
			m.addPuntosNormales((PuntosNormal) entidad);
			break;

		case '#':
			entidad = new PuntosEspecial();
			m.addPuntosEspeciales((PuntosEspecial) entidad);
			break;

		case 'X':
			entidad= new Pared();
			m.addParedes((Pared) entidad);
			break;

		case 'P':
			entidad = new PoderNormal();
			m.addPoderes((PickUpEspecial) entidad);
			break;

		case 'V':
			entidad = new PoderEspecial();
			m.addPoderes((PickUpEspecial) entidad);
			break;

		case 'A':
			entidad= Personaje.getInstancia();
			m.addMovibles((Movible) entidad);
			break;

		case '-':
			entidad= new Pared();
			m.addParedes((Pared) entidad);
			break;

		case '1':
			entidad= Enemigo1.getInstancia();
			m.addMovibles((Movible) entidad);
			break;

		case '2':
			entidad= Enemigo2.getInstancia();
			m.addMovibles((Movible) entidad);
			break;

		case '3':
			entidad= Enemigo3.getInstancia();
			m.addMovibles((Movible) entidad);
			break;

		case '4':
			entidad= Enemigo4.getInstancia();
			m.addMovibles((Movible) entidad);
			break;

		case ' ':
			
			break;

		default:
			break;
		}
	}
}
