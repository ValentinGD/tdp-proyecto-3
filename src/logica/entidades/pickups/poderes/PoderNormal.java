package logica.entidades.pickups.poderes;

import javax.swing.ImageIcon;

import app.App;
import logica.Visitor;
import logica.entidades.Personaje;
import vista.RepositorioGrafico;
import vista.RepresentacionGrafica;
import vista.repositorioGrafico.RepositorioGraficoAbstracto;
import vista.repositorioGrafico.RepositorioGraficoPickUpAbstracto;

public class PoderNormal extends PickUpPoder {
	
	public PoderNormal(int x, int y) {
		 super(x, y,Integer.parseInt(App.configuration.getProperty("PuntosPoderNormal"))
                 ,0,Integer.parseInt(App.configuration.getProperty("VelocidadTicsPoder"))
                 ,true,true,Integer.parseInt(App.configuration.getProperty("tiempoDuracionPoderes")));
	}

	@Override
	public RepresentacionGrafica getRepresentacionGrafica(RepositorioGraficoAbstracto repositorioGrafico) {
		if (comido) {
			miRepresentacion.setImageIcon(null);
		} else {
			miRepresentacion.setImageIcon(repositorioGrafico.getRepositorioGraficoPickUp().getPickUpPoderNormalGrafico());
		}
		return miRepresentacion;
	}
	
	public ImageIcon getRepresentacionGrafica() {
		return RepositorioGrafico.getPoder();
	}

	@Override
	public void aplicarPoder(Personaje personaje) {
		personaje.hacerAsesinoDeEnemigos(true);		
	}

}
