package vista.repositorioGrafico;

import javax.swing.ImageIcon;

public abstract class RepositorioGraficoPickUpAbstracto {
	
	public abstract ImageIcon getPickUpPuntoNormalGrafico();
	
	public abstract ImageIcon getPickUpPoderNormalGrafico();
	
	public abstract ImageIcon getPickUpPuntoEspecialGrafico(int tipo);
	
	public abstract ImageIcon getPickUpPoderEspecialGrafico(int tipo);
	
}
