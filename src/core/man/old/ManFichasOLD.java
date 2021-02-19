package core.man.old;

import java.util.ArrayList;

import core.fichas.Ficha;
import core.man.cursor.Cursor;
import core.man.cursor.Direccion;
import core.tablero.Tablero;
import core.tableroOLD.TableroOLD;

public class ManFichasOLD {

	// Atributos
	private TableroOLD tab;

	// Constructor
	public ManFichasOLD(TableroOLD tab) {
		this.tab = tab;
	}

	// Flip
	public ArrayList<int[]> flipFichas(Ficha f, int fila, int col) {

		// System.out.println(fila + " " + col + " | " + filaAA + " " + columnaAA);

		int celda = 0; // Identificador para la celda del tablero (1-9) en la cuadricula 9x9

		int iCol = col - 1 <= 0 ? col : col - 1;
		int lCol = col + 1 >= TableroOLD.TAMANO_TABLERO ? col : col + 1;
		int iFila = fila - 1 <= 0 ? fila : fila - 1;
		int lFila = fila + 1 >= TableroOLD.TAMANO_TABLERO ? fila : fila + 1;

		System.out.println("FILA: " + iFila + ", " + lFila + " | COL: " + iCol + ", " + lCol);
		// Verifica que exista una ficha
		// if(tab.hayFicha(fila, columna)) {

		System.out.println("FIC: " + f.getColor());

		// Recorre la cuadricula 3x3 enumerada del 1 al 9
		for (int i = iFila; i <= lFila; i++) {

			for (int j = iCol; j <= lCol; j++) {

				celda++;
				// System.out.println(celda);

				// Salta la casilla del centro (Es la ficha que se esta verificando)
				if (i == fila && j == col) {
					System.out.println("Skip " + fila + " " + col + " | " + celda);
					continue;
				}

				// Verifica si en la celda existe ficha para empezar a hacer el cambio
				if (tab.hayFicha(i, j) && !tab.obtenerFicha(i, j).equals(f)) {

					System.out.println(tab.obtenerFicha(i, j).getColor());

					// System.out.println("Hay ficha");
					System.out.println(celda + " | " + Direccion.convertirDireccion(celda));
					Cursor cur = new Cursor(i, j, Tablero.INICIO_TABLERO, Tablero.FINAL_TABLERO, Direccion.convertirDireccion(celda));
					System.out.println("Envia");
					cur = checkFlip(f, cur);
					if (cur != null) {
						System.out.println("MAX: " + cur.getFila() + " | " + cur.getColumna());
					}
				}
			}
		}
		return null;
		// }
	}

	// Recorre en la direccion en busca de fichas
	private Cursor checkFlip(Ficha f, Cursor cur) {

		ArrayList<int[]> coords = new ArrayList<>();
		boolean mamo = false;

		System.out.println("CUR: " + cur.getDireccion());

		// coords.add(new int[] {cur.getY(), cur.getX()});

		// while(tab.hayFicha(cur.getY(), cur.getX()) && cur.getDir() !=
		// Direccion.CENTRO && !mamo) {

		while (cur.getDireccion() != Direccion.CENTRO && !mamo) {
			// System.out.println("CICLO");

			if (tab.hayFicha(cur.getFila(), cur.getColumna())) {

				// Es ficha de otro color
				if (!tab.obtenerFicha(cur.getFila(), cur.getColumna()).equals(f)) {
					System.out.println("AÑADIO COORDS " + cur.getFila() + ", " + cur.getColumna());
					coords.add(new int[] { cur.getFila(), cur.getColumna() });
				} else {
					System.out.println("MAMOP");
					mamo = true;
					break;
				}
			} else {
				coords = null;
				break;
			}
			cur.incrementar();
		}

		System.out.println();
		// IMPRIME TEMP
		if(coords != null) {
			coords.forEach(c -> {
				System.out.println("FL: " + c[0] + ", " + c[1]);
			});
		}
		System.out.println();

		// Si el cursor termino el recorrido y no esta en un borde
		if (cur.getDireccion() != Direccion.CENTRO || mamo) {
			return cur;
		}
		return null;
	}
}
