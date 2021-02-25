package gui;

import othello.jugadores.creador.PlantillaJugador;

public abstract class GUILecturaJugadores implements GUI{

	protected final GUIJuego juego;
	
	protected PlantillaJugador jugadorUno;
	protected PlantillaJugador jugadorDos;
	
	public GUILecturaJugadores(GUIJuego j) {
		this.juego = j;
	}
	
	public abstract void cargarJugadoresAJuego();
}
