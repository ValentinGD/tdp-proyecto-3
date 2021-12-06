package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Properties;

import logica.Juego;
import logica.TopScores;

public class App {

	public static Properties configuration;
	private static TopScores misTopScores;

	public static void main(String[] args) {
		loadConfiguration();
		loadTopScores();

		Thread t = new Thread(new Juego(misTopScores));
		t.start();
	}

	private static void loadConfiguration() {
		try {
			InputStream input = new FileInputStream("configuration.properties");
			App.configuration = new Properties();
			App.configuration.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadTopScores() {
		misTopScores = new TopScores();
		try {
			FileInputStream fileInputStream = new FileInputStream(App.configuration.getProperty("RutaRecords"));
			ObjectInputStream objectInputStram = new ObjectInputStream(fileInputStream);
			misTopScores = (TopScores) objectInputStram.readObject();
			objectInputStram.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}