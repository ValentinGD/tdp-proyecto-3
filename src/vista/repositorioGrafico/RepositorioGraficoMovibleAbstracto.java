package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public abstract class RepositorioGraficoMovibleAbstracto {
	
	protected String path;
	
	protected RepositorioGraficoMovibleAbstracto(String path) {
		this.path = path + "movibles/";
	}
	
	public abstract ImageIcon getMovibleIzquierdaGrafico();
	
	public abstract ImageIcon getMovibleDerechaGrafico();
	
	public abstract ImageIcon getMovibleArribaGrafico();
	
	public abstract ImageIcon getMovibleAbajoGrafico();
	
	public abstract ImageIcon getMovibleMuertoGrafico();
	
}