package gui.swing.tablero;

import gui.GUIJuego;
import gui.GUITablero;
import gui.swing.casilla.CasillaComponente;
import gui.swing.casilla.CasillaComponente.TipoCasilla;
import othello.fichas.FichaColor;
import othello.tablero.Tablero;
import othello.tablero.ubicacion.Coordenadas;

public class TableroGUI extends GUITablero {

	private TableroComponente componente;

	public TableroGUI(GUIJuego j, Tablero t) {
		super(j, t);
		this.componente = new TableroComponente(this);
	}

	public void colocarFicha(int fila, int columna) {
		CasillaComponente c = componente.getCasilla(fila, columna);
		juego.colocarFicha(c.getFila(), c.getColumna());
	}

	public TableroComponente getComponente() {
		return componente;
	}

	@Override
	public void cargar() {
		
		CasillaComponente[][] tmpCasillas = componente.getCasillas();
		
		for(CasillaComponente[] filaCasillas : tmpCasillas) {
			for(CasillaComponente c: filaCasillas) {
				c.setEnabled(false);
			}
		}
	}

	@Override
	public void actualizar() {
		
		for(int i = Tablero.INICIO_TABLERO; i <= Tablero.FINAL_TABLERO; i++) {
			for(int j = Tablero.INICIO_TABLERO; j <= Tablero.FINAL_TABLERO; j++) {
				
				CasillaComponente tmpCasilla = componente.getCasilla(i-1, j-1);
				tmpCasilla.cambiarCasilla(TipoCasilla.VACIA);
				tmpCasilla.setEnabled(false);
				
				//Verifica si existe ficha en la posicion que se esta recorriendo
				if(tablero.hayFicha(i, j)) {
					
					//Verifica si la ficha es negra o blanca para pintar la casilla
					if(tablero.obtenerFicha(i, j).getColor() == FichaColor.NEGRA) {
						tmpCasilla.cambiarCasilla(TipoCasilla.FICHA_NEGRA);
					}else {
						tmpCasilla.cambiarCasilla(TipoCasilla.FICHA_BLANCA);
					}
				}else {
					
					//Verifica si es un posible movimiento
					if(posiblesMovimientos != null && posiblesMovimientos.size() > 0) {
						for(Coordenadas c : posiblesMovimientos) {
							if(c.getFila() == i && c.getColumna() == j) {
								tmpCasilla.cambiarCasilla(TipoCasilla.POSIBLE_MOVIMIENTO);
								tmpCasilla.setEnabled(true);
							}
						}
					}
				}
			}
		}
		componente.repaint();
	}
}
