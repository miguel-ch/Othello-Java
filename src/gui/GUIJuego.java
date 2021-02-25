package gui;

import othello.Othello;

public abstract class GUIJuego implements GUI, GUIOthello{

	// Juego
	protected Othello juego;
	
	//Menu principal
	protected final GUIPrincipal principal;
	
	//Lectura
	protected GUILecturaJugadores lecturaJugadores;
	
	// Partes de la interfaz
	protected GUIJugadores jugadores;
	protected GUIOpciones opciones;
	protected GUITablero tablero;
	
	//Constructor
	public GUIJuego(GUIPrincipal principal) {
		this.principal = principal;
	}
	
	public abstract void colocarFicha(int fila, int columna);
}
