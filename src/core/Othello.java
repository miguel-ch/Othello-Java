package core;

import core.jugadores.Jugador;
import core.man.ManFichas;
import core.man.ManMovimientos;
import core.tablero.Tablero;

public class Othello {

	//Jugadores
	private Jugador jugBlancas;
	private Jugador jugNegras;
	
	//Tablero
	private final Tablero tablero;
	private final ManFichas fichas;
	private final ManMovimientos movs;
	
	//Constructor
	public Othello() {
		this.tablero = new Tablero();
		this.fichas = new ManFichas();
		this.movs = new ManMovimientos();
	}
	
	//Metodos jugadores
	
	
}
