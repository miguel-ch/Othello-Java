package gui;

import java.util.List;

import othello.tablero.Tablero;
import othello.tablero.ubicacion.Coordenadas;

public abstract class GUITablero implements GUI, GUIInformacion{

	protected final GUIJuego juego;
	protected final Tablero tablero;
	
	protected List<Coordenadas> posiblesMovimientos;
	
	public GUITablero(GUIJuego j, Tablero t) {
		this.juego = j;
		this.tablero = t;
	}

	public void actualizarPosiblesMovimientos(List<Coordenadas> movimientos) {
		this.posiblesMovimientos = movimientos;
	}
}
