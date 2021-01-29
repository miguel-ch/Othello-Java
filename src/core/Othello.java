package core;

import core.fichas.FichaBlanca;
import core.fichas.FichaNegra;
import core.jugadores.Jugador;
import core.man.ManFichas;
import core.man.ManMovimientos;
import core.tablero.Tablero;

public class Othello {

	// Jugadores
	private Jugador jugBlancas;
	private Jugador jugNegras;

	// Tablero
	private final Tablero tablero;
	private final ManFichas fichas;
	private final ManMovimientos movs;

	// Constructor
	public Othello() {
		this.tablero = new Tablero();
		this.fichas = new ManFichas();
		this.movs = new ManMovimientos(tablero);

		this.tablero.asignarFicha(new FichaBlanca(), 4, 4);
		this.tablero.asignarFicha(new FichaNegra(), 3, 4);
		this.tablero.asignarFicha(new FichaNegra(), 2, 4);
		this.tablero.asignarFicha(new FichaNegra(), 3, 5);
		this.tablero.asignarFicha(new FichaNegra(), 2, 6);
		this.tablero.asignarFicha(new FichaBlanca(), 1, 4);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void pa() {
		int[][] maka = movs.checkMovements(new FichaBlanca());

		if (maka != null) {
			for (int i = 0; i < maka.length; i++) {
				System.out.println("Posible MOV[" + i + 1 + "] - " + maka[i][0] + ", " + maka[i][1]);
			}
		}
	}

	// Metodos jugadores
}
