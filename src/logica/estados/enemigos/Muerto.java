package logica.estados.enemigos;

import javax.swing.ImageIcon;
import logica.Escenario;
import logica.entidades.enemigos.Enemigo;
import vista.repositorioGrafico.RepositorioGraficoEnemigo;

public class Muerto extends EstadoEnemigo {

	public Muerto(Enemigo enemigo) {
		super(enemigo);
	}

	@Override
	public void mover() {
		//System.out.println("Enemigo muerto moviendose");
		
		int movimientoX, movimientoY;
		
		movimientoX = enemigo.getOrigenX() - enemigo.getX();
		movimientoY = enemigo.getOrigenY() - enemigo.getY();
		
		//System.out.println("\tmovX: " + movimientoX);
		//System.out.println("\tmovY: " + movimientoY);
		
		if ((Math.abs(movimientoX) <= 1) && (Math.abs(movimientoY) <= 1)) {
			enemigo.reset();
			Escenario.getInstancia().ubicarEnZona(enemigo);
			//System.out.println("Enemigo revivido");
		} else {
			//System.out.println(enemigo);
			//System.out.println("Enemigo movido");
			if (movimientoX < 0) {
				movimientoX = Math.min(-1, movimientoX/10);
			} else {
				movimientoX = Math.max(1, movimientoX/10);
			}
			
			if (movimientoY < 0) {
				movimientoY = Math.min(-1, movimientoY/10);
			} else {
				movimientoY = Math.max(1, movimientoY/10);
			}
			
			enemigo.setPosicion(enemigo.getX() + movimientoX, enemigo.getY() + movimientoY);
			//System.out.println(enemigo);
			
			Escenario.getInstancia().agregarEntidadParaActualizar(enemigo);
			Escenario.getInstancia().reubicar(enemigo);
		}
	}
	
	@Override
	public ImageIcon getRepresentacionGrafica(RepositorioGraficoEnemigo repositorio) {
		return repositorio.getMovibleMuertoGrafico();
	}

}
