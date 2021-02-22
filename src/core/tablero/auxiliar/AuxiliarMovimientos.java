package core.tablero.auxiliar;

import java.util.ArrayList;
import java.util.List;

import core.fichas.Ficha;
import core.tablero.Tablero;
import core.tablero.auxiliar.direccion.Cursor;
import core.tablero.auxiliar.direccion.CursorDireccion;
import core.tablero.ubicacion.Coordenadas;

public class AuxiliarMovimientos {

	// Referencia al tablero en uso
	private final Tablero tablero;

	// Constructor
	public AuxiliarMovimientos(Tablero t) {
		this.tablero = t;
	}

	public List<Coordenadas> movimientosPosibles(Ficha ficha) {

		List<Coordenadas> movsPosibles = new ArrayList<>();

		// Recorre todo el tablero para buscar la ficha
		for (int i = 0; i < Tablero.TAMANO_TABLERO; i++) {
			for (int j = 0; j < Tablero.TAMANO_TABLERO; j++) {

				// Verifica la celda del tablero para ver si hay ficha y esta corresponde a la
				// que se busca, despues busca posibles moviminetos
				if (tablero.hayFicha(i, j) && ficha.equals(tablero.obtenerFicha(i, j))) {
					movsPosibles.addAll(validarMovimientos(ficha, i, j));
				}
			}
		}
		return movsPosibles;
	}

	private List<Coordenadas> validarMovimientos(Ficha f, int fila, int col) {

		List<Coordenadas> ubicacionesPosibles = new ArrayList<>();
		int celda = 0; // Identificador para la celda del tablero (1-9) en la cuadricula 9x9

		// Recorre las casillas que rodean la ficha
		for (int i = fila - 1; i <= fila + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {

				// Lleva el registro de la celda que se esta verificando
				celda++;

				// Salta la casilla del centro (Es la ficha que se esta verificando)
				if (i == fila && j == col)
					continue;

				// Si encuentra una ficha opuesta empieza a buscar el espacio libre en esa
				// direccion
				if (tablero.hayFicha(i, j) && !tablero.obtenerFicha(i, j).equals(f)) {

					Cursor cursor = new Cursor(i, j, Tablero.INICIO_TABLERO, Tablero.FINAL_TABLERO,
							CursorDireccion.convertirDireccion(celda));
					Coordenadas coords = buscarEspacio(f, cursor);

					// Si las coordenadas existen las añade a la lista
					if (coords != null) {
						ubicacionesPosibles.add(new Coordenadas(cursor.getFila(), cursor.getColumna()));
					}
				}
			}
		}
		return ubicacionesPosibles;
	}

	// Verifica si un grupo de fichas es flan
	private Coordenadas buscarEspacio(Ficha f, Cursor cur) {

		boolean hayFichaOpuesta = false;

		// Sigue aumentando en la direccion hasta enceuntre un limite (Ficha, espacio
		// vacio o borde)
		while (tablero.hayFicha(cur.getFila(), cur.getColumna()) && cur.getDireccion() != CursorDireccion.CENTRO
				&& !hayFichaOpuesta) {

			// Verifica que no exista una ficha del mismo valor e incrementa el cursor
			if (tablero.hayFicha(cur.getFila(), cur.getColumna())
					&& tablero.obtenerFicha(cur.getFila(), cur.getColumna()).equals(f)) {
				hayFichaOpuesta = true;
			}
			cur.incrementar();
		}

		// Si no paro en un limite del tablero o encontro la misma ficha crea las
		// coordenadas
		if (cur.getDireccion() != CursorDireccion.CENTRO && !hayFichaOpuesta) {
			return new Coordenadas(cur.getFila(), cur.getColumna());
		}
		return null;
	}
}