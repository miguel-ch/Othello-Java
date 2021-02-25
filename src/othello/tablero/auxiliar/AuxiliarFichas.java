package othello.tablero.auxiliar;

import java.util.ArrayList;
import java.util.List;

import othello.fichas.Ficha;
import othello.tablero.Tablero;
import othello.tablero.auxiliar.direccion.Cursor;
import othello.tablero.auxiliar.direccion.CursorDireccion;
import othello.tablero.ubicacion.Coordenadas;

public class AuxiliarFichas {

	// Referencia al tablero en uso
	private final Tablero tablero;

	// Constructor
	public AuxiliarFichas(Tablero t) {
		this.tablero = t;
	}

	// Busca las fichas opuestas con posibilidad de dar vuelta
	public List<Coordenadas> coordenadasFichasOpuestas(Ficha f, int fila, int col) {

		List<Coordenadas> coordenadasFichas = new ArrayList<>();
		int celda = 0; // Identificador para la celda del tablero (1-9) en la cuadricula 3x3

		// Recorre la cuadricula 3x3 como celdas del 1 al 9
		for (int i = fila - 1; i <= fila + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {

				// Lleva el registro de la celda que se esta verificando
				celda++;

				// Salta la casilla del centro (Es la ficha que se esta verificando)
				if (i == fila && j == col)
					continue;

				// Verifica si en la celda en curso existe ficha para empezar a buscar la linea
				if (tablero.hayFicha(i, j) && !tablero.obtenerFicha(i, j).equals(f)) {

					// Crea el cursor que recorrera la linea y añade los espacios donde se puede dar
					// vuelta a las fichas
					Cursor cursor = new Cursor(i, j, Tablero.INICIO_TABLERO, Tablero.FINAL_TABLERO,
							CursorDireccion.convertirDireccion(celda));
					coordenadasFichas.addAll(buscarLinea(f, cursor));
				}
			}
		}

		// Voltea las posibles fichas opuestas y retorna la cantidad de fichas
		return coordenadasFichas;
	}

	// Recorre en la direccion en busca de fichas
	private List<Coordenadas> buscarLinea(Ficha f, Cursor cur) {

		List<Coordenadas> coords = new ArrayList<>();
		boolean cierraLinea = false;

		// Empiza a recorrer en una direccion hasta terminar la linea de fichas opuestas
		// (borde, ficha recibida o espacio vacio)
		while (cur.getDireccion() != CursorDireccion.CENTRO && !cierraLinea) {

			// Verifica si existe una ficha en la posicion actual del cursor y si esta es
			// opuesta, de lo contrario finaliza la linea
			if (tablero.hayFicha(cur.getFila(), cur.getColumna())
					&& !tablero.obtenerFicha(cur.getFila(), cur.getColumna()).equals(f)) {
				coords.add(new Coordenadas(cur.getFila(), cur.getColumna()));
			} else {
				cierraLinea = true;
				break;
			}

			// Incremento del cursor
			cur.incrementar();
		}
		// Verifica la ultima posicion del cursor para saber si es posible dar vuelta a
		// la linea de fichas
		if (!tablero.hayFicha(cur.getFila(), cur.getColumna())
				|| !tablero.obtenerFicha(cur.getFila(), cur.getColumna()).equals(f)) {
			coords.clear();
		}
		return coords;
	}

	public int darVueltaFichasOpuestas(Ficha f, Coordenadas c) {
		List<Coordenadas> coords = coordenadasFichasOpuestas(f, c.getFila(), c.getColumna());
		darVueltaAFichas(f, coords);
		return coords.size();
	}

	// Reemplaza las fichas que se encuentran en las coordenadas obtenidas por la
	// ficha recibida
	private void darVueltaAFichas(Ficha fichaFinal, List<Coordenadas> coords) {
		if (coords != null && coords.size() > 0) {
			coords.forEach(c -> {
				tablero.asignarFicha(fichaFinal, c);
			});
		}
	}
}
