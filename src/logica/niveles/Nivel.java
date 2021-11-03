package logica.niveles;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import logica.Escenario;
import logica.Posicion;
import logica.entidades.PickUp;
import logica.fabricas.PickUpFactory;


public class Nivel {
	protected Posicion grilla[][];
	protected int nivel;
	String pathMapa;
	
	public Posicion[][] getGrilla() {
		return grilla;
	}
	public void setGrilla(Posicion grilla[][]) {
		this.grilla = grilla;
	}
	public Posicion getPosicionGrilla(int fila, int columna) {
		return grilla[fila][columna];
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public void cargarGrilla() throws IOException {
		File mapa=new File(pathMapa);
		Scanner linea=new Scanner(mapa);
	    char[] lineaChar=new char[20];
		for(int f=0;f<grilla[0].length;f++) {
				if (linea.hasNext()) {
	                lineaChar=linea.nextLine().toCharArray();
	                for(int c=0;c<lineaChar.length;c++)
	                	traducirCaracter(lineaChar[c],f,c);
			}
		}
		linea.close();
	}
	/**
	 * Punto chico  -> '*'
	 * Punto grande -> '#'
	 * Poder -> 'P'
	 * Pocion -> 'V'
	 * Pared -> 'X'
	 * Pared que atraviesan los enemigos -> '-'
	 * Enemigo -> '1, 2, 3, 4'
	 * Personaje -> 'A'
	 * @param c
	 * @return
	 */
	private void traducirCaracter(char c, int fila, int colum) {
		Posicion pos;
		PickUp pu;
		switch(c) {
		
			case '*':
				pu=PickUpFactory.createPuntosChicos();
				pos=new Posicion(fila,colum,true,true,pu);
			break;
			
			case '#':
				pu=PickUpFactory.createPuntosGrandes();
				pos=new Posicion(fila,colum,true,true,pu);
			break;
			
			case 'X':
				pos=new Posicion(fila,colum,false,false,null);
			break;
			
			case 'P':
				pu=PickUpFactory.createPoder();
				pos=new Posicion(fila,colum,true,true,pu);
			break;
			
			case 'V':
				pu=PickUpFactory.createPocion();
				pos=new Posicion(fila,colum,true,true,pu);
			break;
			
			case 'A':
				pos=new Posicion(fila,colum,true,true,null);
				//Escenario.posPersonaje(pos);
			break;
			
			case '-':
				pos=new Posicion(fila,colum,false,true,null);
				//Escenario.posPersonaje(pos);
			break;
			
			case '1':
				pos=new Posicion(fila,colum,false,true,null);
				//Escenario.posEnemigo1(pos);
			break;
			
			case '2':
				pos=new Posicion(fila,colum,false,true,null);
				//Escenario.posEnemigo2(pos);
			break;
			
			case '3':
				pos=new Posicion(fila,colum,false,true,null);
				//Escenario.posEnemigo3(pos);
			break;
			
			case '4':
				pos=new Posicion(fila,colum,false,true,null);
				//Escenario.posEnemigo4(pos);
			break;
			
			case ' ':
				pos=new Posicion(fila,colum,true,true,null);
				break;
			default:
				break;
		}
	}
}
