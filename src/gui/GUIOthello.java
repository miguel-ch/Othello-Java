package gui;

import othello.jugadores.Jugador;

public interface GUIOthello{
	public void iniciarJuego(Jugador jugadorNegras, Jugador jugadorBlancas);
	public void actualizarJuego();
	public void terminarJuego(boolean volverAlMenu);
	public void reiniciarJuego(boolean leerJugadores);
}
