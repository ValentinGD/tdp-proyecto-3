package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import logica.Juego;

public class App {
	
	public static Properties configuration;
	
	public static void main(String[] args) {
		loadConfiguration();
		
		Thread t = new Thread(new Juego());
		t.start();
		
	}

	private static void loadConfiguration() {
		try {
			InputStream input = new FileInputStream("configuration.properties");
			App.configuration = new Properties();
			App.configuration.load(input);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
