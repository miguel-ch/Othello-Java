package core.man;

import java.util.ArrayList;

import core.fichas.Ficha;
import core.tablero.Tablero;

public class ManMovimientos {

	// Referencia al tablero en uso
	private final Tablero tab;

	// Constructor
	public ManMovimientos(Tablero t) {
		this.tab = t;
	}

	public int[][] checkMovements(Ficha ficha) {

		int[][] moves = null;
		ArrayList<Cursor> finalm = new ArrayList<>();

		for (int i = 0; i < Tablero.TAMANO_TABLERO; i++) {

			for (int j = 0; j < Tablero.TAMANO_TABLERO; j++) {

				if (tab.hayFicha(i, j) && ficha.equals(tab.obtenerFicha(i, j))) {
					finalm.addAll(validMovs(ficha, i, j));
				}
			}
		}

		if (finalm.size() > 0) {
			moves = new int[finalm.size()][2];
			for (int i = 0; i < finalm.size(); i++) {
				moves[i][0] = finalm.get(i).getY();
				moves[i][1] = finalm.get(i).getX();
			}
		}
		return moves;
	}

	private ArrayList<Cursor> validMovs(Ficha f, int fila, int col) {

		System.out.println("\nFICHA PARA: " + f.getColor() + " [" + fila + ", " + col + "]");
		ArrayList<Cursor> mov = new ArrayList<>();
		int celda = 0; // Identificador para la celda del tablero (1-9) en la cuadricula 9x9
		int iCol = col - 1 <= 0 ? col : col - 1;
		int lCol = col + 1 >= Tablero.TAMANO_TABLERO ? col : col + 1;
		int iFila = fila - 1 <= 0 ? fila : fila - 1;
		int lFila = fila + 1 >= Tablero.TAMANO_TABLERO ? fila : fila + 1;

		System.out.println("Col - [" + iCol + ", " + lCol + "]");
		System.out.println("Fila - [" + iFila + ", " + lFila + "]\n");

		// Recorre las casillas que rodean la ficha
		for (int i = iFila; i <= lFila; i++) {
			for (int j = iCol; j <= lCol; j++) {

				// Realiza el incremento de la celda
				celda++;

				// Salta en caso de que sea la casilla central
				if (i == fila && j == col) {
					continue;
				}

				//System.out.println("Recorriendo - " + "[" + i + ", " + j + "] - Celda: " + celda);

				// Si encuentra una ficha opuesta empieza a buscar el espacio libre en esa
				// direccion
				if (tab.hayFicha(i, j) && !tab.obtenerFicha(i, j).equals(f)) {
					Cursor cur = new Cursor(i, j, Direccion.convertirDireccion(celda));
					cur = checkFlank(f, cur);
					if (cur != null) {
						mov.add(cur);
					}
				}
			}
		}
		System.out.println();
		return mov;
	}

	// Verifica si un grupo de fichas es flan
	public Cursor checkFlank(Ficha f, Cursor cur) {

		boolean hayFichaOpuesta = false;

		// Sigue aumentando en la direccion hasta que exista una ficha o espacio vacio
		while (tab.hayFicha(cur.getY(), cur.getX()) && cur.getDir() != Direccion.CENTRO) {

			// Incrementa y verifica que no exista una ficha opuesta
			cur.incrementar(Tablero.TAMANO_TABLERO);
			
			
			if (tab.hayFicha(cur.getY(), cur.getX())) {
				hayFichaOpuesta = !tab.obtenerFicha(cur.getY(), cur.getX()).equals(f);
			}
			System.out.println("Cur coords ["+cur.getY()+", "+cur.getX()+"] " + cur.getDir());
		}

		// Si no paro en un limite del tablero o si no
		if (cur.getDir() != Direccion.CENTRO || !hayFichaOpuesta) {
			return cur;
		}
		return null;
	}
}