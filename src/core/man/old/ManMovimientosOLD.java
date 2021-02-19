package core.man.old;

import java.util.ArrayList;

import core.fichas.Ficha;
import core.man.cursor.Cursor;
import core.man.cursor.Direccion;
import core.tablero.Tablero;
import core.tableroOLD.TableroOLD;

public class ManMovimientosOLD {

	// Referencia al tablero en uso
	private final TableroOLD tab;

	// Constructor
	public ManMovimientosOLD(TableroOLD t) {
		this.tab = t;
	}

	public ArrayList<int[]> checkMovements(Ficha ficha) {

		int[][] moves = null;
		ArrayList<Cursor> finalm = new ArrayList<>();

		for (int i = 0; i < TableroOLD.TAMANO_TABLERO; i++) {

			for (int j = 0; j < TableroOLD.TAMANO_TABLERO; j++) {

				if (tab.hayFicha(i, j) && ficha.equals(tab.obtenerFicha(i, j))) {
					finalm.addAll(validMovs(ficha, i, j));
				}
			}
		}

		if (finalm.size() > 0) {
			moves = new int[finalm.size()][2];
			for (int i = 0; i < finalm.size(); i++) {
				moves[i][0] = finalm.get(i).getFila();
				moves[i][1] = finalm.get(i).getColumna();
			}
		}
		return null;
	}

	private ArrayList<Cursor> validMovs(Ficha f, int fila, int col) {

		ArrayList<Cursor> mov = new ArrayList<>();
		int celda = 0; // Identificador para la celda del tablero (1-9) en la cuadricula 9x9
		int iCol = col - 1 <= 0 ? col : col - 1;
		int lCol = col + 1 >= TableroOLD.TAMANO_TABLERO ? col : col + 1;
		int iFila = fila - 1 <= 0 ? fila : fila - 1;
		int lFila = fila + 1 >= TableroOLD.TAMANO_TABLERO ? fila : fila + 1;

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

				// Si encuentra una ficha opuesta empieza a buscar el espacio libre en esa
				// direccion
				if (tab.hayFicha(i, j) && !tab.obtenerFicha(i, j).equals(f)) {
					//System.out.println(celda + " | " + Direccion.convertirDireccion(celda));
					Cursor cur = new Cursor(i, j, Tablero.INICIO_TABLERO, Tablero.FINAL_TABLERO, Direccion.convertirDireccion(celda));
					//System.out.println("Envia");
					cur = checkFlank(f, cur);
					if (cur != null) {
						mov.add(cur);
					}
				}
			}
		}
		return mov;
	}

	// Verifica si un grupo de fichas es flan
	public Cursor checkFlank(Ficha f, Cursor cur) {

		boolean hayFichaOpuesta = false;

		// Sigue aumentando en la direccion hasta que exista una ficha o espacio vacio
		while (tab.hayFicha(cur.getFila(), cur.getColumna()) && cur.getDireccion() != Direccion.CENTRO) {

			// Incrementa y verifica que no exista una ficha opuesta

			// 
			//hayFichaOpuesta = !tab.obtenerFicha(0, 0)
			
			if (tab.hayFicha(cur.getFila(), cur.getColumna())) {
				//hayFichaOpuesta = !tab.obtenerFicha(cur.getY(), cur.getX()).equals(f);
				//System.out.println("Opuesto: " + hayFichaOpuesta +" en " + cur.getY() + " , " + cur.getX());
				//break;
			}
			
			/*if(tab.hayFicha(cur.getY(), cur.getX()) && cur.getDir() != Direccion.CENTRO) {
				System.out.println("PAK_BF: " + hayFichaOpuesta +" en " + cur.getY() + " , " + cur.getX());
			}*/
			
			// Incrementa y verifica que no exista una ficha opuesta
			cur.incrementar();
			
			/*if(tab.hayFicha(cur.getY(), cur.getX()) && cur.getDir() != Direccion.CENTRO) {
				System.out.println("PAK_AF: " + hayFichaOpuesta +" en " + cur.getY() + " , " + cur.getX());
			}*/
		}

		// Si no paro en un limite del tablero o si no
		if (cur.getDireccion() != Direccion.CENTRO && !hayFichaOpuesta) {
			//System.out.println("CUR: " + cur.getDir() + " FICH: " + hayFichaOpuesta);
			return cur;
		}
		return null;
	}
}