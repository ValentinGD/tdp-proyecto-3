package logica.estados.personaje;

import javax.swing.ImageIcon;

import logica.entidades.Movible;
import logica.entidades.Personaje;
import logica.estados.EstadoMovible;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;

public abstract class EstadoPersonaje extends EstadoMovible {

	protected Personaje personaje;

	protected EstadoPersonaje(Personaje personaje) {
		super(personaje);
		this.personaje = personaje;
	}

	protected void verificarCambioDireccion() {
		if (personaje.getDireccionActual() != personaje.getDireccionSiguiente()) {
			boolean sonDireccionesOpuestas = Movible.sonDireccionesOpuestas(personaje.getDireccionActual(), personaje.getDireccionSiguiente());
			boolean giroPermitido = personaje.puedeGirar() || sonDireccionesOpuestas;

			if (giroPermitido && puedeMover(personaje, personaje.getDireccionSiguiente())) {
				personaje.actualizarDireccion();
			}
		}
	}

	public abstract ImageIcon getRepresentacionGrafica(RepositorioGraficoPersonaje repositorio);

}