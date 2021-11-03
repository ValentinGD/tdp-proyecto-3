package app;

import java.awt.EventQueue;

import logica.Juego;

public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(Juego.getInstancia());
	}
}
