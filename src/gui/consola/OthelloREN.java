package gui.consola;

import core.fichas.FichaColor;
import core.tablero.Tablero;

public class OthelloREN {

	public void imprimirTablero(Tablero t) {

		System.out.println("    1   2   3   4   5   6   7   8");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int i = Tablero.INICIO_TABLERO; i <= Tablero.FINAL_TABLERO; i++) {

			for (int j = Tablero.INICIO_TABLERO; j <= Tablero.FINAL_TABLERO; j++) {

				if (j == Tablero.INICIO_TABLERO) {
					System.out.print(i + " | ");
				}

				// FICHA
				if (t.hayFicha(i, j)) {

					if (t.obtenerFicha(i, j).getColor() == FichaColor.NEGRA) {
						System.out.print("N | ");
					} else {
						System.out.print("B | ");
					}
				} else {
					System.out.print("  | ");
				}
			}
			System.out.println("\n  +---+---+---+---+---+---+---+---+");
		}
	}
}
