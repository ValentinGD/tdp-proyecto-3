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
		return IconReader.readIcon(path + "enemigo_austado.png");
	}

	@Override
	public ImageIcon getMovibleIzquierdaGraifco() {
		return IconReader.readIcon(path + "enemigo_" + numero +"_izquierda.png");
	}

	@Override
	public ImageIcon getMovibleDerechaGraifco() {
		return IconReader.readIcon(path + "enemigo_" + numero +"_derecha.png");
	}

	@Override
	public ImageIcon getMovibleArribaGraifco() {
		return IconReader.readIcon(path + "enemigo_" + numero +"_arriba.png");
	}

	@Override
	public ImageIcon getMovibleAbajoGraifco() {
		return IconReader.readIcon(path + "enemigo_" + numero +"_abajo.png");
	}

	@Override
	public ImageIcon getMovibleMuertoGrafico() {
		return IconReader.readIcon(path + "enemigo_muerto.png");
	}
}
