package vista.repositorioGrafico.figuras;

import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;
import vista.repositorioGrafico.RepositorioGraficoEscenario;
import vista.repositorioGrafico.RepositorioGraficoPersonaje;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class RepositorioGraficoFiguras extends RepositorioGraficoAbstracto {
	
	private static final String path = "/img/figuras/";
	
	@Override
	public RepositorioGraficoEnemigo getRepositorioGraficoEnemigo1() {
		return new RepositorioGraficoEnemigo(path, "1");
	}

	@Override
	public RepositorioGraficoEnemigo getRepositorioGraficoEnemigo2() {
		return new RepositorioGraficoEnemigo(path, "2");
	}

	@Override
	public RepositorioGraficoEnemigo getRepositorioGraficoEnemigo3() {
		return new RepositorioGraficoEnemigo(path, "3");
	}

	@Override
	public RepositorioGraficoEnemigo getRepositorioGraficoEnemigo4() {
		return new RepositorioGraficoEnemigo(path, "4");
	}

	@Override
	public RepositorioGraficoPersonaje getRepositorioGraficoPersonaje() {
		return new RepositorioGraficoPersonaje(path);
	}

	@Override
	public RepositorioGraficoPickUpAbstracto getRepositorioGraficoPickUp() {
		return new RepositorioGraficoPickUpFiguras(path);
	}

	@Override
	public RepositorioGraficoEscenario getRepositorioGraficoEscenario() {
		return new RepositorioGraficoEscenario(path);
	}
}
