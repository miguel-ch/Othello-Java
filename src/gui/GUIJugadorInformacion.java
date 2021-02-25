package gui;

import othello.jugadores.Jugador;

public abstract class GUIJugadorInformacion implements GUI, GUIInformacion{
	
	protected final Jugador jugador;
	
	public GUIJugadorInformacion(Jugador j) {
		this.jugador = j;
	}
}
