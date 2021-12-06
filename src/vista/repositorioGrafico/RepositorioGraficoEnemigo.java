package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public class RepositorioGraficoEnemigo extends RepositorioGraficoMovibleAbstracto {

	protected String numero;

	public RepositorioGraficoEnemigo(String path, String numero) {
		super(path);
		this.path += "enemigos/";
		this.numero = numero;
	}

	public ImageIcon getEnemigoAsustadoGrafico() {
		return IconReader.readIcon(path + "enemigo_asustado.png");
	}

	@Override
	public ImageIcon getMovibleIzquierdaGrafico() {
		return IconReader.readIcon(path + "enemigo_" + numero + "_izquierda.png");
	}

	@Override
	public ImageIcon getMovibleDerechaGrafico() {
		return IconReader.readIcon(path + "enemigo_" + numero + "_derecha.png");
	}

	@Override
	public ImageIcon getMovibleArribaGrafico() {
		return IconReader.readIcon(path + "enemigo_" + numero + "_arriba.png");
	}

	@Override
	public ImageIcon getMovibleAbajoGrafico() {
		return IconReader.readIcon(path + "enemigo_" + numero + "_abajo.png");
	}

	@Override
	public ImageIcon getMovibleMuertoGrafico() {
		return IconReader.readIcon(path + "enemigo_muerto.png");
	}

}