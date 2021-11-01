package logica.niveles;

import java.io.FileReader;
import java.io.IOException;

import logica.Posicion;
import logica.entidades.PickUp;
import logica.fabricas.PickUpFactory;


public class Nivel {
	protected Posicion grilla[][];
	protected int nivel;
	protected String pathMapa;
	
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
		FileReader fileReader = new FileReader(pathMapa);
	    int caracterLeido = fileReader.read();
	    char caracter;
		for(int f=0;f<grilla[0].length;f++) {
			for(int c=0;c<grilla.length;c++) {
				if (caracterLeido!=-1) {
	                caracter=(char) caracterLeido;
	                grilla[f][c]=traducirCaracter(caracter,f,c);
	                caracterLeido = fileReader.read();
	            }
			}
		}
		fileReader.close();
	}
	/**
	 * Punto chico  -> '*'
	 * Punto grande -> '#'
	 * Poder -> 'P'
	 * Pocion -> 'V'
	 * Pared -> 'X'
	 * @param c
	 * @return
	 */
	private Posicion traducirCaracter(char c, int fila, int colum) {
		Posicion pos = null;
		PickUp pu;
		switch(c) {
		
			case '*':
				pu=PickUpFactory.createPuntosChicos();
				pos=new Posicion(fila,colum,true,pu);
			break;
			
			case '#':
				pu=PickUpFactory.createPuntosGrandes();
				pos=new Posicion(fila,colum,true,pu);
			break;
			
			case 'X':
				pos=new Posicion(fila,colum,false,null);
			break;
			
			case 'V':
				pu=PickUpFactory.createPocion();
				pos=new Posicion(fila,colum,true,pu);
			break;
			case 'P':
				pu=PickUpFactory.createPoder();
				pos=new Posicion(fila,colum,true,pu);
			break;
		}
		return pos;
	}
}