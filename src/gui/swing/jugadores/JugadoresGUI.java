package gui.swing.jugadores;

import gui.GUIJugadores;
import gui.swing.jugadores.informacion.InformacionJugadorGUI;
import othello.jugadores.Jugador;

public class JugadoresGUI extends GUIJugadores {

	// Componentes
	private JugadoresComponente componente;

	public JugadoresGUI(Jugador jugFichasNegras, Jugador jugFichasBlancas) {

		this.jugadorFichasNegras = new InformacionJugadorGUI(jugFichasNegras);
		this.jugadorFichasBlancas = new InformacionJugadorGUI(jugFichasBlancas);
		this.componente = new JugadoresComponente(((InformacionJugadorGUI) jugadorFichasNegras).getComponente(),
				((InformacionJugadorGUI) jugadorFichasBlancas).getComponente());

	}

	public JugadoresComponente getComponente() {
		return componente;
	}
}
