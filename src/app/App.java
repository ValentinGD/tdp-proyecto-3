package app;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import logica.Juego;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;
import vista.repositorioGrafico.figuras.RepositorioGraficoPickUpFiguras;

public class App {
	
	public static Properties configuration;
	
	public static void main(String[] args) {
		loadConfiguration();
		
		EventQueue.invokeLater(Juego.getInstancia());
	}

	private static void loadConfiguration() {
		try {
			InputStream input = new FileInputStream("./configuration.properties");
			App.configuration = new Properties();
			App.configuration.load(input);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
