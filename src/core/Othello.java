package core;

import java.util.List;

import core.fichas.FichaBlanca;
import core.fichas.FichaNegra;
import core.jugadores.Jugador;
import core.man.Coordenadas;
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
		this.fichas = new ManFichas(tablero);
		this.movs = new ManMovimientos(tablero);

		// Fichas iniciales
		this.tablero.asignarFicha(new FichaBlanca(), 4, 4);
		this.tablero.asignarFicha(new FichaBlanca(), 5, 5);
		this.tablero.asignarFicha(new FichaNegra(), 4, 5);
		this.tablero.asignarFicha(new FichaNegra(), 5, 4);
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void tests() {

		List<Coordenadas> posiblesMovs = null;
		List<Coordenadas> posiblesFlanks = null;
		try {
			posiblesMovs = movs.movimientosPosibles(new FichaNegra());
			posiblesFlanks = fichas.buscarFichasOpuestas(new FichaNegra(), 1, 1);

			// Flip
		} catch (Exception e) {
			System.out.println("Ocurrio un error al obtener los posibles");
		}

		// Posibles movimientos
		if (posiblesMovs != null && posiblesMovs.size() > 0) {
			System.out.println();
			posiblesMovs.forEach(c -> {
				System.out.println("Posible en " + c.getFila() + ", " + c.getColumna());
			});
		}else {
			System.out.println("Sin moviminetos posibles");
		}
		

		// Posibles flips
		if (posiblesFlanks != null && posiblesFlanks.size() > 0) {
			System.out.println();
			posiblesFlanks.forEach(c -> {
				System.out.println("Flipp en: " + c.getFila() + ", " + c.getColumna());
			});
		}else {
			System.out.println("No hay posibles flips");
		}
	}

	// Metodos jugadores
}
