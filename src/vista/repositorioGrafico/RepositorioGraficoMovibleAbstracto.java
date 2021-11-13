package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public abstract class RepositorioGraficoMovibleAbstracto {
	
	protected String path;
	
	protected RepositorioGraficoMovibleAbstracto(String path) {
		this.path = path + "movibles/";
	}
	
	public abstract ImageIcon getMovibleIzquierdaGraifco();
	
	public abstract ImageIcon getMovibleDerechaGraifco();
	
	public abstract ImageIcon getMovibleArribaGraifco();
	
	public abstract ImageIcon getMovibleAbajoGraifco();
	
	public abstract ImageIcon getMovibleMuertoGrafico();
	
}
