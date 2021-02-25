package gui.consola;

import gui.GUIJugadores;
import othello.jugadores.Jugador;

public class ConsolaJugadores extends GUIJugadores {

	public ConsolaJugadores(Jugador jugadorFichasNegras, Jugador jugadorFichasBlancas) {
		this.jugadorFichasNegras = new ConsolaJugador(jugadorFichasNegras);
		this.jugadorFichasBlancas = new ConsolaJugador(jugadorFichasBlancas);
	}
}