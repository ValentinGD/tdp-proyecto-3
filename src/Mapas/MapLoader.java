package Mapas;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

import app.App;
import logica.entidades.Entidad;
import logica.entidades.Movible;
import logica.entidades.Pared;
import logica.entidades.Personaje;
import logica.entidades.enemigos.Enemigo1;
import logica.entidades.enemigos.Enemigo2;
import logica.entidades.enemigos.Enemigo3;
import logica.entidades.enemigos.Enemigo4;
import logica.entidades.pickups.poderes.PickUpPoder;
import logica.entidades.pickups.poderes.PoderInmortal;
import logica.entidades.pickups.poderes.PoderNormal;
import logica.entidades.pickups.poderes.PoderVelocidad;
import logica.entidades.pickups.puntos.PuntosEspecial;
import logica.entidades.pickups.puntos.PuntosNormal;

public class MapLoader {

	private static final String rutaMapas = App.configuration.getProperty("RutaMapas");
	private static final String extensionArchivos = App.configuration.getProperty("ExtensionMapas");
	
	public static Mapa getMapa(int nroMapa) {
		String ruta = rutaMapas + nroMapa + extensionArchivos;
		return getMapa(ruta);
	}

	private static Mapa getMapa(String path) {
		System.out.println("leyendo mapa desde: " + path);
		
		Mapa mapa = null;
		String linea;
		int fila = 0;
		int ancho = 0;
		
		
		try (Scanner scanner = new Scanner(new File(path))) {
			if (scanner.hasNextLine()) {
				mapa = new Mapa();

				linea = scanner.nextLine();
				
				System.out.println("cargando linea " + fila +": " + linea);
				cargarLinea(mapa, linea, fila);

				while (scanner.hasNextLine()) {
					linea = scanner.nextLine();
					fila++;
					System.out.println("cargando linea " + fila +": " + linea);
					
					cargarLinea(mapa, linea, fila);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//mapa = Mapa.MAPA_VACIO;
		}
		

		

		//System.out.println("Se cargo el mapa: " + numeroMapa);
		System.out.println("Cantidad de filas: " + fila);
		//System.out.println("mapa creado: " + mapa);
		return mapa;
	}

	private static void cargarLinea(Mapa mapa, String linea, int fila) {
		char[] caracteres = linea.toCharArray();
		for (int i = 0; i < caracteres.length && i < caracteres.length; ++i) {
			caracterAEntidad(caracteres[i], mapa,i,fila);
		}
	}

	/**
	 * Punto normal 	-> '*'
	 * Punto especial 	-> '#'
	 * Poder normal 	-> 'P'
	 * Poder especial 	-> 'V': Velocidad
	 * 					-> 'I': Inmortal
	 * Pared 			-> 'X'
	 * Pared enemigos 	-> '-'
	 * Enemigo 			-> '1', '2', '3', '4'
	 * Personaje 		-> 'A'
	 * 
	 * @param c
	 * @return
	 */
	private static void caracterAEntidad(char c, Mapa m, int x, int y) {
		Entidad entidad;
		switch (c) {

		case '*':
			entidad = new PuntosNormal(x,y);
			m.addPickUpNormal((PuntosNormal) entidad);
			break;

		case '#':
			entidad = new PuntosEspecial(x,y);
			m.addPuntosEspecial((PuntosEspecial) entidad);
			break;

		case 'X':
			entidad= new Pared(x,y);
			m.addParedes((Pared) entidad);
			break;

		case 'P':
			entidad = new PoderNormal(x,y);
			m.addPoderEspecial((PickUpPoder) entidad);
			break;

		case 'V':
			entidad = new PoderVelocidad(x,y);
			m.addPoderEspecial((PickUpPoder) entidad);
			break;
		case 'I':
			entidad = new PoderInmortal(x,y);
			m.addPoderEspecial((PickUpPoder) entidad);
			break;

		case 'A':
			entidad= Personaje.getInstancia();
			entidad.setX(x);
			entidad.setY(y);
			m.addMovible((Movible) entidad);
			break;

		case '-':
			entidad= new Pared(x,y);
			m.addParedes((Pared) entidad);
			break;

		case '1':
			entidad= Enemigo1.getInstancia();
			entidad.setX(x);
			entidad.setY(y);
			m.addMovible((Movible) entidad);
			break;

		case '2':
			entidad= Enemigo2.getInstancia();
			entidad.setX(x);
			entidad.setY(y);
			m.addMovible((Movible) entidad);
			break;

		case '3':
			entidad= Enemigo3.getInstancia();
			entidad.setX(x);
			entidad.setY(y);
			m.addMovible((Movible) entidad);
			break;

		case '4':
			entidad= Enemigo4.getInstancia();
			entidad.setX(x);
			entidad.setY(y);
			m.addMovible((Movible) entidad);
			break;

		case ' ':
			
			break;

		default:
			break;
		}
	}
}
